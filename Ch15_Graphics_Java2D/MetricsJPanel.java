package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;

/** Fig. 15.15: FontMetrics and Graphics methods useful for obtaining font metrics. */
public class MetricsJPanel extends JPanel {

    // displays font metrics
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paintComponent

        // set font to SansSerif (Helvetica), bold, 12pt and draw a string
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        FontMetrics fontMetrics = g.getFontMetrics();
        g.drawString("Current font: " + g.getFont(), 10, 30);
        g.drawString("Height: " + fontMetrics.getHeight(), 10, 45);
        g.drawString("Leading: " + fontMetrics.getLeading(), 10, 60);
        g.drawString("Ascent: " + fontMetrics.getAscent(), 10, 75);
        g.drawString("Descent: " + fontMetrics.getDescent(), 10, 90);

        // set font to Serif (Times), italic, 14pt and draw a string
        g.setFont(new Font("Serif", Font.ITALIC, 14));
        fontMetrics = g.getFontMetrics();
        g.drawString("Current font: " + g.getFont(), 10, 120);
        g.drawString("Height: " + fontMetrics.getHeight(), 10, 135);
        g.drawString("Leading: " + fontMetrics.getLeading(), 10, 150);
        g.drawString("Ascent: " + fontMetrics.getAscent(), 10, 165);
        g.drawString("Descent: " + fontMetrics.getDescent(), 10, 180);
    } // end method paintComponent
} // end class MetricsJPanel