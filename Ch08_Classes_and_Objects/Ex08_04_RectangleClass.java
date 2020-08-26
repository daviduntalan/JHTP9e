package Ch08_Classes_and_Objects;

/**
 * Crate a class Rectangle with attribute length and width, each of which
 * defaults to 1. Provide methods that calculate the rectangle's perimeter and
 * area.
 */
public class Ex08_04_RectangleClass {

    public static void main(String[] args) {
        
        try {
            Rectangle myRectangle = new Rectangle(19.9f, 15f);        
            System.out.println(myRectangle);
        } catch(IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }
}