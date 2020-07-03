package Ch06_Methods;

import java.util.Random;
import java.util.Scanner;

/**
 * Computer-Assisted Instruction: Difficulty Levels. 
 * Exercise 6.35 through Exercise 6.37 developed a computer-assisted
 * instruction program to help teach an elementary school student 
 * multiplication. Modify the program to allow the user to enter a 
 * difficulty level. At a difficulty level of 1, the program should 
 * use only single-digit numbers in the problems; at a difficulty 
 * level of 2, numbers as large as two digits, and so on.
 * 
 * @author David
 */
public class Ex06_38_ComputerAssistedInstruction {

    private static int correctAnswer;
    private static int correctResponses;
    private static int incorrectResponses;
    private static Scanner input = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

        int studentAnswer, counter = 0, maxQs = 10;
        int difficultyLevel = getDifficultyLevel();
        
        do {
            String questionnaire = generateQuestionnaire(difficultyLevel);
            System.out.printf("%d/%d. %s ", ++counter, maxQs, questionnaire);
            studentAnswer = input.nextInt(); // The student then inputs the answer.

            // checks the student's answer. If it's correct
            if (studentAnswer == correctAnswer) {
                System.out.printf("%s\n", correctResponse());
            } else {
                System.err.printf("%s\n", incorrectResponse());
            }
                                
            if (counter == maxQs) { // calculate the percentage of correct responses.
                double percentage = 0.05 + (double) correctResponses / (double) maxQs;
                System.out.printf("You've got %.0f%%\n", percentage * 100);
                if (percentage < 0.75) {
                    System.out.println("Please ask your instructor for extra help.\n");                    
                } else {
                    System.out.println("Congratulations! You have passed the subject.\n");
                }
                counter = 0; // reset the program so another student can try it.
                correctAnswer = 0; correctResponses = 0; incorrectResponses = 0;
            }
        } while (counter < maxQs & studentAnswer > -1);
        
        System.out.println("Tapos na po!");
    } // end of main()
    

    /**
     * Generate random questionnaire in a form of String literals.
     * @return 
     * the correct answer of x * y to static variable correctAnswer
     */
    private static String generateQuestionnaire(int difficultyLevel) {                              
        int n1 = random.nextInt((int) Math.pow(10, difficultyLevel));
        int n2 = random.nextInt((int) Math.pow(10, difficultyLevel));
        correctAnswer = n1 * n2; // saved the correct answer.
        return "How much is " + n1 + " times " + n2 + "?";
    }

    private static String correctResponse() {
        String response; ++correctResponses;
        switch (random.nextInt(4)) {
            case 0: response = "Very good!"; break;
            case 1: response = "Excellent!"; break;
            case 2: response = "Nice work!"; break;
            default:response = "Keep up the good work!";
        }
        return response;
    }

    private static String incorrectResponse() {
        String response; ++incorrectResponses;
        switch (random.nextInt(4)) {
            case 0: response = "No. Please try again."; break;
            case 1: response = "Wrong. Try once more."; break;
            case 2: response = "Don't give up!"; break;
            default:response = "No. Keep trying.";
        }
        return response;
    }

    private static int getDifficultyLevel() {
        System.out.printf("Choose Difficulty Level of your CAI-Test\n");
        System.out.printf("1 - use single-digit numbers in the problems\n");
        System.out.printf("2 - use two-digit numbers in the problems\n");
        System.out.printf("3 - use three-digit numbers in the problems\n");
        System.out.printf("4 - use four-digit numbers in the problems\n");
        System.out.printf("Enter a difficulty level: ");
        return input.nextInt(); 
    }
}
