package Ch07_Arrays_and_ArrayLists;

/**
 * 2-Dimensional Arrays with Rows of Different Lengths.
 * The manner in which multidimensional arrays are represented makes
 * them quite flexible. In fact, the lengths of the rows in array 
 * jaggedArray are NOT required to be the same. Each element of 
 * jaggedArray is a reference to a one-dimensional array of int 
 * variables. The int array for row 0 is a one-dimensional array
 * with two elements (1 and 2), row 1 is a one-dimensional array
 * with three elements (3, 4 and 5), row 2 is a one-dimensional array
 * with four elements (6, 7, 8, 9 and 10) and row 3 is a one-dimensional
 * array with two elements (11 and 12).
 * @author David
 */
public class Array2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] jaggedArray = new int[][] {
            {1, 2},
            {3, 4, 5},
            {6, 8, 9, 10},
            {11, 12}
        };
        
        for (int[] arrays : jaggedArray) {
            for (int element : arrays) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
        
        /* A multi-dimensional array in which each row has a different
        number of columns can be created as follows: */
        int[][] array = new int[2][]; // create 2 rows
        array[0] = new int[5]; // create 5 columns for row 0
        array[1] = new int[3]; // create 3 columns for row 1
        
        for (int[] arr : array) {
            for (int e : arr) {
                System.out.printf("%d ", e);
            }
            System.out.println();
        }
    }
    
}
