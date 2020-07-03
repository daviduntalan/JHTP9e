package Ch06_Methods;

import java.util.Random;

/**
 * Craps class simulate the dice game craps.
 * Fig. 6.8:
 * You roll two dice. Each die has six faces, which contain one, two, three, four, five and
 * six spots, respectively. After the dice have come to rest, the sum of the spots on the two
 * upward faces is calculated. If the sum is 7 or 11 on the first throw, you win. If the sum
 * is 2, 3 or 12 on the first throw (called “craps”), you lose (i.e., the “house” wins). If the
 * sum is 4, 5, 6, 8, 9 or 10 on the first throw, that sum becomes your “point.” To win,
 * you must continue rolling the dice until you “make your point” (i.e., roll that same
 * point value). You lose by rolling a 7 before making your point.
 * 
 * Craps Game Modification. Modify the craps program of Fig. 6.8 to allow wagering. Initialize
 * variable bankBalance to 1000 dollars. Prompt the player to enter a wager. Check that wager
 * is less than or equal to bankBalance, and if it’s not, have the user reenter wager until a valid wager
 * is entered. Then, run one game of craps. If the player wins, increase bankBalance by wager and display
 * the new bankBalance. If the player loses, decrease bankBalance by wager, display the new bank-
 * Balance, check whether bankBalance has become zero and, if so, display the message "Sorry. You
 * busted!" As the game progresses, display various messages to create some “chatter,” such as "Oh,
 * you're going for broke, huh?" or "Aw c'mon, take a chance!" or "You're up big. Now's the time
 * to cash in your chips!". Implement the “chatter” as a separate method that randomly chooses the
 * string to display. @author David
 */
public class Ex06_33_CrapsModified {

    // create random number generator for use in method rollDice
    private static final Random randomNumbers = new Random();

    private static void welcomeMessage() {
        System.out.println("Game of CRAPS!       You WIN          You WIN");
        System.out.println("                     |                |     ");
        System.out.println("(2) (3) <4> <5> <6> (7) <8> <9> <10> (11) (12)");
        System.out.println(" |   |                                      |");
        System.out.println(" You LOSE                                   You LOSE");
        System.out.println("\nHow to Win/Lose?\n");
        System.out.println("(#) - If first roll results were (7) or (11) - You WIN");
        System.out.println("      otherwise [i.e., (2), (3) or (12)] - You LOSE!\n");
        System.out.println("<#> - Kapag naulit ang <point> bago pa lumabas ang (7)");
        System.out.println("      You WIN otherwise - You LOSE!\n");
    }

    private static void chatter() {
        switch (new Random().nextInt(3)) {
            case 0: System.out.printf("\nOh, you're going for broke, huh?\n"); break;
            case 1: System.out.printf("\nAw c'mon, take a chance!\n"); break;
            default:System.out.printf("\nYou're up big. Now's the time to cash in your chips!\n");
        }
    }
    
    // enumeration with constanct that represent the game status
    private enum Status { CONTINUE, WON, LOST };
    
    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    
    private static double bankBalance = 1000.0; // allow wagering (pasahod)
    
    /**
     * plays one game of craps
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        welcomeMessage();
        
        java.util.Scanner input = new java.util.Scanner(System.in);
        double wager;
        
        do {
            // prompt the player to enter a wager.
            System.out.printf("Enter player's wage < %,.2f: ", bankBalance);        
            wager = input.nextDouble();        
        } while (wager > bankBalance);
        
        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WON, LOST
        int sumOfDice = rollDice(); // first roll of the dice
        
        // determine game status and point based on first roll
        switch (sumOfDice) {
            case SEVEN:     // win with 7 on first roll
            case YO_LEVEN:  // win with 11 on first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES:// lose with 2 on first roll
            case TREY:      // lose with 3 on first roll
            case BOX_CARS:  // lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default:        // didn't win or lose, so remember point
                gameStatus = Status.CONTINUE; // game is not over
                myPoint = sumOfDice; // remember the point
                System.out.printf("Point is %d\n", myPoint);
                break; // optional at end of switch
        } // end switch
        
        // while game is not complete
        while (gameStatus == Status.CONTINUE) { // not WON or LOST
            sumOfDice = rollDice(); // roll dice again
            
            // determine game status
            if (sumOfDice == myPoint) { // win by making point
                gameStatus = Status.WON;
            } else 
                if (sumOfDice == SEVEN) { // lose by rolling 7 before point
                gameStatus = Status.LOST;
            }
            
        } // end while
        
        // display won or lost message
        if (gameStatus == Status.WON) {
            System.out.println("Player WINS");
            // if the player wins, increase bankBalance by wager
            bankBalance += wager;
        } else {
            System.out.println("Player LOSES");
            // if the player wins, increase bankBalance by wager
            bankBalance -= wager;
        }
        
        // as the game progresses, display various messages 
        chatter(); // to create some chatter
        
        // display the new bank balance
        System.out.printf("\nNew bank balance is %.2f", bankBalance);
        
        // check whether bankBalcne has become zero
        if (bankBalance <= 0.0) {
            System.out.printf("\nSorry. You busted!");
        }                
        
        System.out.println();
    } // end main
    
    // roll dice, calculate sum and display results
    public static int rollDice() {
        // pick random die values
        int die1 = 1 + randomNumbers.nextInt(6); // first die rool
        int die2 = 1 + randomNumbers.nextInt(6); // second die rool
        int sum = die1 + die2; // sum of die values
        
        // display results of this roll
        System.out.printf("Player rolled %d + %d = %d\n", 
                die1, die2, sum);
        
        return sum; // return sum of dice
    }
}
