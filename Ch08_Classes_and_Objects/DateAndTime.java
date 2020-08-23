package Ch08_Classes_and_Objects;

public class DateAndTime {

    private int year; // 4 digit year e.i. 1000-9999
    private int month; // 1-12
    private int day; // 1-31 based on month

    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    private static final int[] daysPerMonth = { // days in each month
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    /**
     * Default: January 1, 1000, 00:00:00
     */
    public DateAndTime() {
        setTime(0, 0, 0);
    }
    
    /**
     * January 1, 1000, HH:00:00
     * Time constructor: hour supplied, minute and second defaulted to 0
     * @param HH
     */
    public DateAndTime(int HH) {
        setTime(HH, 0, 0);
    }
    
    /**
     * January 1, 1000, HH:MM:00
     * Time constructor: hour and minute supplied, second defaulted to 0
     * @param HH
     * @param MM
     */
    public DateAndTime(int HH, int MM) {
        setTime(HH, MM, 0);
    }

    /**
     * January 1, 1000, HH:MM:SS
     * Time constructor: hour, minute and second supplied
     * @param HH
     * @param MM
     * @param SS
     */
    public DateAndTime(int HH, int MM, int SS) {
        setTime(HH, MM, SS);
    }
    
    // constructor: call checkMonth to confirm proper value for month;
    // call checkDay to confirm proper value for day
    public DateAndTime(int theMonth, int theDay, int theYear,  int HH, int MM, int SS) {
        setTime(HH, MM, SS); // default: January 1, 1000        
        setDate(theYear, theMonth, theDay); // override the default date
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public int getSecond() { return second; }

    public static int[] getDaysPerMonth() { return daysPerMonth; }

    public void setYear(int year) { this.year = year; }
    public void setMonth(int month) { this.month = month; }
    public void setDay(int day) { this.day = day; }

    private void setHour(int h) {
        if (h >= 0 && h < 24) hour = h;
        else throw new IllegalArgumentException("hour must be 0-23");
    }

    private void setMinute(int m) {
        if (m >= 0 && m < 60) minute = m;
        else throw new IllegalArgumentException("minute must be 0-59");
    }

    private void setSecond(int s) {
        if (s >= 0 && s < 60) second = s;
        else throw new IllegalArgumentException("second must be 0-59");
    }

    // When implementing a method of a class, use the class’s set and get methods 
    // to access the class’s private data. This simplifies code maintenance and
    // reduces the likelihood of errors. NOTE: been replaced by lombok annotation       
    
    private void setTime(int h, int m, int s) {
        setDate(1000, 1, 1); // default: January 1, 1000
        setHour(h); setMinute(m); setSecond(s);
    }

    /**
     * Date must be in chronological (e.i, sequential or in order of
     * Year, Month before Day) as day is dependent on month and year.
     * @param YYYY represent year
     * @param MM represent month
     * @param DD represent day
     */
    private void setDate(int YYYY, int MM, int DD) {
        setYear( checkYear(YYYY) ); // validate year
        setMonth( checkMonth(MM) ); // validate month
        setDay( checkDay(DD) ); // validate day
    }

    /**
     * increments the time stored in a DateAndTime object by one second.
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
    
    private void incrementMinute() throws InterruptedException {
        if (getMinute() + 1 < 60) {
            setMinute(getMinute() + 1);
        } else {
            incrementHour();
            setSecond(0);
            setMinute(0);
        }
    }
    
    private void incrementHour() throws InterruptedException {
        if (getHour() + 1 < 24) {
            setHour(getHour() + 1);
        } else {
            nextDay();
            setSecond(0);
            setMinute(0);
            setHour(0);
        }
    }

    private void nextDay() throws InterruptedException {
        int nextDay = getDay() + 1;
        int add1Day = nextDay == 29 && isLeapYear() ? 1 : 0;
        if (nextDay <= daysPerMonth[ getMonth() ] + add1Day) {
            nextDay = checkDay(nextDay); // double check
            setDay(nextDay);
        } else {
            incrementMonth();
            setDay(1); // reset to day 1
        }
        Thread.sleep(10);
    }

    private void incrementMonth() {
        int nextMonth = getMonth() + 1;
        if (nextMonth <= 12) {
            nextMonth = checkMonth(nextMonth); // double check
            setMonth(nextMonth);
        } else {
            incrementYear();
            setMonth(1);
            setDay(1);
        }
    }

    private void incrementYear() {
        int nextYear = checkYear(getYear() + 1);
        setYear(nextYear);
    }
    
    /**
     * @param testYear
     * @return year from 1000-9999.
     */
    private int checkYear(int testYear) {
        if (testYear > 999 && testYear < 10000) {
            return testYear;
        } else 
            throw new IllegalArgumentException("year must be 1000-9999");
    }

    // utility method to confirm proper month value
    private int checkMonth(int testMonth) {
        if (testMonth > 0 && testMonth <= 12) {
            return testMonth;
        } else
            throw new IllegalArgumentException("month must be 1-12");
    }

    private int checkDay(int testDay) {
        if (testDay > 0 && testDay <= daysPerMonth[ getMonth() ])
            return testDay;

        // check for leap year
        if (testDay == 29 && isLeapYear())
            return testDay;

        throw new IllegalArgumentException(
                "day out-of-range for the specified month and year");
    }

    public boolean isLeapYear() {

        return getMonth() == 2 && year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    
    // return a String of the form month/day/year
    public String toStringDate() {        

        return String.format("%d/%d/%d", getMonth(), getDay(), getYear());
    }

    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%s %02d:%02d:%02d",
                toStringDate(), hour, minute, second);
    }

    @Override // convert to String in standard-time format (H:MM:SS AM or PM)
    public String toString() {
        return String.format("%s %2d:%02d:%02d %s", toStringDate(),
                ((hour == 0 || hour == 12) ? 12 : hour % 12),
                minute, second, ((hour < 12) ? "AM" : "PM"));
    }
}
