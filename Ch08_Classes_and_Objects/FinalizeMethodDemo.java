package Ch08_Classes_and_Objects;

/**
 * The finalize method s called by the GC to perform termination
 * housekeeping on an object just before the GC reclaims the object's
 * memory. Method finalize does not take parameters and has return 
 * type void. A problem with method finalize is that the GC is not
 * guaranteed to execute at a specified time. In fact, the GC may
 * never execute before a program terminates. Thus, it's unclear 
 * whether, or when, method finalize will be called. For this reason,
 * most programmers should avoid method finalize.
 * @author David
 */
public class FinalizeMethodDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Date bday = new Date(11, 26, 1980);
        System.out.println(bday);
        
        Employee emp = new Employee("david, jr.", "untalan", bday, new Date(11, 28, 2001));
        
        // wala i can't find finalize method within objects.
    }
    
}
