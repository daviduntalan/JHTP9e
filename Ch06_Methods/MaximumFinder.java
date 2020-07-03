package Ch06_Methods;

import java.util.Scanner;

/**
 * Programmer-declared method maximum with three double parameters. 
 * Fig. 6.3
 *
 * @author David
 */
public class MaximumFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create Scanner for input from command window
        Scanner input = new Scanner(System.in);

        // prompt for and input three floating-point values
        System.out.print("Enter three floating-point values separated by spaces: ");
        double number1 = input.nextDouble();
        double number2 = input.nextDouble();
        double number3 = input.nextDouble();

        // determine the maximum value
        double result = maximum(number1, number2, number3);

        // display maximum value
        System.out.printf("%s: %.2f\n", "Maximum is", result);
    }

    // obtain three floating-point values and locate the maximum value
    public static double maximum(double x, double y, double z) {
        /*
        // assume x is the largest to start
        double maximumValue = x;

        // determine whether y is greater than maximumValue
        if (y > maximumValue) {
            maximumValue = y;
        }

        // determine whether z is greater than maximumValue
        if (z > maximumValue) {
            maximumValue = z;
        }

        return maximumValue;
        */
        
        return Math.max(x, Math.max(y, z));
    }

}
