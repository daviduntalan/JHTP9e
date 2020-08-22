package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

/**
 *
 * @author David
 */
abstract class Transaction {
    private int accountNumber;
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public abstract void execute();
}
