package Ch04_Control_Statements_P1;

import java.math.BigDecimal;

/**
 * Primitive Types. 
 * See also, https://en.wikipedia.org/wiki/Names_of_large_numbers
 * @author David
 */
public class PrimitiveTypes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.printf("Byte range: %d to %d\n", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("Short range: %,d to %,d\n", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("Integer range: %,d to %,d\n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("Long range: %,d to %,d\n", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("Float range: %,f to %,f\n", Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("Double range: %,f to %,f\n", Double.MIN_VALUE, Double.MAX_VALUE);
    }
    
}
