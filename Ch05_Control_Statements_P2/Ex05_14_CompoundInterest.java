package Ch05_Control_Statements_P2;

/**
 * Compound-interest calculations with for. 
 * Fig. 5.14
 * 
 * A person invest $1000 in a savings account yielding 5% interest.
 * Assuming that all the interest is left on deposit, calculate and 
 * print the amount of money in the account at the end of each year
 * for 10 years. Use the following formula to determine the amounts
 * 
 *                   n
 *      a = p (1 + r)
 * 
 * where
 *      p is the original amount invested (i.e., the principal)
 *      r is the annual interest rate (e.g., use 0.05 for 5%)
 *      n is the number of years
 *      a is the amount on deposit at the end of the nth year.
 * 
 * @author David
 */
public class Ex05_14_CompoundInterest {

    /**
     * See more of BDO US$ Time Deposit Rates.
     */
    public static void main(String[] args) {

        double amount; // amount on deposit at end of each year
        double principal = 100_000.0; // initial amount before interest
        double compoundingInterest;

        // display headers
        System.out.printf("%s\n\n", "Compounding-Interest Calculation");
        
        for (double rate = 0.05; rate <= 0.10; rate += 0.01) {
            System.out.printf("%s%20s%20s\n", "Year", "Amount on deposit", "Interest rate %");

            // calculate amount on deposit for each of ten years
            for (int year = 1; year <= 10; ++year) {

                // calculate new amount for specified year
                compoundingInterest = Math.pow(1.0 + rate, year); // 1.0 + rate - JAVA optimizes my code using "constant folding"
                amount = principal * compoundingInterest;   // C/C++ switch for optimization: -O1, -O2, -O3

                // display the year, the amount and the compounding interest
                System.out.printf("%4d%,20.2f%18.4f\n",
                        year, amount, compoundingInterest);
            }
            System.out.println();
        }
        System.out.println("\nNow, would you wanted to invest in Time Deposit instead?");
    }

}
