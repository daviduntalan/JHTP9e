package Ch08_Classes_and_Objects;

/**
 * Set of Integers. Create class IntegerSet. Each IntegerSet object can hold
 * integers in the range 0-9. The set is represented by an array of booleans.
 * Array element a[i] is true if integer i is in the set. Array element a[j] is
 * false if integer j is not in the set. The no- argument constructor
 * initializes the array to the "empty set" (i.e., all false values).
 *
 * Provide the following methods: The static method union creates a set that's
 * the set-theoretic union of two existing sets (i.e., an element of the new
 * set's array is set to true if that element is true in either or both of the
 * existing sets--otherwise, the new set's element is set to false). The static
 * method intersection creates a set which which is the set-theoretic
 * intersection of two existing sets (i.e., an element of the new set's array is
 * set to false if the element is false in either or both of the existing
 * sets--otherwise, the new set's element is set to true.). Method insertElement
 * inserts a new integer k into a set (by setting a[k] to true). Method
 * deleteElement deletes integer m (by setting a[m] to false). Method toString
 * returns a String containing a set as a list of numbers separated by spaces.
 * Include only those element that are present in the set. Use --- to represent
 * an empty set. Method isEqualTo determines whether two sets are equal.
 *
 * Write a program to test class IntegerSet. Instantiate several IntegerSet
 * objects. Test that all your methods work properly.
 *
 */
public class Ex08_13_SetOfIntegers {

    public static void main(String[] args) {
        IntegerSet s1 = new IntegerSet();
        s1.insertElement(1); // input value
        s1.insertElement(2); // input value
        s1.insertElement(3); // input value        
        
        IntegerSet s2 = new IntegerSet();
        s2.insertElement(3); // input value
        s2.insertElement(4); // input value
        s2.insertElement(5); // input value              
        s2.deleteElement(1); // delete 1 from set
        
        IntegerSet union = IntegerSet.union(s1, s2);
        IntegerSet inter = IntegerSet.intersection(s1, s2);                
        
        System.out.println("SET-1: " + s1);
        System.out.println("SET-2: " + s2);
        System.out.println("UNION: " + union);
        
        System.out.printf("\nSet1 %s Set2\n\n", s1.isEqual(s2) ? "==" : "<>");
        
        System.out.println("SET-1: " + s1);
        System.out.println("SET-2: " + s2);
        System.out.println("INTER: " + inter);                
        
        IntegerSet s3 = new IntegerSet();
        System.out.println("SET-3: " + s3);
    }

}

class IntegerSet {    

    private boolean[] a; // hold integers in the range 0-9.

    public IntegerSet() {
        // initialies the array to the "empty set"
        a = new boolean[10]; // false by default
    }

    /**
     * creates a set that's the set-theoretic union of two existing sets (i.e.,
     * an element of the new set's array is set to true if that element is true
     * in either or both of the existing sets--otherwise, the new set's element
     * is set to false).
     * @return new union set.
     */
    public static IntegerSet union(IntegerSet s1, IntegerSet s2) {
        IntegerSet newUSet = new IntegerSet();        
        for (int i = 0; i < s1.arraySize(); ++i) {
            newUSet.setValueAt(i, s1.getValueAt(i) || s2.getValueAt(i));
        }
        return newUSet;
    }

    /**
     * The static method intersection creates a set which is the set-theoretic
     * intersection of two existing sets (i.e., an element of the new set’s
     * array is set to false if that element is false in either or both of the
     * existing sets—otherwise, the new set’s element is set to true).
     * @return new intersection set.
     */
    public static IntegerSet intersection(IntegerSet s1, IntegerSet s2) {
        IntegerSet newISet = new IntegerSet();        
        for (int i = 0; i < s1.arraySize(); ++i) {            
            newISet.setValueAt(i, s1.getValueAt(i) && s2.getValueAt(i));
        }
        return newISet;
    }

    /**
     * inserts a new integer k into a set (by setting a[k] to true).
     */
    public void insertElement(int k) {
        a[k] = true;
    }

    /**
     * deletes integer m (by setting a[m] to false).
     */
    public void deleteElement(int m) {
        a[m] = false;
    }

    public boolean isEqual(IntegerSet b) {
        for (int i = 0; i < arraySize(); ++i) {
            if (getValueAt(i) != b.getValueAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        
        boolean isEmpty = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; ++i) {            
            sb.append("[").append(i).append("]= ")
                    .append(a[i] ? "T":"F").append("  ");
            if (a[i]) isEmpty = false;
        }        
        if (isEmpty) return "empty set";
        else return sb.toString();
    }

    private void setValueAt(int index, boolean value) {
        a[index] = value;
    }

    private boolean getValueAt(int index) {
        return a[index];
    }

    private int arraySize() {
        return a.length;
    }

}