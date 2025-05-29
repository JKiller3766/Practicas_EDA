package pckg;

public class Exer_02_ChangeToBinary {

	
	public static void main (String [] args) {

		/* COMPLETE */
		//Perform some tests here
		System.out.println("33 = " + toBinaryString(33));
		System.out.println("278 = " + toBinaryString(278));
		System.out.println("225 = " + toBinaryString(225));
		System.out.println("545 = " + toBinaryString(545));
		System.out.println("1214 = " + toBinaryString(1214));
		System.out.println("44 = " + toBinaryString(44));
		System.out.println("95 = " + toBinaryString(95));
		System.out.println("0 = " + toBinaryString(0));
		System.out.println("1 = " + toBinaryString(1));
		System.out.println("78 = " + toBinaryString(78));
		System.out.println("729 = " + toBinaryString(729));

	}
	
	
	public static String toBinaryString(int n) {
		/* COMPLETE */
		// Write the recursive function that creates the binary representation of n (n>=0)
		if (n == 0) {
			return "0";
		} else if (n /2 == 0) {
			return "" + n%2;
		}
		else {
			String binary = "" + n%2;
			return toBinaryString((n/2)) + binary;
		}
	}
	
	
}
