package Ch11_ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fig. 11.13: (New in Java SE 7) try-with-Resources:
 * Automatic Resource Deallocation
 * @author David
 */
public class TryWithResources {

    public static void main(String[] args) {
        
        try (FileReader fr = new FileReader("test.txt")) {
            if (fr.ready()) {
                System.out.printf("%s", fr.read());
            }
        } catch (FileNotFoundException | ThreadDeath | VirtualMachineError ex) {
            System.err.printf("Exception: %s\n", ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(TryWithResources.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
}
