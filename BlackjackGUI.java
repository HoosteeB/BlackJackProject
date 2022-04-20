import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class BlackjackGUI extends JPanel {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;

	public GameManager game;

	JPanel north;
	JPanel south;
	JPanel center;
	JFrame frame;

	public BlackjackGUI(GameManager game) {
		this.game = game;

			frame = new JFrame("Blackjack");
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
			north = new JPanel(new FlowLayout());
			south = new JPanel(new FlowLayout());
			center = new JPanel(new FlowLayout());


			///////////////////////////////////////////////////////////////////////////////////////
			//Dimension sizes and background colors


			north.setPreferredSize(new Dimension (40,250));
			north.setBackground(new Color(0,153,0));

			center.setBackground(new Color(0,153,0));

			south.setPreferredSize(new Dimension (40,45));
			south.setBackground(new Color(0,100,0));


			////////////////////////////////////////////////////////////////////////////////////////
			//Center Panel or Player's Panel


			//				for(int i = 0; i < 2 ; i++) {
			//					BufferedImage dealerImage = ImageIO.read(new File(game.player.addPlayerCard().getPath()));
			//					JLabel dealerPic = new JLabel(new ImageIcon(dealerImage));
			//					
			//					dealerCardPlacement.add(dealerPic);
			//					north.add(dealerPic);
			//					
			//					north.add(dealerCardPlacement.pop());
			//					
			//					BufferedImage playerImage = ImageIO.read(new File(game.));
			//					JLabel playerPic = new JLabel(new ImageIcon(playerImage));
			//					
			//					playerCardPlacement.add(playerPic);
			//					
			//					
			//					center.add(playerCardPlacement.pop());
			//				}

			// Display dealer cards

			// Display player cards








			//////////////////////////////////////////////////////////////////////////////////////
			//North Panel or Dealer's Panel
			updateTable();
			checkBlackjack();



			////////////////////////////////////////////////////////////////////////////////////////
			//South Panel


			JButton hitBtn = new JButton();
			hitBtn.setFont(new Font("Plain", Font.BOLD, 20));
			hitBtn.setText("Hit");
			hitBtn.setBackground(Color.WHITE);
			hitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					north.removeAll();
					center.removeAll();
					game.playerDeal();
					updateTable();
					if (Bust()) {
						game.dealer.dealersTurn();
						updateTable();
						winOrLose();
					}
				} } ); 

			JButton doubleBtn = new JButton();
			doubleBtn.setFont(new Font("Plain", Font.BOLD, 20));
			doubleBtn.setText("Double");
			doubleBtn.setBackground(Color.WHITE);
			doubleBtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					//doubleProcess();
				} } );

			JButton standBtn = new JButton();
			standBtn.setFont(new Font("Plain", Font.BOLD, 20));
			standBtn.setText("Stand");
			standBtn.setBackground(Color.WHITE);
			standBtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					game.dealer.dealersTurn();
					updateTable();
					winOrLose();
				    
				} } );

			south.add(hitBtn);
			south.add(doubleBtn);
			south.add(standBtn);

			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Adding all the changes to the panel to the frame
			
			
			frame.add(south, BorderLayout.SOUTH);
			frame.add(center, BorderLayout.CENTER);
			frame.add(north, BorderLayout.NORTH);

			frame.setVisible(true);
	
			}
	public void updateTable() {
		for(int i = game.dealer.hand.getCards().size()-1; i >= 0 ; i--) {
			if (i == 0) {
				
				try {
					BufferedImage dealerImage = ImageIO.read(new File("images/BacksideOfCard.png"));
					JLabel dealerPic = new JLabel(new ImageIcon(dealerImage));
					north.add(dealerPic);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				ArrayList<Card> cards = game.dealer.hand.getCards();
				try {
					BufferedImage dealerImage = ImageIO.read(new File(cards.get(i).getPath()));
					JLabel dealerPic = new JLabel(new ImageIcon(dealerImage));
					north.add(dealerPic);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

		for(Card d : game.player.hand.getCards()) {
			
			try {
				BufferedImage playerImage = ImageIO.read(new File(d.getPath()));
				JLabel playerPic = new JLabel(new ImageIcon(playerImage));
				center.add(playerPic);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public  void exit() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	public void endGame() {
		
		GameManager newGame = new GameManager();
		new BlackjackGUI(newGame);
	}
	public void checkBlackjack() {
		if(game.player.getPlayerTotal() == 21) {
			System.out.println("Player has instant blackjack");
		}else if (game.dealer.getDealerTotal() == 21) {
			System.out.println("Dealer has instant blackjack");
		}
	}

	
	public boolean Bust() {
		if (game.player.getPlayerTotal() > 21 && game.player.hand.contains(FaceValue.ace)) {
			for(Card c : game.player.hand.hand) {
				if (c.getValue() == 11) {
					c.changeAceValue(c);
				}
			} if (game.player.getPlayerTotal() > 22) {
				System.out.println("You Busted you fucking idiot. Player bust total: " + game.player.getPlayerTotal());
				return true;
			}
			System.out.println("Current Total: "+ game.player.getPlayerTotal());
			return false;
		} else if (game.player.getPlayerTotal() < 22 ) {
			System.out.println("Current Total:" + game.player.getPlayerTotal());
			return false;
		}
		else {
			System.out.println("You Busted you fucking idiot. Player bust total: " + game.player.getPlayerTotal());
			return true;
			
		}
		//return newTotal;
	}
	
	public void winOrLose() {
		//Blackjack
		if (game.player.getPlayerTotal() == 21) {
			System.out.println("Player has 21! Congrats!");
			//Return a YOU WIN BOX
			//Return original bet + earnings + half earnings
			//Restart game with new amount
		} else if (game.dealer.getDealerTotal() == 21) {
			System.out.println("Dealer has BlackJack! Congrats!");
			//Return a YOU LOSE BOX
			//Restart game with new amount
		} else if (game.player.getPlayerTotal() == game.dealer.getDealerTotal()) {
			System.out.println("PUSH");
		} else if (game.player.getPlayerTotal() > game.dealer.getDealerTotal() && game.player.getPlayerTotal() < 22) {
			System.out.println("Player Wins!! Player has: " + game.player.getPlayerTotal() + ". Dealer has " + game.dealer.getDealerTotal());
		} else if (game.player.getPlayerTotal() < game.dealer.getDealerTotal() && game.dealer.getDealerTotal() < 22) {
			System.out.println("Dealer Wins!! Dealer has: " + game.dealer.getDealerTotal() + ". Player has " + game.player.getPlayerTotal());
			
		} else if (game.dealer.getDealerTotal() > 21) {
			System.out.println("Dealer Bust: " + game.dealer.getDealerTotal());
		}

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

}
