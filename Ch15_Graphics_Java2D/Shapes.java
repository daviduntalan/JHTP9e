package Ch15_Graphics_Java2D;
/** Fig. 15.30: Demonstrating some Java 2D shapes. */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

/** Fig. 15.29: Demonstrating some Java 2D shapes. */
class ShapesJPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call super class's paintComponent
        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D

        // draw 2D ellipse filled with a blue-yellow gradient
        g2d.setPaint(new GradientPaint(3, 30, Color.BLUE, 35, 100, Color.YELLOW, true));
        g2d.fill(new Ellipse2D.Double(5,30,65,100));

        // draw 2D rectangle in red
        g2d.setPaint(Color.RED);
        g2d.setStroke(new BasicStroke(10.0f));
        g2d.draw(new Rectangle2D.Double(80, 30, 65, 100));

        // draw 2D rounded rectangle with a buffered background
        BufferedImage bufferedImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);

        // obtain Graphics2D from bufferedImage and draw on it
        Graphics2D gg = bufferedImage.createGraphics();
        gg.setColor(Color.YELLOW); gg.fillRect(0,0,10,10); // draw a filled rectangle
        gg.setColor(Color.BLACK); gg.drawRect(1,1,6,6); // draw a rectangle
        gg.setColor(Color.BLUE); gg.fillRect(1,1,3,3); // draw a filled rectangle
        gg.setColor(Color.RED); gg.fillRect(4,4,3,3); // draw a filled rectangle

        // paint bufferedImage onto the JFrame
        g2d.setPaint(new TexturePaint(bufferedImage, new Rectangle(10,10)));
        g2d.fill(new RoundRectangle2D.Double(155, 30, 75, 100, 50, 50));

        // draw 2D pie-shaped arc in white
        g2d.setPaint(Color.WHITE);
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.draw(new Arc2D.Double(240, 30, 75, 100, 0, 270, Arc2D.PIE));

        // draw 2D lines in green and yellow
        g2d.setPaint(Color.GREEN);
        g2d.draw(new Line2D.Double(395, 30, 320, 150));

        // draw 2D line using stroke
        float[] dashes = { 10 }; // specify dash pattern
        g2d.setPaint(Color.YELLOW);
        g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND, 10, dashes, 0));
        g2d.draw(new Line2D.Double(320, 30, 395, 150));

        // auxiliary line to determine where the Blue & Yellow lined up
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(3,30,35,100);
    } // end of method paintComponent
} // end of class ShapesJPanel

public class Shapes {

    public static void main(String[] args) {

        // create frame for ShapesJPanel
        JFrame frame = new JFrame("Drawing 2D Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ShapesJPanel());
        frame.setSize(425,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}