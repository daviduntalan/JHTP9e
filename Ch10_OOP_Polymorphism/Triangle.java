package Ch10_OOP_Polymorphism;

/**
 *
 * @author David
 */
public class Triangle extends Shape {

    public Triangle() {
    }

    @Override
    public void draw() {
        System.out.println("Triangle drawn");
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
