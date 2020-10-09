package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

public class BalanceInquiry extends Transaction {

    public BalanceInquiry(int currentAccountNumber, Screen screen, BankDatabase bankDatabase) {
        super(currentAccountNumber, screen, bankDatabase);
    }

    @Override
    public void execute() {

        // get references to bank database and screen
        BankDatabase bankDatabase = getBankDatabase();
        int accountNumber = getAccountNumber();
        Screen screen = getScreen();

        double availableBalance = bankDatabase.getAvailableBalance( accountNumber );
        double totalBalance = bankDatabase.getTotalBalance( accountNumber );

        screen.displayMessageLine("\nBalance Information:");
        screen.displayMessage(" - Available balance: ");
        screen.displayDollarAmount(availableBalance);
        screen.displayMessage("\n - Total balance: ");
        screen.displayDollarAmount(totalBalance);
        screen.displayMessageLine("");
    }
}
