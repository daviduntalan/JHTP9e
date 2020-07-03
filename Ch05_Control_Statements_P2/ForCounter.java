package Ch05_Control_Statements_P2;

/**
 * Counter-controlled repetition with the while repetition statement.
 * Fig. 5.2
 * @author David
 */
public class ForCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // for statement header includes initialization,
        // loop-continuation condition and increment
        for (int counter = 1; counter <= 10; ++counter) { 
            System.out.printf("%d ", counter);
        }
        
        System.out.println(); // output a newline
    }
    
}
