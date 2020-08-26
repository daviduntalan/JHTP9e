package Ch07_Arrays_and_ArrayLists;

import javax.swing.*;
import java.awt.*;

public class DrawSpiralSquare extends JPanel {

    public DrawSpiralSquare() {
        setBackground(Color.BLACK);
        setForeground(Color.RED);
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
            s = len * i;
            g.drawLine(cx + s, cy - s, cx + s, cy + s + len); // down
            if (i > 0) // <-- ito yung problema ko, gusto ko mawala ito pero the same pa rin ang output
                g.drawLine(cx + s - len, cy + s, cx - s, cy + s); // left
            g.drawLine(cx - s, cy + s, cx - s, cy - s); // up
            g.drawLine(cx - s, cy - s, cx + s, cy - s); // right
        }

    }
}
