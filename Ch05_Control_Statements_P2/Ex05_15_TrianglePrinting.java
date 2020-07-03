package Ch05_Control_Statements_P2;

/**
 * Triangle Printing Program. Write an application that displays 
 * the following patterns separately, one below the other. 
 * Use for loops to generate the patterns.
 * @author David
 */
public class Ex05_15_TrianglePrinting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("(a)");
        for (int a = 1; a <= 10; ++a) {
            for (int i = 0; i < a; ++i) {
                System.out.print('*');
            }
            System.out.println();
        }
        
        System.out.println("(b)");
        for (int b = 10; b > 0; --b) {
            for (int i = 0; i < b; ++i) {
                System.out.print('*');
            }
            System.out.println();
        }
        
        System.out.println("(c)");
        for (int c = 10; c > 0; --c) {   
            for (int j = 0; j < 10 - c; ++j) {
                System.out.print(' ');
            }
            for (int i = 0; i < c; ++i) {                
                System.out.print('*');
            }
            System.out.println();
        }
        
        System.out.println("(d)");
        for (int d = 1; d <= 10; ++d) {   
            for (int j = 0; j < 10 - d; ++j) {
                System.out.print(' ');
            }
            for (int i = 0; i < d; ++i) {                
                System.out.print('*');
            }
            System.out.println();
        }
    }
    
}
