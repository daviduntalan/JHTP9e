package Ch14_GUI_Components_P1;

import javax.swing.*;

/**
 * Ex 14.12: Write a temperature-conversion application that converts from Fahrenheit
 * to Celsius. The Fahrenheit temperature should be entered from the keyboard (via
 * a JTextField). A JLabel should be used to display the converted temperature.
 * Use the following formula for the conversion: Celsius = 5/9 x (Fahrenheit - 32)
 */
public class Ex14_13_TempertureModifiedConversion {

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

        TemperatureConverterModifiedFrame app = new TemperatureConverterModifiedFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(300,150);
        app.setLocationRelativeTo(null);
        app.setVisible( true );
    }
}
