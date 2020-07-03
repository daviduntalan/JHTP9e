package Ch05_Control_Statements_P2;

/**
 * Compound-interest calculations with for. 
 * Fig. 5.6
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
public class Interest {

    /**
     * See more of BDO US$ Time Deposit Rates.
     */
    public static void main(String[] args) {

        double amount; // amount on deposit at end of each year
        double principal = 100_000.0; // initial amount before interest
        double rate = 0.0500; // or 5% interest rate, should be final if you want optimization
        // double rate = 0.0375; // 1 month for $1,000-$9,999
        // double rate = 0.0875; // 6 months for $50,000-$99,999
        double compoundingInterest;

        // display headers
        System.out.printf("%s\n\n", "Compounding-Interest Calculation");
        System.out.printf("%s%20s%20s\n", "Year", "Amount on deposit", "Interest rate %");
        rate += 1.0; // i took it outside of the loop to perform much better

        // calculate amount on deposit for each of ten years
        for (int year = 1; year <= 10; ++year) {

            // calculate new amount for specified year
            compoundingInterest = Math.pow(rate, year); // 1.0 + rate - JAVA optimizes my code using "constant folding"
            amount = principal * compoundingInterest;   // C/C++ switch for optimization: -O1, -O2, -O3

            // display the year, the amount and the compounding interest
            System.out.printf("%4d%,20.2f%18.4f\n",
                    year, amount, compoundingInterest);
        }
        
        System.out.println("\nNow, would you wanted to invest in Time Deposit instead?");
    }

}
