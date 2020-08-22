package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;

/**
 * Accounts Payable System Modification. In this exercise, we modify
 * the accounts payable application of 10.11-10.15 to include the 
 * complete functionality of the payroll application of Figs. 10.4-
 * 10.9. The application should still process Two Invoice objects,
 * but now should process one object of each of the four Employee
 * subclasses. If the object currently being processed is a Base-
 * PlusCommissionEmployee, the application should increase the
 * BasePlusCommissionEmployee's base salary by 10%. Finally, the
 * application should output the payment amount for each object.
 * Complete the following steps to create the new application:
 * 
 * a.)  Modify classes HourlyEmployee (Fig. 10.6) and CommissionEmployee
 *      (Fig. 10.7) to place them in the Payable hierarchy as subclasses of 
 *      the version of Employee (Fig. 10.13) that implements Payable.
 *      [Hit: change the name of method earnings to to getPaymentAmount
 *      in each subclass so that the class satisfies its inherited contract
 *      with interface Payable.]
 * 
 * b.)  Modify class BasePlusCommissionEmployee (Fig. 10.8) such that it
 *      extends the version of class CommissionEmployee created in part(a).
 * 
 * c.)  Modify PayableInterfaceTest (Fig. 10.15) to polymorphically process
 *      two Invoices, one SalariedEmployee, one HourlyEmployee, one
 *      BasePlusCommissionEmployee. First output a String representation
 *      of each Payable object. Next, if an object is a BasePlus-
 *      CommissionEmployee, increase its base salary by 10%. Finally,
 *      output the payment amount for each Payable object.
 * 
 * @author David
 */
public class Ex10_11_AccountsPayableSystemModification {

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
