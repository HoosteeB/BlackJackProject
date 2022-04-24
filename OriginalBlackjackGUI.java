import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class OriginalBlackjackGUI extends JPanel {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;

	public static void main(String[] args) {
		new OriginalBlackjackGUI();
	}

	public OriginalBlackjackGUI() {
		// JFrame configuration
		Stack<String> newCards = new Stack<String>();		
		shuffle(newCards);

			try {
				JFrame frame = new JFrame("Blackjack");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
				frame.setTitle("Blackjack");
				frame.setLocationRelativeTo(null);

				///////////////////////////////////////////////////////////////////////////////////
				// get a screen size and put a frame on the center of screen
				Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
				frame.setLocation(new Point((int) (screenSize.width / 2.0), (int) (screenSize.height / 2.0)));
				///////////////////////////////////////////////////////////////////////////////////


				//JPanels for Border Layout
				frame.setLayout(new BorderLayout());
				JPanel north = new JPanel(new FlowLayout());
				JPanel south = new JPanel(new FlowLayout());
				JPanel center = new JPanel(new FlowLayout());

				
				///////////////////////////////////////////////////////////////////////////////////////
				//Dimension sizes and background colors
				
				
				north.setPreferredSize(new Dimension (40,250));
				north.setBackground(new Color(0,153,0));

				center.setBackground(new Color(0,153,0));

				south.setPreferredSize(new Dimension (40,45));
				south.setBackground(new Color(0,100,0));

				
				////////////////////////////////////////////////////////////////////////////////////////
				//Center Panel or Player's Panel


				String playersFirstCard = newCards.pop();
	
				

				//////////////////////////////////////////////////////////////////////////////////////
				//North Panel or Dealer's Panel


				String dealersFirstCard = newCards.pop();
				BufferedImage img = ImageIO.read(new File("images/2OfHearts.png"));
				JLabel pic = new JLabel(new ImageIcon(img));
				int dealerCV1 = cardValue(dealersFirstCard);
				System.out.println("Dealer's 1st Card: " + dealersFirstCard + "\n \t Card Value: " + dealerCV1);
				
	
				
				north.add(pic);


				////////////////////////////////////////////////////////////////////////////////////////
				//South Panel


				JButton hitBtn = new JButton();
				hitBtn.setFont(new Font("Plain", Font.BOLD, 20));
				hitBtn.setText("Hit");
				hitBtn.setBackground(Color.WHITE);
				hitBtn.addActionListener(new ActionListener() {
	
					public void actionPerformed(ActionEvent e) {
		
					} } ); 

				JButton doubleBtn = new JButton();
				doubleBtn.setFont(new Font("Plain", Font.BOLD, 20));
				doubleBtn.setText("Double");
				doubleBtn.setBackground(Color.WHITE);
				doubleBtn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
			
					} } );

				JButton standBtn = new JButton();
				standBtn.setFont(new Font("Plain", Font.BOLD, 20));
				standBtn.setText("Stand");
				standBtn.setBackground(Color.WHITE);
				standBtn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
					} } );

				south.add(hitBtn);
				south.add(doubleBtn);
				south.add(standBtn);

				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//Adding all the changes to the panel to the frame
				frame.add(north, BorderLayout.NORTH);
				frame.add(center, BorderLayout.CENTER);
				frame.add(south, BorderLayout.SOUTH);
				
				
				frame.setVisible(true);
			
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	/* List Of Methods needed:
	 * - Flip over dealer card
	 * - Dealer turn after stand
	 */
	

	public static void checkPlayerBlackjack(int playerTotal, int dealerTotal) {
			
			if (playerTotal == 21) {
				String btnText = "YOU HAVE BLACKJACK";
				JOptionPane.showMessageDialog(null, btnText);
				new OriginalBlackjackGUI();
				
			} else if (dealerTotal == 21) {
				String btnText = "DEALER HAS BLACKJACK";
				JOptionPane.showMessageDialog(null, btnText);
				new OriginalBlackjackGUI();
			} 
	}
	

	
	public static void doubleProcess() {
		
	}
	
	public static void standProcess(int dealerTotal, int dealerCV1, int dealerCV2) {

	}
	
	public static void hitProcess() {
		
	/*}
		try { 
			String fifthCard = newCards.pop();
			
			BufferedImage img5 = ImageIO.read(new File(fifthCard));
			JLabel pic5 = new JLabel(new ImageIcon(img5));
			int CardValue5 = cardValue(pic5);
			
			hitBtn.add(pic5);
			repaint();
			} catch (IOException e2) {
				e2.printStackTrace();
			} */
		
	} 
	
	public static void shuffle(Stack<String> newCards) {
		ArrayList<String> cards = new ArrayList<String>();
		cards.addAll(Arrays.asList("images/2OfSpades.png", "images/3OfSpades.png", "images/4OfSpades.png", "images/5OfSpades.png", "images/6OfSpades.png", "images/7OfSpades.png", "images/8OfSpades.png", "images/9OfSpades.png", "images/10OfSpades.png", "images/JackOfSpades.png", "KingOfSpades.png", "QueenOfSpades.png", "AceOfSpades.png",
				"2OfHearts.png", "3OfHearts.png", "4OfHearts.png", "5OfHearts.png", "6OfHearts.png", "7OfHearts.png", "8OfHearts.png", "9OfHearts.png", "10OfHearts.png", "JackOfHearts.png", "KingOfHearts.png", "QueenOfHearts.png", "AceOfHearts.png", 
				"2OfDiamonds.png", "3OfDiamonds.png", "4OfDiamonds.png", "5OfDiamonds.png", "6OfDiamonds.png", "7OfDiamonds.png", "8OfDiamonds.png", "9OfDiamonds.png", "10OfDiamonds.png", "JackOfDiamonds.png", "KingOfDiamonds.png", "QueenOfDiamonds.png", "AceOfDiamonds.png", 
				"2OfClubs.png", "3OfClubs.png", "4OfClubs.png", "5OfClubs.png", "6OfClubs.png", "7OfClubs.png", "8OfClubs.png", "9OfClubs.png", "10OfClubs.png", "JackOfClubs.png", "KingOfClubs.png", "QueenOfClubs.png", "AceOfClubs.png"));
		Collections.shuffle(cards);

		for (String c: cards) {
			newCards.push(c);
		}


	}
	public static int cardValue(String Card) {
		if(Card.equals("2OfSpades.png") || Card.equals("2OfHearts.png") || Card.equals("2OfClubs.png") || Card.equals("2OfDiamonds.png")) {
			return 2;
		} else if(Card.equals("3OfSpades.png") || Card.equals("3OfHearts.png") || Card.equals("3OfClubs.png") || Card.equals("3OfDiamonds.png")) {
			return 3;
		} else if(Card.equals("4OfSpades.png") || Card.equals("4OfHearts.png") || Card.equals("4OfClubs.png") || Card.equals("4OfDiamonds.png")) {
			return 4;
		} else if(Card.equals("5OfSpades.png") || Card.equals("5OfHearts.png") || Card.equals("5OfClubs.png") || Card.equals("5OfDiamonds.png")) {
			return 5;
		} else if(Card.equals("6OfSpades.png") || Card.equals("6OfHearts.png") || Card.equals("6OfClubs.png") || Card.equals("6OfDiamonds.png")) {
			return 6;
		} else if(Card.equals("7OfSpades.png") || Card.equals("7OfHearts.png") || Card.equals("7OfClubs.png") || Card.equals("7OfDiamonds.png")) {
			return 7;
		} else if(Card.equals("8OfSpades.png") || Card.equals("8OfHearts.png") || Card.equals("8OfClubs.png") || Card.equals("8OfDiamonds.png")) {
			return 10;
		} else if(Card.equals("9OfSpades.png") || Card.equals("9OfHearts.png") || Card.equals("9OfClubs.png") || Card.equals("9OfDiamonds.png")) {
			return 10;
		} else if(Card.equals("10OfSpades.png") || Card.equals("10OfHearts.png") || Card.equals("10OfClubs.png") || Card.equals("10OfDiamonds.png")) {
			return 10;
		} else if(Card.equals("JackOfSpades.png") || Card.equals("JackOfHearts.png") || Card.equals("JackOfClubs.png") || Card.equals("JackOfDiamonds.png")) {
			return 10;
		} else if(Card.equals("QueenOfSpades.png") || Card.equals("QueenOfHearts.png") || Card.equals("QueenOfClubs.png") || Card.equals("QueenOfDiamonds.png")) {
			return 10;
		} else if(Card.equals("KingOfSpades.png") || Card.equals("KingOfHearts.png") || Card.equals("KingOfClubs.png") || Card.equals("KingOfDiamonds.png")) {
			return 10;
		} else {
			return 11;
		}

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}