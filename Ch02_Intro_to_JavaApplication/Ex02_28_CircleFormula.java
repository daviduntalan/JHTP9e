package Ch02_Intro_to_JavaApplication;

/**
 * Diameter, Circumference and Area of a Circle.
 * @authsor David
 */
public class Ex02_28_CircleFormula {

    public static void main(String[] args) {

        double radius = 14;
        double diameter = 2 * radius;
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;
        System.out.printf("radius: %f\n"
                + "diameter: %f\n"
                + "circumference: %f\n"
                + "area: %f\n", radius,
                diameter, circumference, area);
    }

}
