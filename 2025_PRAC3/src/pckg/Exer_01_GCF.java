package pckg;


import java.util.Random;

public class Exer_01_GCF {
	
	public static void main (String [] args) {
		/* COMPLETE */
		/* Write here a program that generates 100000 pairs of numbers
		between [1, 5000] to check that the function calculates the GCF.*/

	}
	
	
	/* COMPLETE */
	// write here a recursive function that calculates the GCF using Dijkstra's algorithm


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
