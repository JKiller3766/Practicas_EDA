package pckg;

import java.util.Random;

public class Exer_04_Hamming {


    public static void main (String [] args) {
        /* COMPLETE */int num;
    for (int i = 0; i<10; i++){
        num = genHamming();
        System.out.println("Numero de Hamming: "+num + " ,és un numero de Hamming realment? " + isNumHamming(num));
        }

    for (int i = 0; i<10; i++){
        num = genNotHamming();
        System.out.println("Numero que no es de Hamming: "+num + " ,és un numero de Hamming realment? " + isNumHamming(num));
    }
}


    /* COMPLETE */
    // write here the code to determine whether a number is a Hamming number or not
    private static boolean isNumHamming(int num){
        if(num == 1) return true;

        if(num%2 == 0) return isNumHamming(num/2);
        if(num%3 == 0) return isNumHamming(num/3);
        if(num%5 == 0) return isNumHamming(num/5);

        return false;
    }

    /*DO NOT MODIFY CODE BELOW*/
    private static int genHamming(){
        Random rand = new Random();
        int num = rand.nextInt(10);
        int hammingNr = 2;
        int maxNum = Integer.MAX_VALUE/14;
        while(num>=1 && hammingNr<maxNum){ //10% chance that it will stop
            int multiplier = rand.nextInt(2,7); //From 2 to 6
            hammingNr = hammingNr*multiplier;
            num = rand.nextInt(11);
        }
        return hammingNr;
    }


    private static int genNotHamming(){
        Random rand = new Random();
        int num = rand.nextInt(10);
        int notHammingNr = 7;
        int maxNum = Integer.MAX_VALUE/14;
        while(num>=1 && notHammingNr<maxNum){ //Aprox 10% chance that it will stop
            int multiplier = rand.nextInt(2,20); //From 2 to 6
            notHammingNr = notHammingNr*multiplier;
            num = rand.nextInt(11);
        }
        return notHammingNr;
    }

}
