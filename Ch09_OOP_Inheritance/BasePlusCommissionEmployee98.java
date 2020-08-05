package Ch09_OOP_Inheritance;

/**
 * Fig. 9.8: BasePlusCommissionEmployee 
 * private superclass members cannot be accessed in a subclass.
 * @author David
 */
public final class BasePlusCommissionEmployee98 extends CommissionEmployee {
    private double baseSalary; // base salary per week

    public BasePlusCommissionEmployee98(String first, String last, String ssn, double sales, double rate, double salary) {
        // Each subclass constructor must implicitly or explicitly call its 
        // superclass constructor to initialize the instance variables 
        // inherited from the superclass.
        // The CommissionEmployee constructor is NOT inherited. So
        // explicit call to superclass CommissionEmployee constructor occurs 
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
                "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f",
                "base-salaried commission employee", firstName, lastName,
                "social security number", socialSecurityNumber,
                "gross sales", grossSales, "commission rate", commissionRate,
                "base salary", baseSalary
        );
    } // end method toString
}
