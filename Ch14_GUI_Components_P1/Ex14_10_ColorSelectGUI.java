package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;

class ColorSelectFrame extends JFrame {

    private static final String[] colorNames = {
            "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
            "Magenta", "Orange", "Pink", "Red", "White", "Yellow"
    };
    private static final Color[] colors = {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
            Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    private JComboBox colorSelect;
    private JCheckBox backGroundCheckBox;
    private JCheckBox foreGroundCheckBox;
    private JButton btnOK;
    private JButton btnCancel;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;

    public ColorSelectFrame() throws HeadlessException {

        super("Color Select");
        northPanel = new JPanel(new GridLayout(1,1));
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        colorSelect = new JComboBox(colorNames);
        backGroundCheckBox = new JCheckBox("Background");
        foreGroundCheckBox = new JCheckBox("Foreground");
        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");

        northPanel.add(colorSelect);
        centerPanel.add(backGroundCheckBox);
        centerPanel.add(foreGroundCheckBox);
        southPanel.add(btnOK);
        southPanel.add(btnCancel);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel); // added to center region
        add(southPanel, BorderLayout.SOUTH);
    }
}

/**
 * Ex 14.10: Create the following GUI. You don't have to provide any functionality.
 */
public class Ex14_10_ColorSelectGUI {

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

        ColorSelectFrame colorSelectFrame = new ColorSelectFrame();
        colorSelectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorSelectFrame.setSize(320, 150);
        colorSelectFrame.setLocationRelativeTo(null);
        colorSelectFrame.setVisible( true );
    }
}
