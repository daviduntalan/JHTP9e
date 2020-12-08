package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Exercise 14.19 (Ecofont) Ecofont (www.ecofont.eu/ecofont_en.html)—developed by SPRANQ (a Netherlands-
 * based company)—is a free, open-source computer font designed to reduce by as much as
 * 20% the amount of ink used for printing, thus reducing also the number of ink cartridges used and
 * the environmental impact of the manufacturing and shipping processes (using less energy, less fuel
 * for shipping, and so on). The font, based on sans-serif Verdana, has small circular “holes” in the
 * letters that are not visible in smaller sizes—such as the 9- or 10-point type frequently used. Download
 * Ecofont, then install the font file Spranq_eco_sans_regular.ttf using the instructions from
 * the Ecofont website. Next, develop a GUI-based program that allows you to type in a text string to
 * be displayed in the Ecofont. Create Increase Font Size and Decrease Font Size buttons that allow you
 * to scale up or down by one point at a time. Start with a default font size of 9 points. As you scale
 * up, you’ll be able to see the holes in the lettersmore clearly. As you scale down, the holes will be less
 * apparent. What is the smallest font size at which you begin to notice the holes?
 */

/**
 * component required by Ex14_19_EcoFont.java
 */
class EcoFontFrame extends JFrame {

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

public class Ex14_19_EcoFont {

    public static void main(String[] args) {

        EcoFontFrame ecoFontFrame =  new EcoFontFrame();
        ecoFontFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecoFontFrame.setSize(400, 200);
        ecoFontFrame.setLocationRelativeTo(null);
        ecoFontFrame.setVisible(true);
        /*ecoFontFrame.pack();*/
    }
}
