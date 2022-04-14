
public class Player {

Hand hand = new Hand();
Money money = new Money();	

	public void addPlayerCard(Card c) {
		hand.addCard(c);
	}
	public int getPlayerTotal(Hand hand) {
		int total = hand.getTotal();
		return total;
	}
}

