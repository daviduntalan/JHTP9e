package student_assignments;

import java.util.ArrayList;
import java.util.Iterator;

public class FindSmallestLargest {

    public static void main(String[] args) {

        usingArrayListV1();
        // usingTreeV1();
        // usingTreeV2();
        

    }
    
    private static void usingTreeV2() {
        
        java.util.Set<Integer> listOfNumbers
                = new java.util.TreeSet<>();

        listOfNumbers.add(10);
        listOfNumbers.add(5);
        listOfNumbers.add(3);
        listOfNumbers.add(7);
        listOfNumbers.add(4);
        listOfNumbers.add(6);

        Iterator<Integer> iterator = listOfNumbers.iterator();
        int getSmallest = iterator.next();
        int getLargest = 0; 
        while(iterator.hasNext()) getLargest = iterator.next();

        System.out.printf("Smallest: %d\n", getSmallest);
        System.out.printf("Largest: %s\n", getLargest);
    }

    private static void usingTreeV1() {
        java.util.Set<Integer> listOfNumbers
                = new java.util.TreeSet<>();

        listOfNumbers.add(10);
        listOfNumbers.add(5);
        listOfNumbers.add(3);
        listOfNumbers.add(7);
        listOfNumbers.add(4);
        listOfNumbers.add(6);

        // considering listOfNumbers is not empty. 
        // if (!listOfNumbers.isEmpty())         
        Integer[] sortedNumbers = new Integer[listOfNumbers.size()];
        listOfNumbers.toArray(sortedNumbers);

        int getSmallest = sortedNumbers[0];
        int getLargest = sortedNumbers[sortedNumbers.length - 1];

        System.out.printf("Smallest: %d\n", getSmallest);
        System.out.printf("Largest: %s\n", getLargest);
    }

    private static void usingArrayListV1() {
        
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        
        listOfNumbers.add(10);
        listOfNumbers.add(5);
        listOfNumbers.add(3);
        listOfNumbers.add(7);
        listOfNumbers.add(4);
        listOfNumbers.add(6);
        
        int getSmallest = listOfNumbers.get(0);
        int getLargest = listOfNumbers.get(0);
        
        for (Integer value : listOfNumbers) {
            if(value < getSmallest) getSmallest = value;
            if(value > getLargest) getLargest = value;
        }
        
        System.out.printf("Smallest: %d\n", getSmallest);
        System.out.printf("Largest: %s\n", getLargest);
    }

}
