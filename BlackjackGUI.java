import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.ArrayList;

public class BlackjackGUI {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	
	Timer time = new Timer();
	
	GameManager game;
	JFrame frame;
	JPanel mainPanel;
	JPanel gamePanel;
	GridLayout playerGrid;
	GridLayout dealerGrid;
	JButton standBtn;
	JButton doubleBtn;
	JButton hitBtn;
	JButton enterBet;
	
	int currentAmount;
	int betAmount;
	int newAmount;
	
	public BlackjackGUI(GameManager game, int currentMoney) {
		this.game = game;
		this.currentAmount = currentMoney;
		
		frame = new JFrame("Blackjack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setTitle("Blackjack");
		frame.setLocationRelativeTo(null);

		// main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(0,153,0));
		
		JPanel betPanel = new JPanel();
		betPanel.setLayout(new BorderLayout());
		betPanel.setBackground(Color.GREEN);

		JPanel betNorth = new JPanel();
		betNorth.setLayout(new FlowLayout());
		betNorth.setBackground(new Color(0,153,0));
		
		/*JButton infoBtn = new JButton();
		infoBtn.setText("Info");
		infoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				gameInfo();
				
			}
		});
		
		betNorth.add(infoBtn); */
		
		JLabel bet = new JLabel("Bet:  $");
		bet.setFont(new Font("Serif", Font. BOLD, 20));
		bet.setForeground(Color.WHITE);
		betNorth.add(bet);
		
		JTextField input = new JTextField(16);
		//input.setSize(20, 20);
		betNorth.add(input);
		
		
		
		JButton enterBet = new JButton();
		enterBet.setText("Enter");
		enterBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				String betAmountString = input.getText();
				String replacedCharacters = betAmountString.replaceAll("[^\\p{IsDigit}]","");
				betAmount = Integer.parseInt(replacedCharacters);
			    if(currentAmount == 0 && betAmount == 0) {
					kickedOut();
				} else if (currentAmount < betAmount) {
					JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
				} else {
					newAmount = currentAmount - betAmount;
					blackjackTable();
					game.startGame();
				}
				
				
			}
		});
		betNorth.add(enterBet);
		
		JPanel betSouth = new JPanel();
		betSouth.setBackground(new Color(0,153,0));
		
		
		JLabel pot = new JLabel("Current Amount:  $" + currentMoney);
		betSouth.add(pot);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 1));
		center.setBackground(new Color(0,153,0));
		
		
		
		JLabel welcomeText = new JLabel("Welcome to BlackJack");
		welcomeText.setLayout(new FlowLayout());
		welcomeText.setForeground(Color.BLACK);
		
		welcomeText.setFont(new Font("Serif", Font. BOLD, 80));
		
		center.add(welcomeText);
		

		betPanel.add(betNorth, BorderLayout.NORTH);
		betPanel.add(betSouth, BorderLayout.SOUTH);
		betPanel.add(center, BorderLayout.CENTER);
		
		mainPanel.add(betPanel);
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	// Ignore this code it needs to be fixed
	/* public void gameInfo() {
		mainPanel.removeAll();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		JLabel info = new JLabel("Blackjack is a casino-aged game that requires a mental aptitude for odds and common sense.  "
				+ "The game’s object is to “beat” the house and not the other players involved.  "
				+ "Cards are dealt off the top of the deck; the first is placed in front of the player (face-up), the second in front of the dealer(face-down), "
				+ "the third to the player face up again, and the last to the dealer, face down.  Blackjack, also called ‘21,’  is simple in a name. "
				+ "The object is to have the highest value hand while staying under or equal to 21.  "
				+ "While the dealer has set rules,  the player has the option to stand, hit, or double down.  "
				+ "For example, if a player wants to play aggressively and hit on hard 18 (18 with no ace),  they can do so.  "
				+ "The dealer, however, must hit on soft 17 or below and stand on hard 18 or above.  "
				+ "A good play would include standing on 12 when the dealer is showing a six because the dealer must hit, and the odds suggest that the next card to roll off will likely be high than a 5.  "
				+ "Should the player get “BlackJack” right away (any value ten-card paired with any ace), the player shall instantly be awarded 1.5x their original bet.");
		
		mainPanel.add(info);
		frame.add(mainPanel);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
	} */
	
	public void kickedOut() {
		mainPanel.removeAll();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JLabel kickedOut = new JLabel(new ImageIcon("images/KickedOut.png"));
		time.schedule(game.kickedOut, 5000);
		mainPanel.add(kickedOut, BorderLayout.CENTER);
		frame.add(mainPanel);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	public void blackjackTable() {
		System.out.println("Player Blackjack");
		mainPanel.removeAll();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(2, 1));
		gamePanel.setBackground(new Color(0,153,0));
		mainPanel.add(gamePanel);
		
		JPanel controlsPanel = new JPanel();

		hitBtn = new JButton();
		hitBtn.setFont(new Font("Plain", Font.BOLD, 20));
		hitBtn.setText("Hit");
		hitBtn.setBackground(Color.WHITE);
		hitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.playerDeal();
			}
		});
		controlsPanel.add(hitBtn);

		doubleBtn = new JButton();
		doubleBtn.setFont(new Font("Plain", Font.BOLD, 20));
		doubleBtn.setText("Double");
		doubleBtn.setBackground(Color.WHITE);
		doubleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentAmount > (betAmount * 2)) {
					newAmount = currentAmount - (betAmount * 2);
					
					disableButtons();
					game.playerDeal();
					flipDealerCard();
					game.dealersTurn();
				} else JOptionPane.showMessageDialog(null, "You cannot double. Doubling will exceed your current amount of $" + currentAmount +".");
					
			}
		});
		controlsPanel.add(doubleBtn);

		standBtn = new JButton();
		standBtn.setFont(new Font("Plain", Font.BOLD, 20));
		standBtn.setText("Stand");
		standBtn.setBackground(Color.WHITE);
		standBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flipDealerCard();
				disableButtons();
				game.dealersTurn();
			}
		});
		controlsPanel.add(standBtn);

		mainPanel.add(controlsPanel, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	public void playerBlackjack() {
		System.out.println("Player Blackjack");
		mainPanel.removeAll();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);


		JPanel mainPanelTwo = new JPanel();
		mainPanelTwo.setLayout(new BorderLayout());
		
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		JLabel winner = new JLabel(new ImageIcon("images/winnner.png"));
		JLabel winner2 = new JLabel("Player Total:  " + game.player.getPlayerTotal() + "	");
		JLabel winner3 = new JLabel("Dealer Total:  " + game.dealer.getDealerTotal());
		
		winner2.setForeground(Color.RED);
		winner2.setFont(new Font("Serif", Font.BOLD, 45));
		winner3.setForeground(Color.RED);
		winner3.setFont(new Font("Serif", Font.BOLD, 45));
		
		center.add(winner);
		north.add(winner2);
		north.add(winner3);
		
		JButton continueGame = new JButton();
		continueGame.setText("Continue");
		continueGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
				new GameManager(currentAmount + (betAmount + (betAmount/2)));
			}
		});
		
		JButton exitGame = new JButton();
		exitGame.setText("Exit");
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		south.setBackground(Color.BLACK);
		south.add(continueGame);
		south.add(exitGame);
		
		mainPanelTwo.add(north, BorderLayout.NORTH);
		mainPanelTwo.add(center, BorderLayout.CENTER);
		mainPanelTwo.add(south, BorderLayout.SOUTH);
		
		mainPanel.add(mainPanelTwo);

		frame.invalidate();
		frame.validate();
		frame.repaint();

	}
	
	public void loserScreen() {
		System.out.println("Loser Screen");
		mainPanel.removeAll();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);


		JPanel mainPanelTwo = new JPanel();
		mainPanelTwo.setLayout(new BorderLayout());
		
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		JLabel gameOver = new JLabel(new ImageIcon("images/GameOver.png"));
		JLabel gameOver2 = new JLabel("Player Total:  " + game.player.getPlayerTotal() + "   ");
		JLabel gameOver3 = new JLabel("Dealer Total:  " + game.dealer.getDealerTotal());
		
		
		gameOver2.setForeground(Color.RED);
		gameOver2.setFont(new Font("Serif", Font.BOLD, 45));
		gameOver3.setForeground(Color.RED);
		gameOver3.setFont(new Font("Serif", Font.BOLD, 45));
		
		north.setBackground(Color.BLACK);
		center.setBackground(Color.BLACK);
		
		center.add(gameOver);
		north.add(gameOver2);
		north.add(gameOver3);
		
		
		JButton continueGame = new JButton();
		continueGame.setText("Continue");
		continueGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
				new GameManager(newAmount);
			}
		});
		
		JButton exitGame = new JButton();
		exitGame.setText("Exit");
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		south.setBackground(Color.BLACK);
		south.add(continueGame);
		south.add(exitGame);
		
		mainPanelTwo.add(north, BorderLayout.NORTH);
		mainPanelTwo.add(center, BorderLayout.CENTER);
		mainPanelTwo.add(south, BorderLayout.SOUTH);
		
		
		mainPanel.add(mainPanelTwo);

		frame.invalidate();
		frame.validate();
		frame.repaint();
		System.out.println(newAmount);

	}

	public void winner() {
		System.out.println("Winner");
		mainPanel.removeAll();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);


		JPanel mainPanelTwo = new JPanel();
		mainPanelTwo.setLayout(new BorderLayout());
		
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		JLabel winner = new JLabel(new ImageIcon("images/winnner.png"));
		JLabel winner2 = new JLabel("Player Total:  " + game.player.getPlayerTotal() + "	");
		JLabel winner3 = new JLabel("	Dealer Total:  " + game.dealer.getDealerTotal());
		
		winner2.setForeground(Color.RED);
		winner2.setFont(new Font("Serif", Font.BOLD, 45));
		winner3.setForeground(Color.RED);
		winner3.setFont(new Font("Serif", Font.BOLD, 45));
		
		center.setBackground(Color.BLACK);
		north.setBackground(Color.BLACK);
		
		center.add(winner);
		north.add(winner2);
		north.add(winner3);
		
		JButton continueGame = new JButton();
		continueGame.setText("Continue");
		continueGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
				new GameManager(currentAmount + betAmount);

			}
		});
		
		JButton exitGame = new JButton();
		exitGame.setText("Exit");
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		south.setBackground(Color.BLACK);
		south.add(continueGame);
		south.add(exitGame);
		
		mainPanelTwo.add(north, BorderLayout.NORTH);
		mainPanelTwo.add(center, BorderLayout.CENTER);
		mainPanelTwo.add(south, BorderLayout.SOUTH);
		
		mainPanel.add(mainPanelTwo);

		frame.invalidate();
		frame.validate();
		frame.repaint();

	}

	public void push() {
		System.out.println("Push");
		mainPanel.removeAll();
		frame.invalidate();
		frame.validate();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);


		JPanel mainPanelTwo = new JPanel();
		mainPanelTwo.setLayout(new BorderLayout());
		
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		JLabel push = new JLabel(new ImageIcon("images/Push.png"));
		JLabel push2 = new JLabel("Player Total:  " + game.player.getPlayerTotal() + "   ");
		JLabel push3 = new JLabel("Dealer Total:  " + game.dealer.getDealerTotal());
		
		push2.setForeground(Color.RED);
		push2.setFont(new Font("Serif", Font.BOLD, 45));
		push3.setForeground(Color.RED);
		push3.setFont(new Font("Serif", Font.BOLD, 45));
		
		north.setBackground(Color.BLACK);
		center.setBackground(Color.BLACK);
		
		center.add(push);
		north.add(push2);
		north.add(push3);

		
		JButton continueGame = new JButton();
		continueGame.setText("Continue");
		continueGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
				new GameManager(currentAmount);
			}
		});
		
		JButton exitGame = new JButton();
		exitGame.setText("Exit");
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		south.setBackground(Color.BLACK);
		south.add(continueGame);
		south.add(exitGame);
		
		
		mainPanelTwo.add(north, BorderLayout.NORTH);
		mainPanelTwo.add(center, BorderLayout.CENTER);
		mainPanelTwo.add(south, BorderLayout.SOUTH);
		mainPanel.add(mainPanelTwo);

		frame.invalidate();
		frame.validate();
		frame.repaint();

	}
	
	public void flipDealerCard() {
		ArrayList<Card> dealerHand = game.dealer.hand.getCards();
		ArrayList<Card> playerHand = game.player.hand.getCards();

		// clear panels
		gamePanel.removeAll();

		// draw dealer hand
		JPanel dealerPanel = new JPanel();
		dealerPanel.setLayout(new GridLayout(1, dealerHand.size()));
		dealerPanel.setBackground(new Color(0, 153, 0));

		JLabel dealerTotal = new JLabel("	Dealer:");
		dealerTotal.setFont(new Font("Serif", Font.BOLD, 45));
		dealerTotal.setForeground(Color.WHITE);
		dealerPanel.add(dealerTotal);

		for (int i = 0; i < dealerHand.size(); i++) {
			JLabel dealerPic = new JLabel(new ImageIcon(dealerHand.get(i).getPath()));
			dealerPanel.add(dealerPic);
		}
		gamePanel.add(dealerPanel);

		// draw player hand
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(1, playerHand.size()));
		playerPanel.setBackground(new Color(0, 153, 0));

		JLabel playerTotal = new JLabel("	Player:");
		playerTotal.setFont(new Font("Serif", Font.BOLD, 45));
		playerTotal.setForeground(Color.WHITE);
		playerPanel.add(playerTotal);

		for (int i = 0; i < playerHand.size(); i++) {
			JLabel playerPic = new JLabel(new ImageIcon(playerHand.get(i).getPath()));
			playerPanel.add(playerPic);
		}

		gamePanel.add(playerPanel);

		frame.invalidate();
		frame.validate();
		frame.repaint();
	}

	public void redrawCards() {
		ArrayList<Card> dealerHand = game.dealer.hand.getCards();
		ArrayList<Card> playerHand = game.player.hand.getCards();

		// clear panels
		gamePanel.removeAll();

		// draw dealer hand
		JPanel dealerPanel = new JPanel();
		dealerPanel.setLayout(new GridLayout(1, dealerHand.size()));
		dealerPanel.setBackground(new Color(0, 153, 0));

		JLabel dealerTotal = new JLabel("	Dealer:");
		dealerTotal.setFont(new Font("Serif", Font.BOLD, 45));
		dealerTotal.setForeground(Color.WHITE);
		dealerPanel.add(dealerTotal);

		for (int i = 0; i < dealerHand.size(); i++) {
			if (i == dealerHand.size() - 1) {
				JLabel dealerPic = new JLabel(new ImageIcon("images/BacksideOfCard.png"));
				dealerPic.setSize(1, 1);
				dealerPanel.add(dealerPic);
			} else {
				JLabel dealerPic = new JLabel(new ImageIcon(dealerHand.get(i).getPath()));
				dealerPanel.add(dealerPic);
			}
		}
		gamePanel.add(dealerPanel);

		// draw player hand
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(1, playerHand.size()));
		playerPanel.setBackground(new Color(0, 153, 0));

		JLabel playerTotal = new JLabel("	Player:");
		playerTotal.setFont(new Font("Serif", Font.BOLD, 45));
		playerTotal.setForeground(Color.WHITE);
		playerPanel.add(playerTotal);

		for (int i = 0; i < playerHand.size(); i++) {
			JLabel playerPic = new JLabel(new ImageIcon(playerHand.get(i).getPath()));
			playerPanel.add(playerPic);
		}
		gamePanel.add(playerPanel);

		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	public void exit() {
		frame.dispose();
	}

	public void disableButtons() {
		standBtn.setEnabled(false);
		doubleBtn.setEnabled(false);
		hitBtn.setEnabled(false);
	}
}
