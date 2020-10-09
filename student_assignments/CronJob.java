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
        t.scheduleAtFixedRate(myTask, 0, 3000);
    }

}

class MyTask extends TimerTask {


    private int counter;

    public MyTask() {
        counter = 0;
    }

    @Override
    public void run() {
        System.out.printf("%d. Execute your SQL or "
                + "SMS API here accordingly! See you after 3s.\n", ++counter);
    }
}
