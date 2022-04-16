public class Dealer {
	
	Hand hand = new Hand();
	//GameManager game = new GameManager(null, null);
	public Dealer(/*GameManager game*/) {
		//this.game = game;
	}
	
	public void addDealerCard() {
		hand.addCard();
	}
	public int getDealerTotal() {
		int total = hand.getTotal();
		return total;
	}
	public String dealersTurn() {
		int total = getDealerTotal();
		while (total < 17) {
			addDealerCard();
			total = getDealerTotal();
		} 
		
		 if (total >= 17 && total <= 22) {
			return "This card is in beween 17 and 21. Card total is " + total + ".";
		} else if (total == 17 && hand.contains(FaceValue.ace)){  
			return "This cotains an Ace. Card total is" + total + ".";
		} else {
			return "Bust!!! Card total is  " + total + ".";
		} 
	
	}
}
