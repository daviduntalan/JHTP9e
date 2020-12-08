package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

class GuessTheNumberFrame extends JFrame implements ActionListener {

    private int secretNumber, guessNumber, countNumberOfGuess;
    private JLabel instruction1Label;
    private JLabel instruction2Label;
    private JLabel instruction3Label; // holds: Too High/Low or Correct!
    private Container container;
    private JTextField guessInputNumber;
    private JButton playAgainButton;

    public GuessTheNumberFrame() {
        super("Guess the Number Game");
        setLayout( new FlowLayout(FlowLayout.LEFT) );
        container = getContentPane();
        secretNumber = getNewRandomNumber();
        countNumberOfGuess = 0;

        String instruction1 = "I have a number between 1 and 1000. Can you guess my number?";
        String instruction2 = "Please enter your first guess";

        instruction1Label = new JLabel(instruction1);
        instruction2Label = new JLabel(instruction2);
        instruction3Label = new JLabel();

        guessInputNumber = new JTextField(5);
        guessInputNumber.addActionListener(this);
        playAgainButton = new JButton("Play again");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secretNumber = getNewRandomNumber();
                countNumberOfGuess = 0;
                guessInputNumber.setEditable(true);
                guessInputNumber.setText("");
                instruction3Label.setText("");
                playAgainButton.setVisible(false);
            }
        });

        add( instruction1Label );
        add( instruction2Label );
        add( guessInputNumber );
        add( instruction3Label );
        add( playAgainButton );
        playAgainButton.setVisible(false);
    }

    private int getNewRandomNumber() {
        return new java.util.Random().nextInt(1000) + 1;
    }

    @Override // when click event fires for guessInputNumber
    public void actionPerformed(ActionEvent e) {

        try {
            guessNumber = Integer.parseInt(guessInputNumber.getText());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
            guessInputNumber.setText("");
            return; // exit the fx
        }

        // toggle color background to RED and BLUE
        Color color = container.getBackground();
        container.setBackground(color == Color.PINK
                ? Color.WHITE
                : Color.PINK);

        ++countNumberOfGuess;
        String title = GuessTheNumberFrame.this.getTitle();
        GuessTheNumberFrame.this.setTitle(title + ": " + countNumberOfGuess);

        if (guessNumber < secretNumber) {
            instruction3Label.setText("Too Low");
        } else if (guessNumber > secretNumber) {
            instruction3Label.setText("Too High");
        } else {
            instruction3Label.setText("Correct!");
            guessInputNumber.setEditable(false);
            playAgainButton.setVisible(true);
        }

        guessInputNumber.selectAll();
    } // end method actionPerformed()
} // end of class GuessTheNumberFrame

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
