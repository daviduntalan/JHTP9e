package Ch05_Control_Statements_P2;

/**
 * Factorial. Factorials are used frequently in probability problems. The
 * factorial of a positive integer n (written n! and pronounced "n factorial")
 * is equal to the product of the positive integers from 1 to n. Write an
 * application that calculates the factorials of 1 through 20. Use type long.
 * Display results in tabular format.
 *
 * @author David
 */
public class Ex05_13_Factorial {

    public static void main(String args[]) {
        int n;
        long nFact;
        long nFind;

        for (int i = 2; i < 21; ++i) {
            nFind = n = i; // could handle upto 20 only
            nFact = 1;
            while (n > 1) {
                nFact *= n * (n - 1);
                --n;
                --n;
            }
            System.out.printf("factorial(%2d)! %,025d\n", nFind, nFact);
        }
    }
}
