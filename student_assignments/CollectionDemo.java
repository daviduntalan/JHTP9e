package student_assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.collections4.list.TreeList;

/**
The Dev World - by Sergio Lema
FB Reference: https://web.facebook.com/watch/?v=279279189868922
*/
public class CollectionDemo {

    static int SIZE = 1_000_000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> tree = new TreeList<>();
        List<String> array = new ArrayList<>();
        List<String> linked = new LinkedList<>();

        System.out.println("Creation");
        add(tree, "TreeList");
        add(array, "ArrayList");
        add(linked, "LinkedList");
        
        System.out.println("\nReading");
        read(tree, "TreeList");
        read(array, "ArrayList");
        read(linked, "LinkedList");
        
        System.out.println("\nDeletion");
        remove(tree, "TreeList");
        remove(array, "ArrayList");
        remove(linked, "LinkedList");
    }

    private static void add(List<String> list, String name) {
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.add(String.valueOf(i));
        }
        System.out.printf("%s\t%,10d\n", name, (System.nanoTime() - start));
    }

    private static void read(List<String> list, String name) {
        long start = System.nanoTime();
        for (int i = SIZE - 1; i > 0; i -= 200) {
            list.indexOf(String.valueOf(i));
        }
        System.out.printf("%s\t%,10d\n", name, (System.nanoTime() - start));
    }

    private static void remove(List<String> list, String name) {
        long start = System.nanoTime();        
        for (int i = SIZE - 1; i > 0; i -= 200) {
            list.remove(String.valueOf(i));
        }
        System.out.printf("%s\t%,10d\n", name, (System.nanoTime() - start));
    }
}
/*
Sample run:
Creation
TreeList	618,243,822
ArrayList	191,002,477
LinkedList	302,411,762

Reading
TreeList	43,003,131,444
ArrayList	17,930,410,762
LinkedList	45,715,456,926

Deletion
TreeList	62,221,347,678
ArrayList	21,843,402,765
LinkedList	47,089,863,162
BUILD SUCCESSFUL (total time: 3 minutes 59 seconds)
*/

/*
Reference: http://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/list/TreeList.html

org.apache.commons.collections4.list

Class TreeList<E>

java.lang.Object
    java.util.AbstractCollection<E>
        java.util.AbstractList<E>
            org.apache.commons.collections4.list.TreeList<E>

All Implemented Interfaces:
Iterable<E>, Collection<E>, List<E>
--------------------------------------------------------------------
public class TreeList<E>
extends AbstractList<E>

A List implementation that is optimized for fast insertions and removals at any index in the list.
This list implementation utilizes a tree structure internally to ensure that all insertions and removals are O(log n). This provides much faster performance than both an ArrayList and a LinkedList where elements are inserted and removed repeatedly from anywhere in the list.

The following relative performance statistics are indicative of this class:

              get  add  insert  iterate  remove
 TreeList       3    5       1       2       1
 ArrayList      1    1      40       1      40
 LinkedList  5800    1     350       2     325
 
ArrayList is a good general purpose list implementation. It is faster than TreeList for most operations except inserting and removing in the middle of the list. ArrayList also uses less memory as TreeList uses one object per entry.

LinkedList is rarely a good choice of implementation. TreeList is almost always a good replacement for it, although it does use slightly more memory.
*/