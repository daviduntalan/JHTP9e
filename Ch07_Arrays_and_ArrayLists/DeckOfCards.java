package Ch07_Arrays_and_ArrayLists;

import java.util.Random;

/**
 * DeckOfCards class represents a deck of playing cards.
 * Fig. 7.10
 * @author David
 */
public class DeckOfCards {

    private Card[] deck; // array of Card objects
    private int currentCard; // index of next Card to be dealt (0-51)
    static final int NUMBER_OF_CARDS = 52; // constant # of Cards
    private static final Random random = new Random();

    /**
     * constructor fills deck of cards.
     * creates the deck with the 52 Card objects in order by suit and face.
     */
    public DeckOfCards() {
        /* String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" }; */
        String faces[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String suits[] = {"\u2665", "\u2666", "\u2663", "\u2660"};

        deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealth is deck[0]
        
        // populate deck with Card objects
        for (int count = 0; count < deck.length; ++count) {
            deck[count] = new Card(
                    faces[count % 13], // 0-12
                    suits[count / 13] // 0-3 (0: 0-12, 1: 13-25, 2: 26-38, 3:39-51)
            );
        } // end for
    } // end constructor DeckOfCards() 
    
    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // after shuffling, dealing should start at deck[0] again
        currentCard = 0; // reinitialie currentCard
        
        // for each Card, pick another random Card (0-51) and swap them
        for (int first = 0; first < deck.length; ++first) {
            // select a random number between 0 and 51
            int second = random.nextInt(NUMBER_OF_CARDS); // 0-51
            
            // swap current Card with randomly selected Card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        } // end for
    } // end method shuffle.
    
    /**
     * deal one Card.
     * @return card on top of the deck otherwise, return null
     */
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length) {
            return deck[currentCard++]; // return current Card in array
        } 
        return null; // return null to indicate that all Cards were dealt 
    }
}
