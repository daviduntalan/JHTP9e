package Ch07_Arrays_and_ArrayLists;

import java.util.Random;

/**
 * Using the Elements of an Array as Counter.
 * Fig. 7.7: Die-rolling program using arrays instead of switch.
 * @author David
 */
public class RollDie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random random = new Random(); // random number generator
        int[] frequency = new int[7]; // array of frequency counters
        int faceValueAsIndex;
        
        // roll die 6,000,000 times; use die value as frequency index
        for (int roll = 0; roll < 6_000_000; ++roll) {
            faceValueAsIndex = 1 + random.nextInt(6); // random 1-6 as idx
            ++frequency[ faceValueAsIndex ]; // count the frequency of face
        }
        
        System.out.printf("%s%10s\n", "Face", "Frequency");
        
        // output each array element's value, 
        // skip 0 - not included in idx counting
        for (int face = 1; face < frequency.length; ++face) {
            System.out.printf("%4d%10d\n", face, frequency[face]);
        }
    }
    
}
