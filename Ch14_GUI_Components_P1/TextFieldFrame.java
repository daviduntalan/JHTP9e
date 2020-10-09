package Ch14_GUI_Components_P1;

/* Fig. 14.9: Demonstrate the JTextField class. */

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame {

    private JTextField textField1; // text field with set size
    private JTextField textField2; // text field constructed with text
    private JTextField textField3; // text field with text and size
    private JPasswordField passwordField; // password field with text

    // constructor adds JTextFields to JFrame
    public TextFieldFrame() {

        super("Testing JTextField and JPasswordField");
        setLayout( new FlowLayout() ); // set frame layout

        // construct text field with 10 columns
        textField1 = new JTextField(10);
        add( textField1 ); // add textField1 to JFrame

        // construct text field with default text
        textField2 = new JTextField( "Enter text here" );
        add( textField2 ); // add textField2 to JFrame

        // construct text field with default text and 21 columns
        textField3 = new JTextField( "Uneditable text field", 21 );
        textField3.setEditable( false ); // disable editing
        add( textField3 ); // add textField3 to JFrame

        // construct password field with default text
        passwordField = new JPasswordField( "Hidden text" );
        add( passwordField ); // add passwordField to JFrame

        // register event handler for each component
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener( handler );
        textField2.addActionListener( handler );
        textField3.addActionListener( handler );
        passwordField.addActionListener( handler );
    }

    // private inner class for event handling
    private class TextFieldHandler implements ActionListener {

        @Override // process text field events - this method specifies the tasks to perform when an ActionEvent occurs. This object's actionPerformed method will be called automatically when the user presses Enter in any of the GUI's text fields.
        public void actionPerformed(ActionEvent e) {

            String string = ""; // declare string to display

            // user pressed Enter in JTextField textField1
            if (e.getSource() == textField1) {
                string = String.format("textField1: %s", e.getActionCommand());
            }
            // user pressed Enter in JTextField textField2
            else if (e.getSource() == textField2) {
                string = String.format("textField2: %s", e.getActionCommand());
            }
            // user pressed Enter in JTextField textField3
            else if (e.getSource() == textField3) {
                string = String.format("textField3: %s", e.getActionCommand());
            }
            // user pressed Enter in JPasswordField passwordField
            else if (e.getSource() == passwordField) {
                string = String.format("passwordField: %s", e.getActionCommand());
                JOptionPane.showMessageDialog(null, "Entered password: "
                        + Arrays.toString(passwordField.getPassword()));
            }

            // display JTextField content
            JOptionPane.showMessageDialog(null, string );
        } // end method actionPerformed
    } // end private inner class TextFieldHandler
} // end class TextFieldFrame
