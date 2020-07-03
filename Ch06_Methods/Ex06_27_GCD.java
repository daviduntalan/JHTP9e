package Ch06_Methods;

/**
 * Greatest Common Divisor. The greatest common divisor (GCD) of two integers is
 * the largest integer that evenly divides each of the two numbers. Write a
 * method gcd that returns the greatest common divisor of two integers. [Hint:
 * You might want to use Euclid’s algorithm. You can find information about it
 * at en.wikipedia.org/wiki/Euclidean_algorithm.] Incorporate the method into an
 * application that reads two values from the user and displays the result.
 *
 * @author David
 */
public class Ex06_27_GCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Random random = new java.util.Random();

        for (int n = 0; n < 30; ++n) {
            final int n1 = 1 + random.nextInt(100);
            final int n2 = 1 + random.nextInt(100);
            int gcdResult = gcd(n1, n2);
            int lcmResult = lcm(n1, n2);
            System.out.printf("GCD of %d and %d is %d\n", n1, n2, gcdResult);
            System.out.printf("LCM of %d and %d is %d\n", n1, n2, lcmResult);
            System.out.println();
        }
    }

    private static int gcd(int n1, int n2) {
        if (n1 + n2 < 2) {
            return -1; // error-code returned
        }
        int gcd = 0; // stores here the gcd         
        // runs upto smalest number between n1 and n2.
        for (int factor = 1; factor <= n1 && factor <= n2; ++factor) {
            // test common factor between n1 & n2.
            if (n1 % factor == 0 && n2 % factor == 0) {
                gcd = factor; // replaces the previous answer.
            }
        }
        return gcd;
    }

    // lowest common multiple a.k.a. 
    // lcd or lowest common denominator
    // lcd = gcd(n1, n2);
    // numerator / lcd;
    // denominator / lcd;
    // see: Ex08_15_RationalNumbers.java
    private static int lcm(int a, int b) {
        return a*b / gcd(a, b);
    }

}