package Ch05_Control_Statements_P2;

/**
 * “The Twelve Days of Christmas” Song. Write an application that uses 
 * repetition and switch statements to print the song “The TwelveDays 
 * of Christmas.” One switch statement should be used to print the day
 * (“first,” “second,” and so on). A separate switch statement should 
 * be used to print the remainder of each verse.
 * @author David
 */
public class Ex05_29_TwelveDaysOfXmas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("The Twelve Days of Christmas - Lyrics\n" +
            "www.12days.com/library/carols/12daysofxmas.htm\n");
        System.out.println("en.wikipedia.org/wiki/The_Twelve_Days_of_Christmas_(song)\n");
        int days = 1;
        do {
            switch (days) {
                case  1: System.out.println("On the 1st day of Christmas"); break;
                case  2: System.out.println("On the 2nd day of Christmas"); break;
                case  3: System.out.println("On the 3rd day of Christmas"); break;
                case  4: System.out.println("On the 4th day of Christmas"); break;
                case  5: System.out.println("On the 5th day of Christmas"); break;
                case  6: System.out.println("On the 6th day of Christmas"); break;
                case  7: System.out.println("On the 7th day of Christmas"); break;
                case  8: System.out.println("On the 8th day of Christmas"); break;
                case  9: System.out.println("On the 9th day of Christmas"); break;
                case 10: System.out.println("On the 10th day of Christmas"); break;
                case 11: System.out.println("On the 11th day of Christmas"); break;
                case 12: System.out.println("On the 12th day of Christmas"); break;
            }            
            System.out.println("my true love sent to me:");
            switch (days) {
                case 12: System.out.println("12 Drummers Drumming");
                case 11: System.out.println("Eleven Pipers Piping");
                case 10: System.out.println("Ten Lords a Leaping");
                case  9: System.out.println("Nine Ladies Dancing");
                case  8: System.out.println("Eight Maids a Milking");
                case  7: System.out.println("Seven Swans a Swimming");
                case  6: System.out.println("Six Geese a Laying");
                case  5: System.out.println("Five Golden Rings");
                case  4: System.out.println("Four Calling Birds");
                case  3: System.out.println("Three French Hens");
                case  2: System.out.print  ("Two Turtle Doves\nand ");
                case  1: System.out.println("A Partridge in a Pear Tree");
            }
            System.out.println();
        } while (++days <= 12);
        System.out.println("Tapos na po!");
    }
    
}
