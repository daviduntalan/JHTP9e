package Ch07_Arrays_and_ArrayLists;

import java.util.ArrayList;

/**
 * Fig. 7.24: Generic ArrayList<T> collection demonstration.
 * @author David
 */
public class ArrayListCollection {

    public static void main(String[] args) {
        // create a new ArrayList of Strings with an initial capacity of 10
        ArrayList<String> items = new ArrayList<>();
        
        items.add("red"); // append an item to the list
        items.add(0, "yellow"); // insert the value at index 0
        
        System.out.print("Display list contents w/ counter-controlled loop:");
        // display the colors in the list
        for (int index = 0; index < items.size(); ++index) {
            System.out.printf(" %s", items.get(index).toUpperCase());
        }
        // display colors using foreach in the display method
        display(items, "\nDisplay list contents w/ enhanced for statement:");
        
        items.add("green"); // add "green" to the end of the list
        items.add("yellow"); // add "yellow" to the end of the list
        display(items, "List with two new elements:");
        
        items.remove("yellow"); // remove the first yellow
        display(items, "Remove the 1st instance of yellow:");
        
        items.remove(1); // remove item at index 1
        display(items, "Remove 2nd list element (green):");
        
        // check if a value is in the list
        String searchKey = "red";
        System.out.printf("%s is %sin the list\n", searchKey.toUpperCase(),
                items.contains( searchKey ) ? "" : "not ");
        
        // display number of elements in the list
        System.out.printf("Size: %d - number of elements in the list\n", items.size());
    }

    private static void display(ArrayList<String> items, String header) {
        System.out.print( header );
        for (String item : items) {
            System.out.printf(" %s", item.toUpperCase());
        }
        System.out.println();
    }
    
}
