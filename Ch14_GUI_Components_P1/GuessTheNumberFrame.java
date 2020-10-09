package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumberFrame extends JFrame implements ActionListener {

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