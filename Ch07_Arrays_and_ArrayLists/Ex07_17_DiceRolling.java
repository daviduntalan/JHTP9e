package Ch07_Arrays_and_ArrayLists;

import java.util.Random;

/**
 * Dice Rolling. Write an application to simulate the rolling of two dice. The
 * application should use an object of class Random once to roll the first die
 * and again to roll the second die. The sum of the two should be calculated.
 * Each die can show an integer value from 1 to 6, so the sum of the values will
 * vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the least
 * frequent. Fig. 7.28 shows the 36 possible combinations/sums of the two dice.
 * Your application show roll the dice 36,000,000 times. Use a one- dimensional
 * array to tally the number of times each possible sum appears. Display the
 * result in tabular format.
 *
 * @author David
 */
public class Ex07_17_DiceRolling {

    public static void main(String[] args) {

        Random random = new Random();
        int[] sumFrequency = new int[12 + 1];
        int die1, die2, sum;

        for (int ntimes = 0; ntimes < 36_000_000; ++ntimes) {
            die1 = 1 + random.nextInt(6);
            die2 = 1 + random.nextInt(6);
            sum = die1 + die2;
            ++sumFrequency[sum];
        }

        System.out.printf("%4s%12s\n", "Face", "Frequency");
        for (int face = 2; face < sumFrequency.length; ++face) {
            System.out.printf("%4d%,12d\n", face, sumFrequency[face]);
        }
    }

}