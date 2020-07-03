package Ch04_Control_Statements_P1;

/**
 * Tabular Output. Write a Java app that uses loping to print the following
 * table of values:
 *
 * @author David
 */
public class Ex04_22_TabularOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.printf("N\t10*N\t100*N\t1000*N\n\n");

        int num = 0;
        while (num < 5) {
            System.out.printf("%d\t%d\t%d\t%d\n",
                    ++num, num * 10, num * 100, num * 1000);
        }
    }

}
