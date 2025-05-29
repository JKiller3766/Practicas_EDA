package pckg;


import java.util.Random;

public class Exer_01_GCF {

	public static void main (String [] args) {
		int pos = 0;
		int x;
		int y;
		Random rand = new Random();
		/* COMPLETE */
		/* Write here a program that generates 100000 pairs of numbers
		between [1, 5000] to check that the function calculates the GCF.*/
		while(pos < 100000) {
			x= rand.nextInt(1,5001);
			y = rand.nextInt(1,5001);
			System.out.print("Parella: " +x + " y " + y + "\nMCD "+recursiveGCF(x, y) + "\nMCD iteratiu: "+iterativeGCF(x,y) +"\n\n");
			pos++;
		}


	}
	
	
	/* COMPLETE */
	// write here a recursive function that calculates the GCF using Dijkstra's algorithm
	public static int recursiveGCF(int x, int y) {
		// base case
		if (x == y) {
			return x;
		}
		if (x > y ){
			return recursiveGCF(x-y, y);
		}
		else {
			return recursiveGCF(x, y-x);
		}
	}

	/*DO NOT MODIFY CODE BELOW*/
	public static int iterativeGCF(int x, int y) {
		// iterative gcf. Do not modify this function
		int inter;
		int small = Math.min(x, y);
		int great = Math.max(x, y);
		int remainder = great%small;
		while (remainder!=0) {
			inter = small;
			small = Math.min(small, remainder);
			great = Math.max(inter, remainder);
			remainder = great%small;
		}
		return small;
	}
	

}