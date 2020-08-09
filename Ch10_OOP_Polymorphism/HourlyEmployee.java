package Ch10_OOP_Polymorphism;

/**
 * Fig. 10.6: HourlyEmployee concrete class extends abstract class Employee.
 *
 * @author David
 */
public class HourlyEmployee extends Employee {

    private double hours;
    private double wage;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
            double hourlyWage, double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        setWage(hourlyWage); // validate hourly wage
        setHours(hoursWorked); // validate hours worked
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hoursWorked) {
        // hours between 0 and 168 (the total number of hours in a week)
        if ((hoursWorked >= 0.0) && (hoursWorked <= 168.0)) {
            hours = hoursWorked;
        } else {
            throw new IllegalArgumentException(
                    "Hours worked must be >= 0.0 and <= 168.0"
            );
        }
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double hourlyWage) {
        if (hourlyWage >= 0.0) {
            wage = hourlyWage;
        } else {
            throw new IllegalArgumentException(
                    "Hourly wage must be >= 0.0"
            );
        }
    }

    @Override
    public double earnings() {

        if (getHours() <= 40) { // no overtime
            return getWage() * getHours();
        } else { // with overtime
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: $%,.2f; %s: %,.2f",
                "hourly employee", super.toString(),
                "hourly wage", getWage(),
                "hours worked", getHours()
        );
    }
}
