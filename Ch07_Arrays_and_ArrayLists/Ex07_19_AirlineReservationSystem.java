package Ch07_Arrays_and_ArrayLists;

import java.util.Random;
import java.util.Scanner;

/**
 * Airline Reservations System. A small airline has just purchased a computer
 * for its new automated reservations system. You've been asked to develop the
 * new system. You're to write an application to assign seats on each flight of
 * the airline's only plane (capacity: 10 seats). Your application should
 * display the following alternatives: Please type 1 for First Class and Please
 * type 2 for Economy. If the user types 1, your application should assign a
 * seat in the first-class section (seat 1-5)
 *
 * @author David
 */
public class Ex07_19_AirlineReservationSystem {

    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    static boolean[] seatNumbers = new boolean[11];
    static boolean isFirstClassAvailable = true;
    static boolean isEconomyAvailable = true;
    static int n, type, firstClassCounter = 0, economyClassCounter = 0;
    static final int EXIT = 0;
    static final int FIRST_CLASS = 1; 
    static final int ECONOMY_CLASS = 2; 
        
    /**
     * NOTE: Randomly taking available seats. 
     * I intentionally do not follow the given instruction.
     */
    public static void main(String[] args) {

        do {            
            type = findAvailableSeats(); printReport();
        } while (type == FIRST_CLASS || type == ECONOMY_CLASS);

        System.out.println("We will take off soon.");
    }

    private static int findAvailableSeats() {        
        type = welcomeMenu();
        if (type == FIRST_CLASS & !isFirstClassAvailable & isEconomyAvailable) {
            System.out.printf("Would you like to be place in Economy? ");
            if ((input.next().charAt(0) | 32) == 'y') reserveEconomySeat();
        } else if (type == ECONOMY_CLASS & !isEconomyAvailable & isFirstClassAvailable) {
            System.out.printf("Would you like to be place in First-class? ");
            if ((input.next().charAt(0) | 32) == 'y') reserveFirstClassSeat();
        } else if (type == FIRST_CLASS & isFirstClassAvailable) {
            reserveFirstClassSeat();
        } else if (type == ECONOMY_CLASS & isEconomyAvailable) {
            reserveEconomySeat();
        } 
        
        if (firstClassCounter == 5) isFirstClassAvailable = false;
        if (economyClassCounter == 5) isEconomyAvailable = false;
        
        if (!isFirstClassAvailable && !isEconomyAvailable) {
            System.err.println("Plane is in full capacity.");
            return EXIT; // to break the do-while logic;
        }
        return type;
    }

    private static void reserveFirstClassSeat() {
        if (!isFirstClassAvailable) return;
        do n = 1 + random.nextInt(5);
        while (seatNumbers[n]); // find available seat
        seatNumbers[n] = true; // mark unavailable
        ++firstClassCounter;
    }    

    private static void reserveEconomySeat() {
        if (!isEconomyAvailable) return;
        do n = 6 + random.nextInt(5);
        while (seatNumbers[n]); // find available seat
        seatNumbers[n] = true; // mark unavailable
        ++economyClassCounter;
    }    

    private static void printReport() {
        for (int i = 1; i < seatNumbers.length; ++i) {
            if (i == 1) System.out.println("FIRST CLASS:");
            if (i == 6) System.out.println("ECONOMY CLASS:");
            System.out.printf("Seat Number[%2d] is %s\n", 
                    i, seatNumbers[i] ? "N/A" : "AVAILABLE");
        }
        System.out.println();
    }

    private static int welcomeMenu() {
        System.out.printf("%s\n%s\n%s\n%s",
                    "Airline Reservations System",
                    "Please type 1 for First Class",
                    "Please type 2 for Economy",
                    "? ");
        return input.nextInt();
    }
}
