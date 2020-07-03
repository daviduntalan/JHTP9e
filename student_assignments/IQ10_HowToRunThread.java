package student_assignments;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * What are the ways to create and run a Thread?
 * 1. extends Thread class
 * 2. implement Runnable interface
 * 
 * 
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ10_HowToRunThread {

    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        mt1.start(); // cause this thread to begin execution.
        try {
            mt1.join(); // waits for this thread to die.
            System.out.println("Extends thread died.");
        } catch (InterruptedException ex) {
            Logger.getLogger(IQ10_HowToRunThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MyThread2 mt2 = new MyThread2();        
        Thread t = new Thread(mt2);
        t.start(); //  cause this thread to begin execution.
        try {
            t.join(); // waits for this thread to die.
            System.out.println("Runnable thread died.");
        } catch (InterruptedException ex) {
            Logger.getLogger(IQ10_HowToRunThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class MyThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Extends thread running...");
    }
    
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable thread running...");
    }
    
}