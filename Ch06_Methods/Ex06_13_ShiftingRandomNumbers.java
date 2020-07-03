package Ch06_Methods;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Write statements that assign random integers to the variable n in the
 * following ranges:
 *
 * @author David
 */
public class Ex06_13_ShiftingRandomNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        instruction();
        System.out.println("\nGeneralized Scalling and Shifting of Random Numbers:");

        for (char option = 'a'; option <= 'c'; option++) {
            System.out.printf("%c) ", option);
            
            switch (option) {
                case 'a': printValues(2, 2, 15); break;
                case 'b': printValues(3, 2, 10); break;
                case 'c': printValues(6, 4, 5); break;
            }

            System.out.println();
        }
        
    }

    private static void printValues(int shiftingValue, int differenceBetweenValues, int scalingFactor) {
        Random random = new Random();
        Set randomNumbers = new LinkedHashSet();       
        int number;
        do {
            number = shiftingValue + differenceBetweenValues
                    * random.nextInt(scalingFactor);
            randomNumbers.add(number);
        } while (randomNumbers.size() < scalingFactor);        
        System.out.print(randomNumbers);
    }
    
    private static void instruction() {
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
