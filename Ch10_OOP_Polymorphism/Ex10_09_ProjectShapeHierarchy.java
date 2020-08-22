package Ch10_OOP_Polymorphism;

/**
 * Project: Shape Hierarchy. Implement the Shape hierarchy shown in 
 * Fig. 9.3. Each TwoDimensionalShape should contain method getArea
 * to calculate the area of the two-dimensional shape. Each
 * ThreeDimensionalShape should have methods getArea and getVolume 
 * to calculate the surface area and volume, respectively, of the 
 * three-dimensional shape. Create a program that uses an array of
 * Shape references to objects of each concrete class in the hierarchy.
 * The program should print a text description of the object to which
 * each array elements refers.
 * 
 * @author David
 */
public class Ex10_09_ProjectShapeHierarchy {

    public static void main(String[] args) {
        
        Shape1[] shapes = new Shape1[] {
            new Circle1(), new Square1(), new Triangle1(),
            new Sphere1(), new Cube1(), new Tetrahedron1()
        };
        
        for (Shape1 shape : shapes) {
            System.out.printf("%-12s", shape.getClass().getSimpleName());
            if (shape instanceof TwoDimensionalShape1) {
                System.out.printf(" - 2D Area: %3d", 
                        ((TwoDimensionalShape1) shape).getArea()
                );
            }             
            if (shape instanceof ThreeDimensionalShape1) {
                System.out.printf(" - 3D Area: %3d Volume: %4d", 
                        ((ThreeDimensionalShape1) shape).getArea(),
                        ((ThreeDimensionalShape1) shape).getVolume()
                );
            }
            System.out.println();
        }
    }
    
}
