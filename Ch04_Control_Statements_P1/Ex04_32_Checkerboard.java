package Ch04_Control_Statements_P1;

/**
 * Checkerboard Pattern of Asterisk.
 *
 * @author David
 */
public class Ex04_32_Checkerboard {

    public static void main(String args[]) {
        int max = 8;
        int row = 0;
        int col = 0;
        while (row++ < max) {
            System.out.print((row % 2 == 0) ? " " : "");
            while (col++ < max) {
                System.out.print("* ");
            } col = 0;
            System.out.println();            
        }
    }
}
