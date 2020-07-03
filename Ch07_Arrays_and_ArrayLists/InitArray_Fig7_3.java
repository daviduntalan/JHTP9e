package Ch07_Arrays_and_ArrayLists;

/**
 * Initializing the elements of an array with an array initializer.
 * Fig. 7.3
 * @author David
 */
public class InitArray_Fig7_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declare array named intRefArray and create the array object
        // using an array initializer
        int[] intRefArray = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 }; 
        
        System.out.printf("%s%8s\n", "Index", "Value"); // column headings
        // output each array element's value
        for (int counter = 0; counter < intRefArray.length; ++counter) {
            System.out.printf("%5d%8d\n", counter, intRefArray[counter]);
        }
        
        int[] n = { 10, 20, 30, 40, 50 }; // Using an Array Initializer
        
    }
    
}
