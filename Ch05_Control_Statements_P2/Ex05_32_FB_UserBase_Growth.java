package Ch05_Control_Statements_P2;

/**
 * Facebook User Base Growth. According to CNNMoney.com, Facebook hit 500 million
 * users in July of 2010 and its user base has been growing at a rate of 5% per month. 
 * Using the compound-growth technique you learned in Fig. 5.6 and assuming this 
 * growth rate continues, how many months will it take for Facebook to grow its 
 * user base to one billion users? How many months will it take for Facebook to 
 * grow its user base to two billion users (which, at the time of this writing,
 * was the total number of people on the Internet)?
 * @author David
 */
public class Ex05_32_FB_UserBase_Growth {

    /**
     * See more of BDO US$ Time Deposit Rates.
     */
    public static void main(String[] args) {

        double totalUsers = 0.0; // total user base
        double userBase = 500_000_000.0; // 500M users in July 2010
        double growthRate = 0.05; // or 5% growth rate
        double compoundingRate;
        int month;

        // display headers
        System.out.printf("%s: %,.0f\n\n", "Compounding-Growth of Facebook\nUser base", userBase);
        System.out.printf("%5s%20s%20s\n", "Month", "User base", "Growth rate %");
        growthRate += 1.0; // i took it outside of the loop to perform much better

        // calculate total users on user base for each of ten years
        for (month = 1; month <= 12*10; ++month) {

            // calculate new amount for specified year
            compoundingRate = Math.pow(growthRate, month); // 1.0 + rate - JAVA optimizes my code using "constant folding"
            totalUsers = userBase * compoundingRate;   // C/C++ switch for optimization: -O1, -O2, -O3

            // display the month, the total users and the compounding rate
            System.out.printf("%5d%,20.0f%18.2f\n",
                    month, totalUsers, compoundingRate);
            
            if (totalUsers >= 1_000_000_000.0) {
                break;
            }
        }
        
        System.out.printf("\nAt %d months, Facebook hit %,.0f user base.\n", month, totalUsers);
    }

}
