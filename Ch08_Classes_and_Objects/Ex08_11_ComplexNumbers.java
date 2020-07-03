package Ch08_Classes_and_Objects;

/**
 * Complex Numbers. Create a class called Complex for performing arithmetic
 * with complex numbers. Complex numbers have the form
 * 
 *      realPart + imaginaryPart * i
 * 
 * where i is
 * 
 *        -----
 *       / -1
 *      v
 * 
 * Write a program to test your class. Use floating-point variables to
 * represent the private data of the class. Provide a constructor that 
 * enables an object of this class to be initialized when it's declared.
 * Provide a constructor that enables an object of this class to be
 * initialized when it's declared. Provide a no-argument constructor
 * with default values in case no initializers are provided. Provide
 * public methods that perform the following operations:
 * 
 *  a) Add two Complex numbers: The real parts are added together and
 *     imaginary parts are added together.
 * 
 *  b) Subtract two Complex numbers: The real part of the right operand
 *     is subtracted from the real part of the left operand, and the 
 *     imaginary part of the right operand is subtracted from the 
 *     imaginary part of the left operand.
 * 
 *  c) Print Complex numbers  in the form (realPart, imaginaryPart);
 * 
 * @author David
 */
public class Ex08_11_ComplexNumbers {

    public static void main(String[] args) {

        Complex comp1 = new Complex(15, 10);
        Complex comp2 = new Complex(5, 10);
        
        System.out.println("ADDITION");
        System.out.println("Before comp1.add(comp2)");
        System.out.println("comp1: " + comp1);
        System.out.println("comp2: " + comp2);
        
        comp1.add(comp2);
        
        System.out.println(" After comp1.add(comp2)");
        System.out.println("comp1: " + comp1);
        System.out.println("comp2: " + comp2);
        
        System.out.println();
        
        System.out.println("SUBTRACTION");
        System.out.println("Before comp2.subtract(comp1)");
        System.out.println("comp2: " + comp2);
        System.out.println("comp1: " + comp1);
        
        comp2.subtract(comp1);
        
        System.out.println(" After comp2.subtract(comp1)");
        System.out.println("comp2: " + comp2);
        System.out.println("comp1: " + comp1);
    }
    
}

class Complex {
    
    public Complex(double re, double im) {
        setRealPart(re);
        setImaginaryPart(im);
    }
    
    public Complex() {
        this(0.0, 0.0);
    }
    
    public void add(Complex c2) {
        setRealPart(getRealPart() + c2.getRealPart());
        setImaginaryPart(getImaginaryPart() + c2.getImaginaryPart());
    }

    public void subtract(Complex c2) {
        setRealPart(getRealPart() - c2.getRealPart());
        setImaginaryPart(getImaginaryPart() - c2.getImaginaryPart());
    }

    @Override
    public String toString() {
        return String.format("(%5.1f, %5.1f)", getRealPart(), getImaginaryPart());
    }        

    private void setRealPart(double re) {
        realPart = re;
    }

    private void setImaginaryPart(double im) {
        imaginaryPart = im;
    }
    
    private double getRealPart() {
        return realPart;
    }
    
    private double getImaginaryPart() {
        return imaginaryPart;
    }        
    
    private double realPart;
    private double imaginaryPart;
}