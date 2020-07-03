package Ch05_Control_Statements_P2;

/**
 * Suppressing continue statement terminating an iteration of a for statement.
 * Fig. 5.13
 * @author David
 */
public class Ex05_28_AvoidUsingContinue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int count; // control variable also used after loop terminates
    
        for (count = 1; count <= 10; ++count) {
            if (count == 5) { // if count is 5,
                // continue; // skip remaining code in loop
                ++count; // another way to skip
            }
            System.out.printf("%d ", count);
        }
        
        System.out.println("\nUsed continue to skip printing 5");
    }
    
}

/*
For all but the most performance-intensive situations, apply the following rule of thumb:
First, make your code simple and correct; thenmake it fast and small, but only if necessary.
*/
