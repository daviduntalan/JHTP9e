package Ch11_ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Fig. 11.2: Handling ArithmethicExceptions and InputMismatchExceptions.
 * @author David
 */
public class DivideByZeroWithExceptionHandling {

    // demonstrate throwing an exception when a divivde-by-zero occurs
    public static int quotient(int numerator, int denominator) 
            throws ArithmeticException // - may throw an ArithmeticException.
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
            } catch (InputMismatchException inputMismatchException) {
                System.err.printf("\nException: %s\n", inputMismatchException);
                scanner.nextLine(); // discard input so user can try again
                System.out.println("You must enter integers. Please try again.\n");
                // throw new ArithmeticException("from catch-block"); // will test for next catch-block
            } catch (ArithmeticException arithmeticException) {
                System.err.printf("\nException: %s\n", arithmeticException);
                System.out.println("Zero is an invalid denominator. Please try again.\n");
            }
        } while (continueLoop);
    }
    
}

/* Line 35, b'coz an InputMismatchException occurred, the call to method nextInt 
never successfully read in the user’s data—so we read that input with a call to 
method nextLine. We do not do anything with the input at this point, because we 
know that it’s invalid. */