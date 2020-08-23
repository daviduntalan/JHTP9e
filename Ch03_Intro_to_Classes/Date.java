package Ch03_Intro_to_Classes;

public class Date {

    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getYear() { return year; }

    public void setDay(int date) {
        if (date > 0 && date < 32) {
            day = date;
        } else {
            System.err.println("You provide out of range date value");
        }
    }
    public void setMonth(int month) { this.month = month; }
    public void setYear(int year) { this.year = year; }

    public void displayDate() {
        System.out.printf("%d/%d/%d\n", month, day, year);
    }
}
