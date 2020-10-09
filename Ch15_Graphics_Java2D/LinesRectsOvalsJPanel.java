package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;

public class LinesRectsOvalsJPanel extends JPanel {

    // display various lines, rectangles and ovals
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paint method
        setBackground(Color.WHITE);

        g.setColor(Color.RED);
        g.drawLine(5,30,380,30);

        g.setColor(Color.BLUE);
        g.drawRect(5,40,90,55);
        g.fillRect(100,40,90,55);

        g.setColor(Color.CYAN);
        g.drawRoundRect(290,40,90,55,20,50);
        g.fillRoundRect(195,40,90,55,50,50);

        g.setColor(Color.GREEN);
        g.draw3DRect(5,100,90,55,true);
        g.fill3DRect(100,100,90,55,false);

        g.setColor(Color.MAGENTA);
        g.drawOval(195, 100, 90, 55);
        g.fillOval(290, 100, 90, 55);
    }
}
