package Ch08_Classes_and_Objects;

/**
 * Declaring an instance variable as final helps enforce the principle of least privilege. If an
 * instance variable should not be modified, declare it to be final to prevent modification.
 * 
 * Attempting to modify a final instance variable after it’s initialized is a compilation error.
 * 
 * Attempts to modify a final instance variable are caught at compilation time rather than
 * causing execution-time errors. It’s always preferable to get bugs out at compilation time,
 * if possible, rather than allow them to slip through to execution time (where experience has
 * found that repair is often many times more expensive).
 * 
 * A final field should also be declared static if it’s initialized in its declaration to a value
 * that’s the same for all objects of the class. After this initialization, its value can never
 * change. Therefore, we don’t need a separate copy of the field for every object of the class.
 * Making the field static enables all objects of the class to share the final field.
 * 
 * @author David
 */
public class FinalTest {

    private static final int INCREMENT = 1234;
    /*
    private final int INCREMENT;

    public FinalTest() {
        INCREMENT = 8888;
    }
    */
    
    public static void main(String[] args) {

        // Access INCREMENT by class name
        System.out.printf("FinalTest.INCREMENT = %d\n", 
                FinalTest.INCREMENT);
    
        /*
        // Access INCREMENT by instance name
        FinalTest finalTest = new FinalTest();
        System.out.printf("finalTest.INCREMENT = %d\n", finalTest.INCREMENT);
        */
    }

}
