package student_assignments;

/**
 * What's the difference between StringBuffer vs StringBuilder
 * 
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ07_StringBufferBuilder {

    public static void main(String[] args) {
        System.out.printf("1000 milliseconds is equal to 1 second (1000ms = 1s).\n");
        
        // non-synchronized (not-thread-safe)
        StringBuilder sb = new StringBuilder();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; ++i) {
            sb.append("Hello");
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.printf("StringBuilder duration: %dms or %.3fs\n", duration, duration/1000.0);
        
        // synchronized (thread-safe)
        StringBuffer sbf = new StringBuffer();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; ++i) {
            sbf.append("Hello");
        }
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.printf("StringBuffer  duration: %dms or %.3fs\n", duration, duration/1000.0);
        
        
    }

}
