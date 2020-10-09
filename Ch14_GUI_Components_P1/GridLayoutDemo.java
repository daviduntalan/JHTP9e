package Ch14_GUI_Components_P1;
// Fig. 14.44: Testing GridLayoutFrame.

import javax.swing.JFrame;

public class GridLayoutDemo {

    public static void main(String[] args) {

        GridLayoutFrame gridLayoutFrame = new GridLayoutFrame();
        gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridLayoutFrame.setSize(320, 200);
        gridLayoutFrame.setLocationRelativeTo(null);
        gridLayoutFrame.setVisible(true);
    }
}
