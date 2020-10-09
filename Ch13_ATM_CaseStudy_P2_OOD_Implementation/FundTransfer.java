package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

/**
 * Polymorphism makes the system easily extensible.
 * Should we wish to create new transaction type (e.g., funds transfer or bill payment),
 * we would just create an additional Transaction subclass that overrides the execute()
 * method with a version of the method appropriate for executing the new transaction type.
 *
 * We would need to make ony minimal changes to the system code to allow users to choose
 * the new transaction type from the main menu and for the ATM to instantiate and execute
 * objects of the new subclass. The ATM could execute transactions of the new type using
 * the current code, because it executes all transactions polymorphically using a general
 * Transaction reference.
 */
public class FundTransfer extends Transaction {

    public FundTransfer(int accountNumber, Screen screen, BankDatabase bankDatabase) {
        super(accountNumber, screen, bankDatabase);
    }

    @Override
    public void execute() {

    }
}
