package student_assignments;

import java.util.Scanner;

public class LoopsDemo {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        foreachLoop();
        whileLoop();
    }

    private static void foreachLoop() {
        String[] fruits = { "Apple", "Mango", "Orange" };
        for (int i = fruits.length-1; i > -1; --i) {
            System.out.println(fruits[i]);
        }

        System.out.println("foreach demo: ");
        for (String fruit: fruits) {
            System.out.println(fruit);
        }
    }

    private static void whileLoop() {
        String input = "";
        while (true) {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass")) continue;
            if (input.equals("quit")) break;
            System.out.println(input);
        }
    }
}
