package Ch07_Arrays_and_ArrayLists;

/**
 * Fig. 7.9: Card class represents a playing card.
 * @author David
 */
public class Card {

    private String face; // face of card ("Ace", "Deuce", ...)
    private String suit; // face of card ("Heart", "Diamonds", ...)

    public Card(String face, String suit) {
        this.face = face; // initialize face of card
        this.suit = suit; // initialize suit of card
    }

    public String getSuit() {
        return suit;
    }

    /**
     * The toString method of an object is called implicit when the 
     * object is used where a String is expected (e.g. when printf
     * outputs the object as a String using the %s format specifier
     * or when the object is concatenated to a String using the + operator.
     * @return 
     */
    @Override // representation of Card
    public String toString() {
        // return face + " of " + suit;
        return String.format("%2s %s", face, suit);
    }
}
