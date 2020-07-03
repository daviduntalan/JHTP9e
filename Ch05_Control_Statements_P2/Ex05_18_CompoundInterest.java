package Ch05_Control_Statements_P2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** 
 * Modified Compound-Interest Program. Modify the app in Fig. 5.6 to
 * use only integers to calculate the compound interest. [Hint: Treat
 * all monetary amounts as integral numbers of pennies. Then break 
 * the result into its dollars and cents portion by using the division
 * and remainder operations, respectively. Insert a period between the 
 * dollars and the cents portions.]
 * 
 * @author David
 */
public class Ex05_18_CompoundInterest {

    public static void main(String[] args) {

        /* 
        how could i make my precision right without changing my item's value? 
        it gives me incorrect display: 
        
          14.23
        + 18.67
        = 32.91                
        
        my book suggested me of using BigDecimal but i don't know
        how to use it. :( 
        i want to turn it into the following result instead:
        
          14.23
        + 18.67
        = 32.90                
        */
        /*
        double item1 = 14.234;
        double item2 = 18.673;
        double total = item1 + item2;
        */
        
        BigDecimal item1 = new BigDecimal(Double.toString(14.234));
        BigDecimal item2 = new BigDecimal(Double.toString(18.673));
        BigDecimal total = new BigDecimal(
                item1.setScale(2, RoundingMode.FLOOR).doubleValue() + 
                item2.setScale(2, RoundingMode.FLOOR).doubleValue()
        );
        
        System.out.printf("  %.2f\n", item1);
        System.out.printf("+ %.2f\n", item2);
        System.out.printf("= %.2f\n", total);
                
        /*       
        14.23
      + 18.67
      = 32.91
        */
        System.out.println("-------");
        
        double a = 14.234 * 100;
        double b = 18.673 * 100;
        double c = a + b;
        
        System.out.printf("a: %f\n", a);
        System.out.printf("b: %f\n", b);
        System.out.printf("c: %f\n", c);
        
        System.out.printf("  %d.%d\n", (int)a/100, (int)a%100);
        System.out.printf("+ %d.%d\n", (int)b/100, (int)b%100);
        System.out.printf("= %d.%d\n", (int)c/100, (int)c%100);
        
    }

}
