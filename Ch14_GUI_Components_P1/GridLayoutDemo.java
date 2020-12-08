package Ch14_GUI_Components_P1;
// Fig. 14.44: Testing GridLayoutFrame.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Fig. 14.43: Demonstrating GridLayoutFrame.
class GridLayoutFrame extends JFrame implements ActionListener {

    private static final String[] names = { "one", "two", "three", "4", "5", "6" };
    private JButton[] buttons; // array of buttons
    private boolean toggle = true; // toggle between two layouts
    private Container container; // frame container (is also panel)
    private GridLayout gridLayout1; // first grid layout
    private GridLayout gridLayout2; // second grid layout

    public GridLayoutFrame() {
        super("GridLayout Demo");

        gridLayout1 = new GridLayout(2, 3, 5, 5);
        gridLayout2 = new GridLayout(3, 2);
        container = getContentPane(); // get content pane
        setLayout(gridLayout1); // set frame layout - set the content pane's layout to gridLayout1 (e.i, GridLayout)
        buttons = new JButton[ names.length ]; // create array of JButtons

        // create JButtons and register listeners for them
        for (int count = 0; count < names.length; ++count) {
            buttons[count] = new JButton( names[count] );
            buttons[count].addActionListener( this );
            add( buttons[count] ); // add button to JFrame
        }
    } // end constructor

    @Override // handle button events by toggling between layouts
    public void actionPerformed(ActionEvent e) {

        if (toggle) {
            container.setLayout( gridLayout1 );
        } else {
            container.setLayout( gridLayout2 );
        }

        toggle = !toggle; // set toggle to opposite value
        container.validate(); // re-lay out container
    }
}

public class GridLayoutDemo {

    public static void main(String[] args) {

        GridLayoutFrame gridLayoutFrame = new GridLayoutFrame();
        gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridLayoutFrame.setSize(320, 200);
        gridLayoutFrame.setLocationRelativeTo(null);
        gridLayoutFrame.setVisible(true);
    }
}
