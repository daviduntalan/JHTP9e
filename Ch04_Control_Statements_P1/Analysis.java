package Ch04_Control_Statements_P1;

import java.util.Scanner;

/**
 * Analysis of examination results using nested control statements.
 * Fig. 4.12
 *
 * @author David
 */
public class Analysis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int passes = 0;
        int failures = 0;
        int studentCounter = 1;
        int result;
        
        while (studentCounter <= 10) {
            System.out.printf("Enter result (1 = pass, 2 = fail): ");
            result = input.nextInt();
            
            if (result == 1) {
                passes = passes + 1;
            } else {
                failures = failures + 1;
            }
            
            ++studentCounter;
        }
        
        System.out.printf("Passed: %d\nFailed: %d\n", passes, failures);
        
        if (passes > 8) {
            System.out.println("Bonus to instructor!");
        }
    }
}
