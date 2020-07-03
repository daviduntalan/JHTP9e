package Ch07_Arrays_and_ArrayLists;

/**
 * GradeBookTest creates a GradeBook object using an array of grades, then
 * invokes method processGrades to analyze them. Fig. 7.15
 *
 * @author David
 */
public class GradeBookTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // array of student grades
        int[] gradesArray = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};                

        GradeBook myGradeBook = new GradeBook(
                "CS101 Intro to Java Programming", gradesArray);
        
        myGradeBook.displayMessage();
        myGradeBook.processGrades();
    }

}
