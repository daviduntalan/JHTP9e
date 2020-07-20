package student_assignments;

import java.util.Random;
import java.util.Scanner;

/**
 * Shuffles the answers of a questionnaire.
 *
 * @author David
 */
public class QuestionAndAnswer {

    public static void main(String[] args) {

        String[] options = new String[]{
            "Dr. Jose P. Rizal",
            "Andres Bonifacio",
            "Manuel L. Quezon",
            "Apolinario Mabini"
        };

        String ans1 = showQNA("1. Sino ang pambansang bayani?", options);
        String ans2 = showQNA("2. Pumili ng letra para sa tamang sagot?",
                "A", "B", "C", "D", "E", "F");

        System.out.printf("Ang sagot mo sa Q1: %s - %s\n", ans1, 
                (ans1.equalsIgnoreCase(options[0]) ? "Tama" : "Mali"));
        System.out.printf("Ang sagot mo sa Q2: %s - %s\n", ans2,
            (ans2.equalsIgnoreCase("D") ? "Tama" : "Mali"));
    }

    private static String showQNA(String question, String... options) {

        Random random = new Random();
        final int MAX = options.length;
        int randomSelect[] = new int[MAX];
        int idx = 0;

        for (int n = 0; n < MAX; n++) {
            do {
                idx = random.nextInt(MAX);
            } while (randomSelect[idx] != 0);
            randomSelect[idx] = 1 + n;
        }

        System.out.println(question);
        for (int i = 0; i < MAX; ++i) {
            idx = randomSelect[i] - 1;
            System.out.printf("%c. %s\n", 'A' + i, options[idx]);
        }
        System.out.print("Ans: ");
        idx = (new Scanner(System.in).next().charAt(0) | 32) - 97;
        return options[randomSelect[idx] - 1];
    }

}
