package Ch07_Arrays_and_ArrayLists;

/**
 * Fig. 7.12: Using the enhanced for statement to total integers in an array.
 * The enhanced for statement can be used only to obtain array elements.
 * It cannot be used to modify elements. If you program needs to modify
 * elements, use the traditional counter-controlled for statement.
 * @author David
 */
public class EnhancedForTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
        int total = 0;
        
        // add each element's value to total       
        for (int number : array) {
            total += number;
        }
        
        System.out.printf("Total of array elements: %d\n", total);
    }
    
}
