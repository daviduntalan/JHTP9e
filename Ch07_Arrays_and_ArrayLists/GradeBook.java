package Ch07_Arrays_and_ArrayLists;

/**
 * GradeBook class using an array to store test grades. 
 * Fig. 7.14
 * @author David
 */
public class GradeBook {

    private String courseName; // name of course this GradeBook represents
    private int[] grades; // array of student grades

    // two-argument constructor initializes courseName and grades array
    public GradeBook(String name, int[] gradesArray) {
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
        System.out.printf("Welcome to ghe grade book for \n%s!\n\n",
                getCourseName());
    }

    // perform various operations on the data
    public void processGrades() {
        // output grades array
        outputGrades();

        // call method getAverage to calculate the average grade
        System.out.printf("\nClass average is %.2f\n", getAverage());

        // call methods getMinimum and getMaximum
        System.out.printf("Lowest grade is %d\nHighst grade is %d\n\n",
                getMinimum(), getMaximum());

        // call outputBarChart to print grade distribution chart
        outputBarChart();
    }

    // determine average grade for test
    private double getAverage() {
        int total = 0; // initialize total

        // sum grades for one student
        for (int grade : grades) {
            total += grade;
        }
        // return average of grades
        return (double) total / grades.length;
    }

    // find minimum grde
    private int getMinimum() {
        int lowGrade = grades[0]; // assume grades[0] is smallest;
        // loop through grades array
        for (int grade : grades) {
            // if grade lower than lowGrade, assign it to lowGrade
            if (grade < lowGrade) {
                lowGrade = grade; // new lowest grade
            }
        }
        return lowGrade; // return the lowest grade
    }

    // find the maximum grade
    private int getMaximum() {
        int highGrade = grades[0]; // assume grades[0] is largest;
        // loop through grades array
        for (int grade : grades) {
            // if grade greater than highGrade, assign it to highGrade
            if (grade > highGrade) {
                highGrade = grade; // new highest grade
            }
        }
        return highGrade; // return highest grade
    }

    private void outputBarChart() {
        System.out.println("Grade distribution:");

        // stores frequency of grades in each range of 10 grades
        int[] frequency = new int[11]; // 0-10, ignores zero idx

        // for each grade, increment the appropriate frequency
        // increments the grades distribution, say: 80-89: ****
        for (int grade : grades) {
            ++frequency[grade / 10]; 
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
            System.out.println(); // start a new line of output
        }
    }

    // output bar chart displaying grade distribution
    private void outputGrades() {
        System.out.println("The grades are:\n");

        // output each student's grade
        for (int student = 0; student < grades.length; ++student) {
            System.out.printf("Student %2d: %3d\n",
                    student + 1, grades[student]);
        }

    }

} // end of GradeBook class
