package Ch06_Methods;

/**
 * Give the method header for each of the following methods:
 *
 * @author David
 */
public class Ex06_04_Hypotenuse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    // method hypotenuse, which takes two double-precision, 
    // floating-point arguments side1 and side2 and returns a 
    // double-precision, floating-point result.
    private static double hypotenuse(float side1, float side2) {
        // return Math.sqrt(side1*side1 + side2*side2);
        // return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        return Math.hypot(side1, side2);
    }

    // method smallest, which takes three integers x,y and z and
    // returns an integer
    private static int smallest(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    // method instructions, which does not take any arguments and
    // does not return a value. [Note: such methods are commonly
    // used to display instructions to a user.]
    private static void instructions() {
        System.out.println("Read the following question carefully.");
    }

    // method intToFloat, which takes integer argument number 
    // and returns a float.
    private static float intToFloat(int number) {
        return (float) number;
    }
}
