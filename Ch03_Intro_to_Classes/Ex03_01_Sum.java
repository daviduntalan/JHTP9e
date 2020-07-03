package Ch03_Intro_to_Classes;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Addition program that displays the sum of two numbers. Fig. 2.7:
 * Addition.java
 *
 * @authsor David
 */
public class Ex03_01_Sum {

    // main method begins execution of Java appication 
    public static void main(String[] args) {
        // create a Scanner to obtain inut from the command window
        Scanner input = new Scanner(System.in);

        int number1; // first number to add
        int number2; // second number to add
        int sum; // sum of number1 and number2

        number1 = Integer.parseInt( JOptionPane
                .showInputDialog("Enter first number: "));

        number2 = Integer.parseInt( JOptionPane
                .showInputDialog("Enter second number: "));

        sum = number1 + number2;

        String result = String.format("Sum is %d\n", sum);
        JOptionPane.showMessageDialog(null, result);
    }

}
