package Ch10_OOP_Polymorphism;

import java.awt.Color;
import java.awt.Graphics;

/**
 * MyShape represents any shape in general, you cannot implement a 
 * draw method without knowing exactly what shape it is.
 * @author David
 */

public abstract class MyShape {
        
    private int x1; /* coordinates */
    private int y1; /* coordinates */
    private int x2; /* coordinates */
    private int y2; /* coordinates */
    private Color color;

    public MyShape() {
        setX1(0); setX2(0);
        setY1(0); setY2(0);
        setColor(Color.BLACK);
    }

    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        setX1(x1); setX2(x2);
        setY1(y1); setY2(y2);
        setColor(color);
    }

    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public Color getColor() { return color; }

    public void setX1(int x) { x1 = (x >= 0) ? x : 0; }
    public void setY1(int y) { y1 = (y >= 0) ? y : 0; }
    public void setX2(int x) { x2 = (x >= 0) ? x : 0; }
    public void setY2(int y) { y2 = (y >= 0) ? y : 0; }
    public void setColor(Color color) { this.color = color; }

    public abstract void draw(Graphics g);
}