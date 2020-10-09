package Ch14_GUI_Components_P1;

import javax.swing.*;

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