package Ch07_Arrays_and_ArrayLists;

/**
 * Arrays are objects, so they're considered reference types.
 * What we typically think of as an array array is actually a
 * reference to an array object in memory. 
 * Like other objects, arrays are created with keyword new.
 * When an array is created, each element of the array 
 * receive a default value--zero for the numeric primitive-type
 * elements, false for boolean elements and null for references.
 * @author David
 */
public class DeclaringAndCreatingArrays {

    int[] c = new int[ 12 ]; // returns reference, stored in an array variable.    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] d; // declare the array variable
        d = new int[ 12 ]; // create the array; assign to array variable
        
        // a progrm can create several arrays i a single declaration.
        // the following declaration reserves 100 elements for b and 27
        // for x:
        // String[] b = new String[100], x = new String[27];
        
        // for readability, declare only one variable per declaration.
        String[] b = new String[100]; // create array b
        String[] x = new String[27]; // create array x
        
    }
    
}
