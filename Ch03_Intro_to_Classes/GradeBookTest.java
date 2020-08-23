package Ch03_Intro_to_Classes;

import java.util.Scanner;

/**
 * Create GradeBook object and pass a String to 
 * its displayMessage method.
 */
public class GradeBookTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GradeBook gradeBook1 = new GradeBook("CS101 Intro to Java Programming");
        GradeBook gradeBook2 = new GradeBook("CS102 Data Strctures in Java");
        
        // display initial value of courseName
        System.out.printf("Initial course name is %s\n\n", 
                gradeBook1.getCourseName());

        // System.out.println("Please enter the course name:");
        // String nameOfCourse = input.nextLine(); // read a line of text
        System.out.println(); // outputs a blank line

        // call myGradeBook's displayMessage method
        // and pass nameOfCourse as an argument
        // gradeBook1.displayMessage(nameOfCourse);
        
        // display initial value of courseName for each GradeBook
        System.out.printf("gradeBook1 course name is: %s\n", gradeBook1.getCourseName());
        System.out.printf("gradeBook2 course name is: %s\n", gradeBook2.getCourseName());
                
    }
}
