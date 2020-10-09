package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * GUI-Based Craps Game. Modify the application of Section 6.10 to provide a GUI that
 * enables the user to click a JButton to roll the dice. The application should also display four JLabels
 * and four JTextFields, with one JLabel for each JTextField. The JTextFields should be used to
 * display the values of each die and the sum of the dice after each roll. The point should be displayed
 * in the fourth JTextField when the user does not win or lose on the first roll and should continue
 * to be displayed until the game is lost.
 * <p>
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
 * @author David
 */
public class Ex14_16_CrapsGUI {

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

    private static JTextField[] textFields;
    private static JTextArea textArea;
    private static JLabel[] labels;
    private static JLabel status;

    // enumeration with constant that represent the game status
    private enum Status {CONTINUE, WON, LOST}

    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    /**
     * plays one game of craps
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        CrapsFrame crapsFrame = new CrapsFrame();
        crapsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crapsFrame.setSize(400, 230);
        crapsFrame.setLocationRelativeTo(null);
        crapsFrame.setVisible(true);

        welcomeMessage();
        processGameOfCraps();
    } // end main

    private static void processGameOfCraps() {

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
                // System.out.printf("Point is %d\n", myPoint);
                textFields[3].setText("Point is " + myPoint);
                break; // optional at end of switch
        } // end switch

        // while game is not complete
        while (gameStatus == Status.CONTINUE) { // not WON or LOST
            sumOfDice = rollDice(); // roll dice again

            // determine game status
            if (sumOfDice == myPoint) { // win by making point
                gameStatus = Status.WON;
            } else if (sumOfDice == SEVEN) { // lose by rolling 7 before point
                gameStatus = Status.LOST;
            }

        } // end while

        // display won or lost message
        String result;
        if (gameStatus == Status.WON) {
            result = "Player WINS"; // System.out.println(result);
        } else {
            result = "Player LOSES"; // System.out.println(result);
        }
        status.setText(result);
    }

    // roll dice, calculate sum and display results
    public static int rollDice() {
        // pick random die values
        int die1 = 1 + randomNumbers.nextInt(6); // first die rool
        int die2 = 1 + randomNumbers.nextInt(6); // second die rool
        int sum = die1 + die2; // sum of die values

        // display results of this roll
        String diceStatus = String.format("Player rolled %d + %d = %d\n",
                die1, die2, sum);
        System.out.printf(diceStatus);

        textFields[0].setText(Integer.toString(die1));
        textFields[1].setText(Integer.toString(die2));
        textFields[2].setText(Integer.toString(sum));
        textArea.setText(textArea.getText() + diceStatus);

        return sum; // return sum of dice
    }

    private static class CrapsFrame extends JFrame {

        private final JButton rollDiceButton;

        public CrapsFrame() {
            super("GUI-Based Craps Game");
            setLayout(new FlowLayout(FlowLayout.LEFT));

            rollDiceButton = new JButton("Roll Dice");
            rollDiceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String diceRolledAgain = "\nDice rolled...\n";
                    System.out.print(diceRolledAgain);
                    textArea.setText(textArea.getText() + diceRolledAgain);
                    textFields[3].setText("empty");
                    processGameOfCraps();
                }
            });

            textArea = new JTextArea(6, 30);
            textArea.setEditable(false);
            add(new JScrollPane(textArea));

            final int MAX = 4;

            labels = new JLabel[MAX];
            labels[0] = new JLabel("Player rolled");
            labels[1] = new JLabel("+");
            labels[2] = new JLabel("=");
            labels[3] = new JLabel("is");
            status = new JLabel("Status:");

            textFields = new JTextField[MAX];
            textFields[0] = new JTextField(2);
            textFields[1] = new JTextField(2);
            textFields[2] = new JTextField(2);
            textFields[3] = new JTextField(12);

            for (int i = 0; i < MAX; ++i) {
                textFields[i].setEditable(false);
                add(labels[i]);
                add(textFields[i]);
            }

            add(rollDiceButton);
            add(status);
        }
    }
}
