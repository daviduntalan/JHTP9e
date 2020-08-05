package Ch09_OOP_Inheritance;

/**
 * Fig. 9.6: BasePlusCommissionEmployee class represents an employee
 * who receives a base salary in addition to commission.
 * @author David
 */
public class BasePlusCommissionEmployee96 {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage
    private double baseSalary; // base salary per week

    public BasePlusCommissionEmployee96(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
        // implicit call to Object constructor occurs here
        setFirstName(firstName);
        setLastName(lastName);
        setSocialSecurityNumber(socialSecurityNumber);
        setGrossSales(grossSales); // validate and store gross sales
        setCommissionRate(commissionRate); // validate and store commission rate
        setBaseSalary(baseSalary); // validate and store base salary
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double sales) {
        if (sales >= 0.0) {
            this.grossSales = sales;
        } else {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double rate) {
        if (rate > 0.0 && rate < 1.0) {
            commissionRate = rate;
        } else {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double salary) {
        if (salary >= 0.0) {
            baseSalary = salary;
        } else {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
    }
    
    public double earnings() {
        return getBaseSalary() + (getCommissionRate() * getGrossSales());
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
