package Ch06_Methods;

import java.util.Scanner;

/**
 * Parking Charges. A parking garage charges a $2.00 minimum fee to park for up
 * to three hours. The garage charges an additional $0.50 per hour or part
 * thereof in excess of three hours. The maximum charge for any given 24-hour
 * period is $10.00. Assume that no car parks for longer than 24 hours at a
 * time. Write an application that calculates and displays the parking charges
 * for each customer who parked in the garage yesterday. You should enter the
 * hours parked for each customer. The program should display the charge for the
 * current customer and should calculate and display the running total of
 * yesterday's receipts. It should use the method calculateCharges to determine
 * the charge for each customer.
 *
 * NOTE: We multiply charges by 100 to compute it accurately and avoid round off
 * and divide it by 100 to turn it back and display it correctly in terms of
 * money! Modulo don't work with doubles -- it's for integers only.
 *
 * @author David
 */
public class Ex06_08_ParkingCharges {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double hoursParked, charge, totalCharges = 0.0;
        int totalMins, hours, minutes;
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter the hours parked (0 to stop): ");
        hoursParked = input.nextDouble();

        while (hoursParked > 0.0) {
            // multiplied by 100 to make precise calculation accurate!
            totalCharges += charge = calculateCharges(hoursParked) * 100;
            
            totalMins = (int) (hoursParked * 60);
            hours = totalMins / 60;
            minutes = totalMins - (hours * 60);

            System.out.printf("Charge for the current customer: $%.2f for %02d:%02d hh:mm\n",
                    charge / 100, hours, minutes);

            System.out.printf("Enter the hours parked (0 to stop): ");
            hoursParked = input.nextDouble();
        }

        if (totalCharges > 0.0) {
            System.out.printf("The running total of yesterday's receipts is $%.2f\n", totalCharges / 100);
        }

        System.out.println("Thank you.");
    }

    private static double calculateCharges(double hoursParked) {
        final double garageCharges = 2.0; // $2.00 for 3 hours parked
        double additionalCharges = 0.5; // additional $0.50 for every hour beyond 3
        if (hoursParked > 0 && hoursParked <= 3.0) {
            return garageCharges;
        } else if (hoursParked > 3.0 && hoursParked < 24.0) {
            additionalCharges = Math.ceil(hoursParked - 3.0) * additionalCharges;
            return garageCharges + additionalCharges;
        } // 24 hours and beyond. Assume that no car parks for longer than 24 hours 
        else {
            return 10.0;
        }
    }
}
