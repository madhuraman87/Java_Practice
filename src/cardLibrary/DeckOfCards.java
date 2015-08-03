package cardLibrary;
import java.util.*;


public class DeckOfCards {

	private ArrayList<Card> deck; // PART 1 : Creation of Methods
	private int usedCards;

	// constructor to create deck of cards i.e 52 cards.
	public DeckOfCards() {
		deck = new ArrayList<Card>(52);
		int counter = 0;
		for (int i = 0; i <= Card.CLUBS; i++) { // suits
			for (int j = 1; j <= Card.KING; j++) { // value
				deck.add(counter, new Card(j, i));
				counter++;
			}
		}
		usedCards = 0;
	}

	public Card getCard(int randNo) {
		// TODO Auto-generated method stub
		Card card = deck.get(randNo);
		return card;
	}

	public ArrayList<Card> sortBySuit() {
		ArrayList<Card> newDeck = new ArrayList<Card>();
		while (deck.size() > 0) {
			int pos = 0; 
			Card c = deck.get(0); 
			for (int i = 1; i < deck.size(); i++) {
				Card c1 = deck.get(i);
				if (c1.getSuit() < c.getSuit()
						|| (c1.getSuit() == c.getSuit() && c1.getValue() < c
								.getValue())) {
					pos = i;
					c = c1;
				}
			}
			deck.remove(pos);
			newDeck.add(c);
		}
		return newDeck;
	}

	// Shuffle
	public void shuffleCards() {
		for (int i = deck.size() - 1; i > 0; i--) {
			int randNo = (int) (Math.random() * (i + 1));
			Collections.swap(deck, i, randNo);
			// Card temp = deck.get(i);
			// deck[i] = deck[randNo];
			// deck[randNo] = temp;
		}
		usedCards = 0;
	}

	// Deal one card
	public Card dealACard() {
		if (usedCards == deck.size()) {
			System.out.println("No cards left to deal.");
		}
		usedCards++;
		Card temp = deck.get(usedCards - 1);
		deck.set(usedCards - 1, null);
		return temp;
	}

	// Turn Over
	public void turnACard() {
		if (usedCards == deck.size()) {
			System.out.println("No cards left to turn.");
		}
		Card card = deck.get(usedCards);
		System.out.println("Next card to deal is : card [" + card + "]");
		usedCards++;
	}

	// Search position of Card
	public String findCardPos(Card card) {

		for (int i = 0; i <= deck.size() - 1; i++) {
			Card dcard = deck.get(i);
			if (dcard.equals(card)) {
				System.out.println("Card [" + card + "] found at " + (i+1));
			}
		}
		return null;
	}

	// Cut the Deck
	public void cutDeck(int pos) {
		ArrayList<Card> d1 = new ArrayList<Card>(deck.subList(0, pos));// top
		ArrayList<Card> d2 = new ArrayList<Card>(deck.subList(pos, deck.size()));// bottom
		ArrayList<Card> result = new ArrayList<Card>(d2.size() + d1.size());
		result.addAll(d2);
		result.addAll(d1);
		deck = result;
	}

	// New Order of Deck
	public void newOrderDeck() {
		deck = sortBySuit();
		ArrayList<Card> HDeck = new ArrayList<Card>();
		ArrayList<Card> CDeck = new ArrayList<Card>();
		ArrayList<Card> DDeck = new ArrayList<Card>();
		ArrayList<Card> SDeck = new ArrayList<Card>();
		for (int i = 0; i < deck.size(); i++) {
			String face = deck.get(i).getSuitFace();
			switch (face) {
			case "Spades":
				SDeck.add(deck.get(i));
				break;
			case "Hearts":
				HDeck.add(deck.get(i));
				break;
			case "Diamonds":
				DDeck.add(deck.get(i));
				break;
			default:
				CDeck.add(deck.get(i));
				break;
			}
		}
		Collections.reverse(DDeck);
		Collections.reverse(SDeck);
		HDeck.addAll(CDeck);
		HDeck.addAll(DDeck);
		HDeck.addAll(SDeck);
		deck = HDeck;
	}

	public void printDeck() {
		for (int i = 1; i <= 52; i++) {
			Card card = deck.get(i-1);
			System.out.println(i + " : card [" + card + "]");
		}
	}

	public static final void main(String[] args) { // PART 2 : Testing
		
		// create deck
		DeckOfCards deck = new DeckOfCards();
		System.out.println("-----------Deck Of Cards-------------------");
		deck.printDeck();

		// shuffle
		deck.shuffleCards();
		System.out.println("-----------Shuffle Cards-------------------");
		deck.printDeck();

		// find the card position
		System.out.println("-----------Find A Cards--------------------");
		int randNo = (int) (Math.random() * (52));
		Card card1 = deck.getCard(randNo);
		deck.findCardPos(card1);

		// cut the deck
		System.out.println("-----------Cut the Deck--------------------");
		System.out.println("Enter the cut position : ");
		Scanner obj = new Scanner(System.in);
		int input = obj.nextInt();
		deck.cutDeck(input);
		deck.printDeck();

		// newOrder
		System.out.println("-----------New Order of Deck---------------");
		deck.newOrderDeck();
		deck.printDeck();

		// deal a card & turn the card
		System.out.println("-----------Deal a Card---------------------");
		deck.shuffleCards();
		deck.printDeck();
		Card card = deck.dealACard();
		System.out.println("Dealt card is : card [" + card + "]");
		deck.printDeck();
		System.out.println("-----------Turn A Card---------------------");
		deck.turnACard();
		deck.turnACard();
		deck.turnACard();

		obj.close();
	}

}

// public static ArrayList<Card> subDeck(ArrayList<Card> deck, int low, int
// high) {
// ArrayList<Card> sub = new ArrayList<Card>(high - low + 1);
// for (int i = 0; i < sub.size(); i++) {
// Card card = deck.get(low + i);
// sub.add(i, card);
// }
// return sub;
// }

// public static ArrayList<Card> merge(ArrayList<Card> d2, ArrayList<Card> d1) {
//
// ArrayList<Card> result = new ArrayList<Card>(d2.size() + d1.size());
// result.addAll(d2);
// result.addAll(d1);
// //System.arraycopy(d2, 0, result, 0, d2.size());
// //System.arraycopy(d1, 0, result, d2.size(), d1.size());
// return result;
// }
// public static void removeCard(Card[] deck2, int pos) {
// int num = deck2.length - (pos + 1);
// System.arraycopy(deck2, pos + 1, deck2, pos, num);
// }
//
// public static Card[] addCard(Card[] deck, Card card) {
// deck = Arrays.copyOf(deck, deck.length + 1);
// deck[deck.length - 1] = card;
// return deck;
// }
// // New Order
// public void newOrder() {
// Card[] newDeck = new Card[52];
// while (deck.length > 0) {
// int pos = 0; // Position of minimal card.
// Card c = deck[0]; // Minimal card.
// for (int i = 1; i < deck.length; i++) {
// Card c1 = deck[i];
// if (c1.getSuit() < c.getSuit()
// || (c1.getSuit() == c.getSuit() && c1.getValue() < c
// .getValue())) {
// pos = i;
// c = c1;
// }
// }
// removeCard(deck, pos);
// addCard(newDeck, c);
// }
// deck = newDeck;
// }