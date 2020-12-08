package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class DrawRandomLinesUsingNumberOfLines extends JPanel implements ActionListener {

    private int numberOfLinesToDraw = 100;
    private Random random;
    private Timer timer;
    private final Color[] colors = {
        Color.RED, Color.WHITE, Color.BLACK, Color.GREEN,
        Color.BLUE, Color.LIGHT_GRAY, Color.YELLOW, Color.PINK,
        Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.LIGHT_GRAY, Color.ORANGE
    };

    public DrawRandomLinesUsingNumberOfLines() {

        random = new Random();
        timer = new Timer(100, this);
        timer.start();
    }

    public void setNumberOfLinesToDraw(int numberOfLinesToDraw) {
        this.numberOfLinesToDraw = numberOfLinesToDraw;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paint method, clear screen
        setBackground(Color.BLACK);

        for (int count = 0; count < numberOfLinesToDraw; ++count) {
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

public class Ex15_20_ScreenSaverRandomNumberOfLines {

    public static void main(String[] args) {

        DrawRandomLinesUsingNumberOfLines instanceOfScreenSaver = new DrawRandomLinesUsingNumberOfLines();;
        JFrame app = new JFrame();
        JTextField txtNumberOfLinesToDraw = new JTextField("Enter number of lines to draw");
        txtNumberOfLinesToDraw.selectAll();

        app.setTitle("Screen Saver for a Random Number of Lines");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLayout(new BorderLayout());
        app.add(txtNumberOfLinesToDraw, BorderLayout.SOUTH);

        txtNumberOfLinesToDraw.addActionListener(e -> {

            int numberOfLinesToDraw;

            try {
                numberOfLinesToDraw = Integer.parseInt(txtNumberOfLinesToDraw.getText());
            }
            catch(NumberFormatException ex) {
                txtNumberOfLinesToDraw.setText("Please provide a valid number");
                txtNumberOfLinesToDraw.selectAll();
                return;
            }

            instanceOfScreenSaver.setNumberOfLinesToDraw(numberOfLinesToDraw);
            app.add(instanceOfScreenSaver);
            app.setVisible(true);
        });

        app.setSize(800, 600);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}