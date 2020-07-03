package Ch04_Control_Statements_P1;

/**
 * Square of Asterisks. Write an app that prompts the user to enter the side of
 * a square, then displays a hollow square of that size made of asterisks. Your
 * program should work for squares of all side lengths between 1 and 20.
 *
 * @author David
 */
public class Ex04_29_SquareHallow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        int side = 0;
        
        // taking only a valid input...
        while (side < 1 || side > 20) {
            System.out.printf("Enter the size of the side of a square (1-20): ");
            side = input.nextInt();
        }

        // draw the square hallow...                
        int row = 0; 
        while (row < side) {
            int col = 0; // reset column
            while (col < side) {
                // if first or last row then, draw it completely...
                if (row == 0 || row == side - 1) {
                    System.out.print("* ");
                } 
                // ...unless it's told to do the otherwise
                else {
                    if (col == 0 || col == side - 1) {
                        System.out.print("* "); // makes column
                    } else {
                        System.out.print("  "); // makes hallow
                    }
                }
                ++col; // next col
            }
            System.out.println(); // next line
            ++row; // next row
        }
    }

}
