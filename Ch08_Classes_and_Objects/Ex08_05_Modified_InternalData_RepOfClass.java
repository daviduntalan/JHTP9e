package Ch08_Classes_and_Objects;

/**
 * Modify the Time3 (Time2 previously) class of Fig. 8.5 to implement 
 * the Time3 as the number of seconds since midnight and show that no 
 * change is visible to the clients of the class.
 *
 * @author David
 */
public class Ex08_05_Modified_InternalData_RepOfClass {

    public static void main(String[] args) {

        Time3 t1 = new Time3(); // 00:00:00
        Time3 t2 = new Time3(2); // 02:00:00
        Time3 t3 = new Time3(21, 34); // 21:34:00
        Time3 t4 = new Time3(12, 25, 42); // 12:25:42
        Time3 t5 = new Time3(t4); // 12:25:42

        System.out.println("Constructed with:");
        System.out.println("t1: all arguments defaulted");
        System.out.printf("  %s\n", t1.toUniversalString());
        System.out.printf("  %s\n", t1.toString());

        System.out.println(
                "t2: hour specified; minute and second defaulted");
        System.out.printf("  %s\n", t2.toUniversalString());
        System.out.printf("  %s\n", t2.toString());

        System.out.println(
                "t3: hour and minute specified; second defaulted");
        System.out.printf("  %s\n", t3.toUniversalString());
        System.out.printf("  %s\n", t3.toString());

        System.out.println("t4: hour, minute and second specified");
        System.out.printf("  %s\n", t4.toUniversalString());
        System.out.printf("  %s\n", t4.toString());

        System.out.println("t5: Time3 object t4 specified");
        System.out.printf("  %s\n", t5.toUniversalString());
        System.out.printf("  %s\n", t5.toString());
        
        try {
            Time3 t6 = new Time3(27, 74, 99); // invalid values
        } catch (IllegalArgumentException e) {
            System.out.printf("\nException while initializing t6: %s\n", 
                    e.getMessage());
        }
    } // end of main

} // end class Time3Test
