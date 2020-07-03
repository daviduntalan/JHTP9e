package Ch06_Methods;

/**
 * Overload method declaration.
 * Declaring overloaded methods with identical parameter lists is a 
 * compilation error regardless of whether the return types are different.
 * Fig. 6.10
 * @author David
 */
public class MethodOverload {

    /**
     * test overloaded square methods
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("Square of integer 7 is %d\n", square(7));
        System.out.printf("Square of integer 7.5 is %f\n", square(7.5));
    }

    
    private static int square(int intValue) {
        System.out.printf("\nCalled square with int argument: %d\n", 
                intValue);
        return intValue * intValue;
    }

    private static double square(double doubleValue) {
        System.out.printf("\nCalled square with double argument: %f\n", 
                doubleValue);
        return doubleValue * doubleValue;
    }
    
}
