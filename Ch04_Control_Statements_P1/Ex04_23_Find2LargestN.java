package Ch04_Control_Statements_P1;

/**
 * Find the Two Largest Number.
 *
 * @author David
 */
public class Ex04_23_Find2LargestN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        int number = 0;
        int largest = 0;
        int secondLargest = 0;
        int sentinelValue = 0; // guard value

        System.out.printf("Input a number (0 to stop): ");
        number = input.nextInt();

        while (number != sentinelValue) {
                        
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            }
            if (number > secondLargest && number < largest) {
                secondLargest = number;
            }

            System.out.printf("Input a number (0 to stop): ");
            number = input.nextInt();
        }

        System.out.printf("Largest number: %d\n", largest);
        System.out.printf("2nd Largest number: %d\n", secondLargest);
    }

}
