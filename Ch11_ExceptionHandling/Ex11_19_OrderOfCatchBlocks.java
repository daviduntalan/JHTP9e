package Ch11_ExceptionHandling;

import java.util.InputMismatchException;

/**
 * Order of catch Blocks. Write a program that shows that the order of
 * catch blocks is important. If you try to catch a superclass 
 * exception type before a subclass type, the compiler should generate
 * errors.
 * @author David
 */
public class Ex11_19_OrderOfCatchBlocks {

    public static void main(String[] args) {
        
        try {
            int c = 5 / 0;
            throw new InputMismatchException("Invalid input");
        } 
        /* intentionally place here before subclasses as required by exercises.
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        } */
        catch (InputMismatchException | ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }                 
    }
    
}
