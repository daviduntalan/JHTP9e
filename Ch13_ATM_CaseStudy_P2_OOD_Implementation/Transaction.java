package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

public abstract class Transaction {

    private int accountNumber; // indicates account involved
    private Screen screen; // ATM's screen
    private BankDatabase bankDatabase; // account info database

    // constructor invoked by subclasses using super()
    public Transaction(int accountNumber, Screen screen, BankDatabase bankDatabase) {
        setAccountNumber(accountNumber);
        setScreen(screen);
        setBankDatabase(bankDatabase);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    private void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // return reference to screen
    public Screen getScreen() {
        return screen;
    }
    private void setScreen(Screen screen) {
        this.screen = screen;
    }

    // return reference to bank database
    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }
    private void setBankDatabase(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }

    /**
     * it doesn't make sense to provide this method's implementation,
     * because a generic transaction cannot be executed. So, we declare
     * this method abstract and force each Transaction subclass to
     * provide a concrete implementation that executes that particular
     * type of transaction.
     */
    public abstract void execute(); // to be implemented by its subclasses
}
