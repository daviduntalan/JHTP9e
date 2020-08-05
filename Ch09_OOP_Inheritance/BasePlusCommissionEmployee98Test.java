package Ch09_OOP_Inheritance;

/**
 * Fig. 9.7: BasePlusCommissionEmployee98 test program.
 * @author David
 */
public class BasePlusCommissionEmployee98Test {

    public static void main(String[] args) {
        // instantiate BasePlusCommissionEmployee object
        BasePlusCommissionEmployee98 employee = 
                new BasePlusCommissionEmployee98("Bob", "Lewis", 
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
