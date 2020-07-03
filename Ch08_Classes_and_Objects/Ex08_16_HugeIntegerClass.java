package Ch08_Classes_and_Objects;

/**
 * Huge Integer Class. create a class HugeInteger which uses a 40-element
 * digits to store integers as large as 40 digits each. Provide method
 * parse, toString, add and subtract. Method parse should receive a
 * String, extract each digit using method charAt and place the integer
 * equivalent of each digit into the integer array. For comparing 
 * HugeInteger objects, provide he following methods: isEqualTo, 
 * isNotEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo
 * and isLessThanOrEqualTo. Each of these is a predicate method that 
 * returns true if the relationship holds between the two HugeInteger 
 * objects and returns false if the relationship does not hold. 
 * Provide a predicate method isZero. If you feel ambitious, also 
 * provide methods multiply, divide and remainder. [Note: Primitive 
 * boolean values can be output as the word “true” or the word “false” 
 * with format specifier %b.]
 */
public class Ex08_16_HugeIntegerClass {

    public static void main(String[] args) {

        String n1 = "9999999999999999999999999999999999999999";
        String n2 = "9999999999999999999999999999999999999999";
        HugeInteger h1 = new HugeInteger();
        HugeInteger h2 = new HugeInteger();
        h1.parse(n1);
        h2.parse(n2);
        System.out.printf("h1: %40s\n", h1);
        System.out.printf("h2: %40s\n", h2);
        System.out.printf("h1 == h2 ? %b\n", h1.isEqualTo(h2));
        System.out.printf("h1 != h2 ? %b\n", h1.isNotEqualTo(h2));
        System.out.printf("h1  > h2 ? %b\n", h1.isGreaterThan(h2));
        System.out.printf("h1 >= h2 ? %b\n", h1.isGreaterThanOrEqual(h2));
        System.out.printf("h1  < h2 ? %b\n", h1.isLessThan(h2));
        System.out.printf("h1 =< h2 ? %b\n", h1.isLessThanOrEqual(h2));
        System.out.printf("h1 + h2 ? %s\n", h1.add(h2));
        System.out.printf("h1 - h2 ? %s\n", h1.subtract(h2));
    }
    
}

class HugeInteger {
    private final int SIZE = 40;
    private final int[] digits; // 40-element of digits to store integers

    public HugeInteger() {
        digits = new int[SIZE];
    }
   
    public void parse(String s) {
        // validate for its size
        if (s.length() > SIZE) { 
            System.err.println("more than i can accept.");
            return;
        }
        // validate for its integrity, 
        // could be integrate to the following to lesser the codes,
        // but i choose to separate the concern
        for (int i = 0; i < s.length(); ++i) {
            int digit = s.charAt(i) - 48;
            if (digit < 0 || digit > 9) {
                System.out.printf("invalid digit at index: %d", i);
                return; 
            }
        }        
        // stores only the valid digits
        int j = SIZE - 1; // starting from right to left
        for (int i = s.length()-1; i > -1; --i) {
            int digit = s.charAt(i) - 48;            
            digits[j] = digit; --j;
        }
    }
    
    public boolean isEqualTo(HugeInteger hi) {
        if (toString().length() != hi.toString().length())
            return false;
        for (int i = SIZE - 1; i > -1; --i) {
            if (digits[i] == hi.digits[i]) {                                
            } else return false;
        }
        return true; 
    }
    
    public boolean isNotEqualTo(HugeInteger hi) {
       return !isEqualTo(hi);
    }
    
    public boolean isGreaterThan(HugeInteger hi) {
        if (toString().length() > hi.toString().length())
            return true;
        for (int i = SIZE - 1; i > -1; --i) {
            if (digits[i] > hi.digits[i])
            ; else return false;
        }
        return true; 
    }
    
    public boolean isLessThan(HugeInteger hi) {
        if (toString().length() < hi.toString().length())
            return true;
        for (int i = SIZE - 1; i > -1; --i) {
            if (digits[i] < hi.digits[i])
            ; else return false;
        }
        return true; 
    }
    
    public boolean isGreaterThanOrEqual(HugeInteger hi) {
        for (int i = SIZE - 1; i > -1; --i) {
            if (digits[i] >= hi.digits[i]) {                
            } else return false;
        }
        return true; 
    }
    
    public boolean isLessThanOrEqual(HugeInteger hi) {
        for (int i = SIZE - 1; i > -1; --i) {
            if (digits[i] <= hi.digits[i]) {                
            } else return false;
        }
        return true; 
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int startingIndex = 0;
        // search for non-zero prefix index to extract digits
        for (; startingIndex < SIZE; ++startingIndex) {
            if (digits[startingIndex] != 0) {
                for (int i = startingIndex; i < SIZE; ++i) 
                    sb.append(digits[i]).append("");
                startingIndex = SIZE; // break the loop
            } // end if
        } // end for
        return String.format("%s", sb.toString());
    }       

    public HugeInteger add(HugeInteger h2) {
        int h1size = toString().length();
        int h2size = h2.toString().length();
        int MAX = Math.max(h1size, h2size);
        StringBuilder result = new StringBuilder();
        // work within the minimum length of the two HugeInteger
        for (int i = 0; i < MAX; ++i) {
            // TODO add them all together.
            // co = "                        1111111111111100";
            // h1 = "9999999999999999999999999999999999999999";
            // h2 = "+ pad with zeros 00000000678901234567890";
            // rs = "                         678901234567889";
        }
        HugeInteger sum = new HugeInteger();
        sum.parse(result.toString());
        return sum;
    }

    public HugeInteger subtract(HugeInteger h2) {
        int h1size = toString().length();
        int h2size = h2.toString().length();
        int MAX = Math.max(h1size, h2size);
        StringBuilder result = new StringBuilder();        
        for (int i = 0; i < MAX; ++i) {
            
        }
        HugeInteger diff = new HugeInteger();
        diff.parse(result.toString());
        return diff;
    }
}