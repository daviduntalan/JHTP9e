package student_assignments;

/**
 * How to simulate multiple inheritance in java?
 * Answer: extends, interface and implements keyword.
 * 
 * interface
 * - class that consist of implicit abstract methods, defnied by classes
 *   that implement that interface.
 * 
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ08_SimulateInheritance {

    public static void main(String[] args) {
        // this is how we go about doing that.
        Poodle myPoodle = new Dog();                
        myPoodle.poodleSpeak();
        myPoodle.poodleWalk();
        
        GoldenRetriever myGolden = new Dog();
        myGolden.goldenRetrieverSpeak();
        myGolden.goldenRetrieverWalk();                
    }

}

interface Poodle {
    void poodleSpeak(); // by default this is [public abstract]
    void poodleWalk();
}

interface GoldenRetriever {
    void goldenRetrieverSpeak();
    void goldenRetrieverWalk();
}

// multiple inherentance
class Dog implements Poodle, GoldenRetriever {

    @Override
    public void poodleSpeak() {
        System.out.println("Poodle bark!");
    }

    @Override
    public void poodleWalk() {
        System.out.println("Poodle walk.");
    }

    @Override
    public void goldenRetrieverSpeak() {
        System.out.println("Golden bark!");
    }

    @Override
    public void goldenRetrieverWalk() {
        System.out.println("Golden walk.");
    }
    
}