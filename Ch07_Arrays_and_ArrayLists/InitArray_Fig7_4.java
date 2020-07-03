package Ch07_Arrays_and_ArrayLists;

/**
 * Calculating the values to be placed into the elements of an array.
 * Fig. 7.4
 * @author David
 */
public class InitArray_Fig7_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int ARRAY_LENGTH = 10; // declare constant
        int[] intRefArray = new int[ARRAY_LENGTH]; // create array
        
        // calculate value for each array element
        for (int counter = 0; counter < intRefArray.length; ++counter) {
            intRefArray[counter] = 2 + 2 * counter;
        }
        
        System.out.printf("%s%8s\n", "Index", "Value"); // column headings
        // output each array element's value
        for (int counter = 0; counter < intRefArray.length; ++counter) {
            System.out.printf("%5d%8d\n", counter, intRefArray[counter]);
        }
        
        int[] n = { 10, 20, 30, 40, 50 }; // Using an Array Initializer
        
    }
    
}
