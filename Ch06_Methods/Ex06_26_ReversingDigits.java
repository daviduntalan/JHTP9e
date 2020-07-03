package Ch06_Methods;

/**
 *
 * @author David
 */
public class Ex06_26_ReversingDigits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("Min: %,d -to- Max: %,d\n", 
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        int number = Integer.MAX_VALUE;
        System.out.println("Reversing Digits: " + number);
        reverseDigits(number);
    }

    private static int getQuotient(int a, int b) {
        return a / b;
    }

    private static int getRemainder(int a, int b) {
        return a % b;
    }

    private static void reverseDigits(int number) {
        if (number > 0 && number <= Integer.MAX_VALUE) {            
            int remainder;
            String out = "";
            while (number > 0) {
                remainder = getRemainder(number, 10);
                out +=  remainder;
                number = getQuotient(number, 10);
            }
            System.out.println("Reversed Digits : " + out);
        } else {
            System.err.printf("Invalid range.\nCould accept only numbers in between 1 and %,d.\n", 
                    Integer.MAX_VALUE);
        }
    }
    
}
