package Ch07_Arrays_and_ArrayLists;

/**
 * GradeBookTest creates a GradeBook object using an array of grades, then
 * invokes method processGrades to analyze them. Fig. 7.15
 *
 * @author David
 */
public class GradeBook2DTestRandom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.util.Random random = new java.util.Random();
                
        final int STUDENTS = 50;
        final int SEMESTER = 3;
        
        // array of student grades
        int[][] studentsGrades = new int[STUDENTS][SEMESTER]; 
        for (int[] studentGrades : studentsGrades) {
            for (int col = 0; col < studentGrades.length; ++col) {
                studentGrades[col] = 75 + random.nextInt(101-75);
            }
        }
        
        /* // array of student grades - the same as above ^
        int[][] studentsGrades = new int[STUDENTS][]; // create row        
        for (int row = 0; row < studentsGrades.length; ++row) {
            System.out.printf("row %d of %d\n", row, studentsGrades.length);
            studentsGrades[row] = new int[SEMESTER]; // create col
            for (int col = 0; col < studentsGrades[row].length; ++col) {
                System.out.printf("\tcol %d of %d\n", col, studentsGrades[row].length);
                studentsGrades[row][col] 
                        = new java.util.Random().nextInt(101);
            }
        } */                

        GradeBook2D myGradeBook = new GradeBook2D(
                "CS101 Intro to Java Programming", studentsGrades);

        myGradeBook.displayMessage();
        myGradeBook.processGrades();
    }

}
