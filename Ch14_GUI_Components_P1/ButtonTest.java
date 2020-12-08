package Ch14_GUI_Components_P1;

// Fig. 14.16: Testing ButtonFrame

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonFrame extends JFrame {

    private final JButton plainButton; // button with just text
    private final JButton fancyButton; // button with icons

    // constructor adds JButtons to JFrame
    public ButtonFrame() {

        super("Testing Buttons");
        setLayout( new FlowLayout() ); // set frame layout

        plainButton = new JButton("Plain Button"); // button with text
        add( plainButton ); // add plainButton to JFrame

        Icon bug1 = new ImageIcon(getClass().getResource("./images/bug1.png")); // gif is not recognized
        Icon bug2 = new ImageIcon(getClass().getResource("./images/bug2.png")); // gif is not recognized

        fancyButton = new JButton("Fancy Button", bug1 );
        fancyButton.setRolloverIcon( bug2 ); // set rollover image to bug2.gif; using rollover icons for JButtons provides users with visual feedback indicating that when they click the mouse while the cursor is positioned over the JButton, an action will occur.
        add( fancyButton ); // add fancyButton to JFrame

        // create new ButtonHandler for button event handling
        // register event handler for each button
        ButtonHandler handler = new ButtonHandler();
        plainButton.addActionListener( handler );
        fancyButton.addActionListener( handler );
    }

    // private inner class for button event handling
    private class ButtonHandler implements ActionListener {

        @Override // handle button event
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(ButtonFrame.this, // refers to parent GUI component, enables the dialog to be centered over that component
                    String.format("You pressed: %s", e.getActionCommand()) );
        } // end method actionPerformed
    } // end private inner class TextFieldHandler
} // end class TextFieldFrame

public class ButtonTest {

    public static void main(String[] args) {

        ButtonFrame buttonFrame = new ButtonFrame(); // create ButtonFrame
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonFrame.setSize(300, 110); // set frame size
        buttonFrame.setLocationRelativeTo(null); // centered window
        buttonFrame.setVisible(true); // display frame
    }
}
