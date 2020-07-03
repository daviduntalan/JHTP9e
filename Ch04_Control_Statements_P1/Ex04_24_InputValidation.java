package Ch04_Control_Statements_P1;

/**
 * Validating User Input. For any input, if the value entered is
 * other than 1 or 2, keep looping until the user enters a correct value.
 *
 * @author David
 */
public class Ex04_24_InputValidation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        
        int value = 0;
        while (value != 1 && value != 2) {
                        
            System.out.printf("Input a value (1 or 2 to stop): ");
            value = input.nextInt();
        }

        System.out.printf("Last entered value: %d\n", value);
    }

}
