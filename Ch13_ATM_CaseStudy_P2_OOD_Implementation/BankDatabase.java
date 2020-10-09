package Ch13_ATM_CaseStudy_P2_OOD_Implementation;

/**
 * Represents the bank account information database
 * @author David
 */
public class BankDatabase {

    private Account[] accounts; // array of Accounts

    public BankDatabase() {

        accounts = new Account[] { // just 2 accounts for testing
            new Account(1234, 4321, 1000.0, 1200.0),
            new Account(2222, 2222, 2000.0, 2200.0),
            new Account(3333, 3333, 3000.0, 3200.0),
            new Account(4321, 1234, 200.0, 200.0)
        };
    }

    // retrieve Account object containing specified account number
    private Account getAccount(int userAccountNumber) {

        // loop through accounts searching for matching account number
        for (Account currentAccount : accounts) {

            // return current account if match is found
            if(currentAccount.getAccountNumber() == userAccountNumber) {
                return currentAccount;
            }
        }

        return null; // if no matching account was found, return null
    }

    /**
     * @param userAccountNumber
     * @param userPIN
     * @return determine whether user-specified account number and PIN match
     * those of an account in the database.
     */
    public boolean authenticateUser(int userAccountNumber, int userPIN) {

        // attempt to retrieve the account with the account number
        Account userAccount = getAccount(userAccountNumber);

        // if account exists, return result of Account method validatePIN
        if (userAccount != null) {
            return userAccount.validatePIN(userPIN);
        }

        return false; // account number not found, so return false
    }

    public double getAvailableBalance(int userAccountNumber) {

        return getAccount(userAccountNumber).getAvailableBalance();
    }

    public double getTotalBalance(int userAccountNumber) {

        return getAccount(userAccountNumber).getTotalBalance();
    }

    // adds the deposit amount to the user's account balance
    public void credit(int userAccountNumber, double amount) {

        getAccount(userAccountNumber).credit(amount);
    }

    // subtracts the withdrawal amount from the user's account balance
    public void debit(int userAccountNumber, double amount) {

        getAccount(userAccountNumber).debit(amount);
    }
}