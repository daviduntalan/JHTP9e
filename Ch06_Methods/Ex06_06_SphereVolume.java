package Ch06_Methods;

/**
 * Write a complete Java application to prompt the user for the double radius of
 * a sphere, and call method sphereVolume to calculate and display the volume of
 * the sphere. Use the following statement to calculate the volume:
 *
 * double volume (4.0/3.0) * Math.PI * Math.pow( radius, 3 );
 *
 * @author David
 */
public class Ex06_06_SphereVolume {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.printf("Enter radius of a sphere: ");
        double radius = new java.util.Scanner(System.in).nextDouble();
        System.out.printf("Volume of a sphere: %f\n", volumeOfSphere(radius));
    }

    private static double volumeOfSphere(double radius) {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        return volume;
    }

}
