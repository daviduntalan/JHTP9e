package Ch01_Intro_to_ComputersAndJava;

/**
 * First Java Application.
 * @author David
 */
public class Hello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello, world!");
        String name = new java.util.Scanner(System.in).nextLine();
        System.out.printf("Hello, %s\n", name);
    }
    
}
