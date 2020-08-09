package Ch09_OOP_Inheritance;

/**
 * Write an inheritance hierarchy for classes Quadrilateral, Trapezoid, Parallelogram,
 * Rectangle and Square. Use Quadrilateral as the superclass of the hierarchy. 
 * Create and use a Point class to represent the points in each shape. Make the 
 * hierarchy as deep (i.e., as many levels) as possible. Specify the instance 
 * variables and methods for each class. The private instance variables of
 * Quadrilateral should be the x-y coordinate pairs for the four endpoints of 
 * the Quadrilateral. Write a program that instantiates objects of your classes 
 * and outputs each object’s area (except Quadrilateral).
 * @author David
 */

class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}

/*
class Shape {}

class TwoDimensionalShape extends Shape {}
class Circle extends TwoDimensionalShape {}
class Triangle extends TwoDimensionalShape {}
class Quadrilateral extends TwoDimensionalShape {}
class Square extends Quadrilateral {}
*/
class Trapezoid extends Quadrilateral {}
class Parallelogram extends Quadrilateral {}
class Rectangle extends Quadrilateral {
    private Point xy1;
    private Point xy2;

    public Rectangle(Point xy1, Point xy2) {
        this.xy1 = xy1;
        this.xy2 = xy2;
    }    

    @Override
    public String toString() {
        return "Rectangle{" + "\npoint1=" + xy1.getX() + ":" + xy1.getY() 
                + ", \npoint2=" + xy2.getX() + ":" + xy2.getY() + '}';
    }        
}

public class Ex09_08_InhritanceHierarchy {

    public static void main(String[] args) {
        
        Rectangle rect = new Rectangle(new Point(20, 10), new Point(60, 20));
        System.out.println(rect);
    }
    
}
