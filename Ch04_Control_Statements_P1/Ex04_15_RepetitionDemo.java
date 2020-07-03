package Ch04_Control_Statements_P1;

/**
 *
 * @author David
 */
public class Ex04_15_RepetitionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int age = 40;
        if (age >= 65) { // semi-colon removed!
            System.out.println("Age is greater than or equal to 65");
        } else {
            System.out.println("Age is less than 65");
        }
        
        int x = 1, total = 0; // needs initialization
        while (x <= 10) {
            total += x;
            ++x;
        }
        System.out.println("Total: " + total);
        
        while (x <= 100) {
            total += x;
            ++x;
        } // brace needed to enclose ++x
        System.out.println("Total: " + total);
        
        int y = 10;
        while (y > 0) {
            System.out.println(y);
            --y; // replaced with decrement operator to avoid infinite loop.
        }
    }

}
