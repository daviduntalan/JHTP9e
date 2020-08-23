package Ch02_Intro_to_JavaApplication;

/**
 * Finds largest and smallest integers.
 * @authsor David
 */
public class Ex02_24_FindSmallestLargest {

    public static void main(String[] args) {

        int a = 50;
        int b = 20;
        int c = 10;
        int d = 30;
        int e = 40;
        
        int smallest = a;
        // find the smallest
        if (smallest > b) smallest = b;
        if (smallest > c) smallest = c;
        if (smallest > d) smallest = d;
        if (smallest > e) smallest = e;
        
        
        
        int largest = a;
        // find the largest
        if (largest < b) largest = b;
        if (largest < c) largest = c;
        if (largest < d) largest = d;
        if (largest < e) largest = e;

        System.out.printf("smallest: %d\nlargest: %d\n", 
                smallest, largest);
    }

}
