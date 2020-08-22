package Ch11_ExceptionHandling;

/**
 * Catching Exceptions With Superclass. 
 * Use inheritance to create an exception superclass (called ExceptionA) 
 * and exception subclasses ExceptionB and ExceptionC, where ExceptionB
 * inherits from ExceptionA and ExceptionC inherits from ExceptionB. 
 * Write a program to demonstrate that the catch block for type ExceptionA
 * catches exceptions of types ExceptionB and ExceptionC.
 *
 * @author David
 */
class ExceptionA extends Exception {

    public ExceptionA(String message) {
        super(message);
    }

    public ExceptionA(String message, Throwable cause) {
        super(message, cause);
    }        

}

class ExceptionB extends ExceptionA {

    public ExceptionB(String message) {
        super(message);
    }    

    public ExceptionB(String message, Throwable cause) {
        super(message, cause);
    }    

}

class ExceptionC extends ExceptionB {

    public ExceptionC(String message) {
        super(message);
    }

    public ExceptionC(String message, Throwable cause) {
        super(message, cause);
    }
    
    

}

public class Ex11_17_CatchingExceptionsWithSuperclass {

    public static void main(String[] args) {

        try {
            // throw new ExceptionC("Exception C");
            throw new ExceptionB("Exception B");            
        } catch (ExceptionA ex) {
            System.out.printf("caught: %s\n", ex.getMessage());
        } finally {
            System.out.println("done.");
        }
        
    }

}
