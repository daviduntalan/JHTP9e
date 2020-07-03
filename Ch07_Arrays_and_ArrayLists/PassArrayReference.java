package Ch07_Arrays_and_ArrayLists;

/**
 * Passing arrays and individual array elements to methods.
 * Fig. 7.13:
 * @author David
 */
public class PassArrayReference {

    /**
     * main creates array and calls modifyArray and modifyElement
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] array = { 1, 2, 3, 4, 5 };
        System.out.println("Effects of passing reference to entire array:\n"
                + "The values of the original array are:");
        
        // output orginal array elements
        for (int value : array) {
            System.out.printf("   %d", value);                                                
        }
        
        modifyArray( array ); // pass array reference
        System.out.println("\n\nThe values of the modified array are:");
        
        // output orginal array elements
        for (int value : array) {
            System.out.printf("   %d", value);                                                
        }
        
        System.out.printf("\n\nEffects of passing array element value:\n"
                + "array[3] before modifyElement: %d\n", array[3]);
        
        modifyElement( array[3] ); // attempt to modify array[3]
        
        System.out.printf("array[3] after modifyElement: %d\n", array[3]);
    }

    // multiple each element of an array by 2
    // this method receives a copy of the reference.
    private static void modifyArray(int[] array) {
        for (int counter = 0; counter < array.length; ++counter) {
            array[counter] *= 2;
        }
    }

    // multiply argument by 2
    // this method receives a copy of the [array] element's value.
    private static void modifyElement(int element) {
        element *= 2; // modifying the copy in the called method does not affect the
        // original value of that element in the calling method’s array.
        System.out.printf("Value of element in modifyElement: %d\n", element);
    }
    
}
