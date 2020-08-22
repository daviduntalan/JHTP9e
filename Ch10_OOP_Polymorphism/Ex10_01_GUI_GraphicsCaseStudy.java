package Ch10_OOP_Polymorphism;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Ex.10.01: GUI and Graphics Case Study Exercises.
 * Modify the MyLine, MyOval and MyRectangle classes of GUI and Graphics Case Study
 * Exercise 8.1 and Exercise 9.1 to create the class hierarchy in Fig. 10.17. Classes of the MyShape hierarchy
 * should be “smart” shape classes that know how to draw themselves (if provided with a
 * Graphics object that tells them where to draw). Once the program creates an object from this hierarchy,
 * it can manipulate it polymorphically for the rest of its lifetime as a MyShape.
 * In your solution, class MyShape in Fig. 10.17 must be abstract. Since MyShape represents any
 * shape in general, you cannot implement a draw method without knowing exactly what shape it is.
 * The data representing the coordinates and color of the shapes in the hierarchy should be declared
 * as private members of class MyShape. In addition to the common data, class MyShape should
 * declare the following methods:
 * a) A no-argument constructor that sets all the coordinates of the shape to 0 and the color to Color.BLACK.
 * b) A constructor that initializes the coordinates and color to the values of the arguments supplied.
 * c) Set methods for the individual coordinates and color that allow the programmer to set
 *    any piece of data independently for a shape in the hierarchy.
 * d) Get methods for the individual coordinates and color that allow the programmer to retrieve
 *    any piece of data independently for a shape in the hierarchy.
 * e) The abstract method
 * 
 * public abstract void draw( Graphics g );
 * 
 * which the program’s paintComponent method will call to draw a shape on the screen.
 * To ensure proper encapsulation, all data in class MyShape must be private. This requires
 * declaring proper set and get methods to manipulate the data. Class MyLine should provide a noargument
 * constructor and a constructor with arguments for the coordinates and color. Classes
 * MyOval and MyRectangle should provide a no-argument constructor and a constructor with arguments
 * for the coordinates, color and determining whether the shape is filled. The no-argument
 * constructor should, in addition to setting the default values, set the shape to be an unfilled shape.
 * 
 * You can draw lines, rectangles and ovals if you know two points in space. Lines require x1, y1,
 * x2 and y2 coordinates. The drawLine method of the Graphics class will connect the two points
 * supplied with a line. If you have the same four coordinate values (x1, y1, x2 and y2) for ovals and
 * rectangles, you can calculate the four arguments needed to draw them. Each requires an upper-left
 * x-coordinate value (the smaller of the two x-coordinate values), an upper-left y-coordinate value
 * (the smaller of the two y-coordinate values), a width (the absolute value of the difference between
 * the two x-coordinate values) and a height (the absolute value of the difference between the two 
 * y-coordinate values). Rectangles and ovals should also have a filled flag that determines whether to
 * draw the shape as a filled shape.
 * 
 * There should be no MyLine, MyOval or MyRectangle variables in the program—only MyShape
 * variables that contain references to MyLine, MyOval and MyRectangle objects. The program should
 * generate random shapes and store them in an array of type MyShape. Method paintComponent
 * should walk through the MyShape array and draw every shape (i.e., polymorphically calling every
 * shape’s draw method).
 * 
 * Allow the user to specify (via an input dialog) the number of shapes to generate. The program
 * will then generate and display the shapes along with a status bar that informs the user how many of
 * each shape were created.
 * 
 * @author David
 */
public class Ex10_01_GUI_GraphicsCaseStudy {

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
