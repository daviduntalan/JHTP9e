package Ch08_Classes_and_Objects;
import java.awt.Color;
import java.awt.Graphics;
/**
 * Fig. 8.18: MyLine class represents a line.
 */

public class MyLine {
    private int x1; // x-coordinate of first endpoint
    private int y1; // y-coordinate of first endpoint
    private int x2; // x-coordinate of second endpoint
    private int y2; // y-coordinate of second endpoint
    private Color myColor; // color of this shape

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        setX1(x1); setY1(y1); setX2(x2); setY2(y2);
        setMyColor(color);
    }

    public void setX1(int x) {
        if (x >=0 ) this.x1 = x;
        else this.x1 = 0;
    }

    public void setY1(int y) {
        if(y >=0) this.y1 = y;
        else this.y1 = 0;
    }

    public void setX2(int x) {
        if (x >=0 ) this.x2 = x;
        else this.x2 = 0;
    }

    public void setY2(int y) {
        if(y >=0) this.y2 = y;
        else this.y2 = 0;
    }

    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }

    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public Color getMyColor() { return myColor; }

    // draw the line in the specified color
    // g is a reference to draw components to paintComponet(g) 
    public void draw(Graphics g) {
        g.setColor(myColor);
        g.drawLine(x1, y1, x2, y2);
    }
}
