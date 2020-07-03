package Ch06_Methods;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
class DrawBullsEye extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Random random = new Random();
        int w = getWidth();
        int h = getHeight();
        int R, G, B, gap = 10;
        int xthick = 0, xt = (w - gap*2) / gap;
        int ythick = 0, yt = (h - gap*2) / gap;

        for (int ntimes = 0; ntimes < 5; ++ntimes) {
            R = random.nextInt(256);
            G = random.nextInt(256);
            B = random.nextInt(256);
            g.setColor(new Color(R, G, B));
            g.fillOval(
                gap + xthick, 
                gap + ythick, 
                (w - gap*2) - xthick * 2, 
                (h - gap*2) - ythick * 2
            );
            xthick += xt;
            ythick += yt;
        }
    }

}
