package Ch06_Methods;

/**
 *
 * @author David
 */
public class Ex06_30_GuessNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Random random = new java.util.Random();
        System.out.printf("Guess a number between 1 and 1000.\n? ");
        int guessed = input.nextInt();
        do {
            int secretNumber = 1 + random.nextInt(1000);
            input.nextLine();
            do {
                if (guessed > secretNumber) {
                    System.out.println("Too high. Try again");
                } else if (guessed < secretNumber) {
                    System.out.println("Too low. Try again");
                }
                System.out.print("\n? ");
                guessed = input.nextInt();
            } while (guessed != secretNumber);
            System.out.println("Congratulations. You guessed the number!");
            System.out.print("Play again? ");
        } while (input.next().charAt(0) == 'y');
        System.out.println("Tapos na po!");
    }

}
