package Ch09_OOP_Inheritance;

/**
 * Fig. 9.10: CommissionEmployee class uses method to 
 * manipulate its private instance variables.
 * @author David
 */
public class CommissionEmployee910 {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    public CommissionEmployee910(String first, String last, String ssn, double sales, double rate) {
        // implicit call to Object constructor occurs here
        /* We could validate the first and last names—perhaps to 
        ensure that they’re of a reasonable length. 
        Similarly, a social security number could be validated using 
        regular expressions to ensure that it contains nine digits, 
        with or without dashes (e.g., 123-45-6789 or 123456789). */
        setFirstName(first);
        setLastName(last);
        setSocialSecurityNumber(ssn);
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
        return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f",
                "commission employee", getFirstName(), getLastName(), 
                "social security number", getSocialSecurityNumber(), 
                "gross sales", getGrossSales(), 
                "commission rate", getCommissionRate()
        );
    }
}