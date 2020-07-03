package Ch03_Intro_to_Classes;

/**
 *
 * @author David
 */
@lombok.Setter
@lombok.Getter
@lombok.NoArgsConstructor
public class Invoice {

    private String partNumber;
    private String partDescription;
    private int itemQuantity;
    private double itemPrice;

    public Invoice(String partNumber, String partDescription, int itemQuantity, double itemPrice) {
        setPartNumber(partNumber);
        setPartDescription(partDescription);
        setItemQuantity(itemQuantity);
        setItemPrice(itemPrice);
    }

    public double getInvoiceAmount() {
        if (getItemQuantity() < 0) return 0.0;        
        if (getItemPrice() < 0) return 0.0;
        return getItemQuantity() * getItemPrice();
    }

    @Override
    public String toString() {
        return String.format(""
            + "\nPart No:\t%s"
            + "\nDescription:\t%s"
            + "\nPrice:\t\t%,.2f"
            + "\nQuantity:\t%d pc(s)"
            + "\nInvoice:\t%,.2f", 
            getPartNumber(), 
            getPartDescription(), 
            getItemPrice(), 
            getItemQuantity(), 
            getInvoiceAmount()
        );
    }
    
    
}
