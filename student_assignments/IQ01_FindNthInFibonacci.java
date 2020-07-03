package student_assignments;

/**
 * Find the nth in a Fibonacci.
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ01_FindNthInFibonacci {

    public static void main(String[] args) {
        for (int n = 1; n < 100; ++n) {
            System.out.printf("fibonacci of %d is %d\n",
                    n, fibForLoop(n));
        }

    }

    private static int fibRecursive(int n) {
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("no number below 1 or greater than 45.");
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibRecursive(n - 2) + fibRecursive(n - 1);
    }
    
    private static int fibForLoop(int n) {
        
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("no number below 1 or greater than 45.");
        }
        
        if (n == 1 || n == 2) {
            return 1;
        }
        
        int first = 1;
        int second = 1;
        int nth = 2;
        
        for (int i = 3; i <= n; ++i) {
            nth = first + second;
            first = second;
            second = nth;
        }
        
        return nth;
    }

}
