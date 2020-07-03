package Ch03_Intro_to_Classes;

import java.util.Scanner;

/**
 * Modified Account class.
 * 3.14
 *
 * @author David
 */
public class Ex03_12_ModifiedAccount {

    public static void main(String[] args) {
        Account account1 = new Account(50.00); // create Account object

        // display nitial balance of each object
        System.out.printf("account1 balance $%.2f\n", account1.getBalance());

        // create Scanner to obtain input from commmand window
        Scanner input = new Scanner(System.in);
        double withdrawAmount; // withdraw amount read from user

        System.out.printf("Enter withdraw amount for account1: ");
        withdrawAmount = input.nextDouble(); // obtain user input
        System.out.printf("\nsubtracting %.2f from account1 balance\n\n", withdrawAmount);
        account1.debit(withdrawAmount); // subtract from account1 balance
        
        // display balances
        System.out.printf("account1 balance $%.2f\n", account1.getBalance());
        
    }
}
