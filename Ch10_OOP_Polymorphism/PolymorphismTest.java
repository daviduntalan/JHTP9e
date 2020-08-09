package Ch10_OOP_Polymorphism;
import Ch09_OOP_Inheritance.CommissionEmployee910;
import Ch09_OOP_Inheritance.BasePlusCommissionEmployee911;
/**
 * Fig. 10.1: Assigning superclass and subclass references to 
 * superclass and subclass variables.
 * @author David
 */
public class PolymorphismTest {

    public static void main(String[] args) {
        
        // assign superclass reference to superclass variable
        CommissionEmployee910 commissionEmployee = new CommissionEmployee910(
                "Sue", "Jones", "222-22-2222", 10000, .06);
        
        // assign subclass reference to subclass variable
        BasePlusCommissionEmployee911 basePlusCommissionEmployee =
                new BasePlusCommissionEmployee911(
                "Bob", "Lewis", "333-33-3333", 5000, .04, 300);
        
        // invoke toString on superclass object using superclass variable
        System.out.printf("%s %s:\n\n%s\n\n",
                "Call CommissionEmployee910's toString with superclass reference",
                "to superclass object", commissionEmployee.toString());
        
        // invoke toString on subclass object using subclass varible
        System.out.printf("%s %s:\n\n%s\n\n",
                "Call BasePlusCommissionEmployee911's toString with subclass reference",
                "to subclass object", basePlusCommissionEmployee.toString());
        
        // invoke toString on subclass object using superclass variable
        CommissionEmployee910 commissionEmployee2 = basePlusCommissionEmployee; 
        System.out.printf("%s %s:\n\n%s\n\n",
                "Call BasePlusCommissionEmployee911's toString with superclass reference",
                "to subclass object", commissionEmployee2.toString()); 
        /* it overrides CommssionEmployee910's toString() method by BasePlusCommissionEmployee's toString() method.
        When a superclass variable contains a reference to a subclass object, and
        that reference is used to call a method, the subclass version of the method is called.
        The Java compiler allows this “crossover” because an object of a subclass 
        is an object of its superclass (but not vice versa). When the compiler encounters
        a method call made through a variable, the compiler determines if the method can be
        called by checking the variable’s class type. If that class contains the proper method declaration
        (or inherits one), the call is compiled. At execution time, the type of the object to
        which the variable refers determines the actual method to use. This process, called dynamic
        binding, is discussed in detail in Section 10.5. pg. 400. */
    }
    
}
