package Ch11_ExceptionHandling;

import java.util.Scanner;

/**
 * Fig. 11.7: Checking with assert that a value is within range.
 * Command-line compilation:
 * > java -ea AssertTest
 * or set VM options to -ea to test this out.
 * 
 * assert means: 
 *  declare, state, affirm, claim; 
 *  defend, maintain, insist on.
 * 
 * @author David
 */
public class AssertTest {

    public static void main(String[] args) {
        
        Scanner input = new Scanner( System.in );
        
        System.out.printf("Enter a number between 0 and 10:");
        int number = input.nextInt();
        
        // assert that the value is >= 0 and <= 10
        assert(number >= 0 && number <= 10) : "bad number: " + number;
        System.out.printf("You entered %d\n", number);
    }
    
}
