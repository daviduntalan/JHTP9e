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

        String n1 = "9999999999999999999999999999999999999990";
        String n2 = "9999999999999999999999999999999999999999";
        HugeInteger h1 = new HugeInteger();
        HugeInteger h2 = new HugeInteger();
        h1.parse(n1);
        h2.parse(n2);
        System.out.printf("      h1 : %41s\n", h1);
        System.out.printf("      h2 : %41s\n", h2);
        System.out.printf("h1  - h2 ? %41s\n", h1.subtract(h2));
        System.out.printf("h1  + h2 ? %41s\n", h1.add(h2));
        System.out.printf("h1 == h2 ? %b\n", h1.isEqualTo(h2));
        System.out.printf("h1 != h2 ? %b\n", h1.isNotEqualTo(h2));
        System.out.printf("h1  > h2 ? %b\n", h1.isGreaterThan(h2));
        System.out.printf("h1 >= h2 ? %b\n", h1.isGreaterThanOrEqual(h2));
        System.out.printf("h1  < h2 ? %b\n", h1.isLessThan(h2));
        System.out.printf("h1 =< h2 ? %b\n", h1.isLessThanOrEqual(h2));
    }
    
}

class HugeInteger {
    private final int SIZE = 41;
    private final int[] digits; // 40-element of digits to store integers

    public HugeInteger() {
        digits = new int[SIZE];
        for(int i = 0; i < SIZE; ++i)
            digits[i] = 0;
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
                System.err.printf("invalid digit at index: %d", i);
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
        if (toString().length() > hi.toString().length())
            return true;
        for (int i = SIZE - 1; i > -1; --i) {
            if (digits[i] >= hi.digits[i]) {                
            } else return false;
        }
        return true; 
    }
    
    public boolean isLessThanOrEqual(HugeInteger hi) {
        if (toString().length() < hi.toString().length())
            return true;
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
        // skip leading zeros
        for (; startingIndex < SIZE; ++startingIndex) {
            if (digits[startingIndex] != 0) break;
        } 
        for (int i = startingIndex; i < SIZE; ++i) {
            sb.append(digits[i]);                
        } 
        return String.format("%s", sb.toString());
    }       

    public HugeInteger add(HugeInteger h2) {
        StringBuilder summation = new StringBuilder();
        int op1, op2, sum, carry = 0;        
        for (int i = SIZE-1; i > -1; --i) {           
            op1 =    digits[i];
            op2 = h2.digits[i];
            sum = carry + op1 + op2;              
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;                
            } else { 
                carry = 0;
            }
            summation.append(sum);
        }
        if (carry > 0) summation.append(carry);
        
        HugeInteger result = new HugeInteger();
        result.parse(summation.reverse().toString());
        return result;
    }

    public HugeInteger subtract(HugeInteger h2) {
        StringBuilder difference = new StringBuilder();
        int op1, op2, diff, carry = 0;        
        for (int i = SIZE-1; i > -1; --i) {           
            op1 =    digits[i];
            op2 = h2.digits[i];
            diff = op1 - op2;              
//            if (diff > 9) {
//                carry = diff / 10;
//                diff = diff % 10;                
//            } else { 
//                carry = 0;
//            }
            difference.append(diff);
        }
        // if (carry > 0) difference.append(carry);
        
        HugeInteger result = new HugeInteger();
        result.parse(difference.reverse().toString());
        return result;
    }
}