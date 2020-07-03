package Ch04_Control_Statements_P1;

/**
 * Compare and contrast the if single-selection statement and 
 * the while repetition statement. How are these two statement
 * similar? How are they different?
 * @author David
 */
public class Ex04_10_CompareContrast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int value = 5;
        
        if (value < 10) {
            System.out.println("if: value less than 10");
        }
        
        while (value < 10) {
            System.out.println("while: value less than 10");
            ++value;
        }
    }
    
}
