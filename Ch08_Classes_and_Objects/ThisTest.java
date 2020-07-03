package Ch08_Classes_and_Objects;

/**
 * Fig. 8.4: this used implicitly and explicitly to refer to members of an
 * object.
 * 
 * NOTE:
 * We declare 2 classes in 1 file -- class ThisTest & class SimpleTime.
 * We do this to demonstrate that when you compile a .java file
 * containing more than one class, the compiler produces a separate
 * class file with the .class extension for every compiled class.
 * In this case, two separate files are produced:
 * -- SimpleTime.class
 * -- ThisTest.class
 * Note also that only class ThisTest is declared public. A source-
 * code file can contain only one public class--otherwise, compilation
 * error occurs.
 *
 * @author David
 */
public class ThisTest {

    public static void main(String[] args) {

        SimpleTime time = new SimpleTime(15, 30, 19);
        System.out.println(time.buildString());
    }

} // end class ThisTest

// class SimpleTime demonstrate the "this" reference
// Non-public classes can be used only by other classes in the same package.
class SimpleTime {

    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    // if the constructor uses parameter names identical to
    // instance variable names the "this" reference is
    // required to distinguish between the names
    public SimpleTime(int hour, int minute, int second) {
        this.hour = hour; // set "this" object's hour
        this.minute = minute; // set "this" object's minute
        this.second = second; // set "this" object's second
    }
    
    // use explicit and implicit "this" to call toUniversalString
    public String buildString() {
        return String.format("%24s: %s\n%24s: %s", 
                "this.toUniversalString()", this.toUniversalString(), // explicit call
                "toUniversalString()", toUniversalString() ); // implicit call
    }

    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        // "this" is not required here to access instance variables,
        // because method does not have local variables with same
        // names as instance variables
        return String.format("%02d:%02d:%02d", 
                this.hour, this.minute, this.second);
    }

}

/**
 * Java conserves storage by maintaining only one copy of each method per class—this method
 * is invoked by every object of the class. Each object, on the other hand, has its own copy of
 * the class’s instance variables (i.e., non-static fields). Each method f the class implicitly 
 * uses this to determine the specific object of the class to manipulate. 
 */