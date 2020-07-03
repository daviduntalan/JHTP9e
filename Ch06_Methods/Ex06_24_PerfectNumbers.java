package Ch06_Methods;

/**
 * Perfect Numbers. An integer number is said to be a perfect number if its
 * factors, including 1 (but not the number itself), sum to the number. For
 * example, 6 is a perfect number, because 6 = 1 + 2 + 3. Write a method
 * isPerfect that determines if parameter number is a perfect number. Use this
 * method in an application that displays all the perfect numbers between 1 and
 * 1000. Display the factors of each perfect number to confirm that the number
 * is indeed perfect. Challenge the computing power of your computer by testing
 * numbers much larger than 1000. Display the results.
 *
 * @author David
 */
public class Ex06_24_PerfectNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.printf("Enter a number to check if it's perfect or not (0 to stop): ");
        int number = input.nextInt();
        while (number > 0) {

            if (isPerfect(number)) {
                System.out.println("Yes! it's perfect number.");
                for (int sum = 0, n = 1; sum != number; ++n) {
                    System.out.printf("%d + ", n);
                    sum += n;
                }
                System.out.println("\b\b\b.");
            } else {
                System.err.println("No! it's NOT perfect number.");
            }

            System.out.printf("Enter a number to check if it's perfect or not (0 to stop): ");
            number = input.nextInt();
        }

        System.out.println("Tapos na po!");
    }

    private static boolean isPerfect(int number) {
        boolean isPerfect = false;
        for (int sum = 0, n = 1; n > 0 && n <= number; ++n) {
            if ((sum += n) == number) {
                isPerfect = true;
                n = number; // break the loop
            }
            // System.out.println(n + ". " + sum);
        }
        return isPerfect;
    }

}
