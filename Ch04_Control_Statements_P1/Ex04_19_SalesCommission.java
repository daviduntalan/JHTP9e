package Ch04_Control_Statements_P1;

/**
 * Sales Commission Calculator. A large company pays its salespeople
 * on a commission basis. The salespeople receive $200 per week plus
 * 9% of their gross sales for that week. For example, a salesperson
 * who sells $5000 worth of merchandise (goods/products) in a week
 * receives $200 plus 9% of $5000, or a total of $650. You've been
 * supplied with a list of the items sold by each salesperson. 
 * The values of these items are as follows:
 * 
 *  Item    Value
 *  1       239.99
 *  2       129.75
 *  3        99.95
 *  4       350.89
 * 
 * Develop a Java app that inputs one salesperson's items sold for 
 * last week and calculates and displays that salesperson's earnings.
 * There's no limit to the number of items that can be sold.
 * 
 * @author David
 */
public class Ex04_19_SalesCommission {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Scanner input = new java.util.Scanner(System.in);
        
        double item1 = 239.99;
        double item2 = 129.75;
        double item3 =  99.95;
        double item4 = 350.89;
        double itemsSold = 0.0;
        int itemSold = 0;
        final int sentinelValue = 0;
        
        System.out.printf("Item\tValue\n");
        System.out.printf("1\t%6.2f\n", item1);
        System.out.printf("2\t%6.2f\n", item2);
        System.out.printf("3\t%6.2f\n", item3);
        System.out.printf("4\t%6.2f\n", item4);
        
        System.out.printf("%7.2f Enter salesperson's items sold (0 to stop): ", itemsSold); 
        itemSold = input.nextInt();
                
        while(itemSold != sentinelValue) {                        
                
            if (itemSold == 1) itemsSold += item1;            
            if (itemSold == 2) itemsSold += item2;            
            if (itemSold == 3) itemsSold += item3;            
            if (itemSold == 4) itemsSold += item4;                        
            
            System.out.printf("%7.2f Enter salesperson's items sold (0 to stop): ", itemsSold); 
            itemSold = input.nextInt();
        }
        
        double commission = 200.0;        
        commission += (itemsSold < 5000.0) ? 0.0 : itemsSold * 0.09;
        
        System.out.printf("Total items sold: %.2f\n", itemsSold);
        System.out.printf("Salesperson's earnings: %.2f\n", commission);
    }

}
