package Ch06_Methods;

import java.util.Random;
import java.util.Scanner;

/**
 * Computer-Assisted Instruction: Monitoring Student Performance.
 * More sophisticated computer-assisted instruction systems monitor the
 * student's performance over a period of time. The decision to begin a
 * new topic is based on the student's success with previous topics.
 * 
 * Modify the program of Exercise 6.36 to count the number of correct
 * and incorrect responses typed by the student. After the student 
 * types 10 answers, your program should calculate the percentage
 * that are correct. If the percentage is lower than 75%, display
 * "Please ask your teacher for extra help.", then reset the program 
 * so another student can try it. If the percentage is 75% or higher,
 * display "Congratulations, you are ready to go to the next level!",
 * then reset the program so another student can try it.
 * 
 * @author David
 */
public class Ex06_37_ComputerAssistedInstruction {

    private static int correctAnswer;
    private static int correctResponses;
    private static int incorrectResponses;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int studentAnswer, counter = 0, maxQs = 10;

        do {
            String questionnaire = generateQuestionnaire();
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
    private static String generateQuestionnaire() {
        Random random = new Random();
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
        correctAnswer = n1 * n2; // saved the correct answer.
        return "How much is " + n1 + " times " + n2 + "?";
    }

    private static String correctResponse() {
        String response; ++correctResponses;
        switch (new Random().nextInt(4)) {
            case 0: response = "Very good!"; break;
            case 1: response = "Excellent!"; break;
            case 2: response = "Nice work!"; break;
            default:response = "Keep up the good work!";
        }
        return response;
    }

    private static String incorrectResponse() {
        String response; ++incorrectResponses;
        switch (new Random().nextInt(4)) {
            case 0: response = "No. Please try again."; break;
            case 1: response = "Wrong. Try once more."; break;
            case 2: response = "Don't give up!"; break;
            default:response = "No. Keep trying.";
        }
        return response;
    }
}
