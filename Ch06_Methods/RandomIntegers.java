package Ch06_Methods;

import java.util.Random;

/**
 * Shifted and scaled random integers. Fig. 6.6
 *
 * @author David
 */
public class RandomIntegers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random randomNumbers = new Random();
        // generates a random int value in the range -2,147,483,648 
        // to +2,147,483,647, inclusive.
        int randomValue = randomNumbers.nextInt();
        randomValue = randomNumbers.nextInt(2);  // 0-1 for coin tossing
        randomValue = randomNumbers.nextInt(6);  // 0-5 for rolling a six-sided die
        int face; // stores each random int generated: 1-6 for rolling a six-sided die

        for (int counter = 1; counter < 20+1; ++counter) {
            // pick random integer from 1 to 6
            face = 1 + randomNumbers.nextInt(6);
            System.out.printf("%d ", face);
            
            // if counter is divisible by 5, start a new line of output
            if (counter % 5 == 0) System.out.println();
        }

    }

}
