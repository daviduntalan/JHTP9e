package Ch05_Control_Statements_P2;

/**
 * Summing integers with the for statement.
 * Fig. 5.5
 * @author David
 */
public class Sum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int total = 0; // initialize total
        
        // total even integers from 2 through 20
        for (int number = 2; number <= 20; number += 2) { 
            total += number;
            System.out.printf("%d ", number);
        }
        
        System.out.printf("Sum is %d\n", total);
    }
    
}