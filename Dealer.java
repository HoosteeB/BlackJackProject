public class Dealer {

	Hand hand = new Hand();
	GameManager game;

	public Dealer(GameManager game) {
		this.game = game;
	}

	public void addDealerCard(Card c) {
		hand.addCard(c);
	}

	public int getDealerTotal() {
		int total = hand.getTotal();
		return total;
	}

	public void dealersTurn() {
		while (getDealerTotal() < 17) {
			game.dealerDeal();
		}

		if (getDealerTotal() == 17 && hand.contains(FaceValue.ace)) {
			game.dealerDeal();
		} else if (getDealerTotal() > 16 && getDealerTotal() < 22) {
			//System.out.println("Dealers total is in between 17 and 21. Card total is " + getDealerTotal() + ".");
		} else if (getDealerTotal() > 21 && hand.contains(FaceValue.ace)) {
			for (Card c : game.dealer.hand.hand) {
				if (c.getValue() == 11) {
					c.changeAceValue(c);
				}
			}
			while (getDealerTotal() < 17) {
				game.dealerDeal();
			}
		}
	}

	public String toString() {
		return "dealer: " + hand;
	}

}