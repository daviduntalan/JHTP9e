package student_assignments;

import java.util.HashMap;

/**
 * Write a function that returns the count of unique string 
 * values passed into a method. A much like Frequency.
 * @author David
 */
public class IQ04_CountUniqueLetter {

    private static int count = 0;
    private static HashMap<Character, Integer> hmCountFreq = new HashMap<>();
    
    public static void main(String[] args) {
        
        
        String msg = "David, Jr. Untalan Jr.";
        
        System.out.printf("Using HashMap():\n");
        for (int i = 0; i < msg.length(); ++i) {
            System.out.printf("count for letter %c is %d\n", 
                    msg.charAt(i), countUniqueLetter(msg.charAt(i)));
        }
        
        System.out.printf("\nUsing Array Frequency:\n");
        for (int i = 0; i < msg.length(); ++i) {
            System.out.printf("count for letter %c is %d\n", 
                    msg.charAt(i), countLetter(msg.charAt(i)));
        }
    }
    
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                        + " ,abcdefghijklmnopqrstuvwxyz.";
    private static int[] frequency = new int[alphabet.length()];
        
    
    private static int countLetter(Character letter) {
        
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == letter) {
                return ++frequency[i]; 
            }            
        }
        
        return 1;
    }

    private static int countUniqueLetter(Character letter) {
        
        // if the letter doesn't exist then, add
        if (hmCountFreq.get(letter) == null) {            
            count = 1;
            hmCountFreq.put(letter, count);
        } else {
            count = hmCountFreq.get(letter) + 1;
            hmCountFreq.put(letter, count);            
        }
        
        // get the value of the key/value pair within the hash map
        return hmCountFreq.get(letter);
    }

}