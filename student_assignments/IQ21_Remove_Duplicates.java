package student_assignments;

import java.util.HashSet;

/**
 * How to remove duplicate values fro a string?
 * YT: https://youtu.be/eYz_2KFjCVM
 *
 * @author David
 */
public class IQ21_Remove_Duplicates {

    public static void main(String[] args) {

        String words = "door coffee floor dog dinosaur coffee car car money floor";
        String[] wordsArray = words.split(" ");
        HashSet<String> newBucket = new HashSet<>();
        words = ""; // reset words to empty string
        for (String word : wordsArray) {
            if (newBucket.add(word) == true) {
                words += word + " ";
            }
        }
        
        System.out.println(words);
    }

}
