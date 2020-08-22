package Ch10_OOP_Polymorphism;

/**
 * Fig. 10.15: Test interface Payable
 * @author David
 */
public class PayableInterfaceTest {

    public static void main(String[] args) {
        
        // create four-element Payable array
        Payable[] payableObjects = new Payable[] {
            
            // populate array with objects that implement Payable
            new Invoice("01234", "seat", 2, 375.00),
            new Invoice("56789", "tire", 4, 79.95), 
            new SalariedEmployee2("John", "Smith", "111-11-1111", 800.00),
            new SalariedEmployee2("Lisa", "Barnes", "888-88-8888", 1200.00)
        };
        
        System.out.println(
                "Invoices and Employees processed polymorphically:\n");
        
        // genericaly process each element in array payableObjects
        for (Payable currentPayable : payableObjects) {
            
            /* invoke the appropriate class’s implementation of methods 
            toString and getPaymentAmount. For instance, when currentPayable 
            refers to an Invoice during the first iteration of the for loop, 
            class Invoice’s toString and getPaymentAmount execute. */
            
            // output currentPayable and its appropriate payment amount
            System.out.printf("%s \n%s: $%,.2f\n\n",
                    currentPayable.toString(),
                    "payment due", currentPayable.getPaymentAmount()
            );            
        } // end for
    } // end main
    
} // end class PayableInterfaceTest
