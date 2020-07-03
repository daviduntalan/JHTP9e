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
public class Ex06_09_RoundingNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter double values to round (0 to stop): ");
        double value = input.nextDouble();
        while (value != 0.0) {
            double y = Math.floor(value + 0.5);
            System.out.printf("result of Math.floor((%.2f + 0.5)) is %.2f\n", value, y);
        
            System.out.printf("Enter double values to round (0 to stop): ");
            value = input.nextDouble();
        }
    }
    
}
