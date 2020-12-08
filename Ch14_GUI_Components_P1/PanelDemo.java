package Ch14_GUI_Components_P1;
// Fig. 14.46: Testing PanelFrame

import javax.swing.*;
import java.awt.*;

class PanelFrame extends JFrame {

    private JPanel buttonJPanel; // panel to hold buttons
    private JButton[] buttons; // array of buttons

    public PanelFrame() {
        super("Panel Demo");

        buttons = new JButton[ 5 ]; // create button array
        buttonJPanel = new JPanel(); // setup panel
        buttonJPanel.setLayout( new GridLayout(1, buttons.length) );

        // create and add buttons
        for (int count = 0; count < buttons.length; ++count) {
            buttons[count] = new JButton("Button " + (count + 1));
            buttonJPanel.add( buttons[count] ); // add button to panel
        } // end for

        add( buttonJPanel, BorderLayout.SOUTH ); // add panel to bottom of JFrame
    }
}
public class PanelDemo {

    public static void main(String[] args) {

        PanelFrame panelFrame = new PanelFrame();
        panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelFrame.setSize(450, 200);
        panelFrame.setLocationRelativeTo(null);
        panelFrame.setVisible(true);
    }
}
