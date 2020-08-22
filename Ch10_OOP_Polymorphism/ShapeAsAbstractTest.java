package Ch10_OOP_Polymorphism;

/**
 * Sometimes it’s useful to declare classes—called abstract classes—for which 
 * you never intend to create objects. Because they’re used only as superclasses 
 * in inheritance hierarchies, we refer to them as abstract superclasses. These 
 * classes cannot be used to instantiate objects, because, as we’ll soon see, 
 * abstract classes are incomplete. Subclasses must declare the “missing pieces” 
 * to become “concrete” classes, from which you can instantiate objects. 
 * Otherwise, these subclasses, too, will be abstract. @author David
 */
enum Color { RED, GREEN, BLUE, BLACK };

/* An abstract class declares common attributes and behaviors (both
abstract and concrete) of the various classes in a class hierarchy. 
An abstract class typically contains one or more abstract methods 
that subclasses must override if they are to be concrete. The instance
variables and concrete methods of an abstract class are subject to the
normal rules of inheritance. */
abstract class Shape {

    public abstract void draw();
    public abstract void move();
    public abstract void resize();
    public abstract void changeColor(Color newColor);
    
    public static boolean status = true;
    
    Point location;
    Color color;
    int borderThickness;
}
/* Classes that can be used to instantiate objects are called concrete classes. 
Abstract superclasses are too general to create real objects—they specify only
what is common among subclasses. We need to be more specific before we can 
create objects. For example, if you send the draw() message to abstract class
TwoDimensionalShape, the class knows that two-dimensional shapes should be
drawable, but it does not know what specific shape to draw, so it cannot
implement a real draw() method. Concrete classes provide the specifics that
make it reasonable to instantiate objects. 

Abstract methods do not provide implementations. A class that contains any abstract
methods must be explicitly declared abstract even if that class contains some concrete
(nonabstract) methods. Each concrete subclass of an abstract superclass also must provide
concrete implementations of each of the superclass’s abstract methods. Constructors and
static methods cannot be declared abstract. Constructors are not inherited, so an
abstract constructor could never be implemented. Though non-private static
methods are inherited, they cannot be overridden. Since abstract methods are meant to
be overridden so that they can process objects based on their types, it would not make
sense to declare a static method as abstract. */

public class ShapeAsAbstractTest {
 
    public static void main(String[] args) {
        /* Although we cannot instantiate objects of abstract superclasses, 
        you’ll soon see that we can use abstract superclasses to declare 
        variables that can hold references to objects of any concrete class 
        derived from those abstract superclasses. Programs typically use such 
        variables to manipulate subclass objects polymorphically. You also can 
        use abstract superclass names to invoke static methods declared in those 
        abstract superclasses. */
        Shape[] shapes = new Shape[] {
            new Circle(), new Triangle(), new Rectangle()
        };
        
        for (Shape shape : shapes) {
            shape.draw();
        }
        
        if (Shape.status == true) {
            System.out.println("Okay.");
        }
    }
}