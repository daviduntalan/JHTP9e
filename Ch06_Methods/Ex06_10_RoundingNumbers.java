package Ch06_Methods;

import java.util.Scanner;

/**
 * Rounding Numbers. Math.floor can be used to round values to the nearest
 * integer--e.g., 
 *  
 *      y = Math.floor(x + 0.5);
 * 
 * will round the number x to the nearest integer and assign the result 
 * to y. Write an application that reads double values and uses the 
 * preceding statement to round each of the numbers to the nearest
 * integer. For each number processed, display both the original and
 * the rounded number.
 * 
 * @author David
 */
public class Ex06_10_RoundingNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter double values to round (0 to stop): ");
        // double value = input.nextDouble();
        double value = 9.87654321;
        System.out.println(value);
        while (value != 0.0) {                                    
            System.out.printf("result of Math.floor((%f + 0.5)) is %.1f (1s)\n", value, roundToInteger(value));
            System.out.printf("result of Math.floor((%f + 0.5)) is %.2f (10ths)\n", value, roundToTenths(value));
            System.out.printf("result of Math.floor((%f + 0.5)) is %.3f (100ths)\n", value, roundToHundredths(value));
            System.out.printf("result of Math.floor((%f + 0.5)) is %.4f (1000ths)\n", value, roundToThousandths(value));
        
            System.out.printf("Enter double values to round (0 to stop): ");
            value = input.nextDouble();
        }
    }
    
    private static double roundToInteger(double number) {
        return Math.floor(number + 0.5);
    }

    private static double roundToTenths(double number) {
        return Math.floor(number * 10 + 0.5) / 10;
    }
    
    private static double roundToHundredths(double number) {
        return Math.floor(number * 100 + 0.5) / 100;
    }
    
    private static double roundToThousandths(double number) {
        return Math.floor(number * 1000 + 0.5) / 1000;
    }
}
