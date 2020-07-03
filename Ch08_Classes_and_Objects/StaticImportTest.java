package Ch08_Classes_and_Objects;
import static java.lang.Math.*;
/**
 * Fig. 8.14: Static import of Math class methods.
 * @author David
 */
public class StaticImportTest {

    public static void main(String[] args) {
        System.out.printf("sqrt(900.0) = %.1f\n", sqrt(900.0));
        System.out.printf("ceil(-9.8) = %.1f\n", ceil(-9.8));
        System.out.printf("E = %f\n", E);
        System.out.printf("PI = %f\n", PI);
        System.out.printf("log(E) = %.1f\n", log(E));
        System.out.printf("cos(0.0) = %.1f\n", cos(0.0));
    }
    
}
