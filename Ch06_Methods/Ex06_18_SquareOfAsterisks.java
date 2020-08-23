package Ch06_Methods;

/**
 *
 * @author David
 */
public class Ex06_18_SquareOfAsterisks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Random random = new java.util.Random();
        
        System.out.printf("Enter a fill character to draw: ");
        char fill = input.next().charAt(0);
        int col, row;
        
        for (int i = 0; i < 20; ++i) {
            col = 1 + random.nextInt(30);
            row = 1 + random.nextInt(15);
            squareOfAsterisks(col, row, fill);
        }
    }

    private static void squareOfAsterisks(int col, int row, char fillCharacter) {
        System.out.println("Square of " + col + " x " + row);
        for (int y = 0; y < row; ++y) {
            for (int x = 0; x < col; ++x) {
                System.out.printf("%c ", fillCharacter);
            }
            System.out.println();
        }
        System.out.println();
    }

}
