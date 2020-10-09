package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/** component required for Ex14_18_GUI_Based_ATM.java */
public class ATM_GUI_Version extends JFrame {

    private JTextArea txtAreaScreen;
    private JPanel screenPanel;
    private JPanel keypadPanel, keypadPane;
    private JPanel slotsPanel, slotPane;
    private JPanel commandPanel;

    private JButton btnRemoveCash;
    private JButton btnInsertEnvelope;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn0;
    private JTextField txtInput;
    private JButton btnEnter;
    private int inputCommand;
    private boolean isEnterHit;
    private boolean isCashRemoved;
    private boolean isEnvelopeInserted;

    public ATM_GUI_Version() {
        super("GUI-Based Version of the ATM Case Study");
        // setLayout( new GridLayout(2, 1, 5, 5));
        setNimbusLookAndFeel();

        screenPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        keypadPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        slotsPanel = new JPanel(new GridLayout(1, 1, 5, 5));

        txtAreaScreen = new JTextArea(14, 65);
        txtAreaScreen.setEditable(false);
        txtAreaScreen.setLineWrap(true);
        txtAreaScreen.setWrapStyleWord(true);
        txtAreaScreen.setBackground(Color.BLUE);
        txtAreaScreen.setForeground(Color.WHITE);
        txtAreaScreen.setFont(new Font("Arial", Font.BOLD, 13));
        txtAreaScreen.setFocusable(false);

        ButtonHandler btnHandler = new ButtonHandler();
        btn1 = new JButton("1"); btn1.addActionListener(btnHandler);
        btn2 = new JButton("2"); btn2.addActionListener(btnHandler);
        btn3 = new JButton("3"); btn3.addActionListener(btnHandler);
        btn4 = new JButton("4"); btn4.addActionListener(btnHandler);
        btn5 = new JButton("5"); btn5.addActionListener(btnHandler);
        btn6 = new JButton("6"); btn6.addActionListener(btnHandler);
        btn7 = new JButton("7"); btn7.addActionListener(btnHandler);
        btn8 = new JButton("8"); btn8.addActionListener(btnHandler);
        btn9 = new JButton("9"); btn9.addActionListener(btnHandler);
        btn0 = new JButton("0"); btn0.addActionListener(btnHandler);
        txtInput = new JTextField(5);
        btnEnter = new JButton("Enter");
        btnEnter.addActionListener(btnHandler);
        txtInput.addActionListener(btnHandler);
        txtInput.setHorizontalAlignment(JTextField.CENTER);

        btnRemoveCash = new JButton("Remove Cash");
        btnInsertEnvelope = new JButton("Insert Envelope");
        btnInsertEnvelope.setMnemonic('E');
        btnRemoveCash.setMnemonic('C');

        SlotHandler slotHandler = new SlotHandler();
        btnRemoveCash.addActionListener(slotHandler);
        btnInsertEnvelope.addActionListener(slotHandler);

        screenPanel.add( new JScrollPane(txtAreaScreen) );

        keypadPane = new JPanel(new GridLayout(4, 3));
        keypadPane.add(btn1);
        keypadPane.add(btn2);
        keypadPane.add(btn3);
        keypadPane.add(btn4);
        keypadPane.add(btn5);
        keypadPane.add(btn6);
        keypadPane.add(btn7);
        keypadPane.add(btn8);
        keypadPane.add(btn9);
        keypadPane.add(btn0);
        keypadPane.add(txtInput);
        keypadPane.add(btnEnter);
        keypadPanel.add(keypadPane);

        JButton blankSlot1 = new JButton("===================="); blankSlot1.setEnabled(false);
        JButton blankSlot2 = new JButton("===================="); blankSlot2.setEnabled(false);
        slotPane = new JPanel(new GridLayout(4, 1));
        slotPane.add(btnRemoveCash); // add to 1st row
        slotPane.add(blankSlot1); // add to 2nd row
        slotPane.add(btnInsertEnvelope); // add to 3rd row
        slotPane.add(blankSlot2); // add to 4th row
        slotsPanel.add(slotPane);

        commandPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        commandPanel.add(keypadPanel); // add to 1st column
        commandPanel.add(slotsPanel); // add to 2nd column

        add(screenPanel, BorderLayout.CENTER); // add to first row
        add(commandPanel, BorderLayout.SOUTH); // add to second row

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(460,385);
        setLocationRelativeTo(null);
        setVisible( true );

        txtInput.requestFocus();
    } // end of constructor

    private void setNimbusLookAndFeel() {
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
    }

    public JTextArea getTxtAreaScreen() {
        return txtAreaScreen;
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String previousInput = txtInput.getText();
            if (e.getSource()==btn1) txtInput.setText(previousInput + btn1.getText());
            if (e.getSource()==btn2) txtInput.setText(previousInput + btn2.getText());
            if (e.getSource()==btn3) txtInput.setText(previousInput + btn3.getText());
            if (e.getSource()==btn4) txtInput.setText(previousInput + btn4.getText());
            if (e.getSource()==btn5) txtInput.setText(previousInput + btn5.getText());
            if (e.getSource()==btn6) txtInput.setText(previousInput + btn6.getText());
            if (e.getSource()==btn7) txtInput.setText(previousInput + btn7.getText());
            if (e.getSource()==btn8) txtInput.setText(previousInput + btn8.getText());
            if (e.getSource()==btn9) txtInput.setText(previousInput + btn9.getText());
            if (e.getSource()==btn0) txtInput.setText(previousInput + btn0.getText());
            /* setIsEnterHit(false); moved to Keypad.java */
            if (e.getSource() == btnEnter || e.getSource() == txtInput) {
                try {
                    inputCommand = Integer.parseInt(txtInput.getText().trim());
                } catch (NumberFormatException ex) {
                    inputCommand = 0; // zero indicate an invalid input command
                    return; // exit this method with finally clause
                } finally {
                    txtInput.setText("");
                }
                setIsEnterHit(true); // a successful input command--if it goes here
            } // end if
            txtInput.requestFocus();
        }
    } // end of inner class ButtonHandler

    public boolean isEnterHit() {
        return isEnterHit;
    }

    public void setIsEnterHit(boolean value) {
        isEnterHit = value;
    }

    public int getInputCommand() {
        return inputCommand;
    }

    public boolean isCashRemoved() {
        return isCashRemoved;
    }

    public void setIsCashRemoved(boolean value) {
        isCashRemoved = value;
    }

    public boolean isEnvelopeInserted() {
        return isEnvelopeInserted;
    }

    public void setIsEnvelopeInserted(boolean value) {
        isEnvelopeInserted = value;
    }

    public void clearScreen() {
        txtAreaScreen.setText("");
        txtAreaScreen.setCaretPosition(0);
    }

    /** hide the input PIN for security purposes */
    public void hideInputPIN(boolean masked) {
        if (masked) {
            txtInput.setForeground(txtInput.getBackground());
        } else {
            /* back to normal input color */
            txtInput.setForeground(Color.BLACK);
        }
    } // end of hideInputPIN

    private class SlotHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnRemoveCash) {
                setIsCashRemoved(true);
            } else if (e.getSource() == btnInsertEnvelope) {
                setIsEnvelopeInserted(true);
            }
            txtInput.requestFocus();
        } // end of actionPerformed()
    }
} // end of class ATM_GUI_Version