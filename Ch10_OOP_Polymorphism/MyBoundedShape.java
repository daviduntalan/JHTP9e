package Ch10_OOP_Polymorphism;

import java.awt.Color;

/**
 *
 * @author David
 */
public abstract class MyBoundedShape extends MyShape {

    private boolean isFilled; // flag to determine the shape is filled

    public MyBoundedShape() {
        super(0, 0, 0, 0, Color.BLACK);
    }

    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color);
        setIsFilled(filled);
    }
    
    public final boolean getIsFilled() {
        return isFilled;
    }

    public final void setIsFilled(boolean filled) {
        isFilled = filled;
    }
    
    public int getUpperLeftX() { return getX1(); }
    public int getUpperLeftY() { return getY1(); }
    public int getWidth() { return getX2() - getX1(); }
    public int getHeight() { return getY2() - getY1(); }
        
}
