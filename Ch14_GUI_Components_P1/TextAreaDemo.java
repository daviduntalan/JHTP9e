package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Fig. 14.47: Copying selected text from one textarea to another.
class TextAreaFrame extends JFrame {

    private JTextArea textArea1; // displays demo string
    private JTextArea textArea2; // highlighted text is copied here
    private JButton copyJButton; // initiates copying of text

    public TextAreaFrame() {
        super("TextArea Demo");
        Box box = Box.createHorizontalBox(); // ctrl + q for its function
        String demo = "This is a demo string to\n" +
                "illustrate copying text from\n" +
                "one textarea to another textarea \n" +
                "using an external event\n";

        textArea1 = new JTextArea(demo, 10, 15); // create textArea1
        box.add( new JScrollPane( textArea1 )); // add scroll pane

        copyJButton = new JButton("Copy >>>"); // create copy button
        box.add( copyJButton ); // add copy button to box
        copyJButton.addActionListener(new ActionListener() {
            @Override // set text in textArea2 to selected text from textArea1
            public void actionPerformed(ActionEvent e) {
                textArea2.setText( textArea1.getSelectedText() );
            }
        });

        textArea2 = new JTextArea(10, 15); // create 2nd textarea
        textArea2.setEditable( false ); // disable editing
        box.add( new JScrollPane( textArea2 )); // add scroll pane

        add( box ); // add box to frame
    }
}

public class TextAreaDemo {

    public static void main(String[] args) {

        TextAreaFrame textAreaFrame = new TextAreaFrame();
        textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textAreaFrame.setSize(425, 200); // set frame size
        textAreaFrame.setLocationRelativeTo( null ); // center it
        textAreaFrame.setVisible( true ); // display frame
    }
}
