package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

public class Withdrawal extends Transaction {

    private final static int CANCELED = 6;

    // private int accountNumber; // account to withdraw funds from
    private int amount; // amount to withdraw

    // references to associated objects
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser

    public Withdrawal(int currentAccountNumber, Screen screen, BankDatabase bankDatabase,
                      Keypad keypad, CashDispenser cashDispenser) {
        super(currentAccountNumber, screen, bankDatabase);
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {

        boolean cashDispensed;
        // double availableBalance; // amount available for withdrawal

        // get references to bank database and screen
        // BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        // loop until cash is dispensed or the user cancels
        do {
            cashDispensed = false; // cash was not dispensed yet
            // obtain a chosen withdrawal amount or CANCELED from the user
            amount = displayMenuOfAmounts();

            // check whether user chose a withdrawal amount or canceled
            if (amount != CANCELED) {
                cashDispensed = processCashDispensing(cashDispensed, screen);
            } else {
                // user chose cancel menu option
                screen.displayMessageLine("\nCancelling transaction...");
                return; // return to main menu because user canceled it.
            }
        } while (!cashDispensed); // end while
    } // end method execute()

    private boolean processCashDispensing(boolean cashDispensed, Screen screen) {
        // get available balance of account involved
        double availableBalance = getBankDatabase().getAvailableBalance(getAccountNumber());

        // check whether the user has enough money in the account
        if (amount <= availableBalance) {
            // check whether the cash dispenser has enough money
            if (cashDispenser.isSufficientCashAvailable(amount)) {
                // update the account involved to reflect the withdrawal
                getBankDatabase().debit(getAccountNumber(), amount); // interact with db to debit amount from user's account
                cashDispenser.dispenseCash(amount);

                // instruct user to take cash
                screen.displayMessageLine(
                        "\nYour cash has been dispensed. " +
                        "Please take your cash now.");

                cashDispensed = screen.isCashRemoved(); // cash was dispensed, initially false
            } else {
                screen.displayMessageLine(
                        "\nInsufficient cash available in the ATM. " +
                        "\n\nPlease choose a smaller amount.");
            } // end else
        } else {
            screen.displayMessageLine(
                    "\nInsufficient funds in your account. " +
                    "\n\nPlease choose a smaller amount.");
        } // end else
        return cashDispensed;
    } // end of method processCashDispensing

    /**
     * @return the value of amounts at index input or CANCELED
     */
    private int displayMenuOfAmounts() {

        int userChoice = 0; // local variable to store return value
        Screen screen = getScreen(); // get screen reference

        // array of amounts to correspond to menu numbers
        int[] amounts = {0, 20, 40, 60, 100, 200};

        // loop while no valid choice has been made
        while (userChoice == 0) {

            screen.displayMessageLine("\nWithdrawal Menu:");
            screen.displayMessageLine("1 - $20");
            screen.displayMessageLine("2 - $40");
            screen.displayMessageLine("3 - $60");
            screen.displayMessageLine("4 - $100");
            screen.displayMessageLine("5 - $200");
            // for (int n = 1; n < amounts.length; ++n) screen.displayMessageLine(n + " - $" + amounts[n]);
            screen.displayMessageLine("6 - Cancel transaction");
            screen.displayMessage("\nChoose a withdrawal amount: ");
            int input = keypad.getInput();

            // determine how to proceed based on the input value
            switch (input) {
                case 1: // if the user chose a withdrawal amount
                case 2: // (i.e., chose option 1, 2, 3, 4 or 5),
                case 3: // return the corresponding amount from
                case 4: // amounts array.
                case 5: // sets to the value of the element in amounts at index input;
                    userChoice = amounts[input]; // save user's choice
                    break;
                case CANCELED: // the user chose to cancel;
                    userChoice = CANCELED; // save user's choice
                    break;
                default:
                    screen.displayMessageLine(
                        "\nInvalid selection. Try again." );
            } // end switch
        } // end while

        return userChoice; // the value of amounts or CANCELED
    }
}
