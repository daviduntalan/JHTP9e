package Ch08_Classes_and_Objects;

/**
 * Enhancing class Date. Modify class Date of Fig.8.7 to perform error
 * checking on the initializer values for instance variables month, 
 * day and year (currently it validates only the month and day).
 * 
 * @author David
 */
public class Ex08_08_EnhancingDate {

    public static void main(String[] args) {
        
        Date today = new Date(6, 21, 2020);
        int counter = 0, days; // if leap year: 366 days otherwise, 365 days
        for (int year = 2020; year < 2120; ++year) {
            days = today.isLeapYear() ? 366 : 365;
            for (int day = 0; day < days; day++) {
                System.out.printf("Day %d of %d: %s\n", day+1, ++counter, today);
                try { today.nextDay(); } 
                catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            } // inner for
        } // outer for                
    } // end of main
    
} 
