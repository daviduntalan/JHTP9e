package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;

public class LookAndFeelTest {

    public static final String[] guiOptions = { "Metal", "Nimbus", "CDE/Motif", "Windows", "Windows Classic" };

    public static void main(String[] args) {

        String guiOption = guiOptions[1]; // selecting Nimbus
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (guiOption.equals(info.getName())) {
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
        //</editor-fold>

        JFrame windowFrame = new JFrame("Look And Feel Demo");
        windowFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        windowFrame.add(new TextField("Input Text Field"));
        windowFrame.add(new TextField("First Name"));
        windowFrame.add(new TextField("Last Name"));
        windowFrame.add(new JButton("OK"));
        windowFrame.add(new JButton("Cancel"));
        windowFrame.add(new JButton("Help"));

        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(320, 200);
        windowFrame.setLocationRelativeTo( null ); // center CheckBoxJFrame
        windowFrame.setVisible(true);
    } // end method main()
} // end class RadioButtonTest
