package Ch11_ExceptionHandling;

/**
 * Catching Exceptions Using Outer Scope. Write a program showing that
 * a method with its own try block does not have to catch every possible
 * error generated within the try. Some exceptions can slip through to, 
 * and be handled in, other scopes.
 * @author David
 */
public class Ex11_22_CatchingExceptionsUsingOuterScope {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            throwException();
        } catch (Exception ex) {
            System.out.println("caught in main():");
            System.out.println(ex.getMessage());
        }
    }

    private static void throwException() throws Exception {
        try // throw an exception and immediately catch it
        {
            System.out.println("Method throwException");
            throw new Exception("Exception from throwException()"); // generate exception
        } 
        catch (Exception exception) // catch exception thrown in try
        {
            System.out.println("Exception handled partially in method throwException");
            throw exception; // rethrow for further processing
        }
        finally // executes regardless of what occurs in try...catch
        {
            System.out.println("Finally executed in throwException");
        }
    }
    
}
