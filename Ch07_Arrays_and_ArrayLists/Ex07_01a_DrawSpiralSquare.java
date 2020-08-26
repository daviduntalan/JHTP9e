package Ch07_Arrays_and_ArrayLists;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex07_01a_DrawSpiralSquare {

    public static void main(String[] args) {

        DrawSpiralSquare panel = new DrawSpiralSquare();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // add SpiralSquare panel to the frame
        frame.setSize(400, 400 + 22);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
