package Ch03_Intro_to_Classes;

import java.util.Scanner;

/**
 * Inputting and outputting floating-point numbers with Account objects. Fig.
 * 3.14
 *
 * @author David
 */
public class AccountTest {

    public static void main(String[] args) {
        Account account1 = new Account(50.00); // create Account object
        Account account2 = new Account(-7.53); // create Account object

        // display nitial balance of each object
        System.out.printf("account1 balance $%.2f\n", account1.getBalance());
        System.out.printf("account2 balance $%.2f\n", account2.getBalance());

        // create Scanner to obtain input from commmand window
        Scanner input = new Scanner(System.in);
        double depositAmount; // desposit amount read from user

        System.out.printf("Enter deposit amount for account1: ");
        depositAmount = input.nextDouble(); // obtain user input
        System.out.printf("\nadding %.2f to account1 balance\n\n", depositAmount);
        account1.credit(depositAmount); // add to account1 balance
        
        // display balances
        System.out.printf("account1 balance $%.2f\n", account1.getBalance());
        System.out.printf("account2 balance $%.2f\n", account2.getBalance());
        
        
        System.out.printf("\nEnter deposit amount for account2: ");
        depositAmount = input.nextDouble(); // obtain user input
        System.out.printf("\nadding %.2f to account2 balance\n\n", depositAmount);
        account2.credit(depositAmount); // add to account1 balance
        
        // display balances
        System.out.printf("account1 balance $%.2f\n", account1.getBalance());
        System.out.printf("account2 balance $%.2f\n", account2.getBalance());
        
    }
}
