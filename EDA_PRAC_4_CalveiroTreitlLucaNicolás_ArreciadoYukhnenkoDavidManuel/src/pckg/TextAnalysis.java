package pckg;

import java.util.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextAnalysis {
	
	/* DO NOT MODIFY MAIN */
	public static void main (String [] args) throws IOException, 
	                                         InvocationTargetException, InterruptedException {
		
		final File textFileToProcess;
		File binFile = new File("BinFile.dat");
		File textFile = new File("textOutput.text");
		JFileChooser fileChooser = new JFileChooser(".");
		final TreeMap<Integer, List<String>> lineContents, lc;
		final TreeMap<String, Integer> wordCount, wc;
		
		EventQueue.invokeAndWait(()->{
			fileChooser.setDialogTitle("Select Text file to process");
			fileChooser.setFileFilter(new FileNameExtensionFilter("Text files","txt"));
			fileChooser.showOpenDialog(null);
			fileChooser.getSelectedFile();}
		);
		textFileToProcess = fileChooser.getSelectedFile();
		

		// process the text file. First stage: line number -> List of words
		lineContents = processTextFile(textFileToProcess);
		
		// Second stage: word -> number of appearances
		wordCount = countWords(lineContents);
		
		// save both maps. One in a binary file, the other in a text file
		mapToBinFile(lineContents, binFile);
		mapToTextFile(wordCount, textFile);
		
		// inform...
		EventQueue.invokeAndWait(()->
			JOptionPane.showMessageDialog(null,
					"Text processed. Results saved.\nPress OK to retrieve and check")
		);
		
		// retrieve information back from the files
		lc = binFileToMap(binFile);
		wc = textFileToMap(textFile);
		
		// show the results in a cute JFrame
		EventQueue.invokeAndWait(()-> {
			JFrame frame = new JFrame("Results of text processing. File: "+textFileToProcess.getName());
			JTextArea textAreaOne = new JTextArea();
			JScrollPane scrollOne = new JScrollPane(textAreaOne);
			JTextArea textAreaTwo = new JTextArea();
			JScrollPane scrollTwo = new JScrollPane(textAreaTwo);
			JPanel contentPane = new JPanel(new GridLayout(1,2,3,3));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(contentPane);
			textAreaOne.setForeground(Color.BLUE);
			textAreaTwo.setForeground(Color.RED);
			textAreaOne.setEditable(false);
			textAreaTwo.setEditable(false);
			scrollOne.setBorder(new TitledBorder("SELECTED WORDS IN LINES"));
			scrollTwo.setBorder(new TitledBorder("REPETITIONS OF SELECTED WORDS"));
	
			
			frame.getContentPane().add(scrollOne);
			frame.getContentPane().add(scrollTwo);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			textAreaOne.append("\n");
			for (int ln: lc.keySet()) {
				textAreaOne.append(" line "+ln+" => "+lineContents.get(ln)+"\n");
			}
			textAreaOne.setCaretPosition(0);
			
			textAreaTwo.append("\n");
			for (String w: wc.keySet()) {
				textAreaTwo.append(" "+w+": "+wordCount.get(w)+"\n");
			}
			
			frame.setSize(600, 800);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
	
	
	//---------- Text processing  procedures -----------------
	
	private static TreeMap<Integer, List<String>> processTextFile (File f) 
			       throws IOException {
		/* this procedure processes the given text file and produces a map
		   that binds each line number to the list of all all-uppercase words
		   appearing in that line.
		   Lines are numbered from 1 onwards
		   Those lines that do not contain any all-uppercase word DO NOT
		   appear in the map */
		
		
		/* COMPLETE 1 */
		TreeMap<Integer, List<String>> processedsLines = new TreeMap<Integer, List<String>>();
		BufferedReader brLines = new BufferedReader(new FileReader(f));
		int order = 1;
		String [] palabras = brLines.readLine().split("[\\\\s!?\\\"\\',;:.-]+");
		while (palabras!=null){
			for(String palabra: palabras) {
				if (palabra.length()>2 && palabra.equals(palabra.toUpperCase())) {
					try{
						processedsLines.get(order).add(palabra);
					}
					catch (Exception e){
						processedsLines.put(order, new ArrayList<String>());
						processedsLines.get(order).add(palabra);
					}
				}
				palabras = brLines.readLine().split("[\\\\s!?\\\"\\',;:.-]+");
				order++;
			}
		}
		return processedsLines; //Change appropriately
		
	}
	
	private static TreeMap<String, Integer> countWords (TreeMap<?, List<String>> lc) {
		/* This procedure produces a map that binds words to the number of times they
		   appear in a text. The only parameter is another map the values of which
		   are lists containing the words to be counted */
		
		/* COMPLETE 2 */
		TreeMap<String, Integer> numeroParaules = new TreeMap<String, Integer>();
		int contador = 0;
		int numRep = 1;
		for (List<String> palabras : lc.values()){
			for(String palabra: palabras){
				if(palabra.equals(palabras.get(contador))){
					numeroParaules.put(palabra, numRep);
					numRep++;
				}
				contador++;
			}
			numRep = 1;
			contador = 0;
		}
		return numeroParaules; //Change appropriately
	}


	
	// -------------- SAVE procedures ---------
	
	/* DO NOT MODIFY THIS PROCEDURE */
	private static void mapToBinFile (TreeMap<Integer, List<String>> map, File f) throws IOException {
		/* This procedure saves into a binary file (second parameter 
		 * contains its path) the contents of the given map (first
		 * parameter).
		 * The format of this file is "compatible" with the format
		 * of the file expected by procedure binFileToMap
		 */
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		
		for (int num : map.keySet()) {
			dos.writeInt(num);
			dos.writeInt(map.get(num).size());
			for (String s : map.get(num)) {
				dos.writeUTF(s);
			}
		}
		dos.close();
	}
	
	private static void mapToTextFile (TreeMap<String, Integer> map, File f) throws IOException {
		/* This procedure saves into a text file (second parameter 
		   contains its path) the contents of the given map (first
		   parameter).
		   The format of this file has to be compatible with the format
		   of the file expected by procedure textFileToMap */
		
		/* COMPLETE 3 */
		
	}
	
	
	// ------------------ RETRIEVE procedures --------------
	
	/* DO NOT MODIFY THIS PROCEDURE */
	private static TreeMap<String, Integer> textFileToMap (File f) throws IOException {
		TreeMap<String, Integer> result = new TreeMap<>();
		BufferedReader bur = new BufferedReader(new FileReader(f));
		
		String word = bur.readLine();
		String num;
		
		while (word!=null) {
			num = bur.readLine();
			result.put(word, Integer.valueOf(num)); //Updated code
			word = bur.readLine();
		}
		bur.close();
		
		return result;
	}
	
	
	private static TreeMap<Integer, List<String>> binFileToMap (File f) throws IOException {
		/* This procedure retrieves a map, from a bin file produced by
		 * mapToBinFile. Actually the map is created empty and then populated
		 * with the information retrieved from the file */
		
		/* COMPLETE 4 */

		return null; //Change appropriately
		
	}
	
}
