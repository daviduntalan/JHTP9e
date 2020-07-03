package Ch06_Methods;

/**
 * Table of Binary, Octal and Hexadecimal Numbers. Write an application that
 * displays a table of the binary, octal and hexadecimal equivalents of the
 * decimal numbers in the range 1 through 256. If you aren't familiar with these
 * number systems, read Appendix H first
 *
 * @author David
 */
public class Ex06_34_TableOfBinOctHex {
    
    final static int BIN = 2;
    final static int OCT = 8;
    final static int HEX = 16;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // prin the header of the number system
        System.out.printf("%10s%10s%10s%10s\n", 
                "Decimal", "Binary", "Octa", "Hexa");
        
        // prin the body of the number system
        for (int decNum = 1; decNum < 256; ++decNum) {            
            System.out.printf("%10d%10s%10s%10s\n", decNum,
                    toNumberSystem(decNum, BIN),
                    toNumberSystem(decNum, OCT),
                    toNumberSystem(decNum, HEX)
            );
        }
    }

    private static String toNumberSystem(int decimal, int radix) {
        int remainder;
        String out = "";
        while (decimal > 0) {
            remainder = decimal % radix;
            switch (remainder) {
                case 10: out = "A" + out; break;
                case 11: out = "B" + out; break;
                case 12: out = "C" + out; break;
                case 13: out = "D" + out; break;
                case 14: out = "E" + out; break;
                case 15: out = "F" + out; break;
                default: out = remainder + out;
            } 
            decimal /= radix;
        }
        
        // if binary, fill with leading zeros
        // if (radix == BIN) out = String.format("%08d", Integer.valueOf(out));
        
        return out; // return the result to the caller.
    }

}
