package Ch14_GUI_Components_P1;
// Fig. 14.24: Selecting colors from a JList.
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

// Fig. 14.23: JList that displays a list of colors.
class ListFrame extends JFrame {

    private static final String[] colorNames = {
            "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
            "Magenta", "Orange", "Pink", "Red", "White", "Yellow"
    };
    private static final Color[] colors = {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
            Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    private JList colorJList; // list to display colors

    // constructor add JScrollPane containing JList to JFrame
    public ListFrame() {

        super("List Test");
        setLayout( new FlowLayout() ); // set frame layout

        colorJList = new JList( colorNames ); // create with colorNames
        colorJList.setVisibleRowCount( 5 ); // display five rows at once

        // do not allow multiple selections
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // add a JScrollPane containing JList to frame
        add( new JScrollPane( colorJList ) );

        colorJList.addListSelectionListener(new ListSelectionListener() { // anonymous inner class
            @Override // handle list selection
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = colorJList.getSelectedIndex();
                getContentPane().setBackground( colors[selectedIndex] );
            } // end method valueChanged
        }); // end anonymous inner class and call to addListSelectionListener

        /* JFrame consists of 3 layers:
        1. the Background
        2. the Content Pane and - appears in front of the background and completely hides the background
        3. the Glass Pane - is used to display tool tips and other items that should appear in front of the GUI components */
    } // end ListFrame constructor
} // end class ListFrame

public class ListTest {

    public static void main(String[] args) {

        ListFrame listFrame = new ListFrame();
        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listFrame.setSize(350, 150); // set frame size
        listFrame.setLocationRelativeTo( null ); // center frame window
        listFrame.setVisible( true ); // display frame
    }
}
