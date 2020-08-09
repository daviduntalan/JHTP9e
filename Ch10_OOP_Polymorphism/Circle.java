package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Circle extends Shape {

    public Circle() {
    }

    @Override
    public void draw() {
        System.out.println("Circle drawn");
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
