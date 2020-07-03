package Ch02_Intro_to_JavaApplication;

/**
 * Negative, Positive and Zero Values.
 * @author David
 */
public class Ex02_32_CountNegZeroPos {

    public static void main(String[] args) {
        
        int n1 = 50;
        int n2 = -40;
        int n3 = 0;
        int n4 = -20;
        int n5 = 30;
        
        int negative = 0;
        int zero = 0;
        int positive = 0;
        
        
        if (n1 < 0) ++negative;
        if (n2 < 0) ++negative;
        if (n3 < 0) ++negative;
        if (n4 < 0) ++negative;
        if (n5 < 0) ++negative;
        System.out.printf("negative counts: %d\n", negative);
        
        if (n1 > 0) ++positive;
        if (n2 > 0) ++positive;
        if (n3 > 0) ++positive;
        if (n4 > 0) ++positive;
        if (n5 > 0) ++positive;
        System.out.printf("positive counts: %d\n", positive);
        
        if (n1 == 0) ++zero;
        if (n2 == 0) ++zero;
        if (n3 == 0) ++zero;
        if (n4 == 0) ++zero;
        if (n5 == 0) ++zero;
        System.out.printf("zero counts: %d\n", zero);
    }
    
}
