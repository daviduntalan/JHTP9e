package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;
import java.time.LocalDate;

/**
 * Payroll System Modification. Modify the payroll system of Figs.
 * 10.4-10.9 to include private instance variable birthDay in class
 * Employee. Add get methods to class Date. Assume that payroll is
 * processed once per month. Create an array of Employee variables
 * to store references to the various employee objects. In a loop,
 * calculate the payroll for each Employee (polymorphically), and
 * add a $100.00 bonus to the person's payroll amount if the current
 * month is the one in which the Employee's birthday occurs.
 * @author David
 */
public class Ex10_08_PayrollSystemModification {

    public static void main(String[] args) {
        
        // create subclass objects
        SalariedEmployee salariedEmployee = new SalariedEmployee(
                "John", "Smith", new Date(12, 26, 1980), "111-11-1111", 800.00);

        HourlyEmployee hourlyEmployee = new HourlyEmployee(
                "Karen", "Price", new Date(10, 24, 1985), "222-22-2222", 16.75, 40);
        
        CommissionEmployee commissionEmployee = new CommissionEmployee(
                "Sue", "Jones", new Date(8, 8, 1954), "333-33-3333", 10000, 0.06);

        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
                "Bob", "Lewis", new Date(1, 21, 1952), "444-44-4444", 5000, .04, 300);

        System.out.println("Employees processed individually:\n");

        System.out.printf("%s\n%s: $%,.2f\n\n", salariedEmployee, 
                "earned", salariedEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", hourlyEmployee, 
                "earned", hourlyEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", commissionEmployee, 
                "earned", commissionEmployee.earnings());
        System.out.printf("%s\n%s: $%,.2f\n\n", basePlusCommissionEmployee,
                "earned", basePlusCommissionEmployee.earnings());
        
        // create four-element Employee array
        Employee2[] employees = new Employee2[] {
            // initialize array with Employees
            salariedEmployee,           // is-an Employee
            hourlyEmployee,             // is-an Employee
            commissionEmployee,         // is-an Employee
            basePlusCommissionEmployee  // is-an Employee
        };
        /* 10.5.7 Summary of the Allowed Assignments... pg.418 (456 of 1535)
        PS. because the subclass can have additional subclass-
        only members, assigning a superclass reference to a 
        subclass variable is NOT ALLOWED unless, you cast it down
        to its sub-class type BEFORE assignment. For example: 

        Employee emp = salariedEmployee;
        // The following: superclass reference (emp) to subclass variable (se) is ...
        // SalariedEmployee se = emp; // ... NOT ALLOWED - because such 
        // an assignment would leave the sublcass members UNDEFINED for the superclass object.
        SalariedEmployee se = (SalariedEmployee) emp; // ALLOWED!        
        */        
        System.out.println("Employees processed polymorphically:\n");
        
        // generally process each element in array employees.
        // this is know as: dynamic binding or late binding.
        for (Employee2 currentEmployee : employees) {
            // implicity invokes method toString of the object to which
            // currentEmployee refers. As a result of dynamic binding,
            // Java decides which class's toString method to call at 
            // execution time rather than at compile time.
            System.out.println(currentEmployee); // - invokes toString
            // A superclass reference can be used to invoke only methods
            // of the superlass--the subclass method implementations
            // are invoked polymorphically.
            
            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {                
                // downcast Employee reference to 
                // BasePlusCommissionEmployee reference
                System.out.println("down-casting currentEmployee to BasePlus...");                
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;
                
                employee.setBaseSalary(1.10 * employee.getBaseSalary());
                
                System.out.printf("new base salary with 10%% increase is: $%,.2f\n",
                        employee.getBaseSalary());
            } // end if
            
            double earnings = currentEmployee.earnings(); // polymorphic here            
            int employeesBirthMonth = currentEmployee.getBirthDate().getMonth();
            int todaysMonth = LocalDate.now().getMonthValue();
            
            /* add a $100.00 bonus to the person's payroll amount if the current
            month is the one in which the Employee's birthday occurs. */
            if (todaysMonth == employeesBirthMonth) {                
                double bonus = 100.0;
                System.out.printf(
                        "Happy Birthday %s - we've added %.2f bonus to your earnings. Enjoy! ^_^\n", 
                        currentEmployee.getFirstName(), bonus);
                earnings = earnings + bonus;
            }
            
            System.out.printf("earned $%,.2f\n\n", earnings); 
        } // end for
        
        // get tyep name of each object in employees array
        for (int i = 0; i < employees.length; ++i) {
            System.out.printf("Employee %d is a %s\n",
                    i, employees[i].getClass().getSimpleName()
            );
        } // end for
    }
    
}
