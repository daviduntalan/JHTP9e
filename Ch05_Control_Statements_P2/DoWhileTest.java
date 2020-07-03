
package Ch05_Control_Statements_P2;

/**
 * do-while repetition statement.
 * Fig. 5.7
 * @author David
 */
public class DoWhileTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int counter = 1; // innitialize counter
        
        do {
            System.out.printf("%d ", counter);
            ++counter;
        } while (counter <= 10); // end do-while
        
        System.out.println(); // outputs a new line
    }
    
}
