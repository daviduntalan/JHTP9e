package Ch07_Arrays_and_ArrayLists;

/**
 * GradeBook class using a two-dimensional array to store test grades. 
 * Fig. 7.18
 * @author David
 */
public class GradeBook2D {

    private String courseName; // name of course this GradeBook represents
    private int[][] grades; // array of student grades

    // two-argument constructor initializes courseName and grades array
    public GradeBook2D(String name, int[][] gradesArray) {
        courseName = name; // initialize courseName
        grades = gradesArray; // store grades (copy of reference of gradesArray received)
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayMessage() {
        // getCoursename gest the name of the course
        System.out.printf("Welcome to the grade book for \n%s!\n\n",
                getCourseName());
    }

    // perform various operations on the data
    public void processGrades() {
        // output grades array
        outputGrades();

        // call methods getMinimum and getMaximum
        System.out.printf("\n%s %d\n%s %d\n\n",
                "Lowest grade in the grade book is", getMinimum(),
                "Highst grade in the grade book is", getMaximum());

        // call outputBarChart to print grade distribution chart
        outputBarChart();
    }

    // determine average grade for test
    private double getAverage(int[] setOfGrades) {
        int total = 0; // initialize total
        
        // sum grades for one student
        for (int grade : setOfGrades) {
            total += grade;
        }
        
        // return average of grades
        return (double) total / setOfGrades.length;
    }

    // find minimum grde
    private int getMinimum() {
        int lowGrade = grades[0][0]; // assume grades[0][0] is smallest;
        // loop through grades array
        // assigning successive rows to parameter studentGrades on successive iterations.
        for (int[] studentGrades : grades) { 
            // loop through columns of current rown
            for (int grade : studentGrades) {
                // if grade lower than lowGrade, assign it to lowGrade
                if (grade < lowGrade) {
                    lowGrade = grade; // new lowest grade
                }
            }
        }
        return lowGrade; // return the lowest grade
    }

    // find the maximum grade
    private int getMaximum() {
        int highGrade = grades[0][0]; // assume grades[0][0] is largest;
        // loop through grades array
        // assigning successive rows to parameter studentGrades on successive iterations.
        for (int[] studentGrades : grades) {                    
            // loop through columns of current row
            for (int grade : studentGrades) {
                // if grade greater than highGrade, assign it to highGrade
                if (grade > highGrade) {
                    highGrade = grade; // new highest grade
                }
            }
        }
        return highGrade; // return highest grade
    }

    private void outputBarChart() {
        System.out.println("Overall grade distribution:");

        // stores frequency of grades in each range of 10 grades
        int[] frequency = new int[11]; // 0-10, ignores zero idx

        // for each grade, increment the appropriate frequency
        // increments the grades distribution, say: 80-89: ****
        for (int[] studentGrades : grades) {                    
            for (int grade : studentGrades) {
                ++frequency[grade / 10]; 
            }
        }

        // for each grade frequency, print bar in chart
        for (int count = 0; count < frequency.length; ++count) {
            // output bar label ("00-09: ", ..., "90-99 ", "100: ")
            if (count == 10) {
                System.out.printf("%5d: ", 100);
            } else {
                System.out.printf("%02d-%02d: ", 
                        count * 10, count * 10 + 9);
            }
            // print bar of asterisks
            for (int stars = 0; stars < frequency[count]; ++stars) {
                System.out.print("*");
            }
            // start a new line of output
            if (frequency[count] > 0)
                System.out.println("(" + frequency[count] + ")");
            else
                System.out.println();
        }
    }

    // output bar chart displaying grade distribution
    private void outputGrades() {
        System.out.println("The grades are:\n");
        System.out.print( "            " ); // align column heads
        
        // create a column heading for each of the tests
        for (int test = 0; test < grades[0].length; ++test) {
            System.out.printf("Test %d  ", test + 1);
        }
        System.out.println("Average"); // student avearge column heading                

        // create rows/columns of text representing array grades
        for (int student = 0; student < grades.length; ++student) {
            System.out.printf("Student %2d", student + 1);
            // output student's grades
            for (int test : grades[student]) { 
                System.out.printf("%8d", test);
            }
            // call method getAverage to calculate student's average grade;
            // pass row of grades as the argument to getAverage
            double average = getAverage(grades[student]);
            System.out.printf("%9.2f\n", average);
        }

    }

} // end of GradeBook class
