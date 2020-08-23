package student_assignments;

/**
 * Can you call a constructor form another constructor?
 * @author David
 */

class Triangle {

    public Triangle() {
        this("Hello");
    }
    
    public Triangle(String str) {
        System.out.printf("Constructor(%s)\n", str);        
    }
}
public class IQ24_CanConstructor_CallAnotherConstructor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Triangle();
    }
    
}
