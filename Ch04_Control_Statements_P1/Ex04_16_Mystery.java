package Ch04_Control_Statements_P1;

/**
 *
 * @author David
 */
public class Ex04_16_Mystery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int y; 
        int x = 1;
        int total = 0;
        
        while (x <= 10) {
            y = x * x;
            System.out.println(y);
            total += y; 
            ++x;
        } 
        
        System.out.println("Total is " + total);
        
    }

}
