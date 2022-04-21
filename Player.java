public class Player {

	GameManager game;
	Hand hand = new Hand();
	
	public Player(GameManager game) {
		this.game = game;
	}
	
	public void addPlayerCard(Card c) {
		hand.addCard(c);
	}
	
	public int getPlayerTotal() {
		int total = hand.getTotal();
		return total;
	}
	
	public String toString() {
		return "player: " + hand;
	}
}