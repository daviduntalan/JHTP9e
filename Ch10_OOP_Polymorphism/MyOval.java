package Ch10_OOP_Polymorphism;

import java.awt.Color;
import java.awt.Graphics;

/**
 * MyOval class represents an oval.
 *
 * @author David
 */
public class MyOval extends MyBoundedShape {    
    
    public MyOval() {
        super(0, 0, 0, 0, Color.BLACK, false);
    }

    public MyOval(int x, int y, int width, int height, Color color, boolean filled) {
        super(x, y, width, height, color, filled);
    }

    // draw the line in the specified color
    // g is a reference to Graphics object on the JPanel so that
    // we can draw components to it and displayed by system by
    // a call to paintComponet(g) to refresh the drawing on the screen - Just my own opinion.
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getIsFilled()) {            
            g.fillOval(getUpperLeftX(), getUpperLeftY(), 
                    getWidth(), getHeight());                       
        } else {
            g.drawOval(getUpperLeftX(), getUpperLeftY(), 
                    getWidth(), getHeight());
        }
    }
}
