package Ch06_Methods;

/**
 *
 * @author David
 */
public class Ex06_20_CircleArea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Random random = new java.util.Random();

        System.out.println("Compute the area of a circle");
        System.out.printf("Enter a radius of a circle: ");
        int radius = input.nextInt();
        System.out.printf("Area of a circle: %f\n", circleArea(radius));
        System.out.printf("Diameter of a circle: %f\n", diameter(radius));
        System.out.printf("Circumference of a circle: %f\n", circumference(radius));
    }

    private static double circleArea(int radius) {
        return  Math.PI * radius * radius;
    }
    
    private static double circumference(int radius) {
        return 2 * Math.PI * radius;
    }
    
    private static double diameter(int radius) {
        return 2 * radius;
    }

}
