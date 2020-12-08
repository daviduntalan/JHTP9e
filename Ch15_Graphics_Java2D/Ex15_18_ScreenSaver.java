package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class DrawRandomLines extends JPanel {

    private Random random;
    private final Color[] colors = {
        Color.RED, Color.WHITE, Color.BLACK, Color.GREEN,
        Color.BLUE, Color.LIGHT_GRAY, Color.YELLOW, Color.PINK,
        Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.LIGHT_GRAY, Color.ORANGE
    };

    public DrawRandomLines() {
        random = new Random();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paint method - clear screen
        setBackground(Color.WHITE);

        for (int count = 0; count < 100; ++count) {
            g.setColor(colors[random.nextInt(colors.length)]);
            int x1 = random.nextInt(getWidth());
            int y1 = random.nextInt(getHeight());
            int x2 = random.nextInt(getWidth());
            int y2 = random.nextInt(getHeight());
            g.drawLine(x1, y1, x2, y2);
        }

        repaint();
    }
}

public class Ex15_18_ScreenSaver {

    public static void main(String[] args) {

        JFrame app = new JFrame();
        app.setTitle("Screen Saver");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(new DrawRandomLines());
        app.setSize(800, 600);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}