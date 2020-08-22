package Ch11_ExceptionHandling;


/**
 * Fig. 11.5: Stack unwinding and obtaining data from an exception object.
 * @author David
 */
public class StackUnwindingException {

    public static void main(String[] args) {
        try 
        {
            method1(); // call method1
        }
        catch(Exception exception) // catch exception thrown in method1
        {
            System.out.printf("%s\n", exception.getMessage());
            exception.printStackTrace(); // print exception stack trace
            
            // obtain the stack-trace information
            StackTraceElement[] traceElements = exception.getStackTrace();
            
            System.out.println("\nStack trace from getStackTrace:");
            System.out.println("Class\t\t\tFile\t\t\t\tLine\tMethod");
            
            // loop through traceElements to get exception description
            for (StackTraceElement element : traceElements) {
                String className = element.getClassName();
                className = className.substring(className.indexOf(".")+1);
                System.out.printf("%s\t", className);
                System.out.printf("%s\t", element.getFileName());
                System.out.printf("%s\t", element.getLineNumber());
                System.out.printf("%s\n", element.getMethodName());
            }
        }
    }

    // call method2; throw exceptions back to main
    private static void method1() throws Exception {
        method2(); /* (c) not enclose in try-catch, stack unwinding occurs one more time */
    }

    // call method3; throw exceptions back to method1
    private static void method2() throws Exception {
        method3(); /* (b) not enclose in try-catch, stack unwinding occurs again */
    }

    // throw exceptions back to method2
    private static void method3() throws Exception {
        throw new Exception("Exception thrown in method3"); /* this is the throw point */
        /* (a) b'coz the throw statement is not enclosed in a try block, 
        stack unwinding occurs--method3 terminates, then returns 
        control to the statement in method2 that invoked method3. */
    }

}
