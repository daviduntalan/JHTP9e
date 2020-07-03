package Ch06_Methods;

import java.util.Random;
import java.util.Scanner;

/**
 * Computer-Assisted Instruction. The use of computers in education is referred
 * to as computer-assisted instruction (CAI). Write a program that will help an
 * elementary school student learn multiplication. Use a Random object to
 * produce two positive one-digit integers. The program should then prompt the
 * user with a question, such as
 *
 * How much is 6 times 7?
 *
 * The student then inputs the answer. Next, the program checks the student's
 * answer. If it's correct, display the message "Very good!" and ask another
 * multiplication question. If the answer is wrong, display the msg
 * "No. please try again." and let the student try the same question
 * repeatedly until the student finally gets it right. A separate
 * method should b used to generate each new question. This method
 * should be called once when the application begins execution and
 * each time the user answers the question correctly.
 *
 * @author David
 */
public class Ex06_35_ComputerAssistedInstruction {

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
                    System.out.println("Very good!");
                } else {
                    System.err.println("No. Pleae try again.");
                }
            } while (studentAnswer != correctAnswer);

            System.out.println();
        } while (counter != maxQs);
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

}
