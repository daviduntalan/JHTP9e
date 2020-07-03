package Ch06_Methods;

/**
 * Coin Tossing. Write an application that simulates coin tossing. Let the program toss a coin
 * each time the user chooses the “Toss Coin” menu option. Count the number of times each side of
 * the coin appears. Display the results. The program should call a separate method flip that takes no
 * arguments and returns a value from a Coin enum (HEADS and TAILS). [Note: If the program realistically
 * simulates coin tossing, each side of the coin should appear approximately half the time.]
 *
 * @author David
 */
public class Ex06_29_CoinTossing {    

    enum Coin { HEADS, TAILS };
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int headCount = 0;
        int tailCount = 0;

        for (int ntimes = 0; ntimes < 60; ++ntimes) {
            switch (flip()) {
                case HEADS: ++headCount; break;
                case TAILS: ++tailCount; break;
                default: System.err.println("Waley!");
            }
        }
        
        System.out.printf("\nHead count: %d", headCount);
        System.out.printf("\nTail count: %d\n", tailCount);
    }

    private static Coin flip() {
        java.util.Random random = new java.util.Random();
        int toss = random.nextInt(2);
        switch (toss) {
            case 0: return Coin.HEADS;
            default: return Coin.TAILS;
        }
    }
}
