package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultipleSelectionFrame extends JFrame {

    private static final String[] colorNames = {
            "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
            "Magenta", "Orange", "Pink", "Red", "White", "Yellow"
    };
    private JList colorJList; // list to hold color names
    private JList copyJList; // list to copy color names into
    private JButton copyJButton; // button to copy selected names

    public MultipleSelectionFrame() {

        super("Multiple Selection List");
        setLayout( new FlowLayout() ); // set frame layout

        colorJList = new JList( colorNames ); // holds names of all colors
        colorJList.setVisibleRowCount( 5 ); // show five rows only
        colorJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add( new JScrollPane(colorJList) ); // add list with scroll pane

        copyJButton = new JButton("Copy >>>"); // create copy button
        copyJButton.addActionListener(new ActionListener() { // anonymous inner class
            @Override // handle click button
            public void actionPerformed(ActionEvent e) {
                // place selected values in copyJList
                Object[] selectedColors = colorJList.getSelectedValuesList().toArray();
                copyJList.setListData( selectedColors );
                /* You might be wondering why copyJList can used here even though
                * the application does not create the object to which it refers
                * until line 47. Remember that method actionPerformed() does not
                * execute until the user presses the copyJButton, which cannot
                * occur until after the constructor completes execution and the
                * application displays the GUI. At that point in the application's
                * execution, copyJList is already initialized with the new JList object. */
            }
        });
        add( copyJButton ); // add copy button to JFrame

        copyJList = new JList(); // create list to hold copied color names
        copyJList.setVisibleRowCount(  5); // show five rows only
        copyJList.setFixedCellWidth( 100); // set width
        copyJList.setFixedCellHeight( 15); // set height
        copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add( new JScrollPane(copyJList) ); // add list with scroll pane
    } // end of constructor MultipleSelectionFrame
} // end of class MultipleSelectionFrame
