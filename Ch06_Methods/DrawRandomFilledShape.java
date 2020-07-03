package Ch06_Methods;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
class DrawRandomFilledShape extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Random random = new Random();
        int w = getWidth();
        int h = getHeight();
        int R, G, B;

        int xthick = random.nextInt(w / 2);
        int ythick = random.nextInt(h / 2);
        int xpos = random.nextInt(w - xthick);
        int ypos = random.nextInt(h - ythick);

        for (int ntimes = 0; ntimes < 10; ++ntimes) {
            
            R = random.nextInt(256);
            G = random.nextInt(256);
            B = random.nextInt(256);
            g.setColor(new Color(R, G, B));

            if (random.nextBoolean()) {
                g.fillOval(xpos, ypos, xthick, ythick);
            } else {
                g.fillRect(xpos, ypos, xthick, ythick);
            }

            xthick = random.nextInt(w / 2);
            ythick = random.nextInt(h / 2);
            xpos = random.nextInt(w - xthick);
            ypos = random.nextInt(h - ythick);
        }
    }
}
