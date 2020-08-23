package Ch08_Classes_and_Objects;

/**
 * Rational Numbers. Create a class called Rational for performing 
 * arithmetic with fractions. Write a program to test your class. 
 * Use integer variables to represent the private instance variables 
 * of the class--the numerator and the denominator. Provide a 
 * constructor that enables an object of this class to be initialized 
 * when it's declared. The constructor should store the fraction in 
 * reduced form. The fraction 2/4 is equivalent to 1/2 and would be 
 * stored in the object as 1 in the numerator and 2 in the denominator. 
 * Provide a no-argument constructor with default values in case no
 * initializers are provided. Provide public methods that perform 
 * each of the following operations:
 * 
 * a) Add two Rational numbers: The result of the addition should be stored in 
 *    reduced form. Implement this as a static method.
 * 
 * b) Subtract two Rational numbers: The result of the subtraction should be 
 *    stored in reduced form. Implement this as a static method.
 * 
 * c) Multiply two Rational numbers: The result of the multiplication should 
 *    be stored in reduced form. Implement this as a static method.
 * 
 * d) Divide two Rational numbers: The result of the division should be 
 *    stored in reduced form. Implement this as a static method.
 * 
 * e) Return a String representation of a Rational number in the form a/b, 
 *    where a is the numerator and b is the denominator.
 * 
 * f) Return a String representation of a Rational number in floating-point 
 *    format. (Consider providing formatting capabilities that enable the 
 *    user of the class to specify the number of digits of precision to the 
 *    right of the decimal point.)
 */
public class Ex08_15_RationalNumbers {

    public static void main(String[] args) {
        int numerator = 12;
        int denominator = 4;
        Rational r = new Rational(numerator, denominator);
        System.out.printf("Stored as: %s\n", r);
        System.out.printf("Details: %d/%d GCD is %d\n", 
            numerator, denominator, r.gcd(numerator, denominator));
        
        Rational r1 = new Rational(3, 4); Rational r2 = new Rational(1, 3); 
        // Rational r1 = new Rational(3, 5); Rational r2 = new Rational(5, 4);
        
        System.out.println("\nAddition");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(Rational.add(r1, r2));
        
        System.out.println("\nSubtraction");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(Rational.subtract(r1, r2));
        
        System.out.println("\nMultiplication");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(Rational.multiply(r1, r2));
        
        System.out.println("\nDivision");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(Rational.divide(r1, r2));
        System.out.println(Rational.divide(r1, r2).toString(4));
    }
    
}

class Rational {

    private int numerator;
    private int denominator;
        
    public Rational() { this(1, 1); }        
    public Rational(int numerator, int denominator) {
        int lcd = gcd(numerator, denominator);
        // division will turn it to reduced form, kaya i named it lcd
        setNumerator(numerator / lcd); 
        setDenominator(denominator / lcd);
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    public void setNumerator(int numerator) { this.numerator = numerator; }
    public void setDenominator(int denominator) { this.denominator = denominator; }
    
    public static int gcd(int n1, int n2) {
        if (n1 + n2 < 2) {
            return -1; // error-code returned
        }
        int gcd = 1; // stores here the gcd, at least all of them are factor of 1
        // runs upto smalest number between n1 and n2.
        for (int factor = 1; factor <= n1 && factor <= n2; ++factor) {
            // test common factor between n1 & n2.
            if (n1 % factor == 0 && n2 % factor == 0) {
                gcd = factor; // replaces the previous answer.
            }
        }
        return gcd;
    }        
    
    // TODO Review KhanAcademy for addition of fraction with different denominator    
    public static Rational add(Rational r1, Rational r2) {
        // 3   5   3x4 + 5x5   12 + 25   +37
        // - + - = --------- = ------- = --- or 1.85
        // 5   4      5x4        20       20
        int numeratorSum = r1.getNumerator() * r2.getDenominator()
                + r1.getDenominator() * r2.getNumerator();
        int denominatorSum = r1.getDenominator() * r2.getDenominator();
        return new Rational(numeratorSum, denominatorSum);
    }
    
    public static Rational subtract(Rational r1, Rational r2) {
        // 3   5   3x4 - 5x5   12 - 25   -13
        // - - - = --------- = ------- = --- or -0.65
        // 5   4      5x4        20       20
        int numeratorSum = r1.getNumerator() * r2.getDenominator()
                - r1.getDenominator() * r2.getNumerator();
        int denominatorSum = r1.getDenominator() * r2.getDenominator();
        return new Rational(numeratorSum, denominatorSum);
    }
    
    public static Rational multiply(Rational r1, Rational r2) {
        // 3   5   3x5   15
        // - * - = --- * -- or 0.75
        // 5   4   5x4   20
        int numeratorProduct = r1.getNumerator() * r2.getNumerator();
        int denominatorProduct = r1.getDenominator() * r2.getDenominator();
        return new Rational(numeratorProduct, denominatorProduct);
    }
    
    // TODO Review KhanAcademy for division of fraction with different denominator
    public static Rational divide(Rational r1, Rational r2) {
        if (r2.getDenominator() == 0) {
            throw new IllegalArgumentException("cannot divide by zero.");
        }
        // reciprocal happened here, turning 2nd operand upside-down
        // 3   5   3   4   3x4   12
        // - / - = - * - = --- / -- or 0.48
        // 5   4   5   5   5x5   25
        int numeratorQuotient = r1.getNumerator() * r2.getDenominator();
        int denominatorQuotient = r1.getDenominator() * r2.getNumerator();
        return new Rational(numeratorQuotient, denominatorQuotient);
    }

    @Override
    public String toString() {
        return String.format("%d/%d -or- %s", getNumerator(), 
                getDenominator(), toString(2) );
    }        
    
    public String toString(int numberOfPrecision) {
        return String.format("%." + numberOfPrecision + "f", 
                (double) getNumerator() / getDenominator() 
        );
    }

}