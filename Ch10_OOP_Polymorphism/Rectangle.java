package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Rectangle extends Shape {

    public Rectangle() {
    }

    @Override
    public void draw() {
        System.out.println("Rectangle drawn");
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeColor(Color newColor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
