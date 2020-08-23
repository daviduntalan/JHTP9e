package Ch03_Intro_to_Classes;
public class Invoice {

    private String partNumber;
    private String partDescription;
    private int itemQuantity;
    private double itemPrice;

    public Invoice() { }
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

    public String getPartNumber() { return partNumber; }
    public String getPartDescription() { return partDescription; }
    public int getItemQuantity() { return itemQuantity; }
    public double getItemPrice() { return itemPrice; }

    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public void setPartDescription(String partDescription) { this.partDescription = partDescription; }
    public void setItemQuantity(int itemQuantity) { this.itemQuantity = itemQuantity; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }

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
