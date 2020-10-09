package Ch10_OOP_Polymorphism;

public class MathAddition extends MathOperation {

    public MathAddition(double operandA, double operandB) {
        super(operandA, operandB);
    }

    @Override
    public char getOperator() {
        return '+';
    }

    @Override
    public double compute() {
        return getA() + getB();
    }

}
