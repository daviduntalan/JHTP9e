package Ch07_Arrays_and_ArrayLists;

/**
 * GradeBookTest creates a GradeBook object using an array of grades, then
 * invokes method processGrades to analyze them. Fig. 7.15
 *
 * @author David
 */
public class GradeBook2DTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // array of student grades
        int[][] gradesArray = {
            {87, 96, 70},
            {68, 87, 90},
            {94, 100, 90},
            {100, 81, 82},
            {83, 65, 85},
            {78, 87, 65},
            {85, 75, 83},
            {91, 94, 100},
            {76, 72, 84},
            {87, 93, 73}
        };

        GradeBook2D myGradeBook = new GradeBook2D(
                "CS101 Intro to Java Programming", gradesArray);

        myGradeBook.displayMessage();
        myGradeBook.processGrades();
    }

}
