import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
	int currentAmount;
	BlackjackGUI gui;
	Deck deck = new Deck();
	Player player = new Player(this);
	Dealer dealer = new Dealer(this);

	Timer time = new Timer();
	TimerTask dealerDrawCardsTimer = new TimerTask() {
		public void run() {
			
		}
		
	};
	TimerTask loserScreenTimer = new TimerTask() {
		public void run() {
			gui.loserScreen();	
		}
	};
	TimerTask winnerScreenTimer = new TimerTask() {
		public void run() {
			gui.winner();	
		}
	};
	TimerTask pushScreenTimer = new TimerTask() {
		public void run() {
			gui.push();	
		}
	};
	TimerTask kickedOut = new TimerTask() {
		public void run() {
			gui.frame.dispose();	
		}
	};
	TimerTask playerBlackjackScreenTimer = new TimerTask() {
		public void run() {
			gui.playerBlackjack();	
		}
		
	};
	

	public GameManager(int currentAmount) {
		this.currentAmount = currentAmount;
		gui = new BlackjackGUI(this, currentAmount);

	}

	public void startGame() {
		playerDeal();
		dealerDeal();
		playerDeal();
		dealerDeal();
		checkBlackjack();
	}

	public void playerDeal() {
		Card c = deck.draw();
		System.out.println("Player's Card: " + c);
		player.addPlayerCard(c);
		gui.redrawCards();
		checkPlayerBust();
	}

	public void dealerDeal() {
		Card c = deck.draw();
		System.out.println("Dealer's Card: " + c);
		dealer.addDealerCard(c);
		gui.redrawCards();
	}

	public void dealerFlipCardDeal() {
		Card c = deck.draw();
		System.out.println("Dealer's Card: " + c);
		dealer.addDealerCard(c);
		gui.flipDealerCard();
		
	}

	public void dealersTurn() {
		while (dealer.getDealerTotal() < 17) {
			dealerFlipCardDeal();
		} if (dealer.getDealerTotal() > 21) {
			if (dealer.hand.tryToMutateAce()) {
				return;
			}
			// bust
			//gui.winner();
			System.out.print("Winner");
			time.schedule(winnerScreenTimer, 1000);
		
		}else if(dealer.getDealerTotal() > player.getPlayerTotal()) {
			time.schedule(loserScreenTimer, 1000);
			System.out.print("loserScreen");
		} else if(dealer.getDealerTotal() == player.getPlayerTotal()){
			//gui.push();
			System.out.print("Push");
			time.schedule(pushScreenTimer, 1000);
		} else time.schedule(winnerScreenTimer, 1000);
		System.out.print("Winner");

	}

	public void checkBlackjack() {
		if (player.getPlayerTotal() == 21) {
			System.out.println("Player has instant blackjack");
			time.schedule(playerBlackjackScreenTimer, 1000);
		} else if (dealer.getDealerTotal() == 21) {
			System.out.println("Dealer has instant blackjack");
			time.schedule(loserScreenTimer, 1000);
		}
	}
	public boolean checkPlayerBust() {
		// over 21 with ace
		if (player.getPlayerTotal() > 21) {
			if (player.hand.tryToMutateAce()) {
				return false;
			}


			gui.disableButtons();
			time.schedule(loserScreenTimer, 1000);
			return true;
		} else {
			return false;
		}
	}


}
