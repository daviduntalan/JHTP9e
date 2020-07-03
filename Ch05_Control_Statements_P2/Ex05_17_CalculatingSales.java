package Ch05_Control_Statements_P2;

import java.util.Scanner;

/**
 * Calculating Sales. An online retailer sells five products whose
 * retail prices are as follows:
 *  
 *      Product 1, $2.98;
 *      Product 2, $4.50;
 *      Product 3, $9.98;
 *      Product 4, $4.49;
 *      Product 5, $6.87;
 *
 * @author David
 */
public class Ex05_17_CalculatingSales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double product1 = 2.98;
        double product2 = 4.50;
        double product3 = 9.98;
        double product4 = 4.49;
        double product5 = 6.87;
        double retailPrice = 0.0;
        double totalRetailValue = 0.0;
        
        int productNumber;
        int quantitySold;
        
        System.out.println("Calculating Sales");
        System.out.printf("Product 1: $%.2f\n", product1);
        System.out.printf("Product 2: $%.2f\n", product2);
        System.out.printf("Product 3: $%.2f\n", product3);
        System.out.printf("Product 4: $%.2f\n", product4);
        System.out.printf("Product 5: $%.2f\n", product5);
        
        System.out.printf("Enter product number (0 to stop): ");
        productNumber = input.nextInt();
        
        System.out.printf("Enter quantity sold (0 to stop): ");
        quantitySold = input.nextInt();

        while (productNumber > 0 && quantitySold > 0) {
            
            switch (productNumber) {
                case 1: retailPrice = product1; break;
                case 2: retailPrice = product2; break;
                case 3: retailPrice = product3; break;
                case 4: retailPrice = product4; break;
                default:retailPrice = product5; break;
            }
            totalRetailValue += retailPrice * quantitySold;
            
            System.out.printf("Enter product number (0 to stop): ");
            productNumber = input.nextInt();

            System.out.printf("Enter quantity sold (0 to stop): ");
            quantitySold = input.nextInt();
        }
        
        if (totalRetailValue > 0.0) {            
            System.out.printf("\nTotal retail value: $%.2f\n", totalRetailValue);
        } else {
            System.err.println("\nNo inputs has been done.");
        }
    }

}
