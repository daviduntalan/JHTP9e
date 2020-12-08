package student_assignments;

/*
What is the difference between Comparator and Comparable?
- use for sorting objects
- use for custom sorting

Comparator:
- comparator interface enables you to provide custom comparison logic for
  data types that you have no control over.
- if you have no control over objects use this interface (Integers, Long,
  String, etc)
    * from: java.utils package
    * you have to implement method: int compare(Object o1, Object o2)
    * Collections.sort(List, Comparator)
    * see IQ34 for example

Comparable
- allows you to specify how objects that you are implementing get compared
- if you have control over objects use this interface to sort (Student, Bicycle,
  Person, etc)
    * from: java.lang package
    * you have to implement method: int compareTo(Object o2)
    * Collections.sort(List)

Return Values:
* Comparator
    - compare(Object o1, Object o2)
        * 1 -> o1 > o2
        * 0 -> o1 = o2
        * -1 -> o1 < o2
* Comparable
    - compareTo(Object o2)
        * 1 -> object's attribute is greater than o2 attribute
        * 0 -> object's attribute is equal to o2 attribute
        * -1 -> object's attribute is lesser than o2 attribute
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student> {

    private String name;
    private String major;
    private int age;

    public Student(String name, String major, int age) {
        this.name = name;
        this.major = major;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {

        return this.name.compareTo(o.name); // ascending
        // return -this.name.compareTo(o.name); // descending (minus flip the sign)
    }

    @Override
    public String toString() {
        return "Student{name='" + name + '\'' + ", major='" + major + '\'' + ", age=" + age + '}';
    }
}

class ReverseSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        return -o1.compareTo(o2); /* minus sign will reverse the order */
    }
}

public class IQ37_DifferenceBetweenComparatorAndComparable {

    public static void main(String[] args) {

        ArrayList<String> items = new ArrayList<>();
        items.add("zebra");
        items.add("dog");
        items.add("cat");
        items.add("monkey");

        System.out.println("Using Comparator");
        System.out.println("\nAscending: ");
        Collections.sort(items);
        items.forEach(item -> System.out.println(item));

        System.out.println("\nDescending: ");
        Collections.sort(items, new ReverseSort());
        items.forEach(item -> System.out.println(item));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jake", "Computer Science", 18));
        students.add(new Student("Zenethia", "English", 25));
        students.add(new Student("Cynthia", "Psychology", 22));

        System.out.println("\nUsing Comparable");
        Collections.sort(students);
        students.forEach(student -> System.out.println(student));
    }
}
