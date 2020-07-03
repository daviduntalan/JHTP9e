package Ch05_Control_Statements_P2;

/**
 * Assume that i = 1, j = 2, k = 3 and m = 2. What does each of the 
 * following statements print?
 * @author David
 */
public class Ex05_19_BooleanLogic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i = 1, j = 2, k = 3, m = 2;
        System.out.println(i == 1); // true
        System.out.println(j == 3); // false
        System.out.println((i >= 1) && (j < 4)); // true
        System.out.println((m <= 99) & (k < 4)); // true
        System.out.println((j >= i) || (k == m)); // true
        System.out.println((k + m < j) | (3 - j >= k)); // false
        System.out.println(!(k > m)); // false
        
    }
    
}
