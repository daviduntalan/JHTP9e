package Ch03_Intro_to_Classes;

import javax.swing.JOptionPane;

/**
 * Basic input with a dialog box.
 *
 * @author David
 */
public class NameDialog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // promp uer to enter name
        String name = JOptionPane.showInputDialog(null, "What is your name?");
        
        // creat the message
        String message = String.format("Wecome %s, to Java Programming!", name);

        // display the message to welcome the user by name
        JOptionPane.showMessageDialog(null, message);

    }

}
