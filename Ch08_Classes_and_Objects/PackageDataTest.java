package Ch08_Classes_and_Objects;

/**
 * Scope of Package-access: If a program uses multiple classes from
 * the same package (i.e., a group of related classes within 
 * Ch08_Classes_and_Objects), these classes can access each other's 
 * package-access members DIRECTLY through references to objects of
 * the appropriate classes, or in the case of static members 
 * through the class name. 
 * Fig. 8.17: Package-access members of a class are accessible by other classes
 * in the same package
 *
 * @author David
 */
public class PackageDataTest {

    public static void main(String[] args) {
        PackageData packageData = new PackageData();
        
        // output String representation of packageData
        System.out.printf("After instantiation:\n%s\n", packageData);
        
        // change package access data in packageData object
        packageData.number = 77;
        packageData.string = "Goodbye";
        
        // output String representation of packageData
        System.out.printf("\nAfter changing values:\n%s\n", packageData);
    }

}

// class with package access instance variables
class PackageData {

    int number; // package-access instance variable
    String string; // package-access instance variable

    // constructor
    public PackageData() {
        number = 0;
        string = "Hello";
    }
    
    @Override // return PackageData object String representation
    public String toString() {
        return String.format("number: %d; string: %s", number, string);
    }
}

/*
When you compile this program, the compiler
produces two separate .class files—PackageDataTest.class and PackageData.class.
The compiler places the two .class files in the same directory, so the classes are considered
to be part of the same package. Consequently, class PackageDataTest is allowed to
modify the package-access data of PackageData objects. You can also place class Package-
Data (lines 24–41) in a separate source-code file. As long as both classes are compiled in
the same directory on disk, the package-access relationship will still work.
*/