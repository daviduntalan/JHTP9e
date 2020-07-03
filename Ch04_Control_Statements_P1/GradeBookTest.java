package Ch04_Control_Statements_P1;

/**
 * Create GradeBook object and invoke its determineClassAverage method.
 * Fig. 4.7
 *
 * @author David
 */
public class GradeBookTest {

    public static void main(String[] args) {
        
        GradeBook myGradeBook = new GradeBook(
            "CS101 Introduction to Java Programming");
        
        myGradeBook.displayMessage();
        myGradeBook.determinteClassAverage();
    }
}
