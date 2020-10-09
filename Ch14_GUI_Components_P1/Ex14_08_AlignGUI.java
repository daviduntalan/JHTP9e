package Ch14_GUI_Components_P1;

import javax.swing.*;

/**
 * Ex 14.8: Create the following GUI. You don't have to provide any functionality.
 */
public class Ex14_08_AlignGUI {

    public static void main(String[] args) {

        AlignFrame alignFrame = new AlignFrame();
        alignFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alignFrame.setSize(350, 150);
        alignFrame.setLocationRelativeTo(null);
        alignFrame.setVisible( true );
    }
}
