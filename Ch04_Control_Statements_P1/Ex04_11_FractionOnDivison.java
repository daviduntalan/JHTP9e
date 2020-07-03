package Ch04_Control_Statements_P1;

/**
 * Explain what happens when a Java program attempts to divide one integer by
 * another. What happens to the fractional part of the calculation? How can you
 * avoid that outcome?
 *
 * @author David
 */
public class Ex04_11_FractionOnDivison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int value1 = 10 / 3; // fractional value were lost                
        System.out.println("value1: " + value1);
        
        double value2 = 10 / 3; // fractional value were lost
        System.out.println("value2: " + value2);
        
        double value3 = (double) 10 / 3;
        System.out.println("value3: " + value3);
        
        double value4 = 10 / 3.0;
        System.out.println("value4: " + value4);
    }

}
