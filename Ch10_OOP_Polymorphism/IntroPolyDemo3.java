package Ch10_OOP_Polymorphism;

/**
 * Space Objects in a Video Game.
 * 
 * Suppose we design a video game that manipulates objects of class Martian, Venusian,
 * Plutonian, SpaceShip and LaserBeam. Imagine that each class inherits from the superclass
 * SpaceObject, which contains method draw. Each subclass implements this method. A
 * screen manager maintains a collection (e.g., a SpaceObject array) of references to objects
 * of the various classes. To refresh the screen, the screen manager periodically sends each 
 * object the same message--namely, draw. However, each object responds its own way, based
 * on its class. For example, a Martian object might draw itself in red with green eyes and the
 * appropriate number of antennae. A SpaceShip object might draw itself as a bright silver
 * flying saucer. A LaserBeam object might draw itself as a bright red beam across the screen.
 * Again, the same message (in this case, draw) sent to a variety of objects has "many forms"
 * of results.
 * 
 * A screen manager might use polymorphism to facilitate adding new classes to a system
 * with minimal modifications to the system's code. Suppose that we want to add Mercurian
 * objects to our video game. To do so, we'd build a class Mercurian that extends SpaceObject
 * and provides its own draw method implementation. When Mercurian objects appear
 * in the SpaceObject collection, the screen manager code invokes method draw, exactly as it
 * does for every other object in the collection, regardless of its type. So the new Mercurian
 * objects simply "plug right in" without any modification of the screen manager code by the 
 * programmer. Thus, without modifying the system (other than to build new classes and
 * modify the code that creates new objects), you can use polymorphism to conveniently 
 * include additional types that were not envisioned when the system was created.
 * 
 * @author David
 */
abstract class SpaceObject {
    public void draw(){}
}
class Martian extends SpaceObject {}
class Venusian extends SpaceObject {}
class Plutonian extends SpaceObject {}
class SpaceShip extends SpaceObject {} 
class LaserBeam extends SpaceObject {}
// plug right in - w/o modification of the screen manager code
class Mercurian extends SpaceObject {}

public class IntroPolyDemo3 {

    public static void main(String[] args) {
        
        // plug right in - w/o modification of the screen manager code
        SpaceObject[] spaceObjects = new SpaceObject[] {
            new Martian(), new Venusian(), new Plutonian(),
            new SpaceShip(), new LaserBeam(), new Mercurian()
        }; 
        /* Subclass object is-an object of its superclass. But,
        you cannot treat a superclass object as a subclass object, because 
        a superclass object is not an object of any of its subclasses. 
        Ex: Martian m = new SpaceObject(); -- NOT ALLOWED because, SpaceObject 
        doesn't have instance variables and doesn't have methods of Martian. 
        The is-a relationship applies only UP the hierarchy from a subclass to 
        its direct (and indirect) superclasses, and NOT vice versa (i.e., 
        NOT down the hierarchy from a superclass to its subclasses. 
        
        The Java compiler does allow the assignment of a superclass reference to a subclass
        variable if we explicitly cast the superclass reference to the subclass type—a technique we
        discuss in Section 10.5. Why would we ever want to perform such an assignment? A superclass
        reference can be used to invoke only the methods declared in the superclass—
        attempting to invoke subclass-only methods through a superclass reference results in compilation
        errors. If a program needs to perform a subclass-specific operation on a subclass
        object referenced by a superclass variable, the program must first cast the superclass reference
        to a subclass reference through a technique known as downcasting. This enables the
        program to invoke subclassmethods that are not in the superclass.We show a downcasting
        example in Section 10.5. */
        
        for (SpaceObject spaceObject : spaceObjects) {
            spaceObject.draw();
        }
                
    }
    
}
