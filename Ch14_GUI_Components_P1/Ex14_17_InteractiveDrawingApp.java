package Ch14_GUI_Components_P1;

import Ch10_OOP_Polymorphism.MyLine;
import Ch10_OOP_Polymorphism.MyOval;
import Ch10_OOP_Polymorphism.MyRectangle;
import Ch10_OOP_Polymorphism.MyShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Ex 14.17 (Interactive Drawing Application) In this exercise, you’ll implement a GUI application
 * that uses the MyShape hierarchy from GUI and Graphics Case Study Exercise 10.2 to create an interactive
 * drawing application. You’ll create two classes for the GUI and provide a test class that
 * launches the application. The classes of the MyShape hierarchy require no additional changes.
 *
 * The first class to create is a subclass of JPanel called DrawPanel, which represents the area on
 * which the user draws the shapes. Class DrawPanel should have the following instance variables:
 * a) An array shapes of type MyShape that will store all the shapes the user draws.
 * b) An integer shapeCount that counts the number of shapes in the array.
 * c) An integer shapeType that determines the type of shape to draw.
 * d) A MyShape currentShape that represents the current shape the user is drawing.
 * e) A Color currentColor that represents the current drawing color.
 * f) A boolean filledShape that determines whether to draw a filled shape.
 * g) A JLabel statusLabel that represents the status bar. The status bar will display the coordinates
 * of the current mouse position.
 *
 * Class DrawPanel should also declare the following methods:
 * a) Overridden method paintComponent that draws the shapes in the array. Use instance
 * variable shapeCount to determine how many shapes to draw. Method paintComponent
 * should also call currentShape’s draw method, provided that currentShape is not null.
 * b) Set methods for the shapeType, currentColor and filledShape.
 * c) Method clearLastShape should clear the last shape drawn by decrementing instance
 * variable shapeCount. Ensure that shapeCount is never less than zero.
 * d) Method clearDrawing should remove all the shapes in the current drawing by setting
 * shapeCount to zero.
 *
 * Methods clearLastShape and clearDrawing should call repaint (inherited from JPanel) to refresh
 * the drawing on the DrawPanel by indicating that the system should call method paintComponent.
 * Class DrawPanel should also provide event handling to enable the user to draw with the
 * mouse. Create a single inner class that both extends MouseAdapter and implements MouseMotion-
 * Listener to handle all mouse events in one class.
 *
 * In the inner class, override method mousePressed so that it assigns currentShape a new shape
 * of the type specified by shapeType and initializes both points to the mouse position. Next, override
 * method mouseReleased to finish drawing the current shape and place it in the array. Set the second
 * point of currentShape to the current mouse position and add currentShape to the array. Instance
 * variable shapeCount determines the insertion index. Set currentShape to null and call method
 * repaint to update the drawing with the new shape.
 *
 * Override method mouseMoved to set the text of the statusLabel so that it displays the mouse
 * coordinates—this will update the label with the coordinates every time the user moves (but does
 * not drag) the mouse within the DrawPanel. Next, override method mouseDragged so that it sets the
 * second point of the currentShape to the current mouse position and calls method repaint. This
 * will allow the user to see the shape while dragging the mouse. Also, update the JLabel in mouse-
 * Dragged with the current position of the mouse.
 *
 * Create a constructor for DrawPanel that has a single JLabel parameter. In the constructor, initialize
 * statusLabel with the value passed to the parameter. Also initialize array shapes with 100
 * entries, shapeCount to 0, shapeType to the value that represents a line, currentShape to null and
 * currentColor to Color.BLACK. The constructor should then set the background color of the Draw-
 * Panel to Color.WHITE and register the MouseListener and MouseMotionListener so the JPanel
 * properly handles mouse events.
 *
 * Next, create a JFrame subclass called DrawFrame that provides a GUI that enables the user to
 * control various aspects of drawing. For the layout of the DrawFrame, we recommend a BorderLayout,
 * with the components in the NORTH region, the main drawing panel in the CENTER region, and a
 * status bar in the SOUTH region, as in Fig. 14.49. In the top panel, create the components listed
 * below. Each component’s event handler should call the appropriate method in class DrawPanel.
 * a) A button to undo the last shape drawn.
 * b) A button to clear all shapes from the drawing.
 * c) A combo box for selecting the color from the 13 predefined colors.
 * d) A combo box for selecting the shape to draw.
 * e) A checkbox that specifies whether a shape should be filled or unfilled.
 *
 * Declare and create the interface components in DrawFrame’s constructor. You’ll need to create
 * the status bar JLabel before you create the DrawPanel, so you can pass the JLabel as an argument
 * to DrawPanel’s constructor. Finally, create a test class that initializes and displays the DrawFrame to
 * execute the application.
 */

/**
 * Enhanced Fig. 8.19: Program that uses class MyShape to draw selected shape(s).
 * @author David
 */
class DrawPanel extends JPanel {

    private MyShape[] shapes; // will store all the shapes the user draws
    private int shapeCount, tempCount; // counts the number of shapes in the array
    private int shapeType; // determines the type of shape to draw
    private MyShape currentShape; // represents the current shape the user is drawing
    private Color currentColor; // represents the current drawing color
    private boolean filledShape; // determines whether to draw a filled shape
    private JLabel statusLabel; // represents the status bar. will display the coordinates of the current mouse position.

    private Random random = new Random();
    private MyLine[] lines; // array of lines

    // constructor, creates a panel with selected shapes
    public DrawPanel(JLabel statusLabel) {

        this.statusLabel = statusLabel;
        shapes = new MyShape[100];
        shapeCount = 0;
        shapeType = 0; // represent a MyLine
        currentShape = null;
        currentColor = Color.BLACK;
        setBackground(Color.WHITE);

        MyMouseHandler myMouseHandler = new MyMouseHandler();
        addMouseListener(myMouseHandler);
        addMouseMotionListener(myMouseHandler);
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void setFilledShape(boolean filledShape) {
        this.filledShape = filledShape;
    }

    // clear the last shape drawn
    public void clearLastShape() {

        if (shapeCount > 0) {
            shapeCount--;
        }
        repaint(); // to refresh the drawing on the DrawPanel
    }

    // remove all the shapes in the current drawing
    public void clearDrawing() {
        shapeCount = 0;
        repaint(); // to refresh the drawing on the DrawPanel
    }

    @Override // for each shape array, draw the individual shapes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < shapeCount; ++i) {
            shapes[i].draw(g); // call appropriate method of shape
        }
    }

    /**
     * inner class that both extends MouseAdapter and implements MouseMotionListener
     * to handle all mouse events. */
    private class MyMouseHandler extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {

            // if (currentShape != null) return;
            /* assigns currentShape a new shape of the type specified by
            shapeType and initializes both points to the mouse position */
            int x1 = e.getX(); int y1 = e.getY();
            switch (shapeType) {
                case 0: currentShape = new MyRectangle(x1, y1, x1, y1, currentColor, filledShape); break;
                case 1: currentShape = new MyOval(x1, y1, x1, y1, currentColor, filledShape); break;
                case 2: currentShape = new MyLine(x1, y1, x1, y1, currentColor); break;
                default: JOptionPane.showMessageDialog(DrawPanel.this,
                        "OMG! No shape has been selected.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            tempCount = shapeCount; // capture shapeCount
        }

        @Override
        public void mouseReleased(MouseEvent e) {

            if (currentShape == null) return;
            shapeCount = tempCount; // restore shapeCount

            currentShape.setX2( e.getX() );
            currentShape.setY2( e.getY() );
            if (shapeCount < shapes.length) {
                shapes[shapeCount++] = currentShape;
            }
            currentShape = null; // clear the temporary drawing shape
            repaint(); // update the drawing with the new shape
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            statusLabel.setText(String.format("(%d, %d)", e.getX(), e.getY()));
        }

        @Override // allow the user to see the shape while dragging the mouse.
        public void mouseDragged(MouseEvent e) {

            if (currentShape == null) return;

            currentShape.setX2( e.getX() );
            currentShape.setY2( e.getY() );
            if (shapeCount < shapes.length) {
                shapes[shapeCount++] = currentShape;
            }
            mouseMoved(e); // update status of the current mouse location
            repaint(); // update the drawing with the current shape
        }
    } // end of inner class MyMouseHandler
} // end of class DrawPanel


class DrawFrame extends JFrame {

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

public class Ex14_17_InteractiveDrawingApp {

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

        DrawFrame drawFrame = new DrawFrame();
        drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawFrame.setSize(600,480);
        drawFrame.setLocationRelativeTo(null);
        drawFrame.setVisible( true );
    }

} // end of Exercise 14.17