package Ch08_Classes_and_Objects;

/**
 * Fig. 8.7: Date class declaration.
 */
public class Date {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // 4 digit year e.i. 1000-9999
    
    private static final int[] daysPerMonth = // days in each month
    { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // constructor: call checkMonth to confirm proper value for month;
    // call checkDay to confirm proper value for day
    public Date(int theMonth, int theDay, int theYear) {
        month = checkMonth(theMonth); // validate month
        year = checkYear(theYear); // validate year
        day = checkDay(theDay); // validate day
        
        // output the "this" reference as a String.
        // Since "this" is a reference to the current Date object,
        // the object's toString() method is called implicitly to 
        // obtain the object's String representation.
        System.out.printf("Date object constructor for date %s\n", this);
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

    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getYear() { return year; }

    public void setMonth(int month) { this.month = month; }
    public void setDay(int day) { this.day = day; }
    public void setYear(int year) { this.year = year; }

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
    
    @Override // return a String of the form month/day/year
    public String toString() {

        return String.format("%d/%d/%d", getMonth(), getDay(), getYear());
    }

    public void nextDay() throws InterruptedException {
        int nextDay = getDay() + 1;
        int add1Day = nextDay == 29 && isLeapYear() ? 1 : 0;
        if (nextDay <= daysPerMonth[ getMonth() ] + add1Day) {
            nextDay = checkDay(nextDay); // double check
            setDay(nextDay);
        } else {
            incrementMonth();
            setDay(1); // reset to day 1
        }
        // Thread.sleep(10);
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
    
}