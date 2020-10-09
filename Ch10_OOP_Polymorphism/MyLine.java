package Ch10_OOP_Polymorphism;

import java.awt.Color;
import java.awt.Graphics;

/**
 * MyLine class represents a line.
 * 
 * @author David
 */
public class MyLine extends MyShape {

    public MyLine() {
        super(0, 0, 0, 0, Color.BLACK);
    }

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    // draw the line in the specified color
    // g is a reference to draw components to paintComponent(g)
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }

} // end of class MyLine