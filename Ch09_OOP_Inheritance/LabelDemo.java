package Ch09_OOP_Inheritance;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Fig 9.13: Demonstrates the use of labels.
 * @author David
 */
public class LabelDemo {

    public static void main(String[] args) {
        // create a label with plain text
        JLabel northLabel = new JLabel("North");
        
        // create an icon from an image so we can put it on a JLabel
        String path = "F:\\temp\\repoJava\\jHTP9e\\javaHTP9e\\src\\Ch09_OOP_Inheritance\\";
        ImageIcon labelIcon = new ImageIcon(path + "GUItip.gif");
        
        // create a label with an Icon instead of text
        JLabel centerLabel = new JLabel(labelIcon);
        
        // create another label with an Icon       
        JLabel southLabel = new JLabel(labelIcon);
        
        // set the label to display text (as well as an icon)
        southLabel.setText("South");
        
        // create a frame to hold the labels
        JFrame app = new JFrame();
        
        // add the labels to the frame; the second argument 
        // specifies where on the frame to add the label
        app.add(northLabel, BorderLayout.NORTH);
        app.add(centerLabel, BorderLayout.CENTER);
        app.add(southLabel, BorderLayout.SOUTH);
        
        app.setSize(300, 300); // set the size of the frame
        app.setVisible(true); // show the frame
    }
    
}
