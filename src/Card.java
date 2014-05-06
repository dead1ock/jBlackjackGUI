public class Card {
	
	public enum SUIT {
		SPADES,
		HEARTS,
		DIAMONDS,
		CLUBS
	}
	
	public enum RANK {
		ACE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING
	}
	
	private SUIT suit;
	private RANK rank;
	private boolean hidden;
	
	public Card(SUIT suit, RANK rank) {
		this.suit = suit;
		this.rank = rank;
		this.hidden = true;
	}
	
	public SUIT getSuit() {
		return suit;
	}
	
	public RANK getRank() {
		return rank;
	}
	
	public void reveal() {
		hidden = false;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	public static Card deserialize(String token) {
		String[] attributes = token.split("\t");
		SUIT suit = SUIT.values()[Integer.parseInt(attributes[0])];
		RANK rank = RANK.values()[Integer.parseInt(attributes[1])];
		return new Card(suit, rank);
	}
	
	public int getValue() {
		int value = 0;
		
		if(hidden) // Do not count hidden cards.
			return value;
		
		switch(rank) {
		case ACE:
			value = 11;
			break;
		case EIGHT:
			value = 8;
			break;
		case FIVE:
			value = 5;
			break;
		case FOUR:
			value = 4;
			break;
		case JACK:
			value = 10;
			break;
		case KING:
			value = 10;
			break;
		case NINE:
			value = 9;
			break;
		case QUEEN:
			value = 10;
			break;
		case SEVEN:
			value = 7;
			break;
		case SIX:
			value = 6;
			break;
		case TEN:
			value = 10;
			break;
		case THREE:
			value = 3;
			break;
		case TWO:
			value = 2;
			break;
		default:
			System.out.println("Unknown Card Rank: " + rank);
			break;
		}
		
		return value;
	}
	
	public String toString() {
		if(!hidden)
			return new String(suit.toString() + " " + rank.toString());
		else
			return new String("Hidden");
	}
}