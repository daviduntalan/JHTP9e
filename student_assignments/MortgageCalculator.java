package student_assignments;

import jdk.swing.interop.SwingInterOpUtils;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;
    private static final int MINIMUM_PRINCIPAL = 1_000;
    private static final int MAXIMUM_PRINCIPAL = 1_000_000;
    private static final byte MINIMUM_YEARS = 1;
    private static final byte MAXIMUM_YEARS = 30;
    private static final float MINIMUM_INTEREST = 1.0F;
    private static final float MAXIMUM_INTEREST = 10.0F;
    private static final boolean YES = true;
    private static final boolean NO = false;

    public static void main(String[] args) {

        final int income = 120_000;
        boolean hasHighIncome = (income > 100_000);
        boolean hasGoodCredit = YES;
        boolean hasCriminalRecord = NO;
        String className = hasHighIncome ? "First" : "Economy";
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;

        if (isEligible) {
            calculateMortgage();
        } else {
            System.err.println("Sorry, we can't allow you for loans.");
        }
    }

    private static void calculateMortgage() {

        Scanner scanner = new Scanner(System.in);
        int principal = 0;
        float annualInterest = 0F;
        byte years = 0;

        while (true) {
            System.out.print("Principal ($1K - $1M): "); principal = scanner.nextInt();
            if (principal >= MINIMUM_PRINCIPAL && principal <= MAXIMUM_PRINCIPAL) break;
            System.out.printf("Enter a principal between %,d and %,d.\n",
                    MINIMUM_PRINCIPAL, MAXIMUM_PRINCIPAL);
        }

        while (true) {
            System.out.print("Annual Interest: "); annualInterest = scanner.nextFloat();
            if (annualInterest >= MINIMUM_INTEREST && annualInterest <= MAXIMUM_INTEREST) break;
            System.out.printf("Enter annual interest > %.2f and < %.2f.\n",
                    MINIMUM_INTEREST, MAXIMUM_INTEREST);
        }

        while (true) {
            System.out.print("Period (Years): "); years = scanner.nextByte();
            if (years >= MINIMUM_YEARS && years <= MAXIMUM_YEARS) break;
            System.out.printf("Enter a year between %d and %d.\n",
                    MINIMUM_YEARS, MAXIMUM_YEARS);
        }

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) * monthlyInterest)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage per month: " + mortgageFormatted);
    }

}
