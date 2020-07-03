package Ch04_Control_Statements_P1;

/**
 * Prefix increment and postfix increment operators.
 * Fig. 4.15
 *
 * @author David
 */
public class Increment {

    public static void main(String[] args) {
        
        int c;
        
        c = 5;
        System.out.println(c); // 5
        System.out.println(c++); // 5
        System.out.println(c); // 6
        
        System.out.println();
        
        c = 5;
        System.out.println(c); // 5
        System.out.println(++c); // 6
        System.out.println(c); // 6
    }
}
