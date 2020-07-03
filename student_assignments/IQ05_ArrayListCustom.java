package student_assignments;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Avoid duplicate in an ArrayList object.
 * This class's constructor should add the ability to specify whether
 * or not duplicates are allowed in the Custom ArrayList
 * 
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ05_ArrayListCustom {

    public static void main(String[] args) {
        ArrayListCustom<Integer> myList = new ArrayListCustom<>(false);
        myList.add(3);
        myList.add(2);
        myList.add(4);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.forEach((value) -> {
            System.out.printf("%d ", value);
        });
    }

}

class ArrayListCustom<E> extends ArrayList<E> {

    private boolean allowDuplicates;
    private HashSet<E> mySet = new HashSet<>(); // for testing purpose
    
    public ArrayListCustom(boolean allowDuplicates) {
        setAllowDuplicates(allowDuplicates);
    }
    
    @Override
    public boolean add(E element) {
        if (!getAllowDuplicates() && !mySet.add(element)) {
            throw new IllegalArgumentException("No duplicates allowed.");
        } else if (getAllowDuplicates() && !mySet.add(element)) {
            System.out.printf("adding %s\n", element);
            super.add(element);
        }
        return getAllowDuplicates();
    }
    
    private void setAllowDuplicates(boolean allow) {
        allowDuplicates = allow;
    }
    
    private boolean getAllowDuplicates() {
        return allowDuplicates;
    }    
}