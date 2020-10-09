package Ch14_GUI_Components_P1;

// Fig. 14.20: Testing RadioButtonFrame
import javax.swing.*;

public class RadioButtonTest {

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

        RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
        radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        radioButtonFrame.setSize(320, 200);
        radioButtonFrame.setLocationRelativeTo( null ); // center CheckBoxJFrame
        radioButtonFrame.setVisible(true);
    } // end method main()
} // end class RadioButtonTest
