package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

public class Account {

    private int accountNumber;
    private int pin;
    private double availableBalance; /* tracks the amount of money that a user can withdraw from the account. */
    private double totalBalance; /* refers to the total amount of money that the user has "on deposit" (i.e., the amount of money available, plus the amount waiting to be verified or cleared). */

    public Account(int accountNumber, int pin, double availableBalance, double totalBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }

    /**
     * determines whether a user-specified PIN matches PIN in Account
     * @param userPIN
     * @return (pin == userPIN)
     */
    public boolean validatePIN(int userPIN) {
        return (pin == userPIN);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    /**
     * Recall that crediting funds to an Account increases the totalBalance but
     * NOT the availableBalance.
     * @param amount to be added to total balance.
     */
    public void credit(double amount) {
        totalBalance += amount;
    }

    public void debit(double amount) {
        availableBalance -= amount;
        totalBalance -= amount;
    }
}
