package Ch08_Classes_and_Objects;

/**
 * Date and Time Class. Create class DateAndTime that combines the modified
 * Time2 class of Exercise 8.7 and the modified Date class of Exercise 8.8.
 * Modify method incrementHour to call method nextDay if the time is 
 * incremented into the next day. Modify methods toString and 
 * toUniversalString to output the date in addition to the time. Write
 * a program to test the new class DateAndTime. Specifically, test 
 * incrementing the time to the next day.
 * 
 * @author David
 */
public class Ex08_12_DateTimeClass {

    public static void main(String[] args) {
        DateAndTime dt1 = new DateAndTime(); // January 1, 1000, 0:0:0
        DateAndTime dt2 = new DateAndTime(9);  // January 1, 1000, 9:0:0
        DateAndTime dt3 = new DateAndTime(9, 48);  // January 1, 1000, 9:48:0
        DateAndTime dt4 = new DateAndTime(9, 48, 59); // January 1, 1000, 9:48:59
        DateAndTime dt5 = new DateAndTime(6, 21, 2020, 9, 48, 59); // June 21, 2020, 9:48:59
        
        System.out.println("DateAndTime.toString():");
        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
        System.out.println(dt5);
        System.out.println("Ticking started...");
        
        int days = 3; // hh * mm * ss * days + ss
        for (int tick = 0; tick < 24 * 60 * 60 * days + 10; ++tick) {
            try { dt5.tick(); System.out.printf("%s\n", dt5);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
    }
    
}