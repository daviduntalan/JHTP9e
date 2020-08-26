package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

/**
 *
 * @author David
 */
public class Account {

    private int accountNumber;
    private int pin;
    private double availableBalance; /* tracks the amount of money that a user can withdraw from the account. */
    private double totalBalance; /* refers to the total amount of money that the user has "on deposit" (i.e., the amount of money available, plus the amount waiting to be verified or cleared). */

    public boolean validatePIN() {
        return false;
    }

    public double getAvailableBalance() {
        return 0.0;
    }

    public double getTotalBalance() {
        return 0.0;
    }

    public void credit() {
    }

    public void debit() {
    }
}
