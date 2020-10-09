package Ch14_GUI_Components_P1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DrawFrame extends JFrame {

    private final JPanel menuPane;
    private final DrawPanel drawPanel;
    private final JPanel statusPane;
    private final JButton btnUndo;
    private final JButton btnClear;
    private final JComboBox cboColor;
    private final JComboBox cboShape;
    private final String[] colorNames = {
            "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray",
            "Magenta", "Orange", "Pink", "Red", "White", "Yellow"
    };
    private final String[] shapeNames = {
            "Rectangle", "Oval", "Line"
    };
    private final Color[] colors = {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
            Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
            Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };
    private final JCheckBox chkField;
    private final JLabel lblStatus;

    public DrawFrame() {
        super("Java Drawing App");

        lblStatus = new JLabel("Status: Coordinates (X & Y) are written here.");
        menuPane = new JPanel(new FlowLayout());
        drawPanel = new DrawPanel(lblStatus); // content pane with passed reference
        statusPane = new JPanel(new FlowLayout(FlowLayout.LEFT));

        btnUndo = new JButton("Undo");
        btnClear = new JButton("Clear");
        cboColor = new JComboBox(colorNames);
        cboShape = new JComboBox(shapeNames);
        chkField = new JCheckBox("Filled");

        attachEventHandler();

        menuPane.add(btnUndo);
        menuPane.add(btnClear);
        menuPane.add(cboColor);
        menuPane.add(cboShape);
        menuPane.add(chkField);

        statusPane.add(lblStatus);

        add(menuPane, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusPane, BorderLayout.SOUTH);
    }

    private void attachEventHandler() {

        btnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.clearLastShape();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.clearDrawing();
            }
        });

        // combo box for selecting the color from the 13 predefined colors
        cboColor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int selectedColorIndex = cboColor.getSelectedIndex();
                    drawPanel.setCurrentColor( colors[selectedColorIndex] );
                }
            }
        });

        // combo box for selecting the shape to draw
        cboShape.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int selectedShapeIndex = cboShape.getSelectedIndex();
                    drawPanel.setShapeType( selectedShapeIndex );
                }
            }
        });

        // specifies whether a shape should be filled or unfilled
        chkField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                drawPanel.setFilledShape( chkField.isSelected() );
            }
        });
    }
}