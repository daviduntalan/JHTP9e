package Ch06_Methods;

import java.awt.Point;

/**
 * Distance Between Points. Write method distance to calculate the distance
 * between two points (x1, y1) and (x2, y2). All numbers and return values
 * should be of type double. Incorporate this method into an application that
 * enables the user to enter the coordinates of the points.
 */
public class Ex06_32_DistanceBetweenPoints {

    public static void main(String[] args) {

        System.out.printf("\nHypotenuse(4, 3): %f\n", hypotenuse(4, 3));

        Point point1 = new Point(10, 10);
        Point point2 = new Point(50, 40);
        double distance = distance(point1, point2);
        
        System.out.printf("\nThe distance between\n%s and\n%s is %.2f\n", 
                point1, point2, distance);

    }

    private static double distance(Point p1, Point p2) {
        double xSideDiff = p2.getX() - p1.getX();
        double ySideDiff = p2.getY() - p1.getY();
        return hypotenuse(xSideDiff, ySideDiff);
    }

    private static double hypotenuse(double side1, double side2) {
        return Math.sqrt(side1 * side1 + side2 * side2);
        // return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        // return Math.hypot(side1, side2);
    }

}

/* Sample run:
Hypotenuse(4, 3): 5.000000

The distance between
java.awt.Point[x=10,y=10] and
java.awt.Point[x=50,y=40] is 50.00
BUILD SUCCESSFUL (total time: 0 second
*/