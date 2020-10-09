package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * component required by Ex14_19_EcoFont.java
 */
public class EcoFontFrame extends JFrame {

    private final JButton btnIncreaseFontSize;
    private final JButton btnDecreaseFontSize;
    private final JTextArea txtInputField;
    private final JPanel centerPane;
    private final JPanel southPanel;
    private final String fontName = "Ecofont";
    private int fontSize = 60;

    public EcoFontFrame() {

        super("Ecofont - Eco-friendly Font");
        setNimbusLookAndFeel();

        txtInputField = new JTextArea("Sample text", 4, 20);
        txtInputField.setFont(new Font(fontName, Font.BOLD, fontSize));

        btnIncreaseFontSize = new JButton("Increase Font Size");
        btnDecreaseFontSize = new JButton("Decrease Font Size");
        btnIncreaseFontSize.setMnemonic('I');
        btnDecreaseFontSize.setMnemonic('D');

        btnIncreaseFontSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInputField.setFont(new Font(fontName, Font.BOLD, fontSize+=2));
            }
        });

        btnDecreaseFontSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInputField.setFont(new Font(fontName, Font.BOLD, fontSize-=2));
            }
        });

        centerPane = new JPanel(new GridLayout(1, 1, 5, 5));
        southPanel = new JPanel(new GridLayout(1, 2, 5, 5));

        centerPane.add(new JScrollPane(txtInputField));

        southPanel.add(btnDecreaseFontSize);
        southPanel.add(btnIncreaseFontSize);

        add(centerPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void delayBy(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }

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
}
