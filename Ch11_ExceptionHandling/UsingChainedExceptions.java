package Ch11_ExceptionHandling;

/**
 * Fig. 11.6: Chained exceptions. To debug, 
 * read the exception in reverse order.
 * @author David
 */
public class UsingChainedExceptions {

    public static void main(String[] args) {
        try {
            method1(); // call method1
        } 
        catch (Exception exception) {  // exceptions thrown from method1; with method2 and method3 exceptions.
            exception.printStackTrace();
        }
    }

    // call method2; throw exceptions back to main
    private static void method1() throws Exception {
        try 
        {
            method2(); // call method2
        } 
        catch (Exception exception)  // exception thrown from method2
        {
            final Exception cause = exception; // to retain/wrap the original exception from method2
            throw new Exception("Exception thrown in method1", cause); 
        }
    }

    // call method3; throw exceptions back to method1
    private static void method2() throws Exception {
        try {
            method3(); // call method3
        } catch (Exception exception) {
            final Exception cause = exception; // to retain/wrap the original exception from method3
            throw new Exception("Exception thrown in method2", cause); 
        }
    }

    // throw Exception back to method2
    private static void method3() throws Exception {
        throw new Exception("Exception thrown in method3");
    }
    
}

/* 
Also notice that, as you read the output in reverse, 
it shows how many more chained exceptions remain. 

... 2 more
... 1 more 
*/