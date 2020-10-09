package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;

public class AlignFrame extends JFrame {

    private JCheckBox snapToGrid;
    private JCheckBox showGrid;
    private JLabel xLabel;
    private JLabel yLabel;
    private JTextField xTextField;
    private JTextField yTextField;
    private JButton btnOK;
    private JButton btnCancel;
    private JButton btnHelp;
    private JPanel checkBoxesPanel;
    private JPanel coordinatePanel;
    private JPanel actionCmdsPanel;

    public AlignFrame() throws HeadlessException {

        super("Align");
        setLayout( new FlowLayout(FlowLayout.CENTER) );
        checkBoxesPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        coordinatePanel = new JPanel(new GridLayout(2, 2, 0, 5));
        actionCmdsPanel = new JPanel(new GridLayout(3, 1, 0, 5));

        snapToGrid = new JCheckBox("Snap to Grid");
        showGrid = new JCheckBox("Show Grid");

        xLabel = new JLabel("X: "); xTextField = new JTextField(3);
        yLabel = new JLabel("Y: "); yTextField = new JTextField(3);

        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");
        btnHelp = new JButton("Help");

        checkBoxesPanel.add(snapToGrid); // added to col1, row1
        checkBoxesPanel.add(showGrid);   // added to col1, row2

        // labels are contained in a panel so we can align it right
        JPanel xPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel yPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        xPanel.add(xLabel);
        yPanel.add(yLabel);
        coordinatePanel.add(xPanel);     // added to col1 row1
        coordinatePanel.add(xTextField); // added to col2 row1
        coordinatePanel.add(yPanel);     // added to col1 row2
        coordinatePanel.add(yTextField); // added to col2 row2

        actionCmdsPanel.add(btnOK);      // added to col1 row1
        actionCmdsPanel.add(btnCancel);  // added to col1 row2
        actionCmdsPanel.add(btnHelp);    // added to col1 row3

        // added to JFrame with FlowLayout (L-F, centered each panel)
        add(checkBoxesPanel);
        add(coordinatePanel);
        add(actionCmdsPanel);
    }
}
