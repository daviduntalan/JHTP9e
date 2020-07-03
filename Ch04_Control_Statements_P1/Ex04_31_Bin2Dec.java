package Ch04_Control_Statements_P1;

/**
 * Binary to Decimal. Printing the Decimal Equivalent of a Binary Number. See:
 * f:/tc/source/rgb2hex.cpp
 *
 * @author David
 */

public class Ex04_31_Bin2Dec {

    public static void main(String args[]) {        
        long binaryd = 101010111110101111L;
        long decimal = 0; System.out.println(binaryd);
        // remainder is multiply by pos then add to decimal
        for (int pos = 0; binaryd > 0; ++pos) {            
            decimal |= binaryd % 10 << pos;
            binaryd /= 10;
        }
        System.out.println(decimal);
        System.out.println(Integer.parseInt("101010111110101111", 2));
    }
}
