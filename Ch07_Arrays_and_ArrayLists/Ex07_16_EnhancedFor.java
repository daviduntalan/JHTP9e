package Ch07_Arrays_and_ArrayLists;

/**
 * Using the Enhanced for Statement. Write an application that uses an
 * enhanced for statement to sum the double values passed by the command-
 * line arguments. [Hint: Use the static method parseDouble of class 
 * Double to convert a String to a double value.]
 * @author David
 */
public class Ex07_16_EnhancedFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double sum = 0.0;
        
        for (String arg : args) {
            System.out.printf("arg: %s\n", arg);
            sum += Double.parseDouble(arg);
        }
        
        System.out.printf("Sum of args: %.2f\n", sum);
    }
    
}
