package Ch04_Control_Statements_P1;

/**
 * Whats does the following program print?
 *
 * @author David
 */
public class Ex04_25_Mystery2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int count = 1;
        while (count <= 10) {
            System.out.println(count % 2 == 1 ? "*****" : "++++++++");
            ++count;
            
        }
    }

}
