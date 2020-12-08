package Ch14_GUI_Components_P1;
// Fig. 14.29: Testing MouseTrackerFrame.

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class MouseTrackerFrame extends JFrame {
    private JPanel mousePanel; // panel in which mouse events will occur
    private JLabel statusBar; // label that displays event information

    // constructor sets up GUI and registers mouse event handlers
    public MouseTrackerFrame() {

        super("Demonstrating Mouse Events");

        mousePanel = new JPanel(); // create panel
        mousePanel.setBackground(Color.WHITE); // set background color
        add( mousePanel, BorderLayout.CENTER); // add panel to JFrame - BorderLayout automatically sizes the component in the CENTER to use all the space in the JFrame that is not occupied by components in the other regions.

        statusBar = new JLabel("Mouse outside JPanel");
        add( statusBar, BorderLayout.SOUTH ); // add label to JFrame

        // create and register listener for mouse and mouse motion events
        MouseHandler handler = new MouseHandler();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
    } // end MouseTrackerFrame constructor

    private class MouseHandler implements MouseListener, MouseMotionListener {

        /* MouseListener event handlers */

        @Override // handle event when mouse released immediately after press
        public void mouseClicked(MouseEvent e) {
            statusBar.setText(  String.format(
                    "Clicked at [%d, %d]", e.getX(), e.getY()
            ));
        }

        @Override // handle event when mouse pressed
        public void mousePressed(MouseEvent e) {
            statusBar.setText(  String.format(
                    "Pressed at [%d, %d]", e.getX(), e.getY()
            ));
        }

        @Override // handle event when mouse released
        public void mouseReleased(MouseEvent e) {
            statusBar.setText(  String.format(
                    "Released at [%d, %d]", e.getX(), e.getY()
            ));
        }

        @Override // handle event when mouse enters area
        public void mouseEntered(MouseEvent e) {
            statusBar.setText(  String.format(
                    "Mouse entered at [%d, %d]", e.getX(), e.getY()
            ));
            mousePanel.setBackground( Color.GREEN );
        }

        @Override // handle event when mouse exits area
        public void mouseExited(MouseEvent e) {
            statusBar.setText("Mouse outside JPanel");
            mousePanel.setBackground( Color.WHITE );
        }

        /* MouseMotionListener event handlers */

        @Override // handle event when user drags mouse with button pressed
        public void mouseDragged(MouseEvent e) {
            statusBar.setText(  String.format(
                    "Dragged at [%d, %d]", e.getX(), e.getY()
            ));
        }

        @Override // handle event when user moves mouse
        public void mouseMoved(MouseEvent e) {
            statusBar.setText(  String.format(
                    "Moved at [%d, %d]", e.getX(), e.getY()
            ));
        }
    } // end inner class MouseHandler
} // end class MouseTrackerFrame

public class MouseTracker {

    public static void main(String[] args) {

        MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
        mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseTrackerFrame.setSize(300, 100); // set frame size
        mouseTrackerFrame.setLocationRelativeTo(null); // centered window
        mouseTrackerFrame.setVisible(true); // display frame
    }
}
