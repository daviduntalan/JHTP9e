package Ch11_ExceptionHandling;

/**
 * Fig. 11.4: try...catch...finally exception handling mechanism.
 * @author David
 */
public class UsingExceptions {

    public static void main(String[] args) {
        try 
        {
            throwException(); // call method throwException
        } 
        catch (Exception exception) // exception thrown by throwException
        { 
            System.out.println("Exception handled in main");
            System.out.println("> exception: " + exception);
        }
        doesNotThrowException();
    }

    // demonstrate try...catch...finally
    private static void throwException() throws Exception 
    {
        try // throw an exception and immediately catch it
        {
            System.out.println("Method throwException");
            throw new Exception(); // generate exception
        } 
        catch (Exception exception) // catch exception thrown in try
        {
            System.out.println("Exception handled in method throwException");
            throw exception; // rethrow for further processing
        }
        finally // executes regardless of what occurs in try...catch
        {
            System.out.println("Finally executed in throwException");
        }
    }

    // demonstrate finally when no exception occurs
    private static void doesNotThrowException() {
        try  // try block does not throw an exception
        {
            System.out.println("Method doesNotThrowException");
        } 
        catch (Exception exception) // does not execute
        {
            System.out.println(exception);
        }
        finally // executes regardless of what occurs in try...catch
        {
            System.out.println("Finally executed in doesNotThrowException");
        }
        
        System.out.println("End of method doesNotThrowException");
    }
    
}
