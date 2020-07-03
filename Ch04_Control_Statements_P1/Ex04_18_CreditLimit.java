package Ch04_Control_Statements_P1;

/**
 * Credit Limit Calculator. Determines whether any of several
 * department-store customers has exceeded the credit limit on a 
 * charge account. For each customer, the following facts are
 * available:
 * 
 *  a) account number
 *  b) balance at the beginning of the month
 *  c) total of all items charged by the customer this month
 *  d) total of all credits applied to the customer's account this month
 *  e) allowed credit limit
 * 
 * The program should input all these facts as integers, calculate
 * the new balance (= beginning balance + charges - credits), 
 * display the new balance and determine whether the new balance
 * exceeds the customer's credit limit. For those customers whose
 * credit limit is exceeded, the program should display the
 * message "Credit limit exceeded".
 * 
 * @author David
 */
public class Ex04_18_CreditLimit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner input = new java.util.Scanner(System.in);
        int accountNumber = 0;
        int beginningBalance = 0;
        int charges = 0;
        int credits = 0;
        int creditLimit = 0;
        
        System.out.printf("Enter account number: ");
        accountNumber = input.nextInt();
        
        System.out.printf("Enter beginning balance: ");
        beginningBalance = input.nextInt();
        
        System.out.printf("Enter items charged by the customer: ");
        charges = input.nextInt();
        
        System.out.printf("Enter credits applied to customer: ");
        credits = input.nextInt();
        
        System.out.printf("Enter allowed credit limit: ");
        creditLimit = input.nextInt();
        
        int newBalance = beginningBalance + charges - credits;
        
        System.out.printf("\nThe new balance: %d for account#: %d\n", 
                newBalance, accountNumber);
        
        if (newBalance > creditLimit) {
            System.out.println("Credit limit exceeded.");
        }
    }

}
