package Ch07_Arrays_and_ArrayLists;

import java.util.Random;

/**
 * Use a two-dimensional array to solve the following problem: A company has
 * four salespeople (1 to 4) who sell five different products (1 to 5). Once a
 * day, each salesperson passes in a slip for each type of product sold. Each
 * slip contains the following: a) The salesperson number b) The product number
 * c) The total dollar value of that product sold that day Thus, each
 * salesperson passes in between 0 and 5 sales slips per day. Assume that the
 * information from all the slips for last month is available. Write an
 * application that will read all this info for last month's sales and summarize
 * the total sales by salesperson and by product. All totals should be stored in
 * the two-dimensional array sales. After processing all the information for
 * last month, display the results in tabular format, with each column
 * representing a salesperson and each row representing a particular product.
 * Cross-total each row to get the total sales of each product for last month.
 * Cross-total each column to get the total sales by salesperson for last month.
 * Your output should include these cross-totals to the right of the totaled
 * rows and to the bottom of the totaled columns.
 *
 * @author David
 */
public class Ex07_20_TotalSales {

    public static void main(String[] args) {

        int salespersonNumber = 0;
        String[] salespeople = new String[]{ // 0-3, 4
            "David, Jr",
            "Lady Lou",
            "Alexandra",
            "Salamona",
            "TOTAL"
        };        
        
        String[] productNames = new String[]{ // 0-5
            "",
            "C24/7",
            "C.PE",
            "RestorLyf",
            "Choleduz",
            "Vida"
        };        
        int productNumber = 0;
        double[] products = new double[]{ // 0-5
            0.0,
            1320.0, // C24/7 
            1250.0, // CPE
            1700.0, // RestorLyf
            880.0, // Choleduz
            1900.0 // Vida
        };        

        int salesSlipPerDay = 0;
        double totalProductSold = 0.0;
        double[][] sales = new double[products.length][salespeople.length]; // total sales
        double grandTotalByPerson = 0.0;
        double grandTotalByProduct = 0.0;
        Random random = new Random();

        System.out.println("Computing Last month sales...");        
        for (salespersonNumber = 0; salespersonNumber < salespeople.length-1; ++salespersonNumber) {
            System.out.printf("%s sold on:\n", salespeople[salespersonNumber]);
            totalProductSold = 0.0;
            for (int day = 0; day < 31; ++day) {                
                salesSlipPerDay = random.nextInt(6); // 0-5
                // if (salesSlipPerDay > 0) {
                    System.out.printf("Day %2d a product called ", 1+day);
                    productNumber = random.nextInt(6); // 0-5                    
                    totalProductSold += products[productNumber];
                    // if (productNumber > 0)
                    System.out.printf("%-9s that cost Php%,7.0f\n", 
                            productNames[productNumber], 
                            products[productNumber]);
                //}                   
                sales[productNumber][salespersonNumber] = totalProductSold;                
            }
            System.out.println();
        }

        // print header names
        System.out.println("Summary of total sales by salesperson and by product:\n");
        System.out.printf("%-10s", "SALES by:");
        for (int i = 0; i < salespeople.length; ++i) 
            System.out.printf("%10s", salespeople[i]);        
        System.out.println();
        
        // cross-total by product
        for (int idxProduct = 1; idxProduct < products.length; ++idxProduct) {
            System.out.printf("%-10s", productNames[idxProduct]);
            double crossTotalProduct = 0.0;
            for (int idxPerson = 0; idxPerson < salespeople.length-1; ++idxPerson) {
                System.out.printf("%,10.0f", sales[idxProduct][idxPerson]);
                crossTotalProduct += sales[idxProduct][idxPerson];
            }
            System.out.printf("%,10.0f\n", crossTotalProduct);
            grandTotalByProduct += crossTotalProduct;
        }
        
        // cross-total by person
        System.out.printf("%-10s", "TOTAL:"); 
        for (int idxPerson = 0; idxPerson < salespeople.length-1; ++idxPerson) {
            double crossTotalPerson = 0.0;
            for (int idxProduct = 1; idxProduct < products.length; ++idxProduct) {
                crossTotalPerson += sales[idxProduct][idxPerson];
            }
            System.out.printf("%,10.0f", crossTotalPerson);
            grandTotalByPerson += crossTotalPerson;
        }
        
        // validate if they are equal to each other before printing
        if (grandTotalByProduct == grandTotalByPerson) {
            System.out.printf("%,10.0f\n", grandTotalByPerson);
        }
    }

}
