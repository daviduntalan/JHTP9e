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

final class Rectangle {

    private float length = 1;
    private float width = 1;

    public Rectangle(float length, float width) {
        setLength(length);
        setWidth(width);
    }

    public float getPerimeter() {
        return length * 2 + width * 2;
    }
    public float getArea() {
        return length * width;
    }

    public float getLength() { return length; }
    public float getWidth() { return width; }

    public void setLength(float length) {
        if (length > 0.0 && length < 20.0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException(
                    "must be larger than 0.0 and less than 20.0.");
        }
    }

    public void setWidth(float width) {
        if (width > 0.0 && width < 20.0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException(
                    "must be larger than 0.0 and less than 20.0.");
        }
    }

    @Override
    public String toString() {
        return String.format( "Rectangle attributes:\n"
            + "Length: %.2f\n"
            + "Width: %.2f\n" 
            + "Perimeter: %.2f\n"
            + "Area: %.2f\n", 
            getLength(), getWidth(),
            getPerimeter(), getArea()
        );
    }
}
