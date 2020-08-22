package Ch10_OOP_Polymorphism;

/**
 * Fig. 10.12: Invoice class that implements Payable.
 * Java does not allow subclasses to inherit from more than one 
 * superclass, but it allows a class to inherit from one superclass
 * and implement as many interfaces as it needs. To implement more
 * than one interface, use a comma-separated list of interface
 * names after keyword implements in the class declaration, as in:
 * 
 * public class ClassName extends SuperclassName
 *      implements FirstInterface, SecondInterface, ...
 * 
 * @author David
 */
public class Invoice implements Payable {

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String part, String description, int count, double price) {
        setPartNumber(part);
        setPartDescription(description);
        setQuantity(count); // validate and store quantity
        setPricePerItem(price); // validate and store price per item
    }        

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int count) {
        if (count >= 0) {
            quantity = count;
        } else {
            throw new IllegalArgumentException("Quantity must be >= 0");
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double price) {
        if (price >= 0.0) {
            pricePerItem = price;
        } else {
            throw new IllegalArgumentException("Price per item must be >= 0");
        }
    }        
    
    // method required to carry out contract with interface Payable.
    @Override
    public double getPaymentAmount() {
        
        return getQuantity() * getPricePerItem(); // calculate total cost
    }
            
    @Override
    public String toString() {
        
        return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
                "invoice", "part number", getPartNumber(), getPartDescription(),
                "quantity", getQuantity(), "price per item", getPricePerItem()
        );
    }
}
