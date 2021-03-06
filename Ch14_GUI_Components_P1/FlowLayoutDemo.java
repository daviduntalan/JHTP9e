package Ch14_GUI_Components_P1;
// Fig. 14.40: Testing FlowLayoutFrame
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Fig. 14.39: Demonstrating FlowLayout alignments.
class FlowLayoutFrame extends JFrame {

    private JButton btnLeft; // button to set alignment left
    private JButton btnCenter; // button to set alignment center
    private JButton btnRight; // button to set alignment right
    private FlowLayout layout; // layout object
    private Container container; // container to set layout

    public FlowLayoutFrame() {
        super("FlowLayout Demo");
        layout = new FlowLayout(); // create FlowLayout
        container = getContentPane(); // get container to layout
        setLayout( layout ); // set frame layout

        // setup btnLeft and register listener
        btnLeft = new JButton("Left");
        add( btnLeft ); // add Left button to frame
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.LEFT);
                layout.layoutContainer(container); // re-align (rearranged) attached components
            }
        });

        // setup btnCenter and register listener
        btnCenter = new JButton("Center");
        add( btnCenter ); // add Center button to frame
        btnCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.CENTER);
                layout.layoutContainer(container); // re-align (rearranged) attached components
            }
        });

        // setup btnRight and register listener
        btnRight = new JButton("Right");
        add( btnRight ); // add Left button to frame
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.RIGHT);
                layout.layoutContainer(container); // re-align (rearranged) attached components
            }
        });
    } // end of constructor
}

public class FlowLayoutDemo {

    public static void main(String[] args) {

        FlowLayoutFrame flowLayoutFrame = new FlowLayoutFrame();
        flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flowLayoutFrame.setSize(300, 75);
        flowLayoutFrame.setLocationRelativeTo(null);
        flowLayoutFrame.setVisible(true);
    }
}
