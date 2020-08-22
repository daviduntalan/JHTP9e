package Ch11_ExceptionHandling;

/**
 * Rethrowing Exceptions. Write a program that illustrates rethrowing an
 * exception. Define methods someMethod and someMethod2. Method someMethod2
 * should initially throw an exception. Method someMethod should call
 * someMethod2, catch the exception and rethrow it. Call someMehod from 
 * method main, and catch the rethrown exception. Print the stack trace
 * of this exception.
 * @author David
 */
public class Ex11_21_RethrowingExceptions {

    public static void main(String[] args) {
        
        try {
            someMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception ex) {
            throw ex; // retrowing exception
        }
    }

    private static void someMethod2() throws Exception {
        throw new Exception("Initially thrown exception."); 
    }
    
}
