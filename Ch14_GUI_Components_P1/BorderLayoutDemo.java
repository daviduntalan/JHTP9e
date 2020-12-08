package Ch14_GUI_Components_P1;
// Fig. 14.42: Testing BorderLayoutFrame
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BorderLayoutFrame extends JFrame implements ActionListener {

    private static final String[] names = {
            "Hide North", "Hide South", "Hide East", "Hide West", "Hide Center"
    };
    private JButton[] buttons; // array of buttons to hide portions
    private BorderLayout layout; // border layout object

    public BorderLayoutFrame() {
        super("BorderLayout Demo");

        layout = new BorderLayout(5, 5); // 5 pixel gaps
        setLayout(layout); // set frame layout - set the content pane's layout to layout (e.i, BorderLayout)
        buttons = new JButton[ names.length ]; // set size of array

        // create JButtons and register listeners for them
        for (int count = 0; count < names.length; ++count) {
            buttons[ count ] = new JButton( names[count] );
            buttons[ count ].addActionListener( this );
        }

        add( buttons[0], BorderLayout.NORTH ); // add button to north
        add( buttons[1], BorderLayout.SOUTH ); // add button to south
        add( buttons[2], BorderLayout.EAST ); // add button to east
        add( buttons[3], BorderLayout.WEST ); // add button to west
        add( buttons[4], BorderLayout.CENTER ); // add button to center
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // check event source and layout content pane correspondingly
        for (JButton button : buttons) {
            if (e.getSource() == button) {
                button.setVisible(false); // hide button clicked
            } else {
                button.setVisible(true); // show other buttons
            }
        } // end for

        layout.layoutContainer( getContentPane() ); // layout content pane - Ctrl + Q for details
    }
}

public class BorderLayoutDemo {

    public static void main(String[] args) {

        BorderLayoutFrame borderLayoutFrame = new BorderLayoutFrame();
        borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borderLayoutFrame.setSize(320, 200);
        borderLayoutFrame.setLocationRelativeTo(null);
        borderLayoutFrame.setVisible(true);
    }
}
