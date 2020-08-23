package Ch08_Classes_and_Objects;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Enhancing class Time2. Modify class Time2 of Fig. 8.5 to include a tick
 * method that increments the time stored in a Time2 object by one second.
 * Provide method incrementMinute to increment the minute by one and method
 * incrementHour to increment the hour by one. Write a program that tests 
 * the tick method, the incrementMinute method and the incrementHour method
 * to ensure that they work correctly. Be sure to test the following cases:
 * 
 *      a) incrementing into the next minute, 
 *      b) incrementing into the next hour and
 *      c) incrementing into the next day (i.e, 
 *          11:59:59 PM to 12:00:00 AM).
 * 
 * @author David
 */
public class Ex08_07_EnhancingTime2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Time2 time = new Time2(0, 0, 0); int additionalSeconds = 10;
        for (int tick = 0; tick < 60 * 60 * 24 + additionalSeconds; ++tick) {
            System.out.printf("Day %d: %s\n", 
                    time.getDays(), time.toString());
            try {
                time.tick();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex08_07_EnhancingTime2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
