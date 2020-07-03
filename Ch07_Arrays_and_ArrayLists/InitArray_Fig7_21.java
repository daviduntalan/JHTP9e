package Ch07_Arrays_and_ArrayLists;

/**
 * Fig. 7.21: Initializing an array using command-line arguments.
 * @author David
 */
public class InitArray_Fig7_21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // check number of command-line arguments
        if (args.length != 3) {
            System.err.println("Error: Pleae re-enter the entire command, including\n"
                    + "an array size, initial value and increment.");
        } else {
            // get array size from first command-line argument
            int arrayLength = Integer.parseInt(args[0]);
            int[] array = new int[arrayLength]; // create array
            
            // get initial value and increment from command-line arguments
            int initialValue = Integer.parseInt(args[1]);
            int incrementBy = Integer.parseInt(args[2]);
            
            // calculate value for each array element
            for (int counter = 0; counter < array.length; ++counter) {
                array[counter] = initialValue + incrementBy * counter;
            }
            
            System.out.printf("Array length: %d\n", arrayLength);
            System.out.printf("Initial value: %d\n", initialValue);
            System.out.printf("Increment by: %d\n\n", incrementBy);
            
            System.out.printf("%s%8s\n", "Index", "Value");
            
            // display array index and value
            for (int counter = 0; counter < array.length; ++counter) {
                System.out.printf("%5d%8d = %d + (%2d = %d x %d)\n", counter, array[counter], 
                        initialValue, incrementBy*counter, incrementBy, counter);
            }
        } // end else
    } // end main
    
} // end class InitArray_Fig7_21
