package Ch14_GUI_Components_P1;

import javax.swing.*;

/**
 * Ex 14.15: (Displaying Events) It’s often useful to display the events that occur during the execution
 * of an application. This can help you understand when the events occur and how they’re generated.
 * Write an application that enables the user to generate and process every event discussed in this chapter.
 * The application should provide methods from the ActionListener, ItemListener, ListSelectionListener,
 * MouseListener, MouseMotionListener and KeyListener interfaces to display
 * messages when the events occur. Use method toString to convert the event objects received in each
 * event handler into Strings that can be displayed. Method toString creates a String containing all
 * the information in the event object.
 */
public class Ex14_15_DisplayingEvents {

    public static void main(String[] args) {

        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        DisplayingEventsFrame displayingEventsFrame = new DisplayingEventsFrame();
        displayingEventsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayingEventsFrame.setSize(580,400);
        displayingEventsFrame.setLocationRelativeTo(null);
        displayingEventsFrame.setVisible( true );
    }
}
