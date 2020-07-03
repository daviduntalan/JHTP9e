package Ch08_Classes_and_Objects;

import java.util.EnumSet;

/**
 * Fig. 8.11: Testing enum type Book.
 *
 * @author David
 */
public class EnumTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("All books:\n");

        // print all books in enum book
        for (Book book : Book.values()) {
            System.out.printf("%-10s%-45s%s\n", book,
                    book.getTitle(), book.getCopyrightYear());
        }

        System.out.println("\nDisplay a range of enum constants:\n");
        // print first foru books
        for (Book book : EnumSet.range(Book.JHTP, Book.CPPHTP)) {
            System.out.printf("%-10s%-45s%s\n", book,
                    book.getTitle(), book.getCopyrightYear());
        }

        System.out.println();

        System.out.println("Using Enumeration in 'switch' Statement\n");
        for (Book book : Book.values()) {
            switch (book) {
                case JHTP: System.out.printf("%-10s%-45s%s\n", book, book.getTitle(), book.getCopyrightYear()); break;
                case CHTP: System.out.printf("%-10s%-45s%s\n", book, book.getTitle(), book.getCopyrightYear()); break;
                case IW3HTP: System.out.printf("%-10s%-45s%s\n", book, book.getTitle(), book.getCopyrightYear()); break;
                case CPPHTP: System.out.printf("%-10s%-45s%s\n", book, book.getTitle(), book.getCopyrightYear()); break;
                case VBHTP: System.out.printf("%-10s%-45s%s\n", book, book.getTitle(), book.getCopyrightYear()); break;
                case CSHARPHTP: System.out.printf("%-10s%-45s%s\n", book, book.getTitle(), book.getCopyrightYear()); break;
                default: System.err.println("What do you mean?");
            } // end switch
        } // end for

    } // end main

} // end class
