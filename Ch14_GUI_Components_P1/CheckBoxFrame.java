package Ch14_GUI_Components_P1;

// Fig. 14.17: Creating JCheckBox buttons
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame {

    private JTextField textField; // displays text in changing fonts
    private JCheckBox boldJCheckBox; // to select/deselect bold
    private JCheckBox italicJCheckBox; // to select/deselect italic
    private String fontName; // font name for all classes

    // constructor adds JCheckBoxes to JFrame
    public CheckBoxFrame() {

        super("JCheckBox Test");
        setLayout( new FlowLayout() ); // set frame layout
        fontName = "Garamound";

        // setup JTextField and set its font
        textField = new JTextField("Watch the font style change", 20);
        textField.setFont( new Font(fontName, Font.PLAIN, 14) );
        add( textField ); // add textField to JFrame

        boldJCheckBox = new JCheckBox( "Bold" ); // create bold checkbox
        italicJCheckBox = new JCheckBox( "Italic" ); // create bold checkbox
        add( boldJCheckBox ); // add bold checkbox to JFrame
        add( italicJCheckBox ); // add italic checkbox to JFrame

        // register listeners for JCheckBoxes
        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener( handler );
        italicJCheckBox.addItemListener( handler );
    }

    // private inner class for ItemListener event handling
    private class CheckBoxHandler implements ItemListener {

        @Override // respond to checkbox events
        public void itemStateChanged(ItemEvent e) {

            Font font = null; // stores the new Font

            // determine which CheckBoxes are checked and create Font
            if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected()) {
                font = new Font(fontName, Font.BOLD + Font.ITALIC, 14);
            } else if (boldJCheckBox.isSelected()) {
                font = new Font(fontName, Font.BOLD, 14);
            } else if (italicJCheckBox.isSelected()) {
                font = new Font(fontName, Font.ITALIC, 14);
            } else {
                font = new Font(fontName, Font.PLAIN, 14);
            }

            textField.setFont( font ); // set textField's font
        } // end method itemStateChanged
    } // end private inner class CheckBoxHandler
} // end class CheckBoxFrame
