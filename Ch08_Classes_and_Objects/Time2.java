package Ch08_Classes_and_Objects;

/**
 * Fig. 8.5: Time2 class declaration with overloaded constructors.
 * @author David
 */
public class Time2 {
    
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59
    private int days = 1;
        
    // Time2 no-argument constructor:
    // initializes each instance variable to zero
    public Time2() {
        // this reference is allowed only as the first statement in a constructor’s body.
        this(0, 0, 0); // invoke Time2 constructor with 3-arguments
    }
    
    // Time2 constructor: hour suppied, minute and second defaulted to 0
    public Time2(int h) {
        // this reference is allowed only as the first statement in a constructor’s body.
        this(h, 0, 0); // invoke Time2 constructor with 3-arguments
    }
    
    // Time2 constructor: hour and minute, second defaulted to 0
    public Time2(int h, int m) {
        // this reference is allowed only as the first statement in a constructor’s body.
        this(h, m, 0); // invoke Time2 constructor with 3-arguments
    }

    // Time2 constructor: hour, minute and second supplied
    public Time2(int h, int m, int s) {
        setTime(h, m, s);
    }

    Time2(Time2 time) {
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
     * increments the time stored in a Time2 object by one second.
     * @throws InterruptedException 
     */
    public void tick() throws InterruptedException {
        if (getSecond() + 1 < 60) {
            setSecond(getSecond() + 1);
        } else {
            incrementMinute();
            setSecond(0);
        }
        // Thread.sleep(1000);
    }
    
    private void incrementMinute() {
        if (getMinute() + 1 < 60) {
            setMinute(getMinute() + 1);
        } else {
            incrementHour();
            setSecond(0);
            setMinute(0);
        }
    }
    
    private void incrementHour() {
        if (getHour() + 1 < 24) {
            setHour(getHour() + 1);
        } else {
            incrementDay();
            setSecond(0);
            setMinute(0);
            setHour(0);
        }
    }
    
    private void incrementDay() {
        ++days;
    }
    
    public int getDays() {
        return days;
    }
    

    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    // convert to String in standard-time format (H:MM:SS AM or PM)
    @Override
    public String toString() {
        return String.format("%2d:%02d:%02d %s",
            ((hour == 0 || hour == 12) ? 12 : hour % 12),
            minute, second, ((hour < 12) ? "AM" : "PM"));
    }    
    
}