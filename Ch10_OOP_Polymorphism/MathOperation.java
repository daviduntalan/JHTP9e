package Ch10_OOP_Polymorphism;

public abstract class MathOperation {

    private double a;
    private double b;

    public MathOperation(double operandA, double operandB) {
        a = operandA;
        b = operandB;
    }

    public double getA() { return a; }
    public double getB() { return b; }

    abstract char getOperator();
    abstract double compute();
}
