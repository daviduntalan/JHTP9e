package Ch07_Arrays_and_ArrayLists;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawSpiralCircle extends JPanel {

    public DrawSpiralCircle() {
        setBackground(Color.BLACK);
        setForeground(Color.GREEN);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        int s = 0, len = 40;

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        // draw center cross (+)
        g.drawLine(cx - 8, cy, cx + 8, cy); // horizontal line
        // g.drawLine(cx, cy - 8, cx, cy + 8); // vertical line

        // draw spiral square
        for (int i = 0; i < 10; ++i) {             
            g.drawArc(cx-s+len, cy-s+len/2, s*2-len*1, s*2-len*1, 0, +180);
            g.drawArc(cx-s+len, cy-s+len*1, s*2-len*2, s*2-len*2, 0, -180);
            s = len * i;
        }
    }
}

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
