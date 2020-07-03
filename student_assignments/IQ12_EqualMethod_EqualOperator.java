package student_assignments;

/**
 * What's the difference between == and equal()?
 * ...
 * == operator compares object references, compares location in memory;
 * equals() method compares object's contents
 * 
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ12_EqualMethod_EqualOperator {

    public static void main(String[] args) {
        
        // here, both x and y has the same reference to "hello"
        String x = "hello"; // created in constant pool
        String y = "hello";
        System.out.println(x == y); // true
        
        String a = new String("hello"); // created object in heap
        String b = new String("hello"); // created object in heap
        System.out.println(a == b); // false
        
        // equals() method is basically to compare the contents
        System.out.println(x.equals(y)); // true
        System.out.println(a.equals(b)); // true
    }
}