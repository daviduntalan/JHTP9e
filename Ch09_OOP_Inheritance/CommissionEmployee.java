package Ch09_OOP_Inheritance;

/**
 * Fig. 9.4: CommissionEmployee class represents an employee paid a 
 * percentage of gross sales. 
 * Relationship: is-a or inheritance. 
 * Relationship: has-a or composition.
 * @author David
 */
public class CommissionEmployee extends Object {
    // protected class members are also visible to other classes 
    // in the same package.
    protected String firstName;
    protected String lastName;
    protected String socialSecurityNumber;
    protected double grossSales; // gross weekly sales
    protected double commissionRate; // commission percentage

    public CommissionEmployee(String first, String last, String ssn, double sales, double rate) {
        // implicit call to Object constructor occurs here
        /* We could validate the first and last names—perhaps to 
        ensure that they’re of a reasonable length. 
        Similarly, a social security number could be validated using 
        regular expressions to ensure that it contains nine digits, 
        with or without dashes (e.g., 123-45-6789 or 123456789). */
        firstName = first;
        lastName = last;
        socialSecurityNumber = ssn;
        setGrossSales(sales);
        setCommissionRate(rate);
    }

    public void setGrossSales(double sales) {
        if (sales >= 0.0) grossSales = sales;
        else throw new IllegalArgumentException(
                "Gross sales must be >= 0.0");
    }

    public void setCommissionRate(double rate) {
        if(rate > 0.0 && rate < 1.0) 
            commissionRate = rate;
        else throw new IllegalArgumentException(
                "Commission rate must be > 0.0 and < 1.0");
    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public void setLastName(String last) {
        lastName = last;
    }

    public void setSocialSecurityNumber(String ssn) {
        socialSecurityNumber = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }
    
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }
    
    @Override
    public String toString() {
        return String.format("commission employee: %s %s\n"
                + "social security number: %s\n"
                + "gross sales: %.2f\n"
                + "commission rate: %.2f",
                firstName, lastName, socialSecurityNumber, 
                grossSales, commissionRate);
    }
}