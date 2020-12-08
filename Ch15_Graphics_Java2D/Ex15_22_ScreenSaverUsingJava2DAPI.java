package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

class DrawRandomShapesUsing2DAPI extends JPanel implements ActionListener {

    private int numberOfLinesToDraw = 100;
    private Random random;
    private Timer timer;
    private final Color[] colors = {
        Color.RED, Color.WHITE, Color.BLACK, Color.GREEN,
        Color.BLUE, Color.LIGHT_GRAY, Color.YELLOW, Color.PINK,
        Color.MAGENTA, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.LIGHT_GRAY, Color.ORANGE
    };
    int x1, x2, y1, y2, w, h, arcW, arcH, quarterW, quarterH, halfW, halfH;

    public DrawRandomShapesUsing2DAPI() {

        random = new Random();
        timer = new Timer(100, this);
        timer.start();
    }

    public void setNumberOfLinesToDraw(int numberOfLinesToDraw) {

        if (numberOfLinesToDraw < 100_000) {
            this.numberOfLinesToDraw = numberOfLinesToDraw;
        }
        else {
            this.numberOfLinesToDraw = 10_000;
        }
    }

    private Color randomGenerator() {

        quarterW = getWidth() / 4;
        quarterH = getHeight() / 4;

        halfW = getWidth() / 2;
        halfH = getHeight() / 2;

        w = random.nextInt(quarterW);
        h = random.nextInt(quarterH);

        int getW_w = getWidth() - w;
        int getH_h = getHeight() - h;

        x1 = random.nextInt(getW_w);
        y1 = random.nextInt(getH_h);
        x2 = random.nextInt(getW_w);
        y2 = random.nextInt(getH_h);

        arcW = random.nextInt(20);
        arcH = random.nextInt(50);

        return colors[random.nextInt(colors.length)];
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paint method, clear screen
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.BLACK);

        for (int count = 0; count < numberOfLinesToDraw; ++count) {

            g.setColor(randomGenerator()); g.drawLine(x1, y1, x2, y2);
            g.setColor(randomGenerator()); g.drawRect(x1, y1, w, h);
            g.setColor(randomGenerator()); g.drawRoundRect(x1, y1, w, h, arcW, arcH);
            g.setColor(randomGenerator()); g.drawOval(x1, y1, w, h);

            // draw 2D ellipse filled with a blue-yellow gradient
            g2d.setPaint(new GradientPaint(x1, y1, Color.BLUE, x2, y2, Color.YELLOW, true));
            g2d.fill(new Ellipse2D.Double(x1,y1,w,h));

            // draw 2D rectangle in red
            g2d.setPaint(Color.RED);
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.draw(new Rectangle2D.Double(x1, y1, w, h));
        } // end of for loop
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class Ex15_22_ScreenSaverUsingJava2DAPI {

    public static void main(String[] args) {

        DrawRandomShapesUsing2DAPI instanceOfScreenSaver = new DrawRandomShapesUsing2DAPI();
        JFrame app = new JFrame();
        JTextField txtNumberOfLinesToDraw = new JTextField("Enter number of lines to draw");
        txtNumberOfLinesToDraw.selectAll();

        app.setTitle("Screen Saver using the Java 2D API");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLayout(new BorderLayout());
        app.add(txtNumberOfLinesToDraw, BorderLayout.NORTH);

        txtNumberOfLinesToDraw.addActionListener(e -> {

            int numberOfLinesToDraw;

            try {
                numberOfLinesToDraw = Integer.parseInt(txtNumberOfLinesToDraw.getText());
                if (numberOfLinesToDraw > 100_000) {
                    txtNumberOfLinesToDraw.setText("That's too much for me to handle, try less than 100K");
                    txtNumberOfLinesToDraw.selectAll();
                    return;
                }
            }
            catch(NumberFormatException ex) {
                txtNumberOfLinesToDraw.setText("Please provide a valid number");
                txtNumberOfLinesToDraw.selectAll();
                return;
            }

            instanceOfScreenSaver.setNumberOfLinesToDraw(numberOfLinesToDraw);
            app.add(instanceOfScreenSaver);
            app.setVisible(true);
            System.out.println("fire!");
        });

        app.setSize(800, 600);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}