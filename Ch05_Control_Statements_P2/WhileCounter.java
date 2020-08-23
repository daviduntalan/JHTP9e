package Ch05_Control_Statements_P2;

/**
 * Counter-controlled repetition with the while repetition statement.
 * Fig. 5.1
 * @author David
 */
public class WhileCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int counter = 1; // declare and initialize control variable
        
        while (counter <= 10) { // loop-continuation condition
            System.out.printf("%d ", counter);
            ++counter; // increment control variable by 1
        }
        
        System.out.println(); // output a newline
    }
    
}
