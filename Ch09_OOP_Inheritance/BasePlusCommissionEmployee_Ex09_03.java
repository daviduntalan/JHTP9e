package Ch09_OOP_Inheritance;

/**
 * Fig. 9.11: BasePlusCommissionEmployee911 class inherits from 
 * CommissionEmployee910 
 * @author David
 */
public final class BasePlusCommissionEmployee_Ex09_03 {
    CommissionEmployee910 commissionEmployee;
    private double baseSalary; // base salary per week
    
    public BasePlusCommissionEmployee_Ex09_03(String first, String last, 
            String ssn, double sales, double rate, double salary) {        
        commissionEmployee = new CommissionEmployee910(first, last, ssn, sales, rate);
        setBaseSalary(salary); // validate and store base salary
    }
    
    public String getFirstName() { return commissionEmployee.getFirstName(); }
    public String getLastName() { return commissionEmployee.getLastName(); }
    public String getSocialSecurityNumber() { return commissionEmployee.getSocialSecurityNumber(); }
    public double getGrossSales() { return commissionEmployee.getGrossSales(); }
    public double getCommissionRate() { return commissionEmployee.getCommissionRate(); }
    
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
    
    public double earnings() {
        return getBaseSalary() + commissionEmployee.earnings();
    }
    
    // return String representation of BasePlusCommissionEmployee
    @Override // indicates that this method overrides a superclass method
    public String toString() {
        return String.format(
                "%s %s\n%s: %.2f",
                "base-salaried", commissionEmployee,
                "base salary", getBaseSalary()
        );
    } // end method toString
}
