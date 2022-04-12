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

public class BlackjackGUI extends JPanel {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;

	public static void main(String[] args) {
		new BlackjackGUI();
	}

	public BlackjackGUI() {
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
				BufferedImage img3 = ImageIO.read(new File(playersFirstCard));
				JLabel pic3 = new JLabel(new ImageIcon(img3));
				int playersCV1 = cardValue(playersFirstCard);
				System.out.println("Player's 1st Card: " + playersFirstCard + "\n \t Card Value: " + playersCV1);
				
				String playersSecondCard = newCards.pop();
				BufferedImage img4 = ImageIO.read(new File(playersSecondCard));
				JLabel pic4 = new JLabel(new ImageIcon(img4));
				int playersCV2 = cardValue(playersSecondCard);
				System.out.println("Player's 2nd Card: " + playersSecondCard + "\n \t Card Value: " + playersCV2);
				
				
				int playerTotal = playersCV1 + playersCV2;
				//int playerTotal = 21;
				System.out.println("Player Total: " + playerTotal);
				
				center.add(pic4);
				center.add(pic3);
				
				

				//////////////////////////////////////////////////////////////////////////////////////
				//North Panel or Dealer's Panel


				String dealersFirstCard = newCards.pop();
				BufferedImage img = ImageIO.read(new File("BacksideOfCard.png"));
				JLabel pic = new JLabel(new ImageIcon(img));
				int dealerCV1 = cardValue(dealersFirstCard);
				System.out.println("Dealer's 1st Card: " + dealersFirstCard + "\n \t Card Value: " + dealerCV1);
				
				String dealersSecondCard = newCards.pop();
				BufferedImage img2 = ImageIO.read(new File(dealersSecondCard));
				JLabel pic2 = new JLabel(new ImageIcon(img2));
				int dealerCV2 = cardValue(dealersSecondCard);
				System.out.println("Dealer's 2nd Card: " + dealersSecondCard + "\n \t Card Value: " + dealerCV2);
				
				int dealerTotal = dealerCV1 + dealerCV2;
				//int dealerTotal = 21;
				//pic is put right of the pic2
				north.add(pic2);
				north.add(pic);


				////////////////////////////////////////////////////////////////////////////////////////
				//South Panel


				JButton hitBtn = new JButton();
				hitBtn.setFont(new Font("Plain", Font.BOLD, 20));
				hitBtn.setText("Hit");
				hitBtn.setBackground(Color.WHITE);
				
				hitBtn.addActionListener(new ActionListener() {
	
					public void actionPerformed(ActionEvent e) {
						hitProcess();
					} } ); 

				JButton doubleBtn = new JButton();
				doubleBtn.setFont(new Font("Plain", Font.BOLD, 20));
				doubleBtn.setText("Double");
				doubleBtn.setBackground(Color.WHITE);
				
				doubleBtn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent event) {
						doubleProcess();
					} } );

				JButton standBtn = new JButton();
				standBtn.setFont(new Font("Plain", Font.BOLD, 20));
				standBtn.setText("Stand");
				standBtn.setBackground(Color.WHITE);
				
				standBtn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						standProcess();
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
				checkPlayerBlackjack(playerTotal, dealerTotal);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	/* List Of Methods needed:
	 * - Flip over dealer card
	 * - Dealer turn after stand
	 */
	public static void dealersTurn(int dealerTotal, int dealerCV1, int dealerCV2) {
		flipDealerCard();
		if(dealerTotal <= 16) {
			hitProcess();
		} else if(dealerTotal = 17 && dealerCV1 = 11) {
			dealerCV1 = 1; 
			hitProcess();
		} else if(dealerTotal = 17 && dealerCV2 = 11) {
			dealerCV2 = 1; 
			hitProcess();
		} else if(dealerTotal >= 17) {
			standProcess();
		}
	} 
	
	public static void flipDealerCard() {
		//method that flips over the dealers card in 
	}
	
	public static void checkPlayerBlackjack(int playerTotal, int dealerTotal) {
			
			if (playerTotal == 21) {
				String winnerText = "YOU HAVE BLACKJACK";
				JOptionPane.showMessageDialog(null, winnerText);
				new BlackjackGUI();
				
			} else if(dealerTotal == 21) {
				String loserText = "Dealer Has Blackjack, Loser";
				JOptionPane.showMessageDialog(null, loserText);
				new BlackjackGUI();
			}
	}
	
	public static void doubleProcess() {
		int playersCV1;
		int playersCV2;
		if (playersCV1 != playersCV2) {
		String cantDouble = "You cant Double Idiot";
		JOptionPane.showMessageDialog(null, cantDouble);
	}
	}
	public static void standProcess() {
		int dealerTotal;
		dealersTurn(dealerTotal);
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
		cards.addAll(Arrays.asList("2OfSpades.png", "3OfSpades.png", "4OfSpades.png", "5OfSpades.png", "6OfSpades.png", "7OfSpades.png", "8OfSpades.png", "9OfSpades.png", "10OfSpades.png", "JackOfSpades.png", "KingOfSpades.png", "QueenOfSpades.png", "AceOfSpades.png",
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