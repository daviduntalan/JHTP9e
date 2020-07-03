package Ch06_Methods;

/**
 *
 * @author David
 */
public class Ex06_21_SeparatingDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        
        // a) calculate the integer part of the quotient when integer a is divided by integer b
        int quotient = getQuotient(a, b);
        System.out.printf("Quotient of %d and %d: %d\n", a, b, quotient);
        
        // b) calculate the itneger remainder when integer a is divided by integer b
        int remainder = getRemainder(a, b);
        System.out.printf("Remainder of %d and %d: %d\n", a, b, remainder);
        
        // use the methods developed in parts (a) and (b) to write a method
        // displayDigits that receives an integer between 1 and 99999 and
        // displays it as a sequence of digits, separating each pair of
        // digits by two spaces. For example, the integer 4562 should appear
        // as 4..5..6..2..
        int number = 4562;
        System.out.println("Separating Digits: " + number);
        displayDigits(number);
    }

    private static int getQuotient(int a, int b) {
        return a / b;
    }

    private static int getRemainder(int a, int b) {
        return a % b;
    }

    private static void displayDigits(int number) {
        if (number > 0 && number < 100_000) {            
            int remainder;
            String out = "";
            while (number > 0) {
                remainder = getRemainder(number, 10);
                out = remainder + "  " + out;                
                // System.out.println(out);
                number = getQuotient(number, 10);
            }
            System.out.println(out);
        } else {
            System.err.println("Invalid range. Could accept only numbers in between 1-99,999.");
        }
    }
    
}
