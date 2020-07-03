package Ch05_Control_Statements_P2;

/**
 * NOTE: 
 * To run this, remove package name then, 
 * compile and run in your terminal. 
 * Because you can't input CTRL + Z in IDE
 * @author David
 */
public class GradeBookTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create GradeBook object myGradeBook and
        // pass course name to constructor.
        GradeBook myGradeBook = new GradeBook("CS101 Intro to Java Programming");
        myGradeBook.displayMessage(); // display welcome message
        myGradeBook.inputGrades(); // read grades from user
        myGradeBook.displayGradeReport(); // display report
    }
    
}
