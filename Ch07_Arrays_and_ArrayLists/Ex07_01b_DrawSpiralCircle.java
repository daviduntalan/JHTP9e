package Ch07_Arrays_and_ArrayLists;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex07_01b_DrawSpiralCircle {

    public static void main(String[] args) {
        
        DrawSpiralCircle panel = new DrawSpiralCircle();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // add Rainbow panel to frame
        frame.setSize(800, 800+22);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
