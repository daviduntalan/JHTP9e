package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;

/** Fig. 15.11: display strings in different fonts and colors. */
class FontJPanel extends JPanel {

    // displays Strings in different fonrt and colors
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paintComponent

        // set font to Serif (Times), bold, 12pt and draw a string
        g.setFont(new Font("Serif", Font.BOLD, 12));
        g.drawString("Serif 12 point bold.", 20, 30);

        // set font to Monospaced (Courier), italic, 24pt and draw a stirng
        g.setFont(new Font("Monospaced", Font.ITALIC, 24));
        g.drawString("Monospaced 24 point italic.", 20, 50);

        // set font to SansSerif (Helvetica), plain, 14pt and draw a string
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("SansSerif 14 point plain.", 20, 70);

        // set font to Serif (Times), bold/italic, 18pt and draw a string
        g.setColor(Color.RED); // set the color to RED
        g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));
        g.drawString(g.getFont().getName() + " " + g.getFont().getSize()
                + " point bold italic.", 20, 90);

        g.getFont().getStyle();
    }
}

/** Fig. 15.12: Using fonts. */
public class Fonts {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Using Fonts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new FontJPanel() ); // add FontJPanel to frame
        frame.setSize(420, 150);
        frame.setVisible(true); // display frame
    }
}
