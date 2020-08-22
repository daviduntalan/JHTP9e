package Ch11_ExceptionHandling;

import java.io.IOException;

/**
 * Catching Exceptions Using Class Exception. Write a program that demonstrates
 * how various exceptions are caught with
 *
 * catch ( Exception exception )
 *
 * This time, define classes ExceptionA (which inherits from class Exception)
 * and ExceptionB (which inherits from class ExceptionA). In your program,
 * create try blocks that throw exceptions of types ExceptionA, ExceptionB,
 * NullPointerException and IOException. All exceptions should be caught with
 * catch blocks specifying type Exception.
 *
 * @author David
 */
public class Ex11_18_CatchingExceptionsUsingClassException {

    public static void main(String[] args) {

        try {
            method1();
        } catch (ExceptionA | IOException | NullPointerException ex) {
            // System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void method1() throws IOException, ExceptionB, NullPointerException, ExceptionA {
        try {
            method2();
        } catch (IOException | NullPointerException | ExceptionB ex) {
            throw new ExceptionA("Exception A", ex);
        }
    }

    private static void method2() throws IOException, NullPointerException, ExceptionB {
        try {
            method3();
        } catch (IOException | NullPointerException ex) {
            throw new ExceptionB("Exception B", ex);
        }
    }

    private static void method3() throws IOException, NullPointerException {
        try {
            method4();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new NullPointerException("NullPointerException");
        }
    }

    private static void method4() throws IOException {
        throw new IOException("IOException");
    }

}
