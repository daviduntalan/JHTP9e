package Ch06_Methods;

import java.util.Random;

/**
 * Roll a six-sided die 6,000,000 times. Fig. 6.7
 *
 * @author David
 */
public class RollDie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random randomNumbers = new Random();
        int frequency1 = 0; // maintains count of 1s rolled
        int frequency2 = 0; // maintains count of 2s rolled
        int frequency3 = 0; // maintains count of 3s rolled
        int frequency4 = 0; // maintains count of 4s rolled
        int frequency5 = 0; // maintains count of 5s rolled
        int frequency6 = 0; // maintains count of 6s rolled

        int face; // most recently rolled value

        for (int roll = 1; roll < 6_000_000 + 1; ++roll) {
            // pick random integer from 1 to 6
            face = 1 + randomNumbers.nextInt(6);
            switch (face) {
                case 1: ++frequency1; break; // increment the 1s counter
                case 2: ++frequency2; break; // increment the 2s counter
                case 3: ++frequency3; break; // increment the 3s counter
                case 4: ++frequency4; break; // increment the 4s counter
                case 5: ++frequency5; break; // increment the 5s counter
                case 6: ++frequency6; break; // increment the 6s counter
            }
        }
        System.out.println("Face\tFrequency"); // output headers
        System.out.printf("1\t%9d\n2\t%9d\n3\t%9d\n4\t%9d\n5\t%9d\n6\t%9d\n", 
                frequency1, frequency2, frequency3,
                frequency4, frequency5, frequency6);
        System.out.printf("Frequency sum: %9d\n", 
                frequency1+ frequency2+ frequency3+
                frequency4+ frequency5+ frequency6);
        
        
        System.out.println("\nGeneralized Scalling and Shifting of Random Numbers:");
        int scalingFactor = 5;
        int shiftingValue = 2;
        int differenceBetweenValues = 3;
        int number = shiftingValue 
                + differenceBetweenValues 
                * randomNumbers.nextInt(scalingFactor);
        System.out.println("The following produces (2, 5, 8, 11 and 14):");
        for (int i = 0; i < 5; ++i) {
            System.out.printf("%d ", number);
            number = shiftingValue 
                + differenceBetweenValues 
                * randomNumbers.nextInt(scalingFactor);
        }
        
        System.out.println("\n\nRandom-Numbers Repeatedly for Testing and Debugging:");
        System.out.println("\tWhen debugging an app, it's often useful to repate the exact same sequence of");
        System.out.println("pseudorandom numbers during each execution of the program. This repeatability enables");
        System.out.println("you to prove that your application is working for a specifiec sequence of random numbers");
        System.out.println("before you test it with different sequences of random numbers. When repeatability is");
        System.out.println("important, you can create a Random object as follows:");
        System.out.println("\n\tRandom randomNumbers = new Random( seedValue );\n");
        System.out.println("The seedValue argument (of type long) seeds the random-number calculation. If the");
        System.out.println("same seedValue is used every time, the Random object produces the same sequence of num-");
        System.out.println("bers. You can set a Random object's seed at any time during program execution by calling");
        System.out.println("the object's set method, as in");
        System.out.println("\n\trandomNumbers.set( seedValue );\n");
        
    }

}
