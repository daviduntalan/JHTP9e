package Ch14_GUI_Components_P1;
// Fig. 14.29: Testing MouseTrackerFrame.

import javax.swing.JFrame;

public class MouseTracker {

    public static void main(String[] args) {

        MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
        mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseTrackerFrame.setSize(300, 100); // set frame size
        mouseTrackerFrame.setLocationRelativeTo(null); // centered window
        mouseTrackerFrame.setVisible(true); // display frame
    }
}
