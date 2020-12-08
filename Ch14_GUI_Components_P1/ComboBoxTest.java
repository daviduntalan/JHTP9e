package Ch14_GUI_Components_P1;
// Fig. 14.22 Testing ComboBoxFrame
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Fig. 14.21 JComboBox that displays a list of image names.
class ComboBoxFrame extends JFrame {

    private static final String imgLocation = "./images/";
    private static final String[] names = {
            "bug1.png",
            "bug2.png",
            "travelbug.png",
            "buganim.png"
    };
    private Icon[] icons = {
            new ImageIcon( getClass().getResource(imgLocation + names[0]) ),
            new ImageIcon( getClass().getResource(imgLocation + names[1]) ),
            new ImageIcon( getClass().getResource(imgLocation + names[2]) ),
            new ImageIcon( getClass().getResource(imgLocation + names[3]) )
    };
    private JComboBox imagesJComboBox; // combo box to hold names of icons
    private JLabel label; // label to display selected icon

    // constructor adds JComboBox to JFrame
    public ComboBoxFrame() {

        super("Testing ComboBox");
        setLayout( new FlowLayout() ); // set frame layout

        imagesJComboBox = new JComboBox( names ); // set up JComboBox
        imagesJComboBox.setMaximumRowCount( 3 ); // display three rows
        imagesJComboBox.addItemListener(new ItemListener() { // anonymous inner class
            @Override // handle JComboBox event
            public void itemStateChanged(ItemEvent e) {
                // determine whether item is selected
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setIcon( icons[ imagesJComboBox.getSelectedIndex() ] );
                }
            } // end method itemStateChanged
        }); // end anonymous inner class and call to addItemListener
        add( imagesJComboBox ); // add combo box to JFrame

        label = new JLabel( icons[0] ); // display first icon (e.i., bug1.png)
        add( label ); // add label to JFrame
    }
}

public class ComboBoxTest {

    public static void main(String[] args) {

        ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
        comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBoxFrame.setSize(350, 150); // set frame size
        comboBoxFrame.setLocationRelativeTo( null ); // center frame window
        comboBoxFrame.setVisible( true ); // display frame
    }
}
