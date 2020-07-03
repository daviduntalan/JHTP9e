package Ch04_Control_Statements_P1;

import java.util.Scanner;

/**
 * GradeBook class that solves class-average problem using counter-controlled
 * repetition. Fig. 4.6: GradeBook.java
 *
 * @author David
 */
public class GradeBook {

    private String courseName;

    public GradeBook(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayMessage() {
        System.out.printf("Welcoem to the grade book for\n%s!\n\n",
                getCourseName());
    }

    public void determinteClassAverage() {
        Scanner input = new Scanner(System.in);

        int total;
        int gradeCounter;
        int grade;
        double average;

        // initialization phase
        total = 0;
        gradeCounter = 0;

        // processing phase
        System.out.printf("Enter grade or -1 to quit: ");
        grade = input.nextInt();

        // loop until sentinel value read from user
        while (grade != -1) {
            total = total + grade;
            gradeCounter = gradeCounter + 1;

            System.out.printf("Enter grade or -1 to quit: ");
            grade = input.nextInt();
        }

        // terminatino phae
        if (gradeCounter != 0) {
            // Even though varible average is declared as a double,
            // the following calculation loses the fractional part 
            // of the quotient before the result of the division is
            // assigned to average. This occurs because total and 
            // gradeCounter are both integers, and integer division 
            // yeals an integer result. See page 124.
            average = (double) total / gradeCounter; 
            
            System.out.printf("\nTotal of the %d grades entered is %d\n", 
                    gradeCounter, total);
            System.out.printf("Class average is %.2f\n", average);
        } else {
            System.out.println("No grades were entered");
        }
        
    }
}
