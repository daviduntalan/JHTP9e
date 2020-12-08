package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class DrawRandomLinesUsingTimer extends JPanel implements ActionListener {

    private final Random random;
    private final Color[] colors = {
        Color.RED, Color.WHITE, Color.BLACK, Color.GREEN,
        Color.BLUE, Color.LIGHT_GRAY, Color.YELLOW, Color.PINK,
        Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.LIGHT_GRAY, Color.ORANGE
    };

    public DrawRandomLinesUsingTimer() {

        random = new Random();
        new Timer(100, this).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call super class's paint method, clear screen
        setBackground(Color.BLACK);

        for (int count = 0; count < 100; ++count) {
            g.setColor(colors[random.nextInt(colors.length)]);
            int x1 = random.nextInt(getWidth());
            int y1 = random.nextInt(getHeight());
            int x2 = random.nextInt(getWidth());
            int y2 = random.nextInt(getHeight());
            g.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class Ex15_19_ScreenSaverUsingTimer {

    public static void main(String[] args) {

        JFrame app = new JFrame();
        app.setTitle("Screen Saver using Timer");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(new DrawRandomLinesUsingTimer());
        app.setSize(800, 600);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}