package Ch09_OOP_Inheritance;

/**
 * Ex 9.3: Many programs written with inheritance could be written with 
 * composition instead, and vice versa. Rewrite class BasePlusCommissionEmployee 
 * (Fig. 9.11) of the CommissionEmployee–BasePlusCommissionEmployee 
 * hierarchy to use composition rather than inheritance.
 * @author David
 */
public class Ex09_03_Composition {

    public static void main(String[] args) {
        // instantiate BasePlusCommissionEmployee object
        BasePlusCommissionEmployee_Ex09_03 employee = 
                new BasePlusCommissionEmployee_Ex09_03("Bob", "Lewis", 
                        "333-33-3333", 5000, .04, 300);
        
        // get base-salaried commission employee data
        System.out.println("Employee information obtained by get methods:\n");
        System.out.printf("%s %s\n", "First name is", employee.getFirstName());
        System.out.printf("%s %s\n", "Last name is", employee.getLastName());
        System.out.printf("%s %s\n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f\n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f\n", "Commission rate is", employee.getCommissionRate());
        System.out.printf("%s %.2f\n", "Base salary is", employee.getBaseSalary());
        
        employee.setBaseSalary(1000); // set base salary
        
        System.out.printf("\n%s:\n\n%s\n", 
                "Updated employee information obtained by toString", 
                employee.toString());
    }
    
}
