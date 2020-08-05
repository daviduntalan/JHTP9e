package Ch08_Classes_and_Objects;

import java.util.Random;
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

class Maximum {
    // compute up to this length of digits!
    public static int DIGITS = 100; // can add/subtract 7 million digits!
}

public class Ex08_16_HugeIntegerClass {

    public static void main(String[] args) {

        String n1 = generateRandomNumbers(Maximum.DIGITS);
        String n2 = generateRandomNumbers(Maximum.DIGITS);
        HugeInteger h1 = new HugeInteger();
        HugeInteger h2 = new HugeInteger();        
        
        h1.parse(n1); h2.parse(n2); // reset object's value
        System.out.printf("      h1 : %" + (Maximum.DIGITS+1) + "s\n", h1);
        System.out.printf("      h2 : %" + (Maximum.DIGITS+1) + "s\n", h2);
        System.out.printf("h1  - h2 ? %" + (Maximum.DIGITS+1) + "s\n", h1.subtract(h2));

        h1.parse(n1); h2.parse(n2); // reset object's value
        System.out.printf("      h1 : %" + (Maximum.DIGITS+1) + "s\n", h1);
        System.out.printf("      h2 : %" + (Maximum.DIGITS+1) + "s\n", h2);
        System.out.printf("h1  + h2 ? %" + (Maximum.DIGITS+1) + "s\n", h1.add(h2));
        
        h1.parse(n1); h2.parse(n2); // reset object's value
        System.out.printf("h1 == h2 ? %b\n", h1.isEqualTo(h2));
        System.out.printf("h1 != h2 ? %b\n", h1.isNotEqualTo(h2));
        System.out.printf("h1  > h2 ? %b\n", h1.isGreaterThan(h2));
        System.out.printf("h1 >= h2 ? %b\n", h1.isGreaterThanOrEqual(h2));
        System.out.printf("h1  < h2 ? %b\n", h1.isLessThan(h2));
        System.out.printf("h1 =< h2 ? %b\n", h1.isLessThanOrEqual(h2));
    }

    private static String generateRandomNumbers(int LENGTH) {
        StringBuilder sb = new StringBuilder();
        int startingIndex = 0;
        Random random = new Random();
        for (; startingIndex < LENGTH; ++startingIndex) {
            // generate random number between 0 and 9
            sb.append(random.nextInt(10)); 
        } 
        return sb.toString();
    }
    
}

class HugeInteger {
    private final int SIZE = (Maximum.DIGITS+1) + 1;
    private final int[] digits; // 40-element of digits to store integers
    private boolean isNegative = false;

    public HugeInteger() {
        digits = new int[SIZE];
        resetDigitsToZeros();
    }

    private void resetDigitsToZeros() {
        for(int i = 0; i < SIZE; ++i) digits[i] = 0;
    }
   
    public void parse(String s) {
        resetDigitsToZeros(); // clear cache memory        
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
        if (toString().length() < hi.toString().length())
            return false;
        for (int i = 0; i < SIZE; ++i) {                        
            if (digits[i] > hi.digits[i]) return true;            
            if (digits[i] < hi.digits[i]) return false;            
        }
        return false;
    }
           
    public boolean isLessThan(HugeInteger hi) {
        if (toString().length() < hi.toString().length())
            return true;
        if (toString().length() > hi.toString().length())
            return false;
        for (int i = 0; i < SIZE; ++i) {                        
            if (digits[i] < hi.digits[i]) return true;            
            if (digits[i] > hi.digits[i]) return false;            
        }
        return false;
    }
    
    public boolean isGreaterThanOrEqual(HugeInteger hi) {
        if(this.isGreaterThan(hi)) return true;
        if (toString().length() < hi.toString().length()) return false;
        for (int i = 0; i < SIZE; ++i) {                        
            if (digits[i] != hi.digits[i]) return false;                        
        }
        return true;
    }
    
    public boolean isLessThanOrEqual(HugeInteger hi) {
        if(this.isLessThan(hi)) return true;
        if (toString().length() > hi.toString().length()) return false;
        for (int i = 0; i < SIZE; ++i) {                        
            if (digits[i] != hi.digits[i]) return false;                        
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
        if (sb.length() == 0) return "0";
        return String.format("%s%s", (isNegative ? "-" : ""), sb.toString());
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
                
        HugeInteger t1 = new HugeInteger();        
        HugeInteger t2 = new HugeInteger();
        t1.parse(this.toString()); // copy of h1
        t2.parse(h2.toString()); // copy of h2
        
        StringBuilder difference = new StringBuilder();
        int op1, op2, diff;
        
        for (int i = SIZE - 1; i > -1; --i) {
            op1 = digits[i];
            op2 = h2.digits[i];
            diff = op1 - op2;
            if (diff < 0) {
                // search to the left number to borrow decimal
                for (int j = 1; j < i; ++j) {
                    // if we can borrow, then do it; otherwise,
                    if (digits[i - j] > 0) {
                        op1 = digits[i] += 10;
                        --digits[i - j];                        
                        diff = op1 - op2;
                        j = i; // end the search loop
                    } 
                    // if it's zero then make it decimal and
                    // subract 1, then carry decimal to the right
                    else if (digits[i - j] == 0) {
                        digits[i - j] = 9; // or (10 - 1);
                    }
                } // end for
            } // end if
            
            difference.append(diff);
        } // end of for
        
        // if the result has negative, inverse the process
        if (difference.indexOf("-", 0) > -1) {                        
            t2.parse(t2.subtract(t1).toString());
            t2.isNegative = true; // triggers negative sign
            return t2;
        }
        
        HugeInteger result = new HugeInteger();
        result.parse(difference.reverse().toString());
        return result;
    }
}