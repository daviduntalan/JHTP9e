package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ex 14.13: Enhance the temperature-conversion application of Ex 14.12 by
 * adding the Kelvin temperature scale. The application should also allow the
 * user to make conversions between any two scales. Use the following formula
 * for the conversion between Kelvin and Celsius: Kelvin = Celsius + 273.15
 */
class TemperatureConverterModifiedFrame extends JFrame {

    private final JLabel fahrenheitLabel;
    private final JLabel celsiusLabel;
    private final JLabel kelvinLabel;
    private final JButton btnCalculate;

    public TemperatureConverterModifiedFrame() throws HeadlessException {

        super("Temperature Conversion");
        setLayout(new GridLayout(4, 2));

        celsiusLabel = new JLabel("Celsius: ");
        kelvinLabel = new JLabel("Kelvin: ");
        fahrenheitLabel = new JLabel("Fahrenheit: ");
        btnCalculate = new JButton("Calculate");

        JTextField inputFahrenheit = new JTextField(5);
        JLabel outputCelsius = new JLabel();
        JLabel outputKelvin = new JLabel();

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double fahrenheit = Double.parseDouble(inputFahrenheit.getText());
                double celsius = 5.0 / 9.0 * (fahrenheit - 32.0);
                double kelvin = celsius + 273.15;
                outputCelsius.setText(String.format("%.2f", celsius));
                outputKelvin.setText(String.format("%.2f", kelvin));
            }
        });

        add(fahrenheitLabel); add(inputFahrenheit);
        add(celsiusLabel); add(outputCelsius);
        add(kelvinLabel); add(outputKelvin);
        add(btnCalculate);
    }
}

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
