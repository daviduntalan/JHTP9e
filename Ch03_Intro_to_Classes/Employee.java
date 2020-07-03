package Ch03_Intro_to_Classes;

/**
 *
 * @author David
 */
@lombok.Setter
@lombok.Getter
@lombok.NoArgsConstructor
public class Employee {

    private String firstName;
    private String lastName;
    private double moSalary;

    public Employee(String firstName, String lastName, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setMoSalary(salary);
    }
            
    public void setMoSalary(double monthlySalary) {
        if (monthlySalary < 0) return;
        moSalary = monthlySalary;
    }
    
    public void setRaise() {
        double raise = 1.10;
        setMoSalary(getMoSalary() * raise);
    }

    @Override
    public String toString() {
        return String.format(""
            + "\nF Name:\t%s"
            + "\nL Name:\t%s"
            + "\nSalary:\t%,.2f"
            + "\nYearly:\t%,.2f",
            getFirstName(),
            getLastName(),
            getMoSalary(),
            getMoSalary() * 12
        );
    }        
    
}
