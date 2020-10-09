package Ch10_OOP_Polymorphism;

import java.util.Scanner;

public class BasicArithmetic {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final int EXIT = 5;
        int selectedOperation;
        do {
            System.out.println("Compute Math Arithmetic");
            selectedOperation = getSelectedOperation();

            if (selectedOperation == EXIT) {
                System.out.println("Good bye.");
                break; /* stops this do-while loop */
            } else if (selectedOperation < 1 || selectedOperation > 4) {
                System.err.println("Invalid selection.");
                continue; /* by passes the following or restart the process */
            }

            System.out.printf("Enter your 1st operand: ");
            int a = scanner.nextInt();

            System.out.printf("Enter your 2nd operand: ");
            int b = scanner.nextInt();

            switch (selectedOperation) {
                case 1: addNumbers(a, b); break;
                case 2: subtractNumbers(a, b); break;
                case 3: multiplyNumbers(a, b); break;
                case 4: divideNumbers(a, b); break;
            }
            System.out.println();
            System.out.println();
        } while (selectedOperation != EXIT);
    }

    private static int getSelectedOperation() {

        System.out.println("What to do with your operands?");
        System.out.println("Press 1 to Add");
        System.out.println("Press 2 to Subtract");
        System.out.println("Press 3 to Multiply");
        System.out.println("Press 4 to Divide");
        System.out.println("Press 5 to Exit.");
        System.out.print("Select your operation: ");
        int selectedOperation = scanner.nextInt();
        return selectedOperation;
    }

    private static void addNumbers(int a, int b) {
        System.out.printf("Add two operands: %d + %d = ", a, b);
        int sum = a + b;
        System.out.printf("Sum: %d", sum);
    }

    private static void subtractNumbers(int a, int b) {
        System.out.printf("Subtract two operands: %d - %d = ", a, b);
        int difference = a - b;
        System.out.printf("Difference: %d", difference);
    }

    private static void multiplyNumbers(int a, int b) {
        System.out.printf("Multiply two operands: %d * %d = ", a, b);
        int product = a * b;
        System.out.printf("Product: %d", product);
    }

    private static void divideNumbers(int a, int b) {
        System.out.printf("Divide two operands: %d / %d = ", a, b);
        if (b == 0) {
            System.err.println("Error: Cannot divide by zero.");
        }
        else {
            double quotient = (double) a / (double) b;
            System.out.printf("Quotient: %.2f", quotient);
        }
    }
} // end of class BasicArithmetic