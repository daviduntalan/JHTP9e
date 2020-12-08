package student_assignments;

import javax.swing.*;

public class ListTest {

    public static void main(String[] args) {

        ListFrame listFrame = new ListFrame();
        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listFrame.setSize(300, 275); // set frame size
        listFrame.setLocationRelativeTo( null ); // center frame window
        listFrame.setVisible( true ); // display frame
    }
}
