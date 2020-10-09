package Ch14_GUI_Components_P1;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

/**
 * 14.20 (Typing Tutor: Tuning a Crucial Skill in the Computer Age) Typing quickly and correctly
 * is an essential skill for working effectively with computers and the Internet. In this exercise, you’ll
 * build a GUI application that can help users learn to “touch type” (i.e., type correctly without looking
 * at the keyboard). The application should display a virtual keyboard (Fig. 14.50) and should allow
 * the user to watch what he or she is typing on the screen without looking at the actual keyboard.
 * Use JButtons to represent the keys. As the user presses each key, the application highlights the corresponding
 * JButton on the GUI and adds the character to a JTextArea that shows what the user has
 * typed so far. [Hint: To highlight a JButton, use its setBackground method to change its background
 * color. When the key is released, reset its original background color. You can obtain the JButton’s
 * original background color with the getBackground method before you change its color.]
 *
 * You can test your program by typing a pangram—a phrase that contains every letter of the
 * alphabet at least once—such as “The quick brown fox jumped over a lazy dog.” You can find other
 * pangrams on the web.
 *
 * To make the program more interesting you could monitor the user’s accuracy. You could have
 * the user type specific phrases that you’ve prestored in your program and that you display on the
 * screen above the virtual keyboard. You could keep track of how many keystrokes the user types correctly
 * and how many are typed incorrectly. You could also keep track of which keys the user is having
 * difficulty with and display a report showing those keys.
 */


public class Ex14_20_TypingTutor {

    public static void main(String[] args) {

        TypingTutorFrame typingTutorFrame = new TypingTutorFrame();
        typingTutorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        typingTutorFrame.setSize(800, 600);
        typingTutorFrame.setLocationRelativeTo(null);
        typingTutorFrame.setVisible(true);
    }
}
