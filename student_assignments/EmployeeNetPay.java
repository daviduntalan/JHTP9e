package student_assignments;

public class EmployeeNetPay {

    public static void main(String[] args) {

        float grossPay = 25000f;
        float witholdingTax = grossPay * .15f;
        float sssContribution = grossPay * .0363f;
        float medicare = grossPay * .0125f;
        float pagIbig = 100f;

        float deductions = witholdingTax + sssContribution + medicare + pagIbig;
        float netPay = grossPay - deductions;

        String employeeName = "Jess Diaz";

        System.out.printf("%-22s %s\n", "Employee Name:", employeeName);
        System.out.printf("%-22s P%,8.1f\n", "Gross Pay:", grossPay);
        System.out.printf("--------------------------------\n");
        System.out.printf("%-22s %s\n", "Deductions", "Amount");
        System.out.printf("%-22s P%,8.1f\n", "Witholding Tax:", witholdingTax);
        System.out.printf("%-22s P%,8.1f\n", "SSS Contribution:", sssContribution);
        System.out.printf("%-22s P%,8.1f\n", "Medicare:", medicare);
        System.out.printf("%-22s P%,8.1f\n", "Pag-ibig Contribution:", pagIbig);
        System.out.printf("--------------------------------\n");
        System.out.printf("%-22s P%,8.1f\n", "Net Pay:", netPay);
    }
}
