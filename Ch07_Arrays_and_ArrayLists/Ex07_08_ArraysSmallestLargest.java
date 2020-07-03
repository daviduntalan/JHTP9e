package Ch07_Arrays_and_ArrayLists;

import java.util.Arrays;

/**
 *
 * @author David
 */
public class Ex07_08_ArraysSmallestLargest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // display the value of element 6 of array f
        int[] f = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        System.out.printf("element 6 of array f[]: %d\n", f[5]);
        
        // initialize each of the five elements of one-dimensional integer array g to 8;
        int[] g = new int[5];
        Arrays.fill(g, 8);
        
        // total the 100 elements of floating-point array c.
        int[] c = new int[100];
        for (int i = 0; i < c.length; ++i) {
            c[i] = new java.util.Random().nextInt(100);
            System.out.printf("%d ", c[i]);
        }
        
        // copy 11-element array a into the first portion of array b,
        // which contains 34 elements.
        int[] a = new int[34];        
        int[] b = new int[34];
        System.out.println("\n");
        for (int i = 0; i < a.length; ++i) {
            System.out.printf("%d ", a[i] = i);
        }
        System.out.println();
        System.out.println("...");
        System.arraycopy(a, 0, b, 0, a.length);
        for (int i = 0; i < b.length; ++i) {
            System.out.printf("%d ", b[i] = i);
        }
        System.out.println("\n");
        
        // determine and display the smallest and largest values 
        // contained in 99-element floating point array w.
        int[] w = new int[99];
        System.arraycopy(c, 0, w, 0, w.length);
        int smallest, largest; 
        smallest = largest = w[0];
        for (int i = 0; i < w.length; ++i) {
            System.out.printf("%d ", w[i]);
            if (smallest > w[i]) {
                smallest = w[i];
            }
            if (largest < w[i]) {
                largest = w[i];
            }
        }
        
        System.out.printf("\nSmallest: %d\nLargest: %d\n\n", 
                smallest, largest);
    }

}
