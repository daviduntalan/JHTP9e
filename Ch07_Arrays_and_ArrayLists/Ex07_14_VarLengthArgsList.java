package Ch07_Arrays_and_ArrayLists;

import java.util.Random;

/**
 * Calculates the product of a series of integers that are passed to method
 * product using a variable-length argument list. Test your method with several
 * calls, each with a different number of arguments.
 *
 * @author David
 */
public class Ex07_14_VarLengthArgsList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random random = new Random();
        final int LENGTH = 5 + random.nextInt(10-5);
        int[] series = new int[LENGTH];

        for (int i = 0; i < LENGTH; ++i) {
            series[i] = 1 + random.nextInt(10 - 1);
            System.out.printf("series[%d]: %d\n", i, series[i]);
        }
        System.out.printf("product of series: %,d\n", product(series));
        
        System.out.printf("product of 1 & 2: %,d\n", product(1, 2));
        System.out.printf("product of 1, 2 & 3: %,d\n", product(1, 2, 3));
        System.out.printf("product of 1, 2, 3 & 4: %,d\n", product(1, 2, 3, 4));
    }

    private static int product(int... series) {
        int product = 1;
        for (int number : series) {
            product *= number;
        }
        return product;
    }

}
