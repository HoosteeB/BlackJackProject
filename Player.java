public class Player {
	Hand hand = new Hand();
	//GameManager game = new GameManager(null, null);
	
	public Player(/*GameManager game*/) {
		//this.game = game;
	}
	
	public void addPlayerCard() {
		hand.addCard();
	}
	
	public int getPlayerTotal() {
		int total = hand.getTotal();
		return total;
	}
}
