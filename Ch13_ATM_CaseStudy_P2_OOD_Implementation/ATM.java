package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

import Ch14_GUI_Components_P1.ATM_GUI_Version;

public class ATM {

    // constant corresponding to main menu options
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    private boolean userAuthenticated; // whether user is authenticated
    private int currentAccountNumber; // current user's account number
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private DepositSlot depositSlot; // ATM's deposit slot
    private BankDatabase bankDatabase; // account information database

    public ATM() {
        ATM_GUI_Version atmGui = new ATM_GUI_Version();
        userAuthenticated = false; // user is not authenticated to start
        currentAccountNumber = 0; // no current account number to start
        screen = new Screen(atmGui); // create screen
        keypad = new Keypad(atmGui); // create keypad
        cashDispenser = new CashDispenser(); // create cash dispenser
        depositSlot = new DepositSlot(atmGui); // create deposit slot
        bankDatabase = new BankDatabase(); // create acct info database
    }

    public void run() {
        // welcome and authenticate user; perform transactions
        while (true) {
            // loop while user is not yet authenticated
            while (!userAuthenticated) {
                screen.displayMessageLine("\nWelcome!");
                authenticateUser(); // authenticate user
            }
            performTransactions(); // user is now authenticated
            userAuthenticated = false; // reset before next ATM session
            currentAccountNumber = 0; // reset before next ATM session
            screen.displayMessageLine("Thank you! Goodbye!");
            screen.clearScreen();
        } // end while
    } // end method run

    // attempts to authenticate user against database
    private void authenticateUser() {
        screen.displayMessage("\nPlease enter your account number: ");
        int accountNumber = keypad.getInput(); // input account number
        screen.displayMessage("Enter your PIN: "); // prompt for PIN
        keypad.atmGui.hideInputPIN(true); // mask input PIN
        int pin = keypad.getInput(); // input PIN
        keypad.atmGui.hideInputPIN(false); // back to normal input

        // set userAuthenticated to boolean value returned by database
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

        // check whether authentication succeeded
        if (userAuthenticated)
            currentAccountNumber = accountNumber;
        else
            screen.displayMessageLine("Invalid account number or PIN. Please try again.");
    } // end of authenticateUser

    // display the main menu and perform transactions
    private void performTransactions() {
        // local variable to store transaction currently being processed
        Transaction currentTransaction = null;
        boolean userExited = false; // user has not chosen to exit

        // loop while user has not chosen option to exit system
        while (!userExited) {
            // show main menu and get user selection
            int mainMenuSelection = displayMainMenu();
            // decide how to proceed based on user's menu selection
            switch (mainMenuSelection) {
                // user chose to perform one of 3 transaction types
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    // initialize as new object of chosen type
                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute(); // execute transaction
                    break;
                case EXIT:
                    // user chose to terminate session
                    screen.displayMessageLine("\nExiting the system...\n");
                    userExited = true; // this ATM session should end
                    break;
                default: // user did not enter an integer from 1-4
                    screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
            } // end switch
        } // end while
    } // end method performTransactions

    private int displayMainMenu() {
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Exit\n");
        screen.displayMessage("Enter a choice: ");
        return keypad.getInput(); // return user's selection
    }

    private Transaction createTransaction(int mainMenuSelection) {

        Transaction temp = null; // temporary Transaction variable

        // determine which type of Transaction to create
        switch (mainMenuSelection) {

            case BALANCE_INQUIRY:
                temp = new BalanceInquiry( currentAccountNumber, screen, bankDatabase );
                break;

            case WITHDRAWAL:
                temp = new Withdrawal( currentAccountNumber, screen, bankDatabase, keypad, cashDispenser );
                break;

            case DEPOSIT:
                temp = new Deposit( currentAccountNumber, screen, bankDatabase, keypad, depositSlot );
                break;
        } // end switch

        return temp; // return the newly created [transaction] object
    } // end method createTransaction
}