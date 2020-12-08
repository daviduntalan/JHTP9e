package student_assignments;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator2 {

    public static void main(String[] args) {

        System.out.println("Welcome to the Mortgage Calculator Extraordinaire!");

        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte period = (byte) readNumber("Period in years: ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    private static double readNumber(String prompt, double min, double max) {

        Scanner scan = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scan.nextDouble();
            if (value >= min && value <= max) break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(int principal,
                                           float annualInterest,
                                           byte period) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (period * MONTHS_IN_YEAR);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
}
