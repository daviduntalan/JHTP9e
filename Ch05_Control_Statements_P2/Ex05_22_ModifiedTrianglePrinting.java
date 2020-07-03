package Ch05_Control_Statements_P2;

/**
 * Triangle Printing Program. Write an application that displays the following
 * patterns separately, one below the other. Use for loops to generate the
 * patterns.
 *
 * @author David
 */
public class Ex05_22_ModifiedTrianglePrinting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("(a)\t\t(b)\t\t(c)\t\t(d)");
        for (int n = 1; n <= 10; ++n) {
            
            for (int a = 0; a < n; ++a) {
                System.out.print('a');
            }
            for (int a = 0; a < 10 - n; ++a) {
                System.out.print(' ');
            }
            System.out.print("\t");

            
            for (int b = 0; b < 11 - n; ++b) {
                System.out.print('b');
            }
            for (int b = 0; b < n; ++b) {
                System.out.print(' ');
            }
            System.out.print("\t");

            
            for (int c = 0; c < n - 1; ++c) {
                System.out.print(' ');
            }
            for (int c = 0; c < 11 - n; ++c) {
                System.out.print('c');
            }
            System.out.print("\t");

            
            for (int d = 0; d < 10 - n; ++d) {
                System.out.print(' ');
            }
            for (int d = 0; d < n; ++d) {
                System.out.print('d');
            }

            System.out.println();
        }
    }

}
