package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;

public class PrinterFrame extends JFrame {

    private static final String[] priorities = { "High", "Normal", "Low" };
    private JLabel printerLabel;
    private JLabel printQualityLabel;
    private JTextArea filler1, filler2, filler3;
    private JCheckBox cbImage;
    private JCheckBox cbText;
    private JCheckBox cbCode;
    private JCheckBox cbPrintToFile;
    private ButtonGroup buttonGroup;
    private JRadioButton radSelection;
    private JRadioButton radAll;
    private JRadioButton radApplet;
    private JComboBox printQuality;
    private JButton btnOK;
    private JButton btnCancel;
    private JButton btnSetup;
    private JButton btnHelp;
    private JPanel headPanel;
    private JPanel bodyPanel;
    private JPanel footPanel;
    private JPanel optionPane;
    private JPanel optionPanel;
    private JPanel actionPanel;
    private JPanel actionPane;

    public PrinterFrame() throws HeadlessException {

        super("Printer");
        setLayout( new FlowLayout(FlowLayout.CENTER) );

        headPanel = new JPanel(new GridLayout(1, 1, 0, 5));
        bodyPanel = new JPanel(new GridLayout(1, 5, 0, 5));
        footPanel = new JPanel(new GridLayout(1, 3, 0, 5));
        JPanel headPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel bodyPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel footPane = new JPanel(new FlowLayout(FlowLayout.LEFT));

        optionPanel = new JPanel(new GridLayout(3, 1, 0, 5));
        optionPane = new JPanel(new FlowLayout(FlowLayout.LEFT));

        actionPanel = new JPanel(new GridLayout(4, 1, 0, 5));
        actionPane = new JPanel(new FlowLayout());

        printerLabel = new JLabel("Printer: MyPrinter");

        filler1 = new JTextArea(3, 6); filler1.setEditable(false);
        filler2 = new JTextArea(3, 3); filler2.setEditable(false);
        filler3 = new JTextArea(3, 6); filler3.setEditable(false);

        cbImage = new JCheckBox("Image");
        cbText = new JCheckBox("Text");
        cbCode = new JCheckBox("Code");

        radSelection = new JRadioButton("Selection");
        radAll = new JRadioButton("All");
        radApplet = new JRadioButton("Applet");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radSelection);
        buttonGroup.add(radAll);
        buttonGroup.add(radApplet);

        printQualityLabel = new JLabel("Print Quality:");
        printQuality = new JComboBox(priorities);

        cbPrintToFile = new JCheckBox("Print to File");

        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");
        btnSetup = new JButton("Setup...");
        btnHelp = new JButton("Help");

        JPanel checkBoxes = new JPanel(new GridLayout(3,1));
        checkBoxes.add(cbImage);
        checkBoxes.add(cbText);
        checkBoxes.add(cbCode);

        JPanel radioButtons = new JPanel(new GridLayout(3,1));
        radioButtons.add(radSelection);
        radioButtons.add(radAll);
        radioButtons.add(radApplet);

        headPanel.add(printerLabel);

        bodyPanel.add(filler1);
        bodyPanel.add(checkBoxes);
        bodyPanel.add(filler2);
        bodyPanel.add(radioButtons);
        bodyPanel.add(filler3);

        footPanel.add(printQualityLabel);
        footPanel.add(printQuality);
        footPanel.add(cbPrintToFile);

        headPane.add(headPanel);
        bodyPane.add(bodyPanel);
        footPane.add(footPanel);

        optionPanel.add(headPane);
        optionPanel.add(bodyPane);
        optionPanel.add(footPane);
        optionPane.add(optionPanel); // group them
        add(optionPane);

        actionPanel.add(btnOK);
        actionPanel.add(btnCancel);
        actionPanel.add(btnSetup);
        actionPanel.add(btnHelp);
        actionPane.add(actionPanel); // group them
        add(actionPane);
    }
}
