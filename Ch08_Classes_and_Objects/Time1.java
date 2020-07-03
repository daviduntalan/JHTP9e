package Ch08_Classes_and_Objects;

/**
 * Fig. 8.1: Time1 class declaration maintains the time in 24-hour format.
 * @author David
 */
public class Time1 {
    
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59
    
    // in this example, class Time1 doesn't declare a constructor,
    // so the class has a default constructor that's supplied by the
    // compiler. each instance variable implicitly receives a default 
    // value of 0 for an int. instance varibles also can be initialized
    // when they're declared in the class body, using the same 
    // initialization syntax as with a local variable.
    
    // set a new time value using universal time; throw an
    // exception if the hour, minute or second is invalid
    public void setTime(int h, int m, int s) {
        // validate hour, minute and second
        if ((h >= 0 && h < 24) && 
            (m >= 0 && m < 60) && 
            (s >= 0 && s < 60)) {
            hour = h;
            minute = m;
            second = s;
        } else {
            throw new IllegalArgumentException(
                    "hour, minute and/or second was out of range");
        }
    }
    
    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    // convert to String in standard-time format (H:MM:SS AM or PM)
    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s",
            ((hour == 0 || hour == 12) ? 12 : hour % 12),
            minute, second, ((hour < 12) ? "AM" : "PM"));
    }
}