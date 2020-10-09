package Ch14_GUI_Components_P1;

import Ch10_OOP_Polymorphism.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

/**
 * Enhanced Fig. 8.19: Program that uses class MyShape to draw selected shape(s).
 * @author David
 */
public class DrawPanel extends JPanel {

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
