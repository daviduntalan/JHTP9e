package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;

/**
 * Fig. 15.27 Drawing polygons.
 */
public class PolygonsJPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // call super class's paintComponent

        // draw polygon using Polygon object - closed
        int[] xValues1 = {20, 40, 50, 30, 20, 15, 50};
        int[] yValues1 = {50, 50, 60, 80, 80, 60, 80};
        Polygon polygon1 = new Polygon(xValues1, yValues1, xValues1.length);
        g.drawPolygon(polygon1); /* If the last point is different from the first,
        the polygon is closed by a line that connects the last point to the first. */

        // draw polyline with two arrays - opened
        int[] xValues2 = { 70,  90, 100,  80,  70,  65,  50};
        int[] yValues2 = {100, 100, 110, 110, 130, 110, 110};
        g.drawPolyline(xValues2, yValues2, xValues2.length);
        /* If the last point is different from the first,
        the polyline is NOT closed. */

        // draw filled polygon using two arrays - closed
        int[] xValues3 = { 120, 150, 120, 220 };
        int[] yValues3 = {  40,  60, 100,  50 };
        g.fillPolygon( xValues3, yValues3, xValues3.length );

        // draw filled polygon using Polygon object - closed
        Polygon polygon2 = new Polygon();
        polygon2.addPoint( 165, 135 );
        polygon2.addPoint( 165, 170 );
        polygon2.addPoint( 250, 200 );
        polygon2.addPoint( 200, 220 );
        polygon2.addPoint( 130, 180 );
        g.fillPolygon(polygon2);
    }
}
