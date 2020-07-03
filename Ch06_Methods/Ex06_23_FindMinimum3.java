package Ch06_Methods;

/**
 *
 * @author David
 */
public class Ex06_23_FindMinimum3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float a = 34.5f;
        float b = 23.6f;
        float c = 43.8f;
        
        System.out.printf("Minimum among: %.1f, %.1f and %.1f is %.1f\n", 
                a, b, c, minimum3(a, b, c));
    }
    
    private static float minimum3(float a, float b, float c) {
        return Math.min(a, Math.min(b, c));
    }
    
}
