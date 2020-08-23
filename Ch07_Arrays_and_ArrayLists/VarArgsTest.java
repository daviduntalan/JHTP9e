package Ch07_Arrays_and_ArrayLists;

/**
 * Using variable-length argument lists.
 * Fig. 7.20
 * @author David
 */
public class VarArgsTest {

    /** 
     * calculate the average of numbers. 
     * Placing an ellipsis indicating a variable-length argument list 
     * in the middle of a parameter list is a syntax error. An ellipsis 
     * may be placed only at the end of the parameter list.
     * @param numbers
     * @return the average of numbers.
     */
    public static double average(double... numbers) {
        double total = 0.0; // initialize total
        int counter = 0;
        
        // calculate total using the enhanced for statement
        for (double number : numbers) {
            // System.out.printf("numbers[%d] = %.1f\n", counter++, number);
            total += number;
        }        
        
        return total / numbers.length;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int LENGTH = 10;
        double[] numbers = new double[LENGTH];
        
        java.util.Random random = new java.util.Random();
        for (int row = 0; row < numbers.length; row++) {
            numbers[row] = 10.0 + random.nextInt(40-10);
        }
        
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            // System.out.printf("%.1f\n", number);
            System.out.printf("numbers[%d] = %.1f\n", i, number);
        }        
        System.out.println();
        System.out.printf("Average[0-9] %.1f\n\n", average(numbers));
        System.out.printf("Average[0-1] %.1f\n\n", average(numbers[0], numbers[1]));
        System.out.printf("Average[0-2] %.1f\n\n", average(numbers[0], numbers[1], numbers[2]));
        System.out.printf("Average[0-3] %.1f\n\n", average(numbers[0], numbers[1], numbers[2], numbers[3]));
        System.out.printf("Average[4-9] %.1f\n\n", average(numbers[4], numbers[5],
                numbers[6], numbers[7], numbers[8], numbers[9]));
    }        
    
}
