package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

public class Deposit extends Transaction {

    private final static int CANCELED = 0; // constant for cancel option

    // private int accountNumber; // declared in Transaction
    private double amount; // amount to deposit

    // references to associated objects
    private Keypad keypad; // ATM's keypad
    private DepositSlot depositSlot; // ATM's deposit slot

    public Deposit(int currentAccountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, DepositSlot depositSlot) {
        super(currentAccountNumber, screen, bankDatabase);
        this.keypad = keypad;
        this.depositSlot = depositSlot;
    }

    @Override
    public void execute() {

        // get references to bank database and screen
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        amount = promptForDepositAmount(); // get deposit from user

        // check whether user entered a deposit amount or canceled
        if (amount != CANCELED) {

            // request deposit envelope containing specified amount
            screen.displayMessage("Please insert a deposit envelope (within 5s) containing ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine(".");

            // attempt to receive deposit envelope
            if (depositSlot.isEnvelopeReceived()) {
                screen.displayMessageLine("\nYour envelope has been received.\n" +
                        "NOTE: The money just deposited will not be available " +
                        "until we verify the amount of any enclosed cash and " +
                        "your checks clear (for clearance).");
                // credit account to reflect the deposit
                bankDatabase.credit(getAccountNumber(), amount);
            } else {
                screen.displayMessageLine("\nYou did not insert an envelope, " +
                        "so the ATM has canceled your transaction.");
            } // end else
        } else { // end if
            screen.displayMessageLine("\nCancelling transaction...");
        } // end else
    } // end method execute()

    private double promptForDepositAmount() {

        Screen screen = getScreen(); // get reference to screen

        screen.displayMessage("\nPlease enter a deposit amount in CENTS (or Zero (0) to cancel): ");
        int input = keypad.getInput(); // receive input of deposit amount

        // check whether the user canceled or entered a valid amount
        if (input == CANCELED) return CANCELED;
        return (double) input / 100.0; // return dollar amount
    }
}
