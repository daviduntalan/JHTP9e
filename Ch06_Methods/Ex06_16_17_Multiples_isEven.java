package Ch06_Methods;

/**
 * Write a method isMultiple that determines, for a pair of integers, whether
 * the second integer is a multiple of the first. The method should take two
 * integer arguments and return true if the second is a multiple of the first
 * and false otherwise. [Hint: Use the remain der operator.] Incorporate this
 * method into an application that in puts a series of pairs of integers (one
 * pair at a time) and determines whether the second value in each pair is a
 * multiple of the first. @author David
 */
public class Ex06_16_17_Multiples_isEven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Random random = new java.util.Random();

        int x, y;

        for (int i = 0; i < 30; ++i) {
            x = 1 + random.nextInt(99);
            y = 1 + random.nextInt(10);
            System.out.printf("%2d - %4s  ", x, isEven(x) ? "Even" : "Odd");
            System.out.printf("%2d - %4s\t", y, isEven(y) ? "Even" : "Odd");
            if (isMultiple(x, y)) {
                System.out.printf("%2d is a MULTIPLE of %d\n", x, y);
            } else {
                System.out.printf("%2d is NOT a multiple of %d\n", x, y);
            }
        }

        System.out.println("Tapos na po!");
    }

    private static boolean isMultiple(int x, int y) {
        return x % y == 0;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

}
