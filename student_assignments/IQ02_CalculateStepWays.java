package student_assignments;

/**
 * Write a method to find the total number of combination to 
 * climb the staircase.
 * @author David
 */
public class IQ02_CalculateStepWays {

    public static void main(String[] args) {
        for (int n = 0; n < 10; ++n) {
            System.out.printf("fib of %d is %d\n", 
                    n, calculateStepWaysUp(n));
        }
    }

    private static int calculateStepWays(int n) {
        if (n <= 2) {
            return n;           
        }
        return calculateStepWays(n - 2) + calculateStepWays(n - 1);
    }
    
    // non-recursive way getting up, time complexity: O(n)
    private static int calculateStepWaysUp(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int nth = 3;
        
        for (int i = 3; i < n; ++i) {
            nth = first + second;
            first = second;
            second = nth;
        }
        
        return nth;
    }

}