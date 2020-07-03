package Ch06_Methods;

/**
 *
 * @author David
 */
public class Ex06_14_Exponentiation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.util.Scanner input = new java.util.Scanner(System.in);
        int power, base, exponent;
        System.out.printf("Compute the exponential value of base^power\n");
        base = 3; exponent = 4;
        while (base != 0) {
            power = integerPower(base, exponent);
            if (power > 0) {
                System.out.printf("%d^%d is %,d\n", base, exponent, power);
            } else {
                System.err.println("Couldn't handle such huge result.");
            }

            System.out.printf("Enter value for base (0 to stop): ");
            base = input.nextInt();
            if (base == 0) break; // exit immediately!
            System.out.printf("Enter value for exponent: ");
            exponent = input.nextInt();
        }
    }

    private static int integerPower(int base, int exponent) {
        int power = 1;
        for (int i = 0; i < exponent; ++i) {
            power *= base;
        }
        return power;
    }

}
