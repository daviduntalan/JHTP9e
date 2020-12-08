package Ch14_GUI_Components_P1;

// Fig. 14.7: Testing LabelFrame
import javax.swing.*;
import java.awt.*;

// the class extends JFrame to inherit the features of a window.
class LabelFrame extends JFrame {

    private JLabel label1; // JLabel with just text
    private JLabel label2; // JLabel constructed with text and icon
    private JLabel label3; // JLabel with added text and icon

    // constructor adds JLabels to JFrame
    public LabelFrame() {
        /* typically, the JFrame subclass's constructor builds the GUI that's
        displayed in the window when the application executes. */
        super("Testing JLabel");
        setLayout(new FlowLayout());

        // JLabel constructor with string argument
        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1");
        add( label1 ); // add label1 to JFrame

        // JLabel constructor with string, Icon and alignment arguments
        java.net.URL imgURL = getClass().getResource("images/bug1.png"); // returns F:\temp\repoJava\jHTP9e\javaHTP9e\out\production\javaHTP9e\Ch14_GUI_Components_P1\bug1.png
        JOptionPane.showMessageDialog(null, imgURL, "Image Location", JOptionPane.INFORMATION_MESSAGE);
        Icon bug = new ImageIcon( imgURL );
        label2 = new JLabel("Label with text and icon", bug, SwingConstants.LEFT);
        label2.setToolTipText("This is label2");
        add( label2 ); // add label2 to JFrame

        label3 = new JLabel(); // JLabel constructor with no arguments
        label3.setText("Label with icon and text at bottom");
        label3.setIcon(bug); // add icon to JLabel
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        add( label3 ); // add label2 to JFrame
    }
}

public class LabelTest {

    public static void main(String[] args) {

        LabelFrame labelFrame = new LabelFrame(); // create LabelFrame
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(260, 180); // set frame size
        labelFrame.setVisible(true); // display frame
    }
}
