/**
   Name: Dallin Wellington
   Assignment: Final - Blackjack GUI
   Course: CSC205
   Date: May 6th, 2014
*/

import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper class for our hands.
 */
public class Hand {
	private List<Card> hand = new ArrayList<Card>();
	private int betAmount = 0;

	public void AddCard(Card card) {
		hand.add(card);
	}
	
	/**
	 * Returns the total value of the hand.
	 */
	public int getValue() {
		int value = 0;
		
		// Loop through each card and add it's value.
		for(int x = 0; x < hand.size(); x++) {
			value += hand.get(x).getValue();
		}
		
		//
		// This ensures the BEST option is chosen for ACE cards.
		// ACE cards are initially counted as 11, this loop performs
		// a second pass on the hand, where if we are over 21 points and have an ACE card,
		// minus 10 points.
		//
		for(int x = 0; x < hand.size(); x++) {
			if((hand.get(x).getRank() == Card.RANK.ACE) && (value > 21))
				value -= 10;
		}
		
		return value;
	}
	
	public Card getCard(int index) {
		return hand.get(index);
	}
	
	public String toString() {
		String ret = new String();
		for(int x = 0; x < hand.size(); x++)
		{
			ret += hand.get(x);
			if(x != (hand.size() - 1))
				ret += ", ";
		}
		ret += " (" + getValue() + ")";
		return ret;
	}
	
	public int getBetAmount() {
		return betAmount;
	}
	
	public void setBetAmount(int betAmount) {
		this.betAmount = betAmount;
	}
	
	public List<Card> getCards() { return this.hand; }
	
	/**
	 * Compares two hands values and returns the winner, also accounting for pushes, busts and blackjacks.
	 * @return Returns 1 on this hand winning, 0 on other handing winning, and -1 on Push.
	 */
	public int getWinner(Hand other) {
		
		// Check for blackjack.
		if(isBlackjack() && !other.isBlackjack())
			return 1;
		
		// See if anyone busts
		if(isBust())
			return 0;
		else if (other.isBust())
			return 1;
		
		if(getValue() == other.getValue())
			return -1;
		
		return (getValue() > other.getValue()) ? 1 : 0;
		
	}
	
	public boolean isBust() {
		return (getValue() > 21);
	}
	
	public boolean isBlackjack() {
		return (getValue() == 21) && (hand.size() == 2);
	}
	
	public boolean isSplittable() {
		if(hand.size() != 2)
			return false;
		else if((hand.get(0).getRank() == hand.get(1).getRank()))
			return true;
		
		return false;
	}
	
	public int getSize() {
		return hand.size();
	}
	
	public void Clear() {
		hand.clear();
	}
	
	public Hand split() {
		Hand newHand = new Hand();
		
		newHand.AddCard(hand.get(1));
		newHand.setBetAmount(betAmount);
		
		hand.remove(1);
		return newHand;
	}
}