import com.deitel.jhtp.ch08.Time1; // import class Time1

/**
 * Line 1 is known as a single-type-import declaration--that is,
 * the import declaration specifies one class to import. When your
 * program uses multiple classes from the same package, you can 
 * import those classes with a single import declaration. For ex,
 * the import declaration
 * 
 *      import java.util.*; // import classes from package java.util
 * 
 * uses an asterisk(*) as its end to inform the compiler that all
 * public classes from the java.util package are available for use in
 * the program. This is known as a type-import-on-demand declaration.
 * Only the classes from package java.util that are used in the pro-
 * gram are loaded by the JVM. The preceding import allows you to use 
 * the simple name of any class from the java.util package in the 
 * program.
 * 
 * Fig. 8.16: Time1 object used in an application.
 * @author David
 */
public class Time1PackageTest {

    public static void main(String[] args) {
        // create and initialize a Time1 object
        Time1 time = new Time1(); // invokes Time1 constructor

        // output string representations of the time
        System.out.print("The initial universal time is: ");
        System.out.println(time.toUniversalString());
        System.out.print("The initial standard time is: ");
        System.out.println(time.toString());
        System.out.println(); // output a blank line

        // change time and output updated time
        time.setTime(13, 27, 6);
        System.out.print("Universal time after setTime is: ");
        System.out.println(time.toUniversalString());
        System.out.print("Standard time after setTime is: ");
        System.out.println(time.toString());
        System.out.println(); // output a blank line

        // attempt to set time with invalid values
        try {
            time.setTime(99, 99, 99); // all values out of range
        } // end try
        catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s\n\n", e.getMessage());
        } // end catch

        // display time after attempt to set invalid values
        System.out.println("After attempting invalid settings:");
        System.out.print("Universal time: ");
        System.out.println(time.toUniversalString());
        System.out.print("Standard time: ");
        System.out.println(time.toString());
    }

}