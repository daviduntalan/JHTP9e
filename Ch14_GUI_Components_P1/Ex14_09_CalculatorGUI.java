package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;

class CalculatorFrame extends JFrame {

    private JTextField inputTextField;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnPeriod;
    private JButton btnDiv;
    private JButton btnMul;
    private JButton btnSub;
    private JButton btnAdd;
    private JButton btnEqual;
    private JPanel inputBoxPanel;
    private JPanel inputKeyPanel;

    public CalculatorFrame() throws HeadlessException {

        super("Calculator");
        inputBoxPanel = new JPanel(new GridLayout(1, 1, 0, 0));
        inputKeyPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        inputTextField = new JTextField(12);
        inputTextField.setFont(new Font("San Serif", Font.PLAIN, 20));
        inputTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputBoxPanel.add(inputTextField);

        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnPeriod = new JButton(".");
        btnDiv = new JButton("/");
        btnMul = new JButton("*");
        btnSub = new JButton("-");
        btnAdd = new JButton("+");
        btnEqual = new JButton("=");

        inputKeyPanel.add(btn7);      // added to col1 row1
        inputKeyPanel.add(btn8);      // added to col2 row1
        inputKeyPanel.add(btn9);      // added to col3 row1
        inputKeyPanel.add(btnDiv);    // added to col4 row1
        inputKeyPanel.add(btn4);      // added to col1 row2
        inputKeyPanel.add(btn5);      // added to col2 row2
        inputKeyPanel.add(btn6);      // added to col3 row2
        inputKeyPanel.add(btnMul);    // added to col4 row2
        inputKeyPanel.add(btn1);      // added to col1 row3
        inputKeyPanel.add(btn2);      // added to col2 row3
        inputKeyPanel.add(btn3);      // added to col3 row3
        inputKeyPanel.add(btnSub);    // added to col4 row3
        inputKeyPanel.add(btn0);      // added to col1 row4
        inputKeyPanel.add(btnPeriod); // added to col2 row4
        inputKeyPanel.add(btnEqual);  // added to col3 row4
        inputKeyPanel.add(btnAdd);    // added to col4 row4

        // added to JFrame with BorderLayout (Region: NORTH & CENTER)
        add(inputBoxPanel, BorderLayout.NORTH);
        add(inputKeyPanel);
    }
}

/**
 * Ex 14.9: Create the following GUI. You don't have to provide any functionality.
 */
public class Ex14_09_CalculatorGUI {

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

        CalculatorFrame calculatorFrame = new CalculatorFrame();
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setSize(225, 250);
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.setVisible( true );
    }
}
