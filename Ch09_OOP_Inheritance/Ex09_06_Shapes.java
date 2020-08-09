package Ch09_OOP_Inheritance;

/**
 * The world of shapes is much richer than the shapes included in the inheritance 
 * hierarchy of Fig. 9.3. Write down all the shapes you can think of—both two-
 * dimensional and three-dimensional—and form them into a more complete Shape 
 * hierarchy with as many levels as possible. Your hierarchy should have class 
 * Shape at the top. Classes TwoDimensionalShape and ThreeDimensionalShape
 * should extend Shape. Add additional subclasses, such as Quadrilateral and 
 * Sphere, at their correct locations in the hierarchy as necessary.
 * @author David
 */

class Shape {}

class TwoDimensionalShape extends Shape {}
class Circle extends TwoDimensionalShape {}
class Square extends TwoDimensionalShape {} // also a Quadrilateral class
class Triangle extends TwoDimensionalShape {}

class ThreeDimensionalShape extends Shape {}
class Sphere extends ThreeDimensionalShape {}
class Cube extends ThreeDimensionalShape {}
class Tetrahedron extends ThreeDimensionalShape {}

class Quadrilateral extends Shape {}


public class Ex09_06_Shapes {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
