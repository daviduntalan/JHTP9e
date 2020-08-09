package Ch10_OOP_Polymorphism;

/**
 * Fig. 10.7: CommissionEmployee class extends abstract class Employee.
 *
 * @author David
 */
public class CommissionEmployee extends Employee {

    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
            double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate > 0.0 && commissionRate < 1.0) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");
        }
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales >= 0.0) {
            this.grossSales = grossSales;
        } else {
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");
        }
    }

    @Override
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: $%,.2f; %s: %.2f",
                "commission employee", super.toString(),
                "gross sales", getGrossSales(),
                "commission rate", getCommissionRate()
        );
    }
}
