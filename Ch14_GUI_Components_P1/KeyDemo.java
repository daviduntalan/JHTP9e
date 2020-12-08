package Ch14_GUI_Components_P1;
// Fig. 14.37: Testing KeyDemoFrame.
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Fig. 14.36: Demonstrating keystroke events.
class KeyDemoFrame extends JFrame implements KeyListener {

    private String line1 = ""; // first line of textarea
    private String line2 = ""; // second line of textarea
    private String line3 = ""; // third line of textarea
    private JTextArea textArea; // textarea to display output

    public KeyDemoFrame() throws HeadlessException {
        super("Demonstrating Keystroke Events");

        textArea = new JTextArea(10, 15);
        textArea.setText("Press any key on the keyboard...");
        textArea.setEnabled(false); // disable textarea
        textArea.setDisabledTextColor(Color.BLACK); // turn Gray to Black for readability
        add( textArea ); // add textarea to JFrame using default BorderLayout occupying entire container.

        addKeyListener( this ); // allow frame to process key events
    } // end constructor

    @Override
    public void keyPressed(KeyEvent e) {
        line1 = String.format("Key pressed: %s",
                KeyEvent.getKeyText( e.getKeyCode() )
        ); // show pressed key - Ctrl + Q for details
        setLine2and3( e ); // set output lines two and three
    }

    @Override
    public void keyReleased(KeyEvent e) {
        line1 = String.format("Key released: %s",
                KeyEvent.getKeyText( e.getKeyCode() )
        ); // show released key - Ctrl + Q for details
        setLine2and3( e ); // set output lines two and three
    }

    @Override
    public void keyTyped(KeyEvent e) {
        line1 = String.format("Key typed: %s", e.getKeyChar());
        setLine2and3( e ); // set output lines two and three
    }

    // set second and third lines of output
    private void setLine2and3(KeyEvent e) {

        line2 = String.format("This key is %san action key",
                e.isActionKey() ? "" : "not ");

        String temp = KeyEvent.getModifiersExText(e.getModifiersEx());
        line3 = String.format("Modifier keys pressed: %s",
                temp.equals("") ? "none" : temp); // output modifiers

        textArea.setText(String.format("%s\n%s\n%s\n", line1, line2, line3));
    } // end method setLines2and3
} // end class KeyDemoFrame

public class KeyDemo {

    public static void main(String[] args) {

        KeyDemoFrame keyDemoFrame = new KeyDemoFrame();
        keyDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyDemoFrame.setSize(350, 100);
        keyDemoFrame.setLocationRelativeTo(null);
        keyDemoFrame.setVisible(true);
    }
}
