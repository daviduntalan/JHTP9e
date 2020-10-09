package Ch14_GUI_Components_P1;

import javax.swing.*;

/**
 * Ex 14.11: Create the following GUI. You don't have to provide any functionality.
 */
public class Ex14_11_PrinterGUI {

    public static void main(String[] args) {

        /*try {
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
        }*/

        PrinterFrame printerFrame = new PrinterFrame();
        printerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printerFrame.setSize(520, 250);
        printerFrame.setLocationRelativeTo(null);
        printerFrame.setVisible( true );
    }
}
