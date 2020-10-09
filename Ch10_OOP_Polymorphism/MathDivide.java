package Ch10_OOP_Polymorphism;

public class MathDivide extends MathOperation {

    public MathDivide(double operandA, double operandB) {
        super(operandA, operandB);
    }

    @Override
    public char getOperator() {
        return '/';
    }

    @Override
    public double compute() {
        /* return operand A if operand B is zero--cannot divide by zero */
        if (getB() == 0) return getA();
        return getA() / getB();
    }
}
