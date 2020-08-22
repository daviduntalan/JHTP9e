package Ch10_OOP_Polymorphism;

import Ch08_Classes_and_Objects.Date;

/**
 * Fig. 10.8: BasePlusCommissionEmployee class extends abstract class
 * CommissionEmployee.
 *
 * @author David
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary; // base salary per week

    public BasePlusCommissionEmployee(
            String firstName, String lastName, String socialSecurityNumber,
            double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        setBaseSalary(baseSalary); // validate and store base salary
    }
    
    /* constructor for exercise 10.8 Payroll System Modification */
    public BasePlusCommissionEmployee(
            String firstName, String lastName, Date birthDate, String socialSecurityNumber,
            double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, birthDate, socialSecurityNumber, grossSales, commissionRate);
        setBaseSalary(baseSalary); // validate and store base salary
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0.0) {
            this.baseSalary = baseSalary;
        } else {
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0");
        }
    }

    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }
    
    @Override
    public double getPaymentAmount() {        
        return earnings();
    }
    
    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f",
                "base-salaried", super.toString(),
                "base salary", getBaseSalary()
        );
    }
}
