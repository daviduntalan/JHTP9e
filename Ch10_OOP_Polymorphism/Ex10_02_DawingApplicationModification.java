package Ch10_OOP_Polymorphism;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Ex.10.02: Drawing Application Modification.
 * 
 * In Exercise 10.1, you created a MyShape hierarchy in which classes
 * MyLine, MyOval and MyRectangle extend MyShape directly. If your
 * hierarchy was properly designed, you should be able to see the 
 * similarities between the MyOval and MyRectangle classes. 
 * Redesign and re-implement the code for the MyOval and MyRectangle
 * classes to "factor out" the common features into the abstract
 * class MyBoundedShape to produce the hierarchy in Fig. 10.18.
 * 
 * Class MyBoundedShape should declare two constructors that mimic
 * those of class MyShape, only with an added parameter to set whether the 
 * shape is filled. Class MyBoundedShape should also declare get and set 
 * methods for manipulating the filled flag and methods that calculate the 
 * upper left x-coordinate, upper left y-coordinate, width and height. 
 * Remember, the values needed to draw an oval or a rectangle can be 
 * calculated from two (x, y) coordinates. If designed properly, the new 
 * MyOval and MyRectangle classes should each have two constructors and a draw method.
 * 
 * @author David
 */
public class Ex10_02_DawingApplicationModification {

    public static void main(String[] args) {
                
        DrawShapePanel panel = new DrawShapePanel();                
        JFrame frame = new JFrame();        
        
        String shapeCounts = String.format("Lines: %d, Ovals: %d, Rectangle: %d", 
            panel.getLineCounts(), panel.getOvalCounts(), panel.getRectCounts());
        JLabel shapeCountsLabel = new JLabel(shapeCounts);
        
        frame.setTitle("Polymorphism in action using Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600+22);
        frame.add(panel);
        frame.add(shapeCountsLabel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
