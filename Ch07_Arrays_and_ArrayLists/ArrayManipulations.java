package Ch07_Arrays_and_ArrayLists;
import java.util.Arrays;
/**
 * Fig. 7.22: Arrays class methods and System.arraycopy.
 * @author David
 */
public class ArrayManipulations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // sort doubleArray into ascending order
        double[] doubleArray = {8.4, 9.3, 0.2, 7.9, 3.4};
        Arrays.sort(doubleArray); // ascending
        System.out.printf("\ndouleArray: ");
        
        for (double value : doubleArray)
            System.out.printf("%.1f ", value);
        
        // fill 10-element array with 7s
        int[] filledIntArray = new int[10];
        Arrays.fill(filledIntArray, 7);
        displayArray(filledIntArray, "filledIntArray");
        
        // copy array intArray into array intArrayCopy
        int[] intArray = {1, 2, 3, 4, 5, 6};
        int[] intArrayCopy = new int[intArray.length];
        System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
        displayArray(intArray, "intArray");
        displayArray(intArrayCopy, "intArrayCopy");
        
        // compare intArray and intArrayCopy for equality
        boolean b = Arrays.equals(intArray, intArrayCopy);
        System.out.printf("\n\nintArray %s intArrayCopy\n", b ? "==" : "!=");
        
        // compare intArray and filledIntArray for equality
        b = Arrays.equals(intArray, filledIntArray);
        System.out.printf("intArray %s filledIntArray\n", b ? "==" : "!=");
        
        // NOTE: Passing an unsorted array to binarySearch is a logic error
        // --the value returned is undefined.
        // search intArray for the value 5
        int location = Arrays.binarySearch(intArray, 5);
        if (location >= 0) {
            System.out.printf("Found 5 at index %d in intArray\n", location);
        } else {
            System.out.println("5 not found in intArray");            
        }
        
        // search intArray for the value 8763
        location = Arrays.binarySearch(intArray, 8763);
        if (location >= 0) {
            System.out.printf("Found 8763 at index %d in intArray\n", location);
        } else {
            System.out.println("8763 not found in intArray");
            System.out.printf("Returned index: (%d)\n\t%s\n", location, 
                    "binarySearch returns a negative value. The negative value "
                    + "returned is based on the search key’s insertion point"
                    + "—the index where the key would be inserted in the array "
                    + "if we were performing an insert operation.");
        }
    }

    // output values in each array
    private static void displayArray(int[] array, String description) {
        System.out.printf("\n%s: ", description);
        for (int value : array) 
            System.out.printf("%d ", value);
    } // end method displayArray
    
} // end class ArrayManipulations
