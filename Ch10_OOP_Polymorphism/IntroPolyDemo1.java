package Ch10_OOP_Polymorphism;

/**
 * Create a program that simulates the movement of several types of
 * animals for  biology study. Classes Fish, Frog and Bird represent
 * the types of animals under investigation. Imagine that each class
 * extends superclass Animal, which contains a method move and 
 * maintains an animal's current location as x-y coordinates. Each
 * subclass implements method move. Our program maintains an Animal
 * array containing references to objects of the various Animal sub-
 * classes. To simulate the animals' movements, the program sends 
 * each object the same message once per second -- namely, move. 
 * Each specific type of Animal responds to a move message in its 
 * own way -- a Fish might swim three feet, a Frog might jump five
 * feet and a Bird might fly ten feet. Each object knows how to
 * modify its x-y coordinates appropriately for its specific type
 * of movement. Relying on each object to know how to "do the right
 * thing" (i.e., do what is appropriate for that type of object) 
 * in response to the same method call is the key concept of 
 * polymorphism. The same message (in this case, move) sent to a
 * variety of objects has "many forms" of results -- hence the term
 * polymorphism.
 * @author David
 */
abstract class Animal {
    // Animal 'has-a' Point instance variable - composition.
    protected Point location = new Point(0, 0); 
    abstract void move();
}

class Fish extends Animal {

    Fish(int feet) {
        location.setX(feet);
        location.setY(feet);        
    }

    @Override
    void move() {
        System.out.printf("Fish is Swimming ... %d feet\n", location.getX());
    }
    
}
class Frog extends Animal {

    Frog(int feet) {
        location.setX(feet);
        location.setY(feet);
    }

    @Override
    void move() {
        System.out.printf("Frog is Hopping ... %d feet\n", location.getY());
    }
    
}
class Bird extends Animal {

    Bird(int feet) {
        location.setX(feet);
        location.setY(feet);
    }
    
    @Override
    void move() {
        System.out.printf("Bird is Flying ... %d feet\n", location.getX());
    }
}
/*
Implementing for Extensibility

With polymorphism, we can design and implement systems that are easily
extensible--new classes can be added with little or no modification to
the general portions of the programs, as long as the new classes are
part of the inheritance hierarchy that the program processes generically.

The only part of a program that must be altered are those that require
direct knowledge of the new classes that we add to the hierarchy. 
For example, if we extend class Animal to create class Tortoise (which
might respond to a move message by crawling one inch), we need to
write only the Tortoise class and the part of the simulation that 
instantiates a Tortoise object. The portions of the simulation that
tell each Animal to move generically can remain the same. Wow!
*/
class Tortoise extends Animal {

    public Tortoise(int feet) {
        location.setX(feet);
        location.setY(feet);
    }
    @Override
    void move() {
        System.out.printf("Tortoise is Crawling ... %d feet\n", location.getX());
    }
    
}
public class IntroPolyDemo1 {

    public static void main(String[] args) {
                
        // contains references to objects of various Animal sub-classes
        Animal[] animals = new Animal[] {            
            new Bird(10), new Frog(5), new Fish(3), new Tortoise(2)
        }; // Bird, Frog and Fish 'is-an' Animal - inheritance.
        
        for (Animal animal : animals) {
            animal.move(); // sends each object the same message
        }
        
        System.out.printf("%s\n", "Tapos na po!");
    }
    
}
