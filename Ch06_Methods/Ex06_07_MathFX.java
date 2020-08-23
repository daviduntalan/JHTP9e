package Ch06_Methods;

/**
 * Test math function results.
 * @author David
 */
public class Ex06_07_MathFX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(Math.abs(7.5)); // 7.5
        System.out.println(Math.floor(7.5)); // 7.0
        System.out.println(Math.abs(0.0)); // 0.0
        System.out.println(Math.ceil(0.0)); // 0.0
        System.out.println(Math.abs(-6.4)); // 6.4
        System.out.println(Math.ceil(-6.4)); // -6.0        
        System.out.println(Math.ceil(-Math.abs(-8 + Math.floor(-5.5)))); // -14.0
        
    }
    
}
