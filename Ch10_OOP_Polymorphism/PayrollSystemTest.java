package Ch10_OOP_Polymorphism;

/**
 * Fig. 10.9: Employee hierarchy test program.
 *
 * @author David
 */
public class PayrollSystemTest {

    public static void main(String[] args) {

        // create subclass objects
        SalariedEmployee salariedEmployee = new SalariedEmployee(
                "John", "Smith", "111-11-1111", 800.00);

        HourlyEmployee hourlyEmployee = new HourlyEmployee(
                "Karen", "Price", "222-22-2222", 16.75, 40);

        CommissionEmployee commissionEmployee = new CommissionEmployee(
                "Sue", "Jones", "333-33-3333", 10000, .06);

        BasePlusCommissionEmployee basePlusCommissionEmployee
                = new BasePlusCommissionEmployee(
                        "Bob", "Lewis", "444-44-4444", 5000, .04, 300);

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
        Employee[] employees = new Employee[] {
            // initialize array with Employees
            salariedEmployee,           // is-an Employee
            hourlyEmployee,             // is-an Employee
            commissionEmployee,         // is-an Employee
            basePlusCommissionEmployee  // is-an Employee
        };
        
        System.out.println("Employees processed polymorphically:\n");
        
        // generally process each element in array employees.
        // this is know as: dynamic binding or late binding.
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString
            
            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to 
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;
                
                employee.setBaseSalary(1.10 * employee.getBaseSalary());
                
                System.out.printf("new base salary with 10%% increase is: $%,.2f\n",
                        employee.getBaseSalary());
            } // end if
            
            System.out.printf("earned $%,.2f\n\n", 
                    currentEmployee.earnings()); // polymorphic here            
        } // end for
        
        // get tyep name of each object in employees array
        for (int i = 0; i < employees.length; ++i) {
            System.out.printf("Employee %d is a %s\n",
                    i, employees[i].getClass().getSimpleName()
            );
        } // end for
        
    } // end main()

} // end PayrollSystemTest
