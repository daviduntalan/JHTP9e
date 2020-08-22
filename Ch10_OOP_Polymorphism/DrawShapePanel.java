package Ch10_OOP_Polymorphism;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author David
 */

enum RandomShape { LINE, OVAL, RECTANGLE };

public class DrawShapePanel extends JPanel {
    
    private Random random = new Random();
    private MyShape[] shapes; // array of shapes        
    private int lineCounts;
    private int ovalCounts;
    private int rectCounts;
    
    // constructor, creates a panel with random shapes
    public DrawShapePanel() {
        
        setBackground(Color.WHITE);
        inputNumberOfShapeToGenerate();         
        
        // create random values for shapes
        for (int count = 0; count < shapes.length; ++count) {
            
            int value = 10 + random.nextInt( 600 ); // +10 to avoid div/0
            // generate random coordinates
            int x = random.nextInt(value) - value/2;
            int y = random.nextInt(value) - value/2;
            int w = random.nextInt(value) + value/2;
            int h = random.nextInt(value) + value/2;            
            
            // generate a random color
            Color color = new Color( 
                random.nextInt(256), // RGB values
                random.nextInt(256),  
                random.nextInt(256)
            );
            
            generateRandomShapes(count, x, y, w, h, color);
            
        } // end for
    }

    private void inputNumberOfShapeToGenerate() throws HeadlessException {
        int numberOfShape = 0;
        
        do {
            try {
                String inputValue = JOptionPane.showInputDialog(this,
                        "Enter the number of hapes to generate", "Type the number of shape here");
                numberOfShape = Integer.parseInt(inputValue);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                numberOfShape = 0;
            }
        } while (numberOfShape <= 0);
        
        shapes = new MyShape[numberOfShape];
    }

    private void generateRandomShapes(int count, int x, int y, int w, int h, Color color) {
        
        RandomShape[] randomShape = new RandomShape[] {
            RandomShape.LINE,
            RandomShape.OVAL,
            RandomShape.RECTANGLE
        };
        
        int randomIndex = random.nextInt(3);
        switch (randomShape[randomIndex]) {
            case LINE:
                shapes[count] = new MyLine(x, y, w, h, color);
                System.out.printf("Line creation...%d\n", ++lineCounts);
                break;
            case OVAL:
                shapes[count] = new MyOval(x, y, w, h, color, random.nextBoolean());
                System.out.printf("Oval creation...%d\n", ++ovalCounts);
                break;
            case RECTANGLE:
                shapes[count] = new MyRectangle(x, y, w, h, color, random.nextBoolean());
                System.out.printf("Rect creation...%d\n", ++rectCounts);
                break;
        }
    }
    
    @Override // for each shape array, draw the individual shapes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // draw the lines
        for (MyShape shape : shapes) {
            shape.draw(g); // we passed Graphics g object 
            // for drawing (lines) on the panel 
        }
    }

    public int getLineCounts() { return lineCounts; }
    public int getOvalCounts() { return ovalCounts; }
    public int getRectCounts() { return rectCounts; }
}
