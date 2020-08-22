package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;

/**
 * Accounts Payable System Modification. It's possible to include
 * the functionality of the payroll application (Figs. 10.4-10.9) 
 * in the accounts payable application without modifying Employee
 * subclasses SalariedEmployee, HourlyEmployee, CommissionEmployee
 * or BasePluseCommissionEmployee. To do so, you can modify class
 * Employee (Fig. 10.4) to implement interface Payable and declared
 * method getPaymentAmount to invoke method earnings. Method get-
 * PaymentAmount would then be inherited by the subclasses in the
 * Employee hierarchy. When getPaymentAmount is called for a particular
 * subclass object, it will polymorphically invokes the appropriate 
 * earnings method for that subclass. Re-implement Exercise 10.11
 * using the original Employee hierarchy from the payroll application
 * of Figs. 10.4-10.9. Modify class Employee as described in this 
 * exercise, and do not modify any of class Employee's subclass.
 * 
 * PS. Advance pala ako mag isip. This is the exercise I've done from
 * Exercise 10.11. so this exercise is just a copy of that one.
 * 
 * @author David
 */
public class Ex10_12_AccountsPayableSystemModification {

    public static void main(String[] args) {
        
        // create four-element Payable array
        Payable[] payableObjects = new Payable[] {
            
            // populate array with objects that implement Payable
            new Invoice("01234", "seat", 2, 375.00),
            new Invoice("56789", "tire", 4, 79.95), 
            new SalariedEmployee2("John", "Smith", new Date(11, 1, 1975), "111-11-1111", 800.00),
            new HourlyEmployee("Lisa", "Barnes", new Date(12, 11, 1983), "888-88-8888", 30.00, 40),
            new CommissionEmployee("Alexandra", "Failana", new Date(8, 1, 1981), "333-33-3333", 5000.0, 0.2),
            new BasePlusCommissionEmployee("Lady Lou", "Recla", new Date(8, 12, 1982), "444-44-4444", 4500.00, 0.2, 800.0)
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
            System.out.printf("%s \n", currentPayable.toString());                                    
            
            if (currentPayable instanceof BasePlusCommissionEmployee) {
                // System.out.println("down-casting currentEmployee to BasePlus...");                
                BasePlusCommissionEmployee employee = 
                        (BasePlusCommissionEmployee) currentPayable;
                
                employee.setBaseSalary(1.10 * employee.getBaseSalary());
                
                System.out.printf("new base salary with 10%% increase is: $%,.2f\n",
                        employee.getBaseSalary());
            }
            
            System.out.printf("%s: $%,.2f\n\n",
                    "payment due", currentPayable.getPaymentAmount());
        } // end for
    } // end main
    
} // end class PayableInterfaceTest
