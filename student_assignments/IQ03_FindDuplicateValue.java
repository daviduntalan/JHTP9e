package student_assignments;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the duplicate values in an array.
 * for simplicity, use collection Set.
 * @author David
 */
public class IQ03_FindDuplicateValue {

    public static void main(String[] args) {
        int[] values = {5, 2, 3, 6, 4, 5};       

        if (isDuplicateExist(values)) 
            System.out.printf("yes! ");
        
        findDuplicate(values);
    }

    private static boolean findDuplicate(int[] values) {
        
        for (int i = 0; i < values.length; ++i) {
            for (int j = i + 1; j < values.length; ++j) {
                if (values[i] == values[j] && i != j) {
                    System.out.printf("we found duplicate value: %d\n",
                            values[i]);                    
                    return true;
                }
            }
        }
        
        return false;
    }

    private static boolean isDuplicateExist(int[] values) {
        Set<Integer> mySetCollection = new HashSet<>();
        for (int value : values) {
            if (mySetCollection.add(value) == false) {                
                return true;
            }
        }
        return false;
    }
}