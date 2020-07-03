package Ch08_Classes_and_Objects;

/**
 * Every object has its own copy of all the instance variables of the class. In
 * certain cases, only one copy of a particular variable should be 'shared' by
 * all objects of a class. A static field--called a class variable--is used in
 * such cases. A static variable represents class wide information--all objects
 * of the class share the same piece of data. The declaration of a static
 * variable begins with the keyword static.
 *
 * @author David
 */
public class StaticClassMembers {

    private int iamInstanceVariable = 99;
    // private static int iamInstanceVariable = 99;

    public static void main(String[] args) {

        Martian martian1 = new Martian();
        Martian martian2 = new Martian();
        Martian martian3 = new Martian();
        Martian martian4 = new Martian();
        Martian martian5 = new Martian();
        System.out.println("Access through reference object: ");
        System.out.println(martian3.getMartianCount());
        System.out.println("Access by qualifying the member name with the class name and a dot.");
        System.out.println(Martian.martianCount);
        
        /**
         * A static method cannot access non-static class members,
         * because a static method can be called even when no objects
         * of the class have been instantiated. For the same reason,
         * the 'this' reference cannot be used in a static method. 
         * The 'this' reference must refer to a specific/existing
         * object of the class, and when a static method is called,
         * there might not be any objects of its class in memory.
         */                
        
        // iamInstanceVariable = 100;        
    }

}

class Martian {

    protected static int martianCount;

    public Martian() {
        ++martianCount;
    }

    public int getMartianCount() {
        return martianCount;
    }
}
