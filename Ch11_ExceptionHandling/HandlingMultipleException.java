package Ch11_ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Fig. 11.12: (New in Java SE 7) Multi-catch:
 * Handling Multiple Exception in One catch.
 * 
 * @author David
 */
public class HandlingMultipleException {

    // demonstrate throwing an exception when a divivde-by-zero occurs
    public static int quotient(int numerator, int denominator) 
            throws ArithmeticException
    {
        return numerator / denominator; // possible division by zero
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner( System.in ); // scanner for input
        boolean continueLoop = true; // determines if more input is needed
        
        do {            
            try {
                System.out.printf("Please enter an integer numerator: ");
                int numerator = scanner.nextInt();
                System.out.printf("Please enter an integer denominator: ");
                int denominator = scanner.nextInt();
                
                int result = quotient(numerator, denominator);
                System.out.printf("\nResult: %d / %d = %d\n",
                        numerator, denominator, result);
            } catch (InputMismatchException | ArithmeticException exception) {
                System.err.printf("\nException: %s\n", exception);
                scanner.nextLine(); // discard input so user can try again
                System.out.println("Please try again.\n");
            }
        } while (continueLoop);
    }
    
}
