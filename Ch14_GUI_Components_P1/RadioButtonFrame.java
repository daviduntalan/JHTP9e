package Ch14_GUI_Components_P1;

// Fig. 14.19: Creating radio buttons using ButtonGroup and JRadioButton.

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButtonFrame extends JFrame {

    private JTextField textField; // displays text in changing fonts
    private Font plainFont; // font for plain text
    private Font boldFont; // font for bold text
    private Font italicFont; // font for italic text
    private Font boldItalicFont; // font for bold and italic text
    private JRadioButton plainJRadioButton; // selects plain text
    private JRadioButton boldJRadioButton; // selects bold text
    private JRadioButton italicJRadioButton; // selects italic text
    private JRadioButton boldItalicJRadioButton; // bold and italic
    private ButtonGroup radioGroup; // buttongroup to hold radio buttons
    private String fontName; // font name for all classes
    private JList guiJList;

    // constructor adds JCheckBoxes to JFrame
    public RadioButtonFrame() {

        super("RadioButton Test");
        setLayout( new FlowLayout() ); // set frame layout
        fontName = "Garamound"; // set global font

        // setup JTextField and set its font
        textField = new JTextField("Watch the font style change", 25);
        add( textField ); // add textField to JFrame

        // create radio buttons
        plainJRadioButton = new JRadioButton("Plain", true); // it's possible that no JRadioButtons in a ButtonGroup are selected, but this can occur only if no preselected JRadioButtons are added to the ButtonGroup and the user has not selected a JRadioButton yet.
        boldJRadioButton = new JRadioButton("Bold", false);
        italicJRadioButton = new JRadioButton("Italic", false);
        boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
        guiJList = new JList( RadioButtonTest.guiOptions ); guiJList.setVisibleRowCount(5);
        guiJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = guiJList.getSelectedIndex();
                String guiOption = RadioButtonTest.guiOptions[selectedIndex];
                // RadioButtonTest.setSkin(guiOption);
                System.out.println(guiOption);
            }
        });

        add( plainJRadioButton ); // add plain button to JFrame
        add( boldJRadioButton ); // add bold button to JFrame
        add( italicJRadioButton ); // add italic button to JFrame
        add( boldItalicJRadioButton ); // add bold and italic button
        add( new JScrollPane(guiJList) ); // add GUI option to JFrame

        // create logical relationship between JRadioButtons
        radioGroup = new ButtonGroup(); // create ButtonGroup
        radioGroup.add( plainJRadioButton ); // add plain to group
        radioGroup.add( boldJRadioButton ); // add bold to group
        radioGroup.add( italicJRadioButton ); // add italic to group
        radioGroup.add( boldItalicJRadioButton ); // add bold and italic

        // create font objects
        plainFont = new Font(fontName, Font.PLAIN, 14);
        boldFont = new Font(fontName, Font.BOLD, 14);
        italicFont = new Font(fontName, Font.ITALIC, 14);
        boldItalicFont = new Font(fontName, Font.BOLD + Font.ITALIC, 14);
        textField.setFont( plainFont ); // set initial font to plain

        // register events for JRadioButtons - magastos ito sa memory usage, i prefer the old-style:
        plainJRadioButton.addItemListener( new RadioButtonHandler(plainFont) );
        boldJRadioButton.addItemListener( new RadioButtonHandler(boldFont) );
        italicJRadioButton.addItemListener( new RadioButtonHandler(italicFont) );
        boldItalicJRadioButton.addItemListener( new RadioButtonHandler(boldItalicFont) );

        /*RadioButtonHandlerOldStyle handler = new RadioButtonHandlerOldStyle();
        plainJRadioButton.addItemListener( handler );
        boldJRadioButton.addItemListener( handler );
        italicJRadioButton.addItemListener( handler );
        boldItalicJRadioButton.addItemListener( handler );
        otherJRadioButton.addItemListener( handler );*/
    } // end constructor

    // private inner class to handle radio button events
    private class RadioButtonHandler implements ItemListener {

        private Font font; // font associated with this listener

        public RadioButtonHandler(Font font) {
            this.font = font; // set the font of this listener
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            textField.setFont( font ); // set font of textField
        }
    }
    /*
    private class RadioButtonHandlerOldStyle implements  ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            Font font; // hold a reference to font at top-level class

            if (e.getSource() == boldJRadioButton) {
                font = boldFont;
            } else if (e.getSource() == italicJRadioButton) {
                font = italicFont;
            } else if (e.getSource() == boldItalicJRadioButton) {
                font = boldItalicFont;
            } else { // default to plain font style if none of the above is selected
                font = plainFont;
            }

            textField.setFont( font );
        }
    }
     */
} // end class CheckBoxFrame
