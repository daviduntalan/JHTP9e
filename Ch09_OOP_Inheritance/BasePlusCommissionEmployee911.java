package Ch09_OOP_Inheritance;

/**
 * Fig. 9.11: BasePlusCommissionEmployee911 class inherits from 
 * CommissionEmployee910 
 * @author David
 */
public final class BasePlusCommissionEmployee911 extends CommissionEmployee910 {
    private double baseSalary; // base salary per week
    
    public BasePlusCommissionEmployee911(String first, String last, 
            String ssn, double sales, double rate, double salary) {
        super(first, last, ssn, sales, rate); // superclass constructor call syntax
        setBaseSalary(salary); // validate and store base salary
    }
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double salary) {
        if (salary >= 0.0) {
            baseSalary = salary;
        } else {
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0");
        }
    }
    
    /* Methods earnings and toString override the corresponding 
    methods in class CommissionEmployee because their superclass 
    versions do not properly calculate a BasePlusCommissionEmployee’s 
    earnings or return an appropriate String representation */
    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }
    
    // return String representation of BasePlusCommissionEmployee
    @Override // indicates that this method overrides a superclass method
    public String toString() {
        return String.format(
                "%s %s\n%s: %.2f",
                "base-salaried", super.toString(),
                "base salary", getBaseSalary()
        );
    } // end method toString
}
