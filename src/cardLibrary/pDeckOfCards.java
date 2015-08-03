package cardLibrary;
import java.util.ArrayList;
import java.util.Collections;

public class pDeckOfCards {

	private ArrayList<pCard> pdeck; // PART 3 : Creation of Pinochle deck of cards
	private int pusedCards;

	// constructor to create pinochle deck of cards i.e 48 cards excluding 2-8.
	public pDeckOfCards() {
		pdeck = new ArrayList<pCard>(48);
		int counter = 0;
		for (int i = 0; i <= pCard.CLUBS; i++) { // suits
			for (int j = 9; j <= pCard.ACE; j++) { // value
				pdeck.add(counter, new pCard(j, i));
				counter++;
			}
		}
		pdeck.addAll(pdeck);
		pusedCards = 0;
		System.out.println(pusedCards);
	}

	public void sortByValue() {
        ArrayList<pCard> newDeck = new ArrayList<pCard>();
        while (pdeck.size() > 0) {
            int pos = 0;  
            pCard c = pdeck.get(0);  
            for (int i = 1; i < pdeck.size(); i++) {
                pCard c1 = pdeck.get(i);
                if ( c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
                    pos = i;
                    c = c1;
                }
            }
            pdeck.remove(pos);
            newDeck.add(c);
        }
        pdeck = newDeck;
    }
	

	// Shuffle
	public void shuffleCards() {
		for (int i = pdeck.size() - 1; i > 0; i--) {
			int randNo = (int) (Math.random() * (i + 1));
			Collections.swap(pdeck, i, randNo);
		}
		pusedCards = 0;
	}

	public void printDeck() {
		for (int i = 1; i <= 48; i++) {
			pCard card = pdeck.get(i - 1);
			System.out.println(i + " : card [" + card + "]");
		}
	}

	public static final void main(String[] args) { // PART 2 : Testing
		// create deck
		pDeckOfCards pdeck = new pDeckOfCards();
		System.out.println("-----------Deck Of Cards-------------------");
		pdeck.printDeck();

		// shuffle
		pdeck.shuffleCards();
		System.out.println("-----------Shuffle Cards-------------------");
		pdeck.printDeck();

		// sortbyValue
		pdeck.sortByValue();
		System.out.println("-----------Sort Cards----------------------");
		pdeck.printDeck();
		
	}

}