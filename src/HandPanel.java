/**
   Name: Dallin Wellington
   Assignment: Final - Blackjack GUI
   Course: CSC205
   Date: May 6th, 2014
*/

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Responsible for drawing one or multiple Hand(s) of cards to the screen.
 */
public class HandPanel extends JPanel {
	
	private List<Hand> targetHands;
	
	private static Image cardBackImage = new ImageIcon("data/cards/back.png").getImage();
	
	private static Image[] spadesImages = {
		new ImageIcon("data/cards/ace_of_spades.png").getImage(),
		new ImageIcon("data/cards/2_of_spades.png").getImage(),
		new ImageIcon("data/cards/3_of_spades.png").getImage(),
		new ImageIcon("data/cards/4_of_spades.png").getImage(),
		new ImageIcon("data/cards/5_of_spades.png").getImage(),
		new ImageIcon("data/cards/6_of_spades.png").getImage(),
		new ImageIcon("data/cards/7_of_spades.png").getImage(),
		new ImageIcon("data/cards/8_of_spades.png").getImage(),
		new ImageIcon("data/cards/9_of_spades.png").getImage(),
		new ImageIcon("data/cards/10_of_spades.png").getImage(),
		new ImageIcon("data/cards/jack_of_spades.png").getImage(),
		new ImageIcon("data/cards/queen_of_spades.png").getImage(),
		new ImageIcon("data/cards/king_of_spades.png").getImage()
	};

	private static Image[] heartsImages = {
		new ImageIcon("data/cards/ace_of_hearts.png").getImage(),
		new ImageIcon("data/cards/2_of_hearts.png").getImage(),
		new ImageIcon("data/cards/3_of_hearts.png").getImage(),
		new ImageIcon("data/cards/4_of_hearts.png").getImage(),
		new ImageIcon("data/cards/5_of_hearts.png").getImage(),
		new ImageIcon("data/cards/6_of_hearts.png").getImage(),
		new ImageIcon("data/cards/7_of_hearts.png").getImage(),
		new ImageIcon("data/cards/8_of_hearts.png").getImage(),
		new ImageIcon("data/cards/9_of_hearts.png").getImage(),
		new ImageIcon("data/cards/10_of_hearts.png").getImage(),
		new ImageIcon("data/cards/jack_of_hearts.png").getImage(),
		new ImageIcon("data/cards/queen_of_hearts.png").getImage(),
		new ImageIcon("data/cards/king_of_hearts.png").getImage()
	};
	
	private static Image[] diamondsImages = {
		new ImageIcon("data/cards/ace_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/2_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/3_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/4_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/5_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/6_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/7_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/8_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/9_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/10_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/jack_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/queen_of_diamonds.png").getImage(),
		new ImageIcon("data/cards/king_of_diamonds.png").getImage()
	};
	
	private static Image[] clubsImages = {
		new ImageIcon("data/cards/ace_of_clubs.png").getImage(),
		new ImageIcon("data/cards/2_of_clubs.png").getImage(),
		new ImageIcon("data/cards/3_of_clubs.png").getImage(),
		new ImageIcon("data/cards/4_of_clubs.png").getImage(),
		new ImageIcon("data/cards/5_of_clubs.png").getImage(),
		new ImageIcon("data/cards/6_of_clubs.png").getImage(),
		new ImageIcon("data/cards/7_of_clubs.png").getImage(),
		new ImageIcon("data/cards/8_of_clubs.png").getImage(),
		new ImageIcon("data/cards/9_of_clubs.png").getImage(),
		new ImageIcon("data/cards/10_of_clubs.png").getImage(),
		new ImageIcon("data/cards/jack_of_clubs.png").getImage(),
		new ImageIcon("data/cards/queen_of_clubs.png").getImage(),
		new ImageIcon("data/cards/king_of_clubs.png").getImage()
	};
	
	private static final Map<Card.SUIT, Image[]> cardImages;
	static {
		Map<Card.SUIT, Image[]> map = new HashMap<Card.SUIT, Image[]>();
		map.put(Card.SUIT.SPADES, spadesImages);
		map.put(Card.SUIT.HEARTS, heartsImages);
		map.put(Card.SUIT.DIAMONDS, diamondsImages);
		map.put(Card.SUIT.CLUBS, clubsImages);
		cardImages = Collections.unmodifiableMap(map);
	}
	
	/**
	 * We only have one hand to follow, instantiate a new list
	 * and add it.
	 */
	public HandPanel(Hand targetHand) {
		this.targetHands = new ArrayList<Hand>();
		this.targetHands.add(targetHand);
	}
	
	/**
	 * Track an entire list of hands.
	 */
	public HandPanel(List<Hand> targetHands) {
		this.targetHands = targetHands;
	}
	
	/**
	 * Paint each card in the hand.
	 */
	public void paintComponent(Graphics g) {
		for(int y = 0; y < targetHands.size(); y++)
		{
			List<Card> cards = targetHands.get(y).getCards();
			for(int x = 0; x < cards.size(); x++) {
				
				// If the card is hidden, draw the back image. Otherwise, draw it's corresponding face.
				if(cards.get(x).isHidden())
				    // (current_card * x_offset) + ((screen_size_x / (number_of_hands + 1))*(current_hand + 1)) - offset
					g.drawImage(cardBackImage, (x * 20) + ((800 / (targetHands.size() + 1))*(y + 1)) - 75, 10, null);
				else
					g.drawImage(getCardImage(cards.get(x)), (x * 20) + ((800 / (targetHands.size() + 1))*(y + 1)) - 75, 10, null);
			}
		}
	}
	
	private static Image getCardImage(Card card) {
		return cardImages.get(card.getSuit())[card.getRank().ordinal()];
	}
}