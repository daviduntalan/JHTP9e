package Ch03_Intro_to_Classes;

/**
 * Invoice test.
 * @author David
 */
public class Ex03_13_InvoiceTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Invoice invoice = new Invoice();
        invoice.setPartNumber("P1234");
        invoice.setPartDescription("iPhone 4S");
        invoice.setItemQuantity(3);
        invoice.setItemPrice(25000);
        System.out.println(invoice);
    }
    
}
