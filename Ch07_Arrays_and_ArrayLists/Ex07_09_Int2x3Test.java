package Ch07_Arrays_and_ArrayLists;

/**
 * Consider a two-by-three integer array t.
 *
 * @author David
 */
public class Ex07_09_Int2x3Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // a statement taht declares and creates t.
        int[][] t = new int[2][3];
        System.out.printf("      %5s%5s%5s\n", "col0", "col1", "col2");
        for (int row = 0; row < t.length; ++row) {
            System.out.printf("row%d: ", row);
            for (int col = 0; col < t[row].length; ++col) {
                t[row][col] = new java.util.Random().nextInt(100);
                System.out.printf("%5d", t[row][col]);
            }
            System.out.println();
        }
        
        // how many rows does t have? ans: 2
        // how many cols does t have? ans: 3
        // how many elements does t haves: 2 x 3 = 6
        
        // write access expressions for all the elements in row 1 of t.
        int row = 1;
        System.out.printf("row%d col*\n", row);
        System.out.printf("%d\n", t[row][0]);
        System.out.printf("%d\n", t[row][1]);
        System.out.printf("%d\n", t[row][2]);
        
        // write access expressions for all the elements in col 2 of t.
        int col = 2;
        System.out.printf("row* col%d\n", col);
        System.out.printf("%d\n", t[0][col]);
        System.out.printf("%d\n", t[1][col]);
        
        // g) write a single statement that sets the element of t in row 0
        // and column 1 to zero.
        t[0][1] = 0; 
        
        // h) write individual statements to initialize each element of t to zero.
        t[0][0] = 0; 
        t[0][1] = 0; 
        t[0][2] = 0; 
        t[1][0] = 0; 
        t[1][1] = 0; 
        t[1][2] = 0; 
        
        // i) write a nexted for statement that initializes each lement of t to zero.
        for (int rowIndex = 0; rowIndex < t.length; ++rowIndex) {
            for (int colIndex = 0; colIndex < t[rowIndex].length; ++colIndex) {                
                t[rowIndex][colIndex] = 0;
            }
        }
        
        // j) write a nested for statement that inputs the valaues for the element of t from the user.
        for (int rowIndex = 0; rowIndex < t.length; ++rowIndex) {
            for (int colIndex = 0; colIndex < t[rowIndex].length; ++colIndex) {                
                System.out.printf("Enter value for t[%d][%d]: ", rowIndex, colIndex);
                t[rowIndex][colIndex] = new java.util.Scanner(System.in).nextInt();
            }
        }
        
        // k) write a series of statement that determines and displays the smallest value in t.
        int smallest = t[0][0];
        for (int rowIndex = 0; rowIndex < t.length; ++rowIndex) {
            for (int colIndex = 0; colIndex < t[rowIndex].length; ++colIndex) {                
                if (t[rowIndex][colIndex] < smallest) {
                    smallest = t[rowIndex][colIndex];
                }
            }
        }
        System.out.printf("\nSmallest: %d\n", smallest);
        
        // l) write a single printf statemetn that display the element of first row of t.
        System.out.printf("row0: %d %d %d", t[0][0], t[0][1], t[0][2]);
        
        // m) write a statement that totals the elements of the 3rd column of t. Don't use repetition
        int total = 0;
        total += t[0][2];
        total += t[1][2];
        System.out.printf("\ntotal of 3rd columns: %d\n", total);
        
        // n) write a series of statements that display the content of t
        // in tabular format. list the column indices as headings 
    }

}
