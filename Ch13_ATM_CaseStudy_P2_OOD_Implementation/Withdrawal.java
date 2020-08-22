package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

/**
 *
 * @author David
 */
public class Withdrawal extends Transaction {
    
    // attributes
    private int accountNumber; // account to withdraw funds from
    private double amount; // amount to withdraw
    
    // references to associated objects
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private BankDatabase bankDatabase; // account info database

    // no-argument constructor
    public Withdrawal() {
    }        
    
    @Override
    public void execute() {
        
    }
}
