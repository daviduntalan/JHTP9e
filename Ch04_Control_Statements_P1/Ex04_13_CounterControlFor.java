package Ch04_Control_Statements_P1;

/**
 * What type of repetition would be appropriate for calculating the 
 * sum of the first 100 positive integer?
 *
 * @author David
 */
public class Ex04_13_CounterControlFor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int sum = 0;
        for (int i = 1; i <= 100; ++i) {
            System.out.printf("sum: %5d + %3d\n", sum, i);
            sum += i;
        }
        
        System.out.printf("sum: %5d\n", sum);
        
        int total = 0; sum = 0;
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.printf("Enter value to add (0 to stop): ");
        int value = input.nextInt();
        while (value != 0) {            
            System.out.printf("sum: %5d + %3d (value)\n", sum, value);
            sum += value;
            System.out.printf("Enter value to add (0 to stop): ");
            value = input.nextInt();
        }
        
        System.out.printf("sum: %5d\n", sum);
    }

}
