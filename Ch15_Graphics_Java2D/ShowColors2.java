package Ch15_Graphics_Java2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Fig. 15.7: Choosing colors with JColorChooser. */
class ShowColors2JFrame extends JFrame {

    private JButton changeColorJButton;
    private Color color = Color.LIGHT_GRAY;
    private JPanel colorJPanel;

    public ShowColors2JFrame() {
        super("Using JColorChooser");
        setNimbusLookAndFeel();
        // create JPanel for display color
        colorJPanel = new JPanel();
        colorJPanel.setBackground( color );

        // setup changeColorJButton and register its event handler
        changeColorJButton = new JButton("Change Color");
        changeColorJButton.addActionListener(new ActionListener() { // anonymous inner class
            @Override // display JColorChooser when user clicks button
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(ShowColors2JFrame.this,
                        "Choose a color", color);
                // set default color if no color is returned
                if (color == null) color = Color.LIGHT_GRAY;
                // change content pane's background color
                colorJPanel.setBackground( color );
            } // end method actionPerformed
        });

        add( colorJPanel, BorderLayout.CENTER ); // add colorJPanel
        add( changeColorJButton, BorderLayout.SOUTH ); // add button
        setSize(400, 130); // set frame size
        setVisible(true); // display frame
    } // end constructor

    private void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
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
    }
} // end of class ShowColors2JFrame

/** Fig. 15.8: Choosing colors with JColorChooser */
public class ShowColors2 {

    public static void main(String[] args) {

        ShowColors2JFrame app = new ShowColors2JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
