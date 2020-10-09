package Ch14_GUI_Components_P1;
// Fig. 14.34: Using class MouseMotionAdapter.
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {

    private int pointCount = 0; // count number of points

    // array of 10000 java.awt.Point references
    private Point[] points = new Point[ 10000 ];

    // set up GUI and register event handler
    public PaintPanel() {
        setBackground(java.awt.Color.WHITE);
        // handle frame mouse motion event
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override // store drag coordinates and repaint
            public void mouseDragged(MouseEvent e) {
                if (pointCount < points.length) {
                    points[ pointCount ] = e.getPoint(); // find point
                    ++pointCount; // increment number of points in array
                    System.out.printf("counted point(s): %d\n",pointCount);
                    repaint(); // repaint JFrame
                }
            } // end method mouseDragged
        }
        ); // end anonymous inner class
    } // end PaintPanel constructor

    @Override // draw oval in a 4x4 bounding box at specified locations on windows
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // clears drawing area
        // draw all points in array
        for (int i = 0; i < pointCount; ++i) {
            g.fillOval(points[i].x, points[i].y, 4, 4);
        } // end method paintComponent
    } // end class PaintPanel
}
