package Ch07_Arrays_and_ArrayLists;

/**
 * Fig. 7.11: Card shuffling and dealing.
 * @author David
 */
public class DeckOfCardsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DeckOfCards myDeckOfCards = new DeckOfCards(); // Ctrl + Space for more info
        myDeckOfCards.shuffle(); // place Cards in random order
        
        // print all 52 Cards in the order in which they are dealt
        for (int i = 1; i <= DeckOfCards.NUMBER_OF_CARDS; ++i) {
            
            // deal and display a Card            
            System.out.printf("%-9s", myDeckOfCards.dealCard());
            
            if (i % 4 == 0) { // output a newline every fourth card
                System.out.println();
            }
        }
    }
    
}