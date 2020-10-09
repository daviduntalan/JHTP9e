package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Random;

/** dependent on Ex14_20_TypingTutor.java */
public class TypingTutorFrame extends JFrame implements KeyListener {

    private final String[] randomWords;

    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel statsPanel;

    private JPanel[] keyPanels;
    private JPanel keyPanel1;
    private JPanel keyPanel2;
    private JPanel keyPanel3;
    private JPanel keyPanel4;
    private JPanel keyPanel5;


    private JTextArea typingArea;
    private JLabel typeWhat;
    private JLabel wordToTypeLabel;
    private JLabel statLabel;
    private Random random;

    private JButton btnTilda;
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
    private JButton btnMinus;
    private JButton btnPlus;
    private JButton btnBackspace;

    private JButton btnTab;
    private JButton btnQ;
    private JButton btnW;
    private JButton btnE;
    private JButton btnR;
    private JButton btnT;
    private JButton btnY;
    private JButton btnU;
    private JButton btnI;
    private JButton btnO;
    private JButton btnP;
    private JButton btnSBO;
    private JButton btnSBC;
    private JButton btnBackslash;

    private JButton btnCaps;
    private JButton btnA;
    private JButton btnS;
    private JButton btnD;
    private JButton btnF;
    private JButton btnG;
    private JButton btnH;
    private JButton btnJ;
    private JButton btnK;
    private JButton btnL;
    private JButton btnColon;
    private JButton btnDoubleQuote;
    private JButton btnEnter;

    private JButton btnLShift;
    private JButton btnZ;
    private JButton btnX;
    private JButton btnC;
    private JButton btnV;
    private JButton btnB;
    private JButton btnN;
    private JButton btnM;
    private JButton btnComma;
    private JButton btnPeriod;
    private JButton btnQuestion;
    private JButton btnArrowUp;

    private JButton btnSpace;
    private JButton btnArrowLeft;
    private JButton btnArrowDown;
    private JButton btnArrowRight;

    private Color prevColor;
    private char keyUpper;
    private StringBuffer inputText;
    private HashMap difficultKey;
    private int index, correct, incorrect, totalCorrect, totalIncorrect;

    public TypingTutorFrame() {
        super("Typing Tutor Application");
        setNimbusLookAndFeel();
        instantiateComponents();
        JPanel centerPane = new JPanel( new GridLayout(2, 1, 10, 0));
        northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        random = new Random();

        String instruction1 = "Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed\n";
        String instruction2 = "Note: Clicking the buttons with your mouse will not perform any action.";
        randomWords = new String[]{"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog", "near", "the", "bank", "of", "the", "river."};
        wordToTypeLabel = new JLabel(randomWords[random.nextInt(randomWords.length)]);

        typingArea = new JTextArea(10, 75);
        typingArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        typingArea.setLineWrap(true);
        typingArea.setWrapStyleWord(true);
        typingArea.addKeyListener(this);

        typeWhat = new JLabel("Type: [" + wordToTypeLabel.getText() + "]");
        northPanel.add(new JLabel(instruction1));
        northPanel.add(new JLabel(instruction2));
        northPanel.add(typeWhat);
        northPanel.add(new JScrollPane(typingArea));

        keyPanel1 = new JPanel(new GridLayout(1,1,5,5));
        keyPanel2 = new JPanel(new GridLayout(1,1,5,5));
        keyPanel3 = new JPanel(new GridLayout(1,1,5,5));
        keyPanel4 = new JPanel(new GridLayout(1,1,5,5));
        keyPanel5 = new JPanel(new GridLayout(1,4,5,5));

        keyPanel1.add(btnTilda);
        keyPanel1.add(btn1);
        keyPanel1.add(btn2);
        keyPanel1.add(btn3);
        keyPanel1.add(btn4);
        keyPanel1.add(btn5);
        keyPanel1.add(btn6);
        keyPanel1.add(btn7);
        keyPanel1.add(btn8);
        keyPanel1.add(btn9);
        keyPanel1.add(btn0);
        keyPanel1.add(btnMinus);
        keyPanel1.add(btnPlus);
        keyPanel1.add(btnBackspace);

        keyPanel2.add(btnTab);
        keyPanel2.add(btnQ);
        keyPanel2.add(btnW);
        keyPanel2.add(btnE);
        keyPanel2.add(btnR);
        keyPanel2.add(btnT);
        keyPanel2.add(btnY);
        keyPanel2.add(btnU);
        keyPanel2.add(btnI);
        keyPanel2.add(btnO);
        keyPanel2.add(btnP);
        keyPanel2.add(btnSBO);
        keyPanel2.add(btnSBC);
        keyPanel2.add(btnBackslash);

        keyPanel3.add(btnCaps);
        keyPanel3.add(btnA);
        keyPanel3.add(btnS);
        keyPanel3.add(btnD);
        keyPanel3.add(btnF);
        keyPanel3.add(btnG);
        keyPanel3.add(btnH);
        keyPanel3.add(btnJ);
        keyPanel3.add(btnK);
        keyPanel3.add(btnL);
        keyPanel3.add(btnColon);
        keyPanel3.add(btnDoubleQuote);
        keyPanel3.add(btnEnter);

        keyPanel4.add(btnLShift);
        keyPanel4.add(btnZ);
        keyPanel4.add(btnX);
        keyPanel4.add(btnV);
        keyPanel4.add(btnB);
        keyPanel4.add(btnN);
        keyPanel4.add(btnM);
        keyPanel4.add(btnComma);
        keyPanel4.add(btnPeriod);
        keyPanel4.add(btnQuestion);
        keyPanel4.add(new JLabel(""));
        keyPanel4.add(btnArrowUp);
        keyPanel4.add(new JLabel(""));

        keyPanel5.add(new JLabel(""));
        keyPanel5.add(new JLabel(""));
        keyPanel5.add(new JLabel(""));
        keyPanel5.add(new JLabel(""));
        keyPanel5.add(btnSpace);
        keyPanel5.add(new JLabel(""));
        keyPanel5.add(new JLabel(""));
        keyPanel5.add(new JLabel(""));
        keyPanel5.add(btnArrowLeft);
        keyPanel5.add(btnArrowDown);
        keyPanel5.add(btnArrowRight);

        southPanel.add(keyPanel1);
        southPanel.add(keyPanel2);
        southPanel.add(keyPanel3);
        southPanel.add(keyPanel4);
        southPanel.add(keyPanel5);

        statLabel = new JLabel("");
        statsPanel.add(statLabel);

        centerPane.add(northPanel);
        centerPane.add(southPanel);
        add(centerPane, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.SOUTH);
        prevColor = btnA.getBackground();
        keyPanels = new JPanel[] { keyPanel1, keyPanel2, keyPanel3, keyPanel4, keyPanel5 };
        inputText = new StringBuffer();
        difficultKey = new HashMap<Character, Integer>();

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                printDifficultKeyReport();
            }
        });
    } // end of constructor

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

    private void instantiateComponents() {
        btnTilda = new JButton("~");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btnMinus = new JButton("-");
        btnPlus = new JButton("+");
        btnBackspace = new JButton("Backspace");

        btnTab = new JButton("Tab");
        btnQ = new JButton("Q");
        btnW = new JButton("W");
        btnE = new JButton("E");
        btnR = new JButton("R");
        btnT = new JButton("T");
        btnY = new JButton("Y");
        btnU = new JButton("U");
        btnI = new JButton("I");
        btnO = new JButton("O");
        btnP = new JButton("P");
        btnSBO = new JButton("[");
        btnSBC = new JButton("]");
        btnBackslash = new JButton("\\");

        btnCaps = new JButton("Caps");
        btnA = new JButton("A");
        btnS = new JButton("S");
        btnD = new JButton("D");
        btnF = new JButton("F");
        btnG = new JButton("G");
        btnH = new JButton("H");
        btnJ = new JButton("J");
        btnK = new JButton("K");
        btnL = new JButton("L");
        btnColon = new JButton(":");
        btnDoubleQuote = new JButton("\"");
        btnEnter = new JButton("Enter");

        btnLShift = new JButton("Shift");
        btnZ = new JButton("Z");
        btnX = new JButton("X");
        btnC = new JButton("C");
        btnV = new JButton("V");
        btnB = new JButton("B");
        btnN = new JButton("N");
        btnM = new JButton("M");
        btnComma = new JButton(",");
        btnPeriod = new JButton(".");
        btnQuestion = new JButton("?");
        btnArrowUp = new JButton("^");

        btnSpace = new JButton(" ");
        btnArrowLeft = new JButton("<");
        btnArrowDown = new JButton("v");
        btnArrowRight = new JButton("v");
    }

    @Override
    public void keyTyped(KeyEvent e) {

        char expectedChar = wordToTypeLabel.getText().charAt(index);
        if (expectedChar == e.getKeyChar()) {
            ++correct; totalCorrect += correct;
            inputText.append(e.getKeyChar());
            if (index < wordToTypeLabel.getText().length() - 1) ++index;
        } else {
            /* if action key or space and the following: don't count them as incorrect when hit */
            if (e.isActionKey()
                    || e.getKeyChar() == ' '
                    || e.getKeyChar() == '\b'
                    || e.getKeyChar() == '\r'
                    || e.getKeyChar() == '\n') {
            } else {
                ++incorrect; totalIncorrect += incorrect;
                /* count difficult key to type */
                if (difficultKey.containsKey(expectedChar)) {
                    int count = 1 + (int) difficultKey.get(expectedChar);
                    difficultKey.put(expectedChar, count);
                } else {
                    difficultKey.put(expectedChar, 1);
                } // end else
            } // end else
        } // end else - to navigate at the beginning press: Ctrl + [ or ]

        if (e.getKeyChar() == ' ') /* test only if space is pressed */
        if (wordToTypeLabel.getText().equals(inputText.toString())) {
            index = correct = incorrect = 0;
            int inputLength = inputText.length();
            inputText.delete(0, inputLength);
            String newWordToType = randomWords[random.nextInt(randomWords.length)];
            wordToTypeLabel.setText(newWordToType);
            typeWhat.setText("Type: [" + wordToTypeLabel.getText() + "]");
        }

        System.out.printf("[%s] vs. [%s]\n", wordToTypeLabel.getText(), inputText.toString() );
        String statistic = String.format("STATISTIC: index: %d | correct: %d | incorrect: %d | Total correct: %d | Total incorrect: %d",
                index, correct, incorrect, totalCorrect, totalIncorrect);
        statLabel.setText(statistic);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyUpper = Character.toUpperCase(e.getKeyChar());
        for (JPanel keyPanel : keyPanels) /* <- intentional: no code-block */
        for (Component comp : keyPanel.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (button.getText().length() == 1 && button.getText().charAt(0) == keyUpper)
                    button.setBackground(Color.WHITE);
                else {
                    if (e.getKeyCode() ==  8) btnBackspace.setBackground(Color.WHITE); else
                    if (e.getKeyCode() ==  9) btnTab.setBackground(Color.WHITE); else
                    if (e.getKeyCode() == 20) btnCaps.setBackground(Color.WHITE); else
                    if (e.getKeyCode() == 10) btnEnter.setBackground(Color.WHITE); else
                    if (e.getKeyCode() == 16) btnLShift.setBackground(Color.WHITE); else
                    if (e.getKeyCode() == 37) btnArrowLeft.setBackground(Color.WHITE); else
                    if (e.getKeyCode() == 38) btnArrowUp.setBackground(Color.WHITE); else
                    if (e.getKeyCode() == 39) btnArrowRight.setBackground(Color.WHITE); else
                    if (e.getKeyCode() == 40) btnArrowDown.setBackground(Color.WHITE);
                } // end else
            } // end if
        } // end for each getComponents
        /* end for each keyPanels */
    } // end of keyPressed

    @Override
    public void keyReleased(KeyEvent e) {

        /* turn back the previous background color */
        for (JPanel keyPanel : keyPanels) {
            for (Component comp : keyPanel.getComponents()) {
                comp.setBackground(prevColor);
            }
        } // end for each keyPanels
    } // end of keyReleased()

    private void printDifficultKeyReport() {
        System.out.printf("Difficult key REPORT:\n");
        difficultKey.forEach((key, value) -> {
            System.out.printf("key: %c => value: %d (attempt)\n", (Character) key, (Integer) value);
        });
    }
} // end of class TypingTutorFrame
