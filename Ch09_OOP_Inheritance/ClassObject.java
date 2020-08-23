package Ch09_OOP_Inheritance;

/**
 *
 * @author David
 */

class ClassObj {
    
}
public class ClassObject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClassObj co = new ClassObj();
        System.out.println(co.getClass()); // class Ch09_OOP_Inheritance.ClassObj
        System.out.println(co.getClass().getName()); // Ch09_OOP_Inheritance.ClassObj
        System.out.println(co.getClass().getTypeName()); // Ch09_OOP_Inheritance.ClassObj
        System.out.println(co.getClass().isAnnotation());
        System.out.println(co); // see Fig. 9.12 | hexa decimal representation
        System.out.println(co.hashCode()); // decimal representation                
    }
    
}
