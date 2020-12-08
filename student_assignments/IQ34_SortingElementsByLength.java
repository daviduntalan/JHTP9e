package student_assignments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/* operating on String thus, Comparator<String> */
class SortByLength implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        int x = o1.length();
        int y = o2.length();

        // return Integer.compare(x, y);
        // return x - y; // ascending
        return y - x; // descending
    }
}

public class IQ34_SortingElementsByLength {

    public static void main(String[] args) {

        ArrayList<String> items = new ArrayList<>();
        items.add("headphones");
        items.add("shoe");
        items.add("cat");
        items.add("money");
        items.add("remote");

        Collections.sort(items, new SortByLength());
        items.forEach(item -> System.out.println(item));
    }
}
