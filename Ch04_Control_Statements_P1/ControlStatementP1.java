package Ch04_Control_Statements_P1;

/**
 *
 * @author David
 */
public class ControlStatementP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int grade = 60;

        // if...else construct
        if (grade >= 60) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        // ternary operator
        System.out.println((grade >= 60) ? "Passed" : "Failed");

        // nested if...else statements
        if (grade >= 90) {
            System.out.println("A");
        } else {
            if (grade >= 80) {
                System.out.println("B");
            } else {
                if (grade >= 70) {
                    System.out.println("C");
                } else {
                    if (grade >= 60) {
                        System.out.println("D");
                    } else {
                        System.out.println("F");
                    }
                }
            }
        }
        
        if (grade >= 90) 
            System.out.println("A");
        else if (grade >= 80) 
            System.out.println("B");
        else if (grade >= 70) 
            System.out.println("C");
        else if (grade >= 60) 
            System.out.println("D");
        else 
            System.out.println("F");
        
        int x = 5;
        int y = 7;
        // dangling-if...else
        if (x > 5) {
            if (y > 5)
                System.out.println("x and y are > 5");
        } else 
            System.out.println("x is <= 5");


        
        int total = 0;
        int gradeCounter = 1;
        
        while (gradeCounter <= 10) {
            System.out.printf("Enter the next grade: ");
            grade = new java.util.Scanner(System.in).nextInt();
            total += grade;
            ++gradeCounter;
        }
        
        double average = total / 10;
        System.out.printf("Average: %.2f\n", average);
        
        System.out.println("Tapos na po!");
    }

}
