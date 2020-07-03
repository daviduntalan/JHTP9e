package Ch08_Classes_and_Objects;

/**
 * Create a class SavingsAccount. Use a static variable annualInterestRate
 * to store the annual interest rate for all account holders. Each object
 * of the class contains a private instance variable savingsBalance
 * indicating the amount the saver currently has on deposit. Provide
 * method calculateMonthlyInterest to calculate the monthly interest by
 * multiplying the savingsBalance by annualIterestRate divided by 12
 * -- this interest should be added to savingsBalance. Provided a 
 * static method modifyInterestRate that sets the annualInterestRate to 
 * a new value. Write a program to test class SavingsAccount. Instantiate
 * two savingsAccount object, with balances of $2000.00 and $3000.00, 
 * respectively. Set annualInterestRate to 4%, then calculate the monthly
 * interest for each of 12 months and print the new balances for both savers.
 * 
 * @author David
 */
public class Ex08_06_SavingAccountClass {

    public static void main(String[] args) {                
                
        for (double rate = 0.04; rate <= 0.05; rate += 0.01) {
            for (double balance = 2000.0; balance <= 3000.0; balance += 1000.0) {
                SavingsAccount saver1 = new SavingsAccount(balance);
                // SavingsAccount saver2 = new SavingsAccount(3000.0);
                SavingsAccount.setAnnualInterestRate( rate );

                System.out.printf("Initial Savings Account at %d%% Interest Rate\n", 
                        (int)(SavingsAccount.getAnnualInterestRate() * 100.0));
                System.out.println(saver1);
                // System.out.println(saver2);

                for (int month = 0; month < 12; ++month) {
                    saver1.calculateMonthlyInterest();
                    // saver2.calculateMonthlyInterest();
                    System.out.printf("M%02d: new savings balance: %.2f\n", 
                            month + 1, saver1.getSavingsBalance());
                }

                System.out.println("Savings Account after 12 months:");
                System.out.println(saver1);
                // System.out.println(saver2);
                System.out.println("...");
            } // end for
        } // end for        
    } // end main
    
} // end of class

@lombok.Getter
@lombok.Setter
class SavingsAccount {
    
    private static double annualInterestRate;
    private double savingsBalance; // deposit goes here.

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double interestRate) {
        SavingsAccount.annualInterestRate = interestRate;
    }        

    public SavingsAccount(double newBalance) {
        setSavingsBalance(newBalance);
    }
    
    public void calculateMonthlyInterest() {
        setSavingsBalance(getSavingsBalance() + getSavingsBalance() * annualInterestRate / 12.0);        
    }
    
    public static void modifyInterestRate(double newRate) {
        setAnnualInterestRate(newRate);
    }

    @Override
    public String toString() {
        return String.format("SavingsAccount's balance: %.2f", getSavingsBalance());
    }        
}