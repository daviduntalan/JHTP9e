package Ch04_Control_Statements_P1;

/**
 * Salary Calculator. determines the gross pay for each of three employees. The
 * company pays straight time for the first 40 hours worked by each employee and
 * time and a half for all hours worked in excess of 40. You're given a list of
 * the employees, their number of hours worked last week and their hourly rates.
 *
 * @author David
 */
public class Ex04_20_SalaryCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        double hourlyRate, weeklySalary, overTimePay, grossPay;
        int hoursWork, overTimeHour;

        int counter = 0;
        while (counter < 3) {

            System.out.printf("Enter employee(%d)'s hours work for one week: ",
                    ++counter); hoursWork = input.nextInt();
            System.out.printf("Enter employee(%d)'s hourly rate: ", counter);
            hourlyRate = input.nextDouble();

            if (hoursWork > 40) {
                weeklySalary = hourlyRate * 40; // typical salary
                overTimeHour = hoursWork - 40; // compute over time
                overTimePay = hourlyRate * 1.5 * overTimeHour; // 50% bonus
                grossPay = weeklySalary + overTimePay;                
                System.out.printf("weekly salary: %,10.2f (40 hours)\n", weeklySalary);
                System.out.printf("over time pay: %+,10.2f (%2d hours)\n", overTimePay, overTimeHour);
            } else {
                grossPay = hoursWork * hourlyRate;
            }

            System.out.printf("Gross pay /wk: %,10.2f\n\n", grossPay);
        }
    }

}
