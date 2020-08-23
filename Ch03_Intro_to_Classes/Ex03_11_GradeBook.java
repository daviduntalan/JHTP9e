package Ch03_Intro_to_Classes;

public class Ex03_11_GradeBook {

    public static void main(String[] args) {

        GradeBook gradeBook = new GradeBook();
        
        gradeBook.setCourseName("CS101 Intro to Object and Classes");
        gradeBook.setCourseInstructor("David, Jr.");
        
        gradeBook.displayMessage();
    }
    
}
