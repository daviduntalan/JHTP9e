package Ch06_Methods;

import java.util.Random;

/**
 * Write statements that assign random integers to the variable n 
 * in the following ranges:
 * @author David
 */
public class Ex06_12_RandomRanges {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        int n = 0;
        System.out.printf("Random 1 to 2: %d\n", 1 + random.nextInt(2));
        System.out.printf("Random 1 to 100: %d\n", 1 + random.nextInt(100));
        System.out.printf("Random 0 to 9: %d\n", random.nextInt(10));
        System.out.printf("Random 1000 to 1112: %d\n", 1000 + random.nextInt(112));
        System.out.printf("Random -1 to 1: %d\n", -1 + random.nextInt(3));
        System.out.printf("Random -3 to 11: %d\n", -3 + random.nextInt(15));
    }
    
}
