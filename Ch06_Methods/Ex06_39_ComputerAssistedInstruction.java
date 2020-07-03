package Ch06_Methods;

import java.util.Random;
import java.util.Scanner;

/**
 * Computer-Assisted Instruction: Varying the Types of Problems.
 * Modify the program of Exercise 6.38 to allow the user to pick a 
 * type of arithmetic problem to study. An option of 1 means addition 
 * problems only, 2 means subtraction problems only, 3 means multiplication 
 * problems only, 4 means division problems only and 5 means a random 
 * mixture of all these types.
 * @author David
 */
public class Ex06_39_ComputerAssistedInstruction {

    private static int correctAnswer;
    private static int correctResponses;
    private static int incorrectResponses;
    private static Scanner input = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

        int studentAnswer, counter = 0, maxQs = 10;
        int difficulty = getDifficultyLevel(); System.out.println();
        int mathOption = getArithmeticOption(); System.out.println();
        
        do {
            String questionnaire = generateQuestionnaire(difficulty, mathOption);
            System.out.printf("%d/%d. %s ", ++counter, maxQs, questionnaire);
            studentAnswer = input.nextInt(); // The student then inputs the answer.

            // checks the student's answer. If it's correct
            if (studentAnswer == correctAnswer) {
                System.out.printf("%s\n", correctResponse());
            } else {
                System.err.printf("%s\n", incorrectResponse());
            }
                                
            if (counter == maxQs) { 
                calculatePercentageAndCorrectResponse(maxQs);
                counter = 0; // reset the counter so another student can try it.                
            }
        } while (counter < maxQs); // & studentAnswer > -1);
        
        System.out.println("Tapos na po!");
    } // end of main()

    /**
     * calculate the percentage of correct responses.
     * @param maxQs 
     */
    private static void calculatePercentageAndCorrectResponse(int maxQs) {
        
        double percentage = 0.05 + (double) correctResponses / (double) maxQs;
        System.out.printf("You've got %.0f%%\n", percentage * 100);
        
        if (percentage < 0.75) {
            System.out.println("Please ask your instructor for extra help.\n");
        } else {
            System.out.println("Congratulations! You have passed the subject.\n");
        }
        
        correctAnswer = correctResponses = incorrectResponses = 0;
    }
    

    /**
     * Generate random questionnaire in a form of String literals.
     * @return 
     * the correct answer of x * y to static variable correctAnswer
     */
    private static String generateQuestionnaire(int difficultyLevel, int mathOption) {                              
        int n1 = random.nextInt((int) Math.pow(10, difficultyLevel));
        int n2 = random.nextInt((int) Math.pow(10, difficultyLevel));
        return getVaryingTypesOfProblem(n1, n2, mathOption);
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

    private static String getVaryingTypesOfProblem(int n1, int n2, int option) {
        switch ((option == 5) ? 1 + random.nextInt(4) : option) {
            case  4: correctAnswer = n1 / n2; return "How much is " + n1 + " / " + n2 + "?";            
            case  3: correctAnswer = n1 * n2; return "How much is " + n1 + " * " + n2 + "?";
            case  2: correctAnswer = n1 - n2; return "How much is " + n1 + " - " + n2 + "?";
            default: correctAnswer = n1 + n2; return "How much is " + n1 + " + " + n2 + "?"; 
        }
    }

    private static int getArithmeticOption() {
        System.out.printf("Pick a Type of Arithmetic Problem to Study\n");
        System.out.printf("1 - Addition problems only\n");
        System.out.printf("2 - Subtraction problems only\n");
        System.out.printf("3 - Multiplication problems only\n");
        System.out.printf("4 - Division problems only\n");
        System.out.printf("5 - Mixture of all these types\n");
        System.out.printf("Enter your option: "); 
        return input.nextInt(); 
    }
}