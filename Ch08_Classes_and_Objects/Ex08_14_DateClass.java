package Ch08_Classes_and_Objects;

/**
 * Date Class. Create class Date with the following capabilities:
 * 
 * a) Output the date in multiple formats, such as
 * 
 *      MM/DD//YYYY
 *      June 14, 1992
 *      DDD YYYY
 * 
 * b) Use overloaded constructors to create Date objects initialized
 *    with dates of the formats in part (a). In the first case the 
 *    constructor should receive three integer values. In the 2nd case
 *    it should receive a String and two integer values. In the 3rd
 *    case it should receive two integer values, the first of which
 *    represents the day number in the year.
 * 
 * [Hint: To convert the String representation of the month to a numeric value, 
 * compare Strings using the equals method. For example, if s1 and s2 are 
 * Strings, the method call s1.equals( s2 ) returns true if the Strings are 
 * identical and otherwise returns false.]
 */
public class Ex08_14_DateClass {

    public static void main(String[] args) {
        int MM = 11; // November
        int DD = 30; 
        int YYYY = 2020;
        int DDD = 367;
        DateClass d1 = new DateClass(MM, DD, YYYY);
        DateClass d2 = new DateClass("November", DD, YYYY);
        DateClass d3 = new DateClass(DDD, YYYY);        
        
        System.out.println("DateClass(MM, DD, YYYY): " + d1);        
        System.out.println("DateClass(\"November\", DD, YYYY): " + d2);        
        System.out.printf("The day number (%d) in year %d is %s\n", 
                DDD, YYYY, d3);
    }
    
}

class DateClass {

    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // 4 digit year e.i. 1000-9999

    private static final String[] namesOfMonth = { "Not Available",
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"
    };

    private static final int[] daysPerMonth = { // days in each month
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    
    /**
     * @param theDayNumberIn represents the day number in year.
     * @param theYear 
     */
    public DateClass(int theDayNumberIn, int theYear) {
        DateClass td = new DateClass(1, 1, theYear); // Day1
        for (int i = 1; i < theDayNumberIn; ++i) { // i=1 is Day2
            try { td.nextDay(); } 
            catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
        setDateClass(td.getMonth(), td.getDay(), td.getYear());
    }
    
    public DateClass(String theStringMonth, int theDay, int theYear) {
        int theMonth = getIntValueOfMonth(theStringMonth);
        setDateClass(theMonth, theDay, theYear);
    }   

    public DateClass(int theMonth, int theDay, int theYear) {

        setDateClass(theMonth, theDay, theYear);
    }

    public static String[] getNamesOfMonth() { return namesOfMonth; }
    public static int[] getDaysPerMonth() { return daysPerMonth; }

    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getYear() { return year; }

    public void setMonth(int month) { this.month = month; }
    public void setDay(int day) { this.day = day; }
    public void setYear(int year) { this.year = year; }

    private int getIntValueOfMonth(String theMonth) throws IllegalArgumentException {
        int intValueOfMonth = 0;
        for (int i = 0; i < namesOfMonth.length; i++) {
            String nameOfMonth = namesOfMonth[i];            
            if (nameOfMonth.equals(theMonth)) {
                intValueOfMonth = i;
                i = namesOfMonth.length; // break the loop
            }
        }
        if (intValueOfMonth > 0) {
            return intValueOfMonth;
        } 
        throw new IllegalArgumentException("month must be incorrect spelling");
    }

    private void setDateClass(int theMonth, int theDay, int theYear) {
        setMonth( checkMonth(theMonth) ); // validate month
        setDay( checkDay(theDay) ); // validate day
        setYear( checkYear(theYear) ); // validate year
    }
    
    /**
     * validate if year is within the range of 1000-9999.
     * @param testYear represent the year to test
     * @return year in the range between 1000 and 9999.
     * @throws IllegalArgumentException
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
            
        if (testDay == 29 && isLeapYear())
            return testDay;
                
        throw new IllegalArgumentException(
                "day out-of-range for the specified month and year");
    }

    private boolean isLeapYear() {
        return getMonth() == 2 && year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
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

    @Override // return a String of the form month/day/year
    public String toString() {
        return String.format("%d/%d/%d", getMonth(), getDay(), getYear());
    }
}