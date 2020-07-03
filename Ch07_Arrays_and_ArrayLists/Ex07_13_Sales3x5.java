package Ch07_Arrays_and_ArrayLists;

/**
 * Label the elements of three-by-five two-dimensional array sales to 
 * indicate the order in which they're set to zero by the following:
 * @author David
 */
public class Ex07_13_Sales3x5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] sales = new int[3][5];
        for (int colHead = 0; colHead < sales[0].length; ++colHead) {
            System.out.printf("\tCol-%d", colHead);
        }
        System.out.println();
        for (int row = 0; row < sales.length; ++row) {
            System.out.printf("Row-%d\t", row);
            for (int col = 0; col < sales[row].length; ++col) {
                sales[row][col] = 0;
                System.out.printf("%5d\t", sales[row][col]);
            }
            System.out.println();
        }
        
    }
    
}
