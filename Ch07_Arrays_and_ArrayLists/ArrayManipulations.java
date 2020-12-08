package Ch07_Arrays_and_ArrayLists;

import java.util.Arrays;

/**
 * Fig. 7.22: Arrays class methods and System.arraycopy.
 *
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
        System.out.printf("\ndoubleArray: ");

        for (double value : doubleArray)
            System.out.printf("%.1f ", value);

        // fill 10-element array with 7s
        int[] filledIntArray = new int[10];
        Arrays.fill(filledIntArray, 7);
        displayArray(filledIntArray, "filledIntArray");

        // copy array intArrayOrig into array intArrayCopy
        int[] intArrayOrig = {1, 2, 3, 4, 5, 6};
        int[] intArrayCopy = new int[intArrayOrig.length];
        System.arraycopy(intArrayOrig, 0, intArrayCopy, 0, intArrayOrig.length);
        displayArray(intArrayOrig, "intArrayOrig");
        displayArray(intArrayCopy, "intArrayCopy");

        // compare intArrayOrig and intArrayCopy for equality
        boolean b = Arrays.equals(intArrayOrig, intArrayCopy);
        System.out.printf("\n\nintArrayOrig %s intArrayCopy\n", b ? "==" : "!=");

        // compare intArrayOrig and filledIntArray for equality
        b = Arrays.equals(intArrayOrig, filledIntArray);
        System.out.printf("intArrayOrig %s filledIntArray\n", b ? "==" : "!=");

        // NOTE: Passing an unsorted array to binarySearch is a logic error
        // --the value returned is undefined.
        // search intArrayOrig for the value 5
        int location = Arrays.binarySearch(intArrayOrig, 5);
        if (location >= 0) {
            System.out.printf("Found 5 at index %d in intArrayOrig\n", location);
        } else {
            System.out.println("5 not found in intArrayOrig");
        }

        // search intArrayOrig for the value 8763
        int key = 8763;
        location = Arrays.binarySearch(intArrayOrig, key);
        if (location >= 0) {
            System.out.printf("Found %d at index %d in intArrayOrig\n", key, location);
        } else {
            System.out.printf("%d not found in intArrayOrig\n", key);
            System.out.printf("Returned index: (%d)\n\t%s\n", location,
                    "binarySearch returns a negative value. The negative value "
                            + "returned is based on the search key’s insertion point "
                            + "— the index (minus one) where the key would be inserted in the array "
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
