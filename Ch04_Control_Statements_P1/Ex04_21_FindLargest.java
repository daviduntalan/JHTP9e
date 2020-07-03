package Ch04_Control_Statements_P1;

/**
 * Find the Largest Number.
 *
 * @author David
 */
public class Ex04_21_FindLargest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        int number = 0;
        int largest = 0;

        System.out.printf("Input a number (0 to stop): ");
        number = input.nextInt();

        while (number != 0) {
            
            if (number > largest) {
                largest = number;
            }

            System.out.printf("Input a number (0 to stop): ");
            number = input.nextInt();
        }

        System.out.printf("Largest number: %d\n", largest);
    }

}
