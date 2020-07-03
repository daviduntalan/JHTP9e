package Ch05_Control_Statements_P2;

import java.util.Scanner;

/**
 * Bar Chart Printing Program. One interesting app of computers is to display
 * graphs and bar charts. Write an app that reads five numbers
 *
 * @author David
 */
public class Ex05_16_BarChart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        final int lines = 5;
        for (int n, i = 1; i <= lines; ++i) {
            do {
                System.out.printf("%d/%d. enter numbers between 1-30: ", i, lines);
                n = input.nextInt();
            } while (n < 1 || n > 30);
            for (int j = 0; j < n; ++j) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
