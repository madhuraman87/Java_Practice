package cardLibrary;
public class pCard {

	// numeric value for the four suits
	public final static int SPADES = 0;
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;

	// numeric value for the non-numeric cards
	public final static int ACE = 14;
	public final static int KING = 12;
	public final static int QUEEN = 11;
	public final static int JACK = 10;
	
	

	private final int suit;
	private final int value;

	public pCard(int value, int suit) {
		if (suit < SPADES || suit > CLUBS)
			System.out.println("Illegal playing card suit");
		if (value < 9 || value > 14)
			System.out.println("Illegal playing card value");
		this.value = value;
		this.suit = suit;
	}

	public int getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}
	
	public String getSuitFace(){
		switch(suit){
		case SPADES:
			return "Spades";
		case HEARTS:
			return "Hearts";
		case DIAMONDS:
			return "Diamonds";
		case CLUBS:
			return "Clubs";
		default:
			return "Unknown";
		}
	}
	
	public String getValueFace(){
		switch(value){
        case 9:   
        	return "9";
        case 10:  
        	return "Jack";
        case 11:  
        	return "Queen";
        case 12:  
        	return "King";
        case 13:  
        	return "10";	
        default:  
        	return "Ace";
		}
	}
	
	public String toString(){
		return getValueFace() + " of " + getSuitFace();
		
	}
	
	

}
