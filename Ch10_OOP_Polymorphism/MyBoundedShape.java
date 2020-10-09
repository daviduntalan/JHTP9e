package Ch10_OOP_Polymorphism;

import java.awt.Color;

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
    
    public int getUpperLeftX() { return Math.min(getX1(), getX2()); }
    public int getUpperLeftY() { return Math.min(getY1(), getY2()); }
    public int getWidth() { return Math.abs(getX2() - getX1()); } /* this fn turns -n to +n */
    public int getHeight() { return Math.abs(getY2() - getY1()); } /* so you could draw, from L-Right to U-Left */
        
}
