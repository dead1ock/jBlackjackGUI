/**
   Name: Dallin Wellington
   Assignment: Final - Blackjack GUI
   Course: CSC205
   Date: May 6th, 2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck = new Stack<Card>();
	private String filename;
	
	public Deck(String filename) throws IOException {
		this.filename = filename;
		createDeck(filename);
	}
	
	/**
	 * Draws one card and returns it, if there are no cards left
	 * it will return NULL instead.
	 */
	public Card drawOne(boolean faceUp) {
		if(deck.size() > 0)
			{
				Card drawnCard = deck.pop();
				if(faceUp)
					drawnCard.reveal();
				return drawnCard;
			}
		else
			return null;
	}
	
	/**
	 * Default drawOne face up.
	 */
	public Card drawOne() {
		return drawOne(true);
	}
	
	public void reshuffle() {
		try {
			createDeck(filename);
		} catch(IOException e) {
			
		}
	}
	
	/**
	 * 
	 * @param file
	 * @throws IOException
	 */
	private void createDeck(String file) throws IOException {
		// Load Deck from file.
		BufferedReader deckFile = new BufferedReader(new FileReader(file));
		String cLine;
		
		while((cLine = deckFile.readLine()) != null) {
			deck.push(Card.deserialize(cLine));
		}
		
		deckFile.close();
		
		// Shuffle Deck
		Collections.shuffle(deck);
	}
}