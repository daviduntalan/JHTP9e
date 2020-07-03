package Ch04_Control_Statements_P1;

/**
 * Sides of a Triangle.
 * Factorial.
 *
 * @author David
 */
public class Ex04_33_37_TriangleSides {

    public static void main(String args[]) {
        int n = 2;
        while (n > 0) {
            System.out.printf("%,25d\n", n);
            n *= 2;
        }

        long x = 10;
        long y = 20;
        long z = 30;
        // System.out.println(++(x + y)); // increment op applies only to a variable.
        System.out.println("sum: " + 1 + (x + y));

        if (x == y && y == z) {
            System.out.println("sides of triangle.");
        }

        y = n = 20; // could handle upto 20 only
        x = 1;
        while (n > 1) {
            x *= n * (n - 1);
            --n; --n;
        }

        System.out.printf("f(%d)! = %,d\n", y, x);
    }
}
