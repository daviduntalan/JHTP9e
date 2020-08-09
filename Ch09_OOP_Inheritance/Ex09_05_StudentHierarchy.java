package Ch09_OOP_Inheritance;

/**
 * Draw an inheritance hierarchy for students at a university similar 
 * to the hierarchy shown in Fig. 9.2. Use Student as the superclass 
 * of the hierarchy, then extend Student with classes UndergraduateStudent
 * and GraduateStudent. Continue to extend the hierarchy as deep (i.e., 
 * as many levels) as possible. For example, Freshman, Sophomore, Junior 
 * and Senior might extend UndergraduateStudent, and DoctoralStudent and 
 * MastersStudent might be subclasses of GraduateStudent. 
 * After drawing the hierarchy, discuss the relationships that exist 
 * between the classes. [Note: You do not need to write any code for this 
 * exercise.] @author David
 */

class Student {}

class UndergraduateStudent extends Student {}
class Freshman extends UndergraduateStudent {}
class Sophomore extends UndergraduateStudent {}
class Junior extends UndergraduateStudent {}
class Senior extends UndergraduateStudent {}

class GraduateStudent extends Student {}
class DoctoralStudent extends GraduateStudent {}
class MastersStudent extends GraduateStudent {}

public class Ex09_05_StudentHierarchy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
