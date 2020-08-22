package Ch11_ExceptionHandling;

import java.util.Scanner;
/**
 * Fig. 11.1: Integer division without exception handling.
 * @author David
 */
public class DivideByZeroNoExceptionHandling {

    // demonstrate throwing an exception when a divivde-by-zero occurs
    public static int quotient(int numerator, int denominator) {
        
        return numerator / denominator; // possible division by zero
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner( System.in ); // scanner for input
        
        System.out.printf("Please enter an integer numerator: ");
        int numerator = scanner.nextInt();
        System.out.printf("Please enter an integer denominator: ");
        int denominator = scanner.nextInt();
        
        int result = quotient(numerator, denominator);
        System.out.printf("\nResult: %d / %d = %d\n", 
                numerator, denominator, result);
    }
    
}
