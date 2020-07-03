package Ch07_Arrays_and_ArrayLists;

/**
 * Initializing two-dimensional arrays. Fig. 7.17
 *
 * @author David
 */
public class InitArray_Fig7_17 {

    /**
     * create and output two-dimensional arrays
     */
    public static void main(String[] args) {

        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array2 = {{1, 2}, {3}, {4, 5, 6}};
        int total = 0; // saves the running total
        
        System.out.println("Values in array1 by row are");
        total = outputArray(array1); // displays array1 by row
        System.out.printf("Running total: %d\n", total);
        
        System.out.println("\nValues in array2 by row are");
        total = outputArray(array2); // displays array1 by row
        System.out.printf("Running total: %d\n", total);
    }

    // output rows and columns of a two-dimensional array
    private static int outputArray(int[][] array) {        
        int total = 0; // loop through array's rows, 
        // array.length determines the number of rows in the array
        for (int row = 0; row < array.length; ++row) {
            // loop through columns of current row
            for (int col = 0; col < array[row].length; ++col) {
                System.out.printf("%d ", array[row][col]);
                total += array[row][col];
            }
            System.out.println();
        }
        return total;
    }

}
