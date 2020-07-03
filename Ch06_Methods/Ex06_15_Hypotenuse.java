package Ch06_Methods;

/**
 *
 * @author David
 */
public class Ex06_15_Hypotenuse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.printf("%8s%8s%8s%8s\n", "Triangle", "Side1", "Side2", "Result");
        System.out.printf("%8d%8.1f%8.1f%8.1f\n", 1, 3.0, 4.0, hypotenuse(3, 4));
        System.out.printf("%8d%8.1f%8.1f%8.1f\n", 2, 5.0, 12.0, hypotenuse(5, 12));
        System.out.printf("%8d%8.1f%8.1f%8.1f\n", 3, 8.0, 15.0, hypotenuse(8, 15));
    }

    private static double hypotenuse(double x, double y) {
        // return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return Math.hypot(x, y);
    }

}