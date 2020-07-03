package Ch02_Intro_to_JavaApplication;

import java.util.Scanner;

/**
 * @authsor David
 */
public class Ex02_15_MathOperators {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a, b;

        System.out.printf("Enter an integer: ");
        a = input.nextInt();
        
        System.out.printf("Enter second integer: ");
        b = input.nextInt();

        System.out.printf("Sum is %d\n", a + b);
        System.out.printf("Product is %d\n", a * b);
        System.out.printf("Difference is %d\n", a - b);
        System.out.printf("Quotient is %d\n", a % b);
    }

}
