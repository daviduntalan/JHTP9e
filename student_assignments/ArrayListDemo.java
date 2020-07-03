package student_assignments;

import java.util.ArrayList;
import java.util.List;

class MyBucket {

    private static List<String> myList = new ArrayList<>();

    public synchronized void addToList(String str) {
        myList.add(str);
    }

    public synchronized List<String> showList() {
        return myList;
    }
}

/**
 *
 * @author David
 */
public class ArrayListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        MyBucket myBucket = new MyBucket();
        Thread t = null;
        for (int i = 0; i < 10; ++i) {
            String s = "S" + i;
            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    myBucket.addToList(s);
                }
            });
            t.start();
        }
        t.join();
        System.out.println("list: " + myBucket.showList());

    }

}
