package Ch06_Methods;

import java.util.Random;
import java.util.Scanner;

/**
 * Computer-Assisted Instruction: Reducing Student Fatigue. One problem
 * in CAI environment is student fatigue. This can be reduced by varying
 * the computer's responses to hold the student's attention. Modify the
 * program of Exercise 6.35 so that various comments are displayed for 
 * each answer as follows:
 * 
 * Possible responses to a correct answer:
 * 
 *      Very good!
 *      Excellent!
 *      Nice work!
 *      Keep up the good work!
 * 
 * Possible responses to an incorrect answer:
 * 
 *      No. Please try again.
 *      Wrong. Try once more.
 *      Don't give up!
 *      No. Keep trying.
 *  
 * Use random-number generation to choose a number from 1 to 4 that will
 * be used to select one of the four appropriate responses to each correct
 * or incorrect answer. Use a switch statement to issue the responses.
 * @author David
 */
public class Ex06_36_ComputerAssistedInstruction {

    static int correctAnswer;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int studentAnswer, counter = 0, maxQs = 10;

        do {
            String questionnaire = generateQuestionnaire();
            ++counter;

            do {
                // The student then inputs the answer.
                System.out.printf("%d/%d. %s ", counter, maxQs, questionnaire);
                studentAnswer = input.nextInt();

                // checks the student's answer. If it's correct
                if (studentAnswer == correctAnswer) {
                    System.out.printf("%s\n", correctResponse());
                } else if(studentAnswer < 0) { // negative numbers - exit!
                    System.err.println("Good bye.");
                } else {
                    System.err.printf("%s\n", incorrectResponse());
                }
            } while (studentAnswer != correctAnswer & studentAnswer > -1);

            System.out.println();
        } while (counter != maxQs & studentAnswer > -1);
    }

    /**
     * Generate random questionnaire in a form of String literals.
     * @return 
     * the correct answer of x * y to static variable correctAnswer
     */
    private static String generateQuestionnaire() {
        Random random = new Random();
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
        correctAnswer = n1 * n2; // saved the correct answer.
        return "How much is " + n1 + " times " + n2 + "?";
    }

    private static String correctResponse() {
        String response;
        switch (new Random().nextInt(4)) {
            case 0: response = "Very good!"; break;
            case 1: response = "Excellent!"; break;
            case 2: response = "Nice work!"; break;
            default:response = "Keep up the good work!";
        }
        return response;
    }

    private static String incorrectResponse() {
        String response;
        switch (new Random().nextInt(4)) {
            case 0: response = "No. Please try again."; break;
            case 1: response = "Wrong. Try once more."; break;
            case 2: response = "Don't give up!"; break;
            default:response = "No. Keep trying.";
        }
        return response;
    }
}
