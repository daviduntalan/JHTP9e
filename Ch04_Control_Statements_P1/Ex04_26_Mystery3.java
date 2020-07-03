package Ch04_Control_Statements_P1;

/**
 * Whats does the following program print?
 *
 * @author David
 */
public class Ex04_26_Mystery3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int row = 10;
        int column;
        while (row >= 1) {
            column = 1;
            while (column <= 10) {
                System.out.print(row % 2 == 1 ? "<" : ">");
                ++column;
            } // end while
            --row;
            System.out.println();
        } // end while
    }

}

/* Output:
>>>>>>>>>>
<<<<<<<<<<
>>>>>>>>>>
<<<<<<<<<<
>>>>>>>>>>
<<<<<<<<<<
>>>>>>>>>>
<<<<<<<<<<
>>>>>>>>>>
<<<<<<<<<<
*/