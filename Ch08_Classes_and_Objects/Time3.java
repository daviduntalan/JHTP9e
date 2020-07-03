package Ch08_Classes_and_Objects;

/**
 * For exercise 8.5: Time3 class declaration with overloaded constructors.
 * @author David
 */
public class Time3 {
    
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59
    
    // Time2 no-argument constructor:
    // initializes each instance variable to zero
    public Time3() {
        // this reference is allowed only as the first statement in a constructor’s body.
        this(0, 0, 0); // invoke Time2 constructor with 3-arguments
    }
    
    // Time2 constructor: hour suppied, minute and second defaulted to 0
    public Time3(int h) {
        // this reference is allowed only as the first statement in a constructor’s body.
        this(h, 0, 0); // invoke Time2 constructor with 3-arguments
    }
    
    // Time2 constructor: hour and minute, second defaulted to 0
    public Time3(int h, int m) {
        // this reference is allowed only as the first statement in a constructor’s body.
        this(h, m, 0); // invoke Time2 constructor with 3-arguments
    }

    // Time2 constructor: hour, minute and second supplied
    public Time3(int h, int m, int s) {
        setTime(h, m, s);
    }

    Time3(Time3 time) {
        setTime(time.getHour(), time.getMinute(), time.getSecond());
    }

    // set methods
    // set a new time value using universal time;
    // validate the data
    public void setTime(int h, int m, int s) {
        setHour(h); setMinute(m); setSecond(s);
    }

    public void setHour(int h) {
        if (h >= 0 && h < 24) hour = h;
        else throw new IllegalArgumentException("hour must be 0-23");
    }

    public void setMinute(int m) {
        if (m >= 0 && m < 60) minute = m;
        else throw new IllegalArgumentException("minute must be 0-59");
    }

    public void setSecond(int s) {
        if (s >= 0 && s < 60) second = s;
        else throw new IllegalArgumentException("second must be 0-59");
    }

    // When implementing a method of a class, use the class’s set and get methods 
    // to access theclass’s private data. This simplifies code maintenance and 
    // reduces the likelihood of errors.
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public int getSecond() { return second; }

    /**
     * convert to String in universal-time format (HH:MM:SS)
     * @return 
     */
    public String toUniversalString() {
        return String.format("%2d:%02d:%02d -OR- %2d:%02d:%02d %s", 
                hour, minute, second,
                ((hour == 0 || hour == 12) ? 12 : hour % 12),
                minute, second, ((hour < 12) ? "AM" : "PM") );
    }
    
    /**
     * convert to String in standard-time format (H:MM:SS AM or PM)
     * @return the number of seconds since midnight.
     */
    @Override
    public String toString() {
        return String.format("%,8d seconds ", 
                hour * 3600 + minute * 60 + second * 1
        );        
    }
}