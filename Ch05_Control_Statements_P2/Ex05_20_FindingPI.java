package Ch05_Control_Statements_P2;

/**
 * Calculating the value of PI. with Precision.
 *
 * @author David
 */
public class Ex05_20_FindingPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double pi = 4.0;
        double n = 3.0;
        int PI = 0;
        int K100 = 100000;
        for (int i = 0; i < 200_000; ++i) {
            pi = (i % 2 == 0)
                    ? pi - 4.0 / n
                    : pi + 4.0 / n;
            PI = (int) (pi * K100); // turn 3.14159 to 314159 then, 
            // truncate precision so that we can compare to the ff:
            System.out.printf("%6d. %d.%d\n", i, PI / K100, PI % K100);
            if (PI == 314159) {
                break; // found@136119
            }
            n += 2.0;
        }
    }

}
