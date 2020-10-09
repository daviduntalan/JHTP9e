package Ch14_GUI_Components_P1;

import javax.swing.*;

/**
 * Ex 14.14: Guess-the-Number Game. Write an application that plays "guess the number"
 * as follows: Your application chooses the number to be guessed by selecting an
 * integer at random in the range 1-1000. The application then displays the following
 * in a label:
 *
 * I have a number between 1 and 1000. Can you guess my number?
 * Please enter your first guess.
 *
 * A JTextField should be used to input the guess. As each guess is input, the
 * background color should change to either red or blue. Red indicates that the
 * user is getting "warmer," and blue, "colder." A JLabel should display either
 * "Too High" or "Too Low" to help the user zero in. When the user gets the
 * correct answer, "Correct!" should be displayed, and the JTextField used for
 * input should be changed to be uneditable. A JButton should be provided to allow
 * the user to play the game again. When the JButton is clicked, a new random
 * number should be generated and the input JTextField changed to be editable.
 */
public class Ex14_14_GuessTheNumber {

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

        GuessTheNumberFrame guessTheNumberFrame = new GuessTheNumberFrame();
        guessTheNumberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessTheNumberFrame.setSize(400,150);
        guessTheNumberFrame.setLocationRelativeTo(null);
        guessTheNumberFrame.setVisible( true );
    }
}
