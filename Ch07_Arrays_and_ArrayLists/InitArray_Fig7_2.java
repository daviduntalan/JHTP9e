package Ch07_Arrays_and_ArrayLists;

/**
 * Initializing the elements of an array to default values of zero.
 * Fig. 7.2
 * @author David
 */
public class InitArray_Fig7_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] intRefArray; // declare array named intRefArray
        intRefArray = new int[10]; // create the array object
        
        System.out.printf("%s%8s\n", "Index", "Value");
        // output each array element's value
        for (int counter = 0; counter < intRefArray.length; ++counter) {
            System.out.printf("%5d%8d\n", counter, intRefArray[counter]);
        }
        
        int[] n = { 10, 20, 30, 40, 50 }; // Using an Array Initializer
        
    }
    
}
