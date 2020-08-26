package Ch01_Intro_to_ComputersAndJava;

/**
 * First Java Application.
 * @author David
 */
public class Hello {

    public static void main(String[] args) {

        System.out.print("Enter your name: ");
        String name = new java.util.Scanner(System.in).nextLine();
        System.out.printf("Hello, %s\n", name);
    }
    
}
