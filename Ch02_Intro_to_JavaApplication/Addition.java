package Ch02_Intro_to_JavaApplication;
import java.util.Scanner;
/**
 * Addition program that displays the sue of two numbers.
 * Fig. 2.7: Addition.java
 * 
 * @authsor David
 */
public class Addition {

    // main method begins execution of Java appication 
    public static void main(String[] args) {
        // create a Scanner to obtain inut from the command window
        Scanner input = new Scanner(System.in);
        
        int number1; // first number to add
        int number2; // second number to add
        int sum; // sum of number1 and number2
        
        System.out.print("Enter first integer: "); // prompt
        number1 = input.nextInt();
        
        System.out.print("Enter second integer: "); // prompt
        number2 = input.nextInt();
        
        sum = number1 + number2;
        
        System.out.printf("Sum is %d\n", sum);
    }
    
}
