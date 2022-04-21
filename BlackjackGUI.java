import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BlackjackGUI {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;

	GameManager game;
	JFrame frame;
	JPanel mainPanel;
	JPanel gamePanel;
	GridLayout playerGrid;
	GridLayout dealerGrid;

	public BlackjackGUI(GameManager game) {
		this.game = game;

		frame = new JFrame("Blackjack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setTitle("Blackjack");
		frame.setLocationRelativeTo(null);

		// main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(2, 1));
		mainPanel.add(gamePanel);

		// controls panel
		JPanel controlsPanel = new JPanel();

		JButton hitBtn = new JButton();
		hitBtn.setFont(new Font("Plain", Font.BOLD, 20));
		hitBtn.setText("Hit");
		hitBtn.setBackground(Color.WHITE);
		hitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.playerDeal();
			}
		});
		controlsPanel.add(hitBtn);

		JButton doubleBtn = new JButton();
		doubleBtn.setFont(new Font("Plain", Font.BOLD, 20));
		doubleBtn.setText("Double");
		doubleBtn.setBackground(Color.WHITE);
		doubleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		controlsPanel.add(doubleBtn);

		JButton standBtn = new JButton();
		standBtn.setFont(new Font("Plain", Font.BOLD, 20));
		standBtn.setText("Stand");
		standBtn.setBackground(Color.WHITE);
		standBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.dealersTurn();
			}//
		});
		controlsPanel.add(standBtn);

		mainPanel.add(controlsPanel, BorderLayout.SOUTH);

		frame.add(mainPanel);
		frame.setVisible(true);
	}

	public void redrawCards() {
		ArrayList<Card> dealerHand = game.dealer.hand.getCards();
		ArrayList<Card> playerHand = game.player.hand.getCards();

		// clear panels
		gamePanel.removeAll();

		// draw dealer hand
		JPanel dealerPanel = new JPanel();
		dealerPanel.setLayout(new GridLayout(1, dealerHand.size()));
		for (int i=0; i<dealerHand.size(); i++) {
			if (i == dealerHand.size()-1) {
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
		for (int i=0; i<playerHand.size(); i++) {
			JLabel playerPic = new JLabel(new ImageIcon(playerHand.get(i).getPath()));
			playerPanel.add(playerPic);
		}
		gamePanel.add(playerPanel);

		frame.invalidate();
		frame.validate();
		frame.repaint();
	}

	public void exit() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

	public void endGame() {
		GameManager newGame = new GameManager();
		new BlackjackGUI(newGame);
	}

	public void checkBlackjack() {
		if (game.player.getPlayerTotal() == 21) {
			System.out.println("Player has instant blackjack");
		} else if (game.dealer.getDealerTotal() == 21) {
			System.out.println("Dealer has instant blackjack");
		}
	}



	public void winOrLose() {
		// Blackjack
		if (game.player.getPlayerTotal() == 21) {
			System.out.println("Player has 21! Congrats!");
			// Return a YOU WIN BOX
			// Return original bet + earnings + half earnings
			// Restart game with new amount
		} else if (game.dealer.getDealerTotal() == 21) {
			System.out.println("Dealer has BlackJack! Congrats!");
			// Return a YOU LOSE BOX
			// Restart game with new amount
		} else if (game.player.getPlayerTotal() == game.dealer.getDealerTotal()) {
			System.out.println("PUSH");
		} else if (game.player.getPlayerTotal() > game.dealer.getDealerTotal() && game.player.getPlayerTotal() < 22) {
			System.out.println("Player Wins!! Player has: " + game.player.getPlayerTotal() + ". Dealer has "
					+ game.dealer.getDealerTotal());
		} else if (game.player.getPlayerTotal() < game.dealer.getDealerTotal() && game.dealer.getDealerTotal() < 22) {
			System.out.println("Dealer Wins!! Dealer has: " + game.dealer.getDealerTotal() + ". Player has "
					+ game.player.getPlayerTotal());

		} else if (game.dealer.getDealerTotal() > 21) {
			System.out.println("Dealer Bust: " + game.dealer.getDealerTotal());
		}

	}
	public void GameOver() {
		System.out.println("GameOver");
		mainPanel.removeAll();
		frame.invalidate();
		frame.validate();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.repaint();
		
		JPanel mainPanelTwo = new JPanel();
		mainPanelTwo.setBackground(Color.black);
		JLabel gameOver = new JLabel(new ImageIcon("images/GameOver.png"));
		JLabel gameOver2 = new JLabel("Player Total:  " + game.player.getPlayerTotal());
		JLabel gameOver3 = new JLabel("Dealer Total:  " + game.dealer.getDealerTotal());
		gameOver2.setForeground(Color.RED);
		gameOver2.setFont(new Font("Serif", Font. BOLD, 45));
		gameOver3.setForeground(Color.RED);
		gameOver3.setFont(new Font("Serif", Font. BOLD, 45));
		mainPanelTwo.add(gameOver);
		mainPanelTwo.add(gameOver2);
		mainPanelTwo.add(gameOver3);
		mainPanel.add(mainPanelTwo);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
		
		
	}
	public void winner() {
		System.out.println("Winner");
		mainPanel.removeAll();
		frame.invalidate();
		frame.validate();
		frame.pack();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.repaint();
		
		JPanel mainPanelTwo = new JPanel();
		mainPanelTwo.setBackground(Color.black);
		JLabel winner = new JLabel(new ImageIcon("images/winnner.png"));
		JLabel winner2 = new JLabel("Player Total:  " + game.player.getPlayerTotal());
		JLabel winner3 = new JLabel("Dealer Total:  " + game.dealer.getDealerTotal());
		winner2.setForeground(Color.RED);
		winner2.setFont(new Font("Serif", Font. BOLD, 45));
		winner3.setForeground(Color.RED);
		winner3.setFont(new Font("Serif", Font. BOLD, 45));
		mainPanelTwo.add(winner);
		mainPanelTwo.add(winner2);
		mainPanelTwo.add(winner3);
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
		frame.repaint();
		
		JPanel mainPanelTwo = new JPanel();
		mainPanelTwo.setBackground(Color.black);
		JLabel push = new JLabel(new ImageIcon("images/Push.png"));
		JLabel push2 = new JLabel("Player Total:  " + game.player.getPlayerTotal());
		JLabel push3 = new JLabel("Dealer Total:  " + game.dealer.getDealerTotal());
		push2.setForeground(Color.RED);
		push2.setFont(new Font("Serif", Font. BOLD, 45));
		push3.setForeground(Color.RED);
		push3.setFont(new Font("Serif", Font. BOLD, 45));
		mainPanelTwo.add(push);
		mainPanelTwo.add(push2);
		mainPanelTwo.add(push3);
		mainPanel.add(mainPanelTwo);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
		
		
	}
}