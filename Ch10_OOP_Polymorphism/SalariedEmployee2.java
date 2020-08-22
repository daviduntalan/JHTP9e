package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;

/**
 * Fig. 10.14: SalariedEmployee2 extends Employee2, which implements Payable.
 * @author David
 */
public class SalariedEmployee2 extends Employee2 {

    private double weeklySalary;

    public SalariedEmployee2(String firstName, String lastName, String ssn,
            double weeklySalary) {
        super(firstName, lastName, ssn); // pass to Employee constructor
        setWeeklySalary(weeklySalary); // validate and store slary
    }
    
    public SalariedEmployee2(String firstName, String lastName, Date birthDate, String ssn,
            double weeklySalary) {
        super(firstName, lastName, ssn, birthDate); // pass to Employee constructor
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
    
    // Alternative to above code: earnings(). 
    // calculate earnings; implement interface Payable method that 
    // was abstract in superclass Employee2.
    @Override
    public double getPaymentAmount() {
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
