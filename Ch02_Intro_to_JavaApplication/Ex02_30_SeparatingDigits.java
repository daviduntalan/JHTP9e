package Ch02_Intro_to_JavaApplication;

/**
 * Separating the Digits in an Integer.
 * @author David
 */
public class Ex02_30_SeparatingDigits {

    public static void main(String[] args) {
        
        int number = 42339;
        int e = number % 10; number = number / 10;
        int d = number % 10; number = number / 10;
        int c = number % 10; number = number / 10;
        int b = number % 10; number = number / 10;
        int a = number % 10; 
        
        System.out.printf("%d %d %d %d %d\n", a, b, c, d, e);
    }
    
}
