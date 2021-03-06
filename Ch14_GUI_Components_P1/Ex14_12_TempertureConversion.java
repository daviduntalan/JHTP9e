package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TemperatureConverterFrame extends JFrame {

    private final JLabel fahrenheitLabel;
    private final JLabel celsiusLabel;
    private final JButton btnCalculate;

    public TemperatureConverterFrame() throws HeadlessException {

        super("Temperature Conversion");
        setLayout(new GridLayout(3, 2));

        celsiusLabel = new JLabel("Celsius: ");
        fahrenheitLabel = new JLabel("Fahrenheit: ");
        btnCalculate = new JButton("Calculate");

        JTextField inputFahrenheit = new JTextField(5);
        JLabel outputCelsius = new JLabel();

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fahrenheit = Double.parseDouble(inputFahrenheit.getText());
                double celsius = 5.0 / 9.0 * (fahrenheit - 32.0);
                outputCelsius.setText(String.format("%.2f", celsius));
            }
        });

        add(fahrenheitLabel); add(inputFahrenheit);
        add(celsiusLabel); add(outputCelsius);
        add(btnCalculate);
    }
}

/**
 * Ex 14.12: Write a temperature-conversion application that converts from Fahrenheit
 * to Celsius. The Fahrenheit temperature should be entered from the keyboard (via
 * a JTextField). A JLabel should be used to display the converted temperature.
 * Use the following formula for the conversion: Celsius = 5/9 x (Fahrenheit - 32)
 */
public class Ex14_12_TempertureConversion {

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

        TemperatureConverterFrame temparatureConverterFrame = new TemperatureConverterFrame();
        temparatureConverterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temparatureConverterFrame.setSize(300,150);
        temparatureConverterFrame.setLocationRelativeTo(null);
        temparatureConverterFrame.setVisible( true );
    }
}
