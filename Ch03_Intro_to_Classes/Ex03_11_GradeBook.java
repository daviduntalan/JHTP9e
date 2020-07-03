// package Ch03_Intro_to_Classes;

/**
 *
 * @author David
 */
public class Ex03_11_GradeBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GradeBook gradeBook = new GradeBook();
        
        gradeBook.setCourseName("CS101 Intro to Object and Classes");
        gradeBook.setCourseInstructor("David, Jr.");
        
        gradeBook.displayMessage();
    }
    
}
