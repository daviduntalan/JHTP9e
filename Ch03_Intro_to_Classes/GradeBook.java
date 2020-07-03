// package Ch03_Intro_to_Classes;

/**
 * GradeBook class that contains a courseName instance variable
 * and methods to set and get its value.
 * @author David
 */
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class GradeBook {

    private String courseName;
    private String courseInstructor;

    public GradeBook(String courseName) {
        setCourseName(courseName);
    }

    public GradeBook(String courseName, String courseInstructor) {
        this(courseName);
        setCourseInstructor(courseInstructor);
    }
    
    public void displayMessage(String courseName) {
        setCourseName(courseName);
        displayMessage();
    }

    public void displayMessage() {
        System.out.printf("Welcome to the grade book for\n%s!\nThis course is presented by: %s\n",
                getCourseName(), getCourseInstructor());
    }
    
}
