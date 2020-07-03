package Ch05_Control_Statements_P2;

/**
 *
 * @author David
 */
public class Ex05_24_DiamondPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int len = 30;
        int starLen = 1;
        
        for (int i = len / 2; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < starLen; j++) {
                System.out.print('^');
            }
            starLen += 2;
            System.out.println();
        }
        
        if (len % 2 != 0) {
            for (int x = 0; x < len; ++x) {
                System.out.print('*');
            }
            System.out.println();
        }
        
        for (int i = 1; i <= len / 2; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }
            starLen -= 2;
            for (int j = 0; j < starLen; j++) {
                System.out.print('v');
            }
            System.out.println();
        }
    }
    
}
