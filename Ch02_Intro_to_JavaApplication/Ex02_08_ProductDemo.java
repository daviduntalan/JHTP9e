package Ch02_Intro_to_JavaApplication;

import java.util.Scanner;

/**
 * @authsor David
 */
public class Ex02_08_ProductDemo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a, b, c;

        System.out.printf("Enter an integer: ");
        b = input.nextInt();
        
        System.out.printf("Enter second integer: ");
        c = input.nextInt();

        a = b * c;

        System.out.printf("Product is %d\n", a);
    }

}
