package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/** An application that randomly draws characters in different fonts, sizes and colors. */
class RandomCharacters extends JPanel {

    String[] style;
    String[] fontNames;
    Integer[] fontStyles;

    public RandomCharacters() {
        fontNames = new String[] {
                "Serif", "Monospaced", "Courier New", "Arial"
        };

        fontStyles = new Integer[] {
                Font.PLAIN, Font.BOLD, Font.ITALIC,
                Font.BOLD + Font.ITALIC
        };

        style = new String[] { "PLAIN", "BOLD", "ITALIC", "BOLD+ITALIC"};
    }

    // displays Strings in different fonrt and colors
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paintComponent

        Random random = new Random();
        for (int count = 0; count < 8; ++count) {

            String fontName = fontNames[random.nextInt(fontNames.length)];
            int fontStyleIndex = fontStyles[random.nextInt(fontStyles.length)];
            int charIndex = random.nextInt(26); // +65: A to Z
            int size = 12 + random.nextInt(28);
            int R = random.nextInt(256);
            int G = random.nextInt(256);
            int B = random.nextInt(256);

            g.setFont(new Font(fontName, fontStyleIndex, size));
            g.setColor( new Color(R, G, B) );
            g.drawString(g.getFont().getFontName() + " " +
                    g.getFont().getSize(), 20, 60 + count * 40);
        } // end for
    }
}

/** (Random Characters) Write an application that randomly draws characters in different
 fonts, sizes and colors. */
public class Ex15_10_RandomCharacters {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Random Characters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new RandomCharacters() ); // add FontJPanel to frame
        frame.setSize(620, 400);
        frame.setVisible(true); // display frame
    }
}
