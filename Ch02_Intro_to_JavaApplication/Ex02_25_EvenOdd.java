package Ch02_Intro_to_JavaApplication;

/**
 * Odd or Even
 * @author David
 */
public class Ex02_25_EvenOdd {

    public static void main(String[] args) {
        
        int number = 10;
        
        if (number % 2 == 0) {
            System.out.printf("%d is even\n", number);
        } else {
            System.out.printf("%d is odd\n", number);
        }

                
    }

}
