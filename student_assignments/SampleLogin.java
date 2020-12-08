import java.io.Console;
import java.util.Arrays;

public class SampleLogin {

    private static final Console console = System.console();

    public static void main(String[] args) {

        String username = console.readLine("username: ");
        char[] password = console.readPassword("password for %s: ", username);

        boolean validUsername = "admin".equals(username);
        boolean validPassword = "admin".equals(new String(password));
        Arrays.fill(password, (char) 0);

        if (validUsername && validPassword) {
            System.out.println("Welcome Granted!");
        } else {
            System.err.println("Access Denied!");
        }

        System.out.println("Done.");
    }
}