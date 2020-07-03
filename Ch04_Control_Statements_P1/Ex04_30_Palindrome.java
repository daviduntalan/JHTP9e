package Ch04_Control_Statements_P1;

/**
 * Palindrome.
 *
 * @author David
 */
public class Ex04_30_Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        int number = 0, num = 0, n;
        int digitCount = 0;        
        
        while (digitCount != 5) {
            System.out.printf("Let me see if your 5 digits is palindrome: ");
            n = num = number = input.nextInt();
            digitCount = 0; // validate if it's 5 digits
            while (n != 0) {
                n /= 10; ++digitCount;
            }
        }
        
        int digit5 = number % 10; number /= 10;
        int digit4 = number % 10; number /= 10;
        int digit3 = number % 10; number /= 10;
        int digit2 = number % 10; number /= 10;
        int digit1 = number % 10; number /= 10;

        if (digit1 == digit5 && digit2 == digit4) {
            System.out.printf("\nYes your %d is a palindrome\n", num);
        } else {
            System.err.println("\nNo it's NOT palindrome.");
        }
        
    }

}
