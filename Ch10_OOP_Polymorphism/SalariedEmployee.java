package Ch10_OOP_Polymorphism;

/**
 * Fig. 10.5: SalariedEmployee concrete class extends abstract class Employee.
 *
 * @author David
 */
public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String ssn,
            double weeklySalary) {
        super(firstName, lastName, ssn); // pass to Employee constructor
        setWeeklySalary(weeklySalary); // validate and store slary
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary >= 0.0) {
            this.weeklySalary = weeklySalary;
        } else {
            throw new IllegalArgumentException(
                    "Weekly salary must be >= 0.0"
            );
        }
    }

    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %.2f",
                "salaried employee", super.toString(),
                "weekly salary", getWeeklySalary()
        );
    }
}
