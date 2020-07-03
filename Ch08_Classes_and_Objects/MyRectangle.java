package Ch08_Classes_and_Objects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Ex08_01: MyRectangle class represents an rectangle.
 *
 * @author David
 */
public class MyRectangle extends MyLine {

    private boolean isFilled; // flag to determine the shape is filled

    public MyRectangle() {
        super(0, 0, 0, 0, Color.BLACK);
        setIsFilled(false);
    }        

    public MyRectangle(int x, int y, int width, int height, Color color, boolean filled) {        
        super(x, y, width, height, color);
        setIsFilled(filled);
    }

    public final void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }
    
    public int getUpperLeftX() { return getX1(); }
    public int getUpperLeftY() { return getY1(); }
    public int getWidth() { return getX2() - getX1(); }
    public int getHeight() { return getY2() - getY1(); }

    // draw the line in the specified color
    // g is a reference to Graphics object on the JPanel so that
    // we can draw components to it and displayed by system by
    // a call to paintComponet(g) to refresh the drawing on the screen - Just my own opinion.
    @Override
    public void draw(Graphics g) {
        g.setColor(getMyColor());
        if (isFilled) {
            g.fillRect(getUpperLeftX(), getUpperLeftY(), 
                    getWidth(), getHeight());
        } else {
            g.drawRect(getUpperLeftX(), getUpperLeftY(), 
                    getWidth(), getHeight());
        }
    }
}
