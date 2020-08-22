package Ch10_OOP_Polymorphism;

/**
 * Fig. 10.11: Payable interface declaration.
 * Interface Payable contains public abstract method getPayableAmount().
 * The method is not explicitly declared public or abstract. Interface
 * methods are always public and abstract, so they do not need to be
 * declared as such. Interfaces may also contain fields that are 
 * implicitly final and static.
 * @author David
 */
public interface Payable {
    // int ID = 10; // -- usually candidate for enumeration
    double getPaymentAmount(); // calculate payment; no implementation
}
