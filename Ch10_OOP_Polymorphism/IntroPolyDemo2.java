package Ch10_OOP_Polymorphism;

/**
 * If class Rectangle is derived from class Quadrilateral, then a Rectangle object is a more
 * specific version of a Quadrilateral. Any operation (e.g., calculating the perimeter or the
 * area) that can be performed on a Quadrilateral can also be performed on a Rectangle.
 * These operations can also be performed on other Quadrilaterals, such as Squares, Parallelograms
 * and Trapezoids. The polymorphism occurs when a program invokes a method
 * through a superclass Quadrilateral variable—at execution time, the correct subclass
 * version of the method is called, based on the type of the reference stored in the superclass
 * variable.
 * @author David
 */
abstract class AbstractShape {}
abstract class TwoDimensionalShape extends AbstractShape {}
class CircleClass extends TwoDimensionalShape {}
// class SquareClass extends TwoDimensionalShape {}
class TriangleClass extends TwoDimensionalShape {}

abstract class ThreeDimensionalShape extends AbstractShape {}
class SphereClass extends ThreeDimensionalShape {}
class CubeClass extends ThreeDimensionalShape {}
class TetrahedronClass extends ThreeDimensionalShape {}

class Quadrilateral extends TwoDimensionalShape {
    public int getPerimeter() { return 0; }
    public int getArea() { return 0; }
}

class RectangleClass extends Quadrilateral {}
class SquareClass  extends Quadrilateral {}
class ParallelogramClass extends Quadrilateral {}
class TrapezoidClass extends Quadrilateral {}

public class IntroPolyDemo2 {

    public static void main(String[] args) {
        
        Quadrilateral[] quads = new Quadrilateral[] {
            new RectangleClass(), new SquareClass(), 
            new ParallelogramClass(), new TrapezoidClass()
        };
        
        // send the same message for all Quadrilaterals
        for (Quadrilateral quad : quads) {
            quad.getArea(); // polymorphic behavior 
            quad.getPerimeter(); // happens here.
        }
    }
    
}
