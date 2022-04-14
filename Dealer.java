
public class Dealer {
	
	Hand hand = new Hand();
	
	
	public void addDealerCard(Card c) {
		hand.addCard(c);
	}
	public int getDealerTotal(Hand hand) {
		int total = hand.getTotal();
		return total;
	}
	public int dealersTurn() {
		int tot = getDealerTotal(hand);
		while (tot < 17) {
			addDealerCard(null);
		} if (tot > 17 && 17 < 22) {
			return tot;
		} else if (tot == 17 && hand.contains(Pip.ace)){  
			x = GameManager.hit;
			addDealerCard(x);
		}else {
			return tot;
	}
}
	
