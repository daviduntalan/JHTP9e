package Ch07_Arrays_and_ArrayLists;

/**
 * Rewrite Fig. 7.2 so that the size of the array is specified by the first
 * command-line argument. If no command-line argument is supplied, use 10 as the
 * default size of the array.
 * 
 * NOTE: Press Shift+F6 to test default size of the array 
 * otherwise, Press F6 with command-line argument supplied.
 *
 * @author David
 */
public class Ex07_15_CommandLineArgs {

    public static void main(String[] args) {

        int[] intRefArray = null;

        // check number of command-line arguments
        switch (args.length) {
            case 0:
                intRefArray = new int[10]; // create default size array
                break;
            case 1:
                // get array size from first command-line argument
                int arrayLength = Integer.parseInt(args[0]);
                intRefArray = new int[arrayLength]; // create array
                break;
            default:
                System.err.println("Error: Please enter an array size.");
        }

        System.out.printf("%s%8s\n", "Index", "Value");
        // output each array element's value
        for (int counter = 0; counter < intRefArray.length; ++counter) {
            System.out.printf("%5d%8d\n", counter, intRefArray[counter]);
        }

    }
}
