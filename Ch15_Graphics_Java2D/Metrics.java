package Ch15_Graphics_Java2D;

import javax.swing.*;

/** Fig. 15.16: Displaying font metrics. */
public class Metrics {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Demonstrating FontMetrics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new MetricsJPanel() ); // add MetricsJPanel to frame
        frame.setSize(510, 240);
        frame.setVisible(true); // display frame
    }
}
