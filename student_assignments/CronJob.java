package student_assignments;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author David
 */
public class CronJob {

    public static void main(String[] args) {

        Timer t = new Timer();
        MyTask myTask = new MyTask();
        t.scheduleAtFixedRate(myTask, 0, 5000);        
    }

}

class MyTask extends TimerTask {

    public MyTask() {
    }

    @Override
    public void run() {
        System.out.println("Execute your SQL or "
                + "SMS API here accordingly! See you after 5s.");
    }
}
