package student_assignments;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the first non-repeating character in a string.
 * @author David
 */
public class IQ22_First_NonRepeating_Char {

    public static void main(String[] args) {
        
        String letters = "AABBCDDEE";
        HashMap<Character, Integer> bucket = new HashMap<>();
        int count = 0;
        for (char ch : letters.toCharArray()) {
            count = 1; // count for each unique letter
            if (bucket.containsKey(ch)) {
                // additional count for existing one
                count = bucket.get(ch) + 1;
            }
            bucket.put(ch, count);
        }
        
        for (Map.Entry<Character, Integer> entry : bucket.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("first non-repeating character: "
                    + entry.getKey());
            }
        }
    }
    
}
