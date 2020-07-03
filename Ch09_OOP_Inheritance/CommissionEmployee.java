package Ch09_OOP_Inheritance;

/**
 * Fig. 9.4: CommissionEmployee class represents an employee paid a 
 * percentage of gross sales.
 * @author David
 */
public class CommissionEmployee extends Object {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    public CommissionEmployee(String first, String last, String ssn, double sales, double rate) {
        // implicit call to Object constructor occurs here
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