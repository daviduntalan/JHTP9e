package Ch07_Arrays_and_ArrayLists;

/**
 * Sales Commissions. Use a one-dimensional array to solve the following 
 * problem: A company pays its salespeople on a commission basis. The 
 * salespeople receive $200 per week plus 9% of their gross sales for 
 * that week. For example, a salesperson who grosses $5000 in sales in 
 * a week receives $200 plus 9% of $5000, or a total of $650. Write an 
 * application (using an array of counters) that determines how many 
 * of the salespeople earned salaries in each of the following ranges 
 * (assume that each salesperson’s salary is truncated to an integer 
 * amount):
 *  
 *      a) $200–299
 *      b) $300–399
 *      c) $400–499
 *      d) $500–599
 *      e) $600–699
 *      f) $700–799
 *      g) $800–899
 *      h) $900–999
 *      i) $1000 and over
 * 
 * Summarize the results in tabular format.
 * @author David
 */
public class Ex07_10_SalesCommissions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int NUMBER_OF_SALESPERSON = 20;
        double[] grossSales = new double[NUMBER_OF_SALESPERSON];
        double[] salesCommission = new double[NUMBER_OF_SALESPERSON];
        double[] earnedSalaries = new double[NUMBER_OF_SALESPERSON];
        java.util.Random random = new java.util.Random();
        double totalSales = 0.0;
        double totalCommissions = 0.0;
        double totalSalaries = 0.0;
        
        System.out.printf("%15s%15s%15s%15s\n", "TABLE SUMMARY #", "Gross Sales", "9% Commission", "Salaries");
        for (int i = 0; i < grossSales.length; ++i) {
            grossSales[i] = 200.0 + random.nextInt(10000-200);
            salesCommission[i] = grossSales[i] * 0.09;
            earnedSalaries[i] = 200.0 + salesCommission[i];            
            
            System.out.printf("Sales Person %2d%,15.2f%,15.2f%,15.2f\n", 
                    i+1, grossSales[i], salesCommission[i], earnedSalaries[i]);
            
            totalSales += grossSales[i] * 100;
            totalCommissions += salesCommission[i] * 100;
            totalSalaries += earnedSalaries[i] * 100;
        }
        System.out.printf("%-15s%,15.2f%,15.2f%,15.2f\n", "GRAND TOTAL",
                totalSales / 100, totalCommissions / 100, totalSalaries / 100);
        
        int[] frequency = new int[11]; // 0, 1, 2-10
        int asIndex = 0;
        
        for (int i = 0; i < earnedSalaries.length; ++i) {
            asIndex = (int)earnedSalaries[i]/100;
            if (asIndex > 10) asIndex = 10;
            ++frequency[ asIndex ];
        }
        
        System.out.printf("\n%s\n", "NUMBER OF SALESPEOPLE IN EACH OF THE FOLLOWING RANGES:");
        for (int count = 2; count < frequency.length; ++count) {
            if (count == 10) {
                System.out.printf(" %+,3d: ", count*100);
            } else {
                System.out.printf("%03d-%03d: ",
                    count*100, count*100 + 99);            
            }
            
            // print bar of asterisks
            for (int stars = 0; stars < frequency[count]; ++stars) {
                System.out.print("*");
            }
            
            // start a new line of output
            if (frequency[count] > 0) System.out.println("(" 
            + frequency[count] + ")"); else System.out.println();
        }
    }
    
}
