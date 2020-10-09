package Ch10_OOP_Polymorphism;

public class TestArithmetic {

    public static void main(String[] args) {

        MathOperation[] mathOperations = new MathOperation[] {
            new MathAddition(10, 20),
            new MathSubtract(10, 20),
            new MathMultiply(20, 10),
            new MathDivide(10, 20)
        };

        for (MathOperation mathOperation: mathOperations) {
            System.out.printf("%.2f %c %.2f = %6.2f\n",
                mathOperation.getA(),
                mathOperation.getOperator(),
                mathOperation.getB(),
                mathOperation.compute()
            );
        } // end of for each
    } // end of main()
} // end of TestArithmetic
