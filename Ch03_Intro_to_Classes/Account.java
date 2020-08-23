package Ch03_Intro_to_Classes;

/**
 * Account class with constructor to validate and 
 * initialize instance variable balance of type double.
 *
 * @author David
 */
public class Account {

    private double balance; // instance variable that stores the balance.

    public Account(double balance) {
        // vaidate that initialBalance is greater than 0.0;        
        if (balance > 0.0) {
            setBalance(balance);
        }
        // if it is not, balane is initialized to the default value 0.0
    }

    // credit (add) an amount to the balance
    public void credit(double amount) {
        // add amoun tto previous balance
        setBalance(getBalance() + amount);
    }

    // debit (subtract) an amount from balance
    public void debit(double amount) {
        if (amount >= 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
        } else if (amount > getBalance()) {
            System.err.println("Debit amount exceeded account balance.");
        } else {
            System.err.println("Debit amount is negative.");
        }
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
