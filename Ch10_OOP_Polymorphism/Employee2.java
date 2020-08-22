package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;

/**
 * Fig. 10.13: Employee abstract superclass that implements Payable.
 * 
 * When a class implements an interface, the same is-a relationship
 * provided by inheritance applies. Class Employee2 implements
 * Payable, so we can say that an Employee2 is-a Payable. In fact,
 * objects of any classes that extend Employee2 are also Payable objects.
 * SalariedEmployee2 objects, for instance, are Payable objects.
 * Objects of any subclasses of the class that implements the inter-
 * face can also be thought of as objects of the interface type.
 * Thus, just as we can assign the reference of a SalariedEmployee2
 * object to a superclass Employee2 variable, we can assign the 
 * reference of a SalariedEmployee2 object to an interface Payable
 * variable.
 * 
 * Employee2 = SalariedEmployee2;
 * Payable = SalariedEmployee2;
 * 
 * Invoice implements Payable, so an Invoice object also is-a Payable
 * object, and we can assign the reference of an Invoice object to a
 * Payable variable.
 * 
 * Payable = Invoice;
 * 
 * PS.
 * 
 * When a method parameter is declared with a superclass or interface type, 
 * the method processes the object received as an argument polymorphically.
 * 
 * Using a superclass reference, we can polymorphically invoke any method 
 * declared in the superclass and its superclasses (e.g., class Object). 
 * Using an interface reference, we can polymorphically invoke any method 
 * declared in the interface, its super-interfaces (one interface can 
 * extend another) and in class Object—a variable of an interface type must 
 * refer to an object to call methods, and all objects have the 
 * methods of class Object.
 * 
 * @author David
 */

@lombok.Getter
@lombok.Setter
public abstract class Employee2 implements Payable {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private Date birthDate;

    public Employee2(String firstName, String lastName, String socialSecurityNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setSocialSecurityNumber(socialSecurityNumber);
    }

    public Employee2(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setSocialSecurityNumber(socialSecurityNumber);
        setBirthDate(birthDate);
    }   

    @Override
    public String toString() {
        return String.format("%s %s\nsocial security number: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber());
    }        
    
    // abstract method overriden by concrete subclasses
    public abstract double earnings();

    /*
    NOTE: We do not implement Payable method getPaymentAmount here so
    this class must be declared abstract to avoid a compilation error.
    
    Recall that when a class implements an interface, it makes a 
    contract with the compiler sating either that the class will 
    implement EACH of the methods in the interface or that the class
    will be declared abstract. If the latter option is chosen, we
    do not need to declare the interface methods as abstract in the
    abstract class--they're already implicitly declared as such in
    the interface.
    
    Any concrete subclass of the abstract class must implement the 
    interface methods to fulfill the superclass's contract with the
    compiler. If the subclass does not do so, it too must be declared
    abstract. As we mentioned here in the NOTE:
    
    This class does not implement method getPaymentAmount, so the 
    class is declared abstract. Each direct Employee2 subclass
    inherits the superclass's contract to implement method getPayment-
    Amount and thus must implement this method to become a concrete
    class for which objects can be instantiated. 
    
    A class that extends one of Employee2's concrete subclases will 
    inherit an implementation of getPaymentAmount and thus will also
    be a concrete class.
    */
}
