package Ch06_Methods;

/**
 * Prime Numbers. A positive integer is prime if it’s divisible by only 1 and
 * itself. For example, 2, 3, 5 and 7 are prime, but 4, 6, 8 and 9 are not. The
 * number 1, by definition, is not prime.
 *
 * a) Write a method that determines whether a number is prime.
 *
 * b) Use this method in an application that determines and displays all the
 * prime numbers less than 10,000. How many numbers up to 10,000 do you have to
 * test to ensure that you’ve found all the primes?
 *
 * c) Initially, you might think that n/2 is the upper limit for which you must
 * test to see whether a number n is prime, but you need only go as high as the
 * square root of n. Rewrite the program, and run it both ways.
 *
 * @author David
 */
public class Ex06_25_PrimeNumbers {

    static int testCounts = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number = 0;
        while (number < 10) {
            System.out.printf("%d - ", number);
            if (isPrime(number)) {
                System.out.println("Yes! It's PRIME.");
            } else {
                System.out.println("No! It's NOT prime.");
            }
            ++number;
        }
        
        System.out.println("\nPrime numbers upto 10,000");
        int primeCounts = 0, counts = 0;
        for (int n = 0;  n < 10000; ++n) {
            if (isPrime(n)) {                
                System.out.printf("%5d", n);
                if(++counts % 10 == 0) {
                    System.out.println();
                    counts = 0;
                } 
                ++primeCounts;
            }
        }
        
        System.out.printf("\ntest counts: %,d", testCounts);
        System.out.printf("\nprime counts: %,d\n", primeCounts);
    }

    private static boolean isPrime(int number) {
        if (number > 1) {
            final int MAX = number; // 1,254 over 8,766,890
            // final int MAX = number / 2; // 1,923 over 5,864,484
            // final int MAX = (int) Math.sqrt(number); // 3,872 over 284,352
            for (int factor = 2; factor < MAX; ++factor) {                                
                ++testCounts;
                // if there's a factor then, it's NOT prime.
                if (number % factor == 0) {                   
                    return false;
                }                 
            }
            return true;
        } 
        return false;
    }
}
