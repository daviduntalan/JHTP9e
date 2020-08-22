package Ch11_ExceptionHandling;

/**
 * Constructor Failure. Write a program that shows a constructor passing 
 * information about constructor failure to an exception handler. Define 
 * class SomeClass, which throws an Exception in the constructor. Your 
 * program should try to create an object of type SomeClass and catch 
 * the exception that’s thrown from the constructor.
 * @author David
 */

class SomeClass {

    private String name; 
    
    public SomeClass() throws Exception {
        name = "SomeClass";
        throw new Exception("Constructor failure.");
    }
    
    public void print() {
        System.out.println(name);
    }
}
public class Ex11_20_ConstructorFailure {

    public static void main(String[] args) {
        
        try {
            SomeClass someClass = new SomeClass();
            someClass.print();
        } catch (Exception ex) {
            System.out.printf("%s\n", ex.getMessage());
        }
    }
    
}
