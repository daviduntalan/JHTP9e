package Ch05_Control_Statements_P2;

/**
 * Suppressing break statement exiting a for statement.
 * Fig. 5.12
 * @author David
 */
public class Ex05_26_AvoidUsingBreak  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int count; // control variable also used after loop terminates
    
        for (count = 1; count <= 10; ++count) {
            System.out.printf("%d ", count);
            if (count == 5) { // if count is 5,
                // break; terminate loop
                count = 10; // fail the condition. 
            }            
        }
        
        System.out.printf("\nBroke out of loop at count = %d\n", count);
    }
    
}
