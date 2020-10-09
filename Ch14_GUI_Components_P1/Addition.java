package Ch14_GUI_Components_P1;

import javax.swing.JOptionPane; // program uses JOptionPane

/**
 * Fig. 14.2: Addition program that uses JOptionPane for input and output.
 */
public class Addition {

    public static void main(String[] args) {

        // obtain user input from JOptionPane input dialogs
        String firstNumber = JOptionPane.showInputDialog("Enter first integer");
        String secondNumber = JOptionPane.showInputDialog("Enter second integer");
        int sum = 0; // add numbers

        try {
            // convert String inputs to int values for use in a calculation
            int number1 = Integer.parseInt( firstNumber.trim() );
            int number2 = Integer.parseInt( secondNumber.trim() );
            sum = number1 + number2;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.printf("ERROR: %s\n", e.getMessage());
        }

        // display result in a JOptionPane message dialog
        JOptionPane.showMessageDialog(null, "The sum is " + sum,
                "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
         /* if the first argument is null, the dialog box is displayed at the
         center of your screen, otherwise causes the dialog to appear
         centered over the parent component. */
    } // end method main
} // end class Addition
