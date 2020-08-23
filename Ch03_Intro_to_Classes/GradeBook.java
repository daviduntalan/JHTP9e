package Ch03_Intro_to_Classes;

/**
 * GradeBook class that contains a courseName instance variable
 * and methods to set and get its value.
 * @author David
 */
public class GradeBook {

    private String courseName;
    private String courseInstructor;

    public GradeBook() { }
    public GradeBook(String courseName) {
        setCourseName(courseName);
    }
    public GradeBook(String courseName, String courseInstructor) {
        this(courseName); setCourseInstructor(courseInstructor);
    }

    public void displayMessage(String courseName) {
        setCourseName(courseName);
        displayMessage();
    }

    public void displayMessage() {
        System.out.printf(
                "Welcome to the grade book for\n%s!\n" +
                "This course is presented by: %s\n",
                getCourseName(), getCourseInstructor());
    }

    public String getCourseName() { return courseName; }
    public String getCourseInstructor() { return courseInstructor; }

    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
}
