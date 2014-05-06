/**
   Name: Dallin Wellington
   Assignment: Final - Blackjack GUI
   Course: CSC205
   Date: May 6th, 2014
*/

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Draws felt and background image on the board.
 */
public class BoardPanel extends JPanel {
	
	private Image feltImage;
	private Image backgroundImage;
	
	/**
	 * Default Constructor
	 */
	public BoardPanel(String feltImage, String backgroundImage) {
		this.feltImage = new ImageIcon(feltImage).getImage();
		this.backgroundImage = new ImageIcon(backgroundImage).getImage();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(feltImage, 0, 0, null);
		g.drawImage(backgroundImage, 50, 150, null);
	}
}