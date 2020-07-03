package Ch03_Intro_to_Classes;

/**
 *
 * @author David
 */
public class Ex03_15_DateDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date today = new Date(5, 31, 2020);
        today.displayDate();
        today.setDay(today.getDay() + 3);
        today.displayDate();
    }

}
