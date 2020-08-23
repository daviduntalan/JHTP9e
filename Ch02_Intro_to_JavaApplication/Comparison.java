package Ch02_Intro_to_JavaApplication;

import java.util.Scanner;

/**
 * Compare integers using if statements, relational operators 
 * and equality operators.
 * Fig. 2.15: Comparison.java
 * 
 * @authsor David
 */
public class Comparison {

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );
        
        int number1; 
        int number2;
        
        System.out.printf("Enter first integer: ");
        number1 = input.nextInt();
        
        System.out.printf("Enter second integer: ");
        number2 = input.nextInt();
        
        if (number1 == number2) System.out.printf("%d == %d\n", number1, number2);
        if (number1 != number2) System.out.printf("%d != %d\n", number1, number2);
        if (number1  < number2) System.out.printf("%d  < %d\n", number1, number2);
        if (number1  > number2) System.out.printf("%d  > %d\n", number1, number2);
        if (number1 <= number2) System.out.printf("%d <= %d\n", number1, number2);
        if (number1 >= number2) System.out.printf("%d >= %d\n", number1, number2);
    }
    
}
