
public class GameManager {

	BlackjackGUI gui;
	Deck deck = new Deck();
	Player player = new Player(this);
	Dealer dealer = new Dealer(this);

	public GameManager() {
		gui = new BlackjackGUI(this);
		startGame();

//		System.out.println(player);
//		System.out.print(player.getPlayerTotal());
//		System.out.println(dealer);
//		System.out.println(dealer.getDealerTotal());

		// 1) place bets
		// removes amount player bets
		// bets can't exceed the amount you currently have

		// 2) Game start by dealing out cards the 4 cards
		// System.out.println("New Deck : \n" + player.hand.newCards.toString() + "\n");
//		for (int i = 0; i < 2; i++) {
//			System.out.println(i + " Iteration: " + playerDeal());
//			System.out.println("Player total: " + player.getPlayerTotal() + "\n");
//			System.out.println(dealerDeal());
//			System.out.println("Dealer total: " + dealer.getDealerTotal() + "\n");
//			
//		} 

		// 3) winOrLose

		// 4) actionListener
		// Hit gives the player an extra card
		// If players card value exceeds 21 then bust
		// Lose money and restart game with new amount of money

		// Double if doesn't exceed current money
		// Gives player only one card and ends turn
		// If players total cards exceeds 21 then bust
		// Lose money and restart with new amount of money

		// Stand changes over to where player can't play and the dealer can add cards
		// and play
		// If dealer has less than 17 then add cards until hitting 17
		// If dealer busts then return amount doubled

		// 5) restart game with new amount of money and shuffle cards

		// 6) If you have $0 after the round ends and you lose against dealer.
		// Restart the game with a certain amount.
	}

	public void startGame() {
		playerDeal();
		dealerDeal();
		playerDeal();
		dealerDeal();
	}

	public void playerDeal() {
		Card c = deck.draw();
		player.addPlayerCard(c);
		gui.redrawCards();
		System.out.println(c);
		checkPlayerBust();
	}

	public void dealerDeal() {
		dealer.addDealerCard(deck.draw());
		gui.redrawCards();
	}
	public void dealersTurn() {
		while (dealer.getDealerTotal() < 17) {
			dealerDeal();
		} if (dealer.getDealerTotal() > 21) {
			if (dealer.hand.tryToMutateAce()) {
				return;
			}
			// bust
			gui.winner();
		}else if(dealer.getDealerTotal() > player.getPlayerTotal()) {
			gui.GameOver();
		} else if(dealer.getDealerTotal() == player.getPlayerTotal()){
			gui.push();
		}
		
}
	public boolean checkPlayerBust() {
		// over 21 with ace
		if (player.getPlayerTotal() > 21) {
			if (player.hand.tryToMutateAce()) {
				return false;
			}
			
			// bust
			gui.GameOver();
			return true;
		} else {
			return false;
		}
	}
}
