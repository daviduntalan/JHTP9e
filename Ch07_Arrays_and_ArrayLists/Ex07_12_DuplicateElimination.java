package Ch07_Arrays_and_ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Duplicate Elimination. Use a one-dimensional array to solve the following
 * problem: write an app that inputs five numbers, each of which is between 10
 * and 100, inclusive. As each number is read, display it only if it is not a
 * duplicate of a number already read. Provide for the "worst case", in which
 * all five numbers are different. Use the smallest possible array to solve this
 * problem. Display the complete set of unique values input after the user
 * inputs each new value.
 *
 * @author David
 */
public class Ex07_12_DuplicateElimination {

    public static void main(String[] args) {

        final int LEN = 5;
        ArrayList<Integer> numbers = new ArrayList<>(LEN);
        int inputNumber;

        System.out.println("initial 5 numbers:");
        for (int n : numbers) System.out.println(n);

        System.out.println("enter 5 numbers between (10-100): ");
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < LEN; ++i) {
            System.out.print((i + 1) + ": "); inputNumber = input.nextInt();

            if (inputNumber < 10 || inputNumber > 100) {
                System.out.println("invalid range, try again.");
                --i; // stays to the same index.
            } else {
                // if valid range, test for duplicate
                if (numbers.contains(inputNumber)) {                    
                    System.out.printf("duplicate entry, try again.\n");
                    --i; // stays to the same index.
                } else {
                    numbers.add(inputNumber);
                    System.out.printf("inserted at index: %d\n", 
                            numbers.indexOf(inputNumber));
                }
            }
        }

        System.out.println("unique 5 numbers:");
        for (int n : numbers) System.out.println(n);
    }

}
