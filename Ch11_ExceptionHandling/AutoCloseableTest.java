package Ch11_ExceptionHandling;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Demo how to use try-with-resources.
 * to de-allocate resources automatically;
 * requires that the class name implements
 * AutoCloseable interface before you can use
 * it into try-with-resource.
 * @author David
 */

class FileCloseable implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Freeing resources...");
        System.out.println("...closing Done.");
    }

    void open() {
        System.out.println("Opening a file...");
    }

    String read() {
        return "This is a test";
    }
    
}

public class AutoCloseableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try( 
                FileCloseable fc = new FileCloseable(); 
                FileReader fr = new FileReader("F:\\temp\\repoJava\\jHTP9e\\javaHTP9e\\src\\Ch11_ExceptionHandling\\AutoCloseableTest.java")
            ) {
            fc.open();
            String message = fc.read();
            System.out.printf("fetch message: %s\n", message);
        } catch (Exception ex) {
            Logger.getLogger(AutoCloseableTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
