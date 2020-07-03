package Ch07_Arrays_and_ArrayLists;

import java.util.Arrays;

/**
 * Writ statements that perform the following one-dimensional-array ops.
 * @author David
 */
public class Ex07_11_Operation1D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set the 10 elements of integer array counts to zero
        int[] counts = new int[10];
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            System.out.printf("counts[%d]: %d\n", i, count);
        }
        
        // add 1 to each of the 15 elemetns of integer array bonus
        int[] bonus = new int[15];
        for (int i = 0; i < bonus.length; i++) {
            bonus[i] = new java.util.Random().nextInt(100);
            System.out.printf("bonus[%d]: %d + 1 = %d\n", 
                    i, bonus[i], bonus[i] + 1);
        }
        
        int[] bestScores = new int[10];
        for (int i = 0; i < bestScores.length; ++i) {
            bestScores[i] = new java.util.Random().nextInt(100);
            System.out.printf("bestScores[%d]: %d\n", i, bestScores[i]);
        }
        Arrays.sort(bestScores);
        System.out.println("Top 5 Best Score:");
        for (int i = bestScores.length-1; i >= bestScores.length-5; --i) {
            System.out.printf("bestScores[%d]: %d\n", i, bestScores[i]);
        }
    }
    
}
