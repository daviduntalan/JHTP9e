package Ch14_GUI_Components_P1;
// Fig. 14.32: Testing MouseDetailsFrame.

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Fig. 14.31 Demonstrating mouse clicks and distinguishing between mouse buttons.
class MouseDetailsFrame extends JFrame {

    private String details; // String that displayed in the statusBar
    private JLabel statusBar; // label that displays event information

    // constructor sets up GUI and registers mouse event handlers
    public MouseDetailsFrame() {

        super("Mouse Clicks and Buttons");

        statusBar = new JLabel("Click the mouse");
        add( statusBar, BorderLayout.SOUTH ); // add label to JFrame

        this.addMouseListener( new MouseClickHandler() );
    } // end MouseTrackerFrame constructor

    // inner class to handle mouse events - extends MouseAdapter so we can declare "just" the mouseClicked method we need in this example.
    private class MouseClickHandler extends MouseAdapter {

        @Override // handle event when mouse released immediately after press
        public void mouseClicked(MouseEvent e) {
            int xPos = e.getX(); // get x-position of mouse
            int yPos = e.getY(); // get y-position of mouse
            details = String.format("Clicked %d time(s) at [%d, %d]",
                    e.getClickCount(), xPos, yPos);
            if (e.isMetaDown()) { // being use for one-button mouse: right mouse button, Cmd key on Mac
                details += " with right mouse button";
            } else if (e.getButton() == MouseEvent.BUTTON3) { // right mouse button
                details += " with right mouse button";
            } else if (e.isAltDown()) { // middle mouse button
                details += " with center mouse button";
            } else { // left mouse button
                details += " with left mouse button";
            }
            statusBar.setText( details ); // display msg in statusBar
        }

    } // end inner class MouseClickHandler
} // end class MouseDetailsFrame

public class MouseDetails {

    public static void main(String[] args) {

        MouseDetailsFrame mouseDetailsFrame = new MouseDetailsFrame();
        mouseDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseDetailsFrame.setSize(400, 150); // set frame size
        mouseDetailsFrame.setLocationRelativeTo(null); // centered window
        mouseDetailsFrame.setVisible(true); // display frame
    }
}
