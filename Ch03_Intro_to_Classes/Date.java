package Ch03_Intro_to_Classes;

/**
 *
 * @author David
 */
@lombok.Getter
@lombok.Setter
public class Date {

    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }
    
    public void setDay(int date) {
        if (date > 0 && date < 32) {
            day = date;
        } else {
            System.err.println("You provide out of range date value");
        }
    }

    public void displayDate() {
        System.out.printf("%d/%d/%d\n", month, day, year);
    }
}
