import java.util.ArrayList;

public class Hand {
	
	ArrayList<Card> hand = new ArrayList<Card>();
	
	Deck newCards = new Deck();

	public void addCard() {
		 hand.add(newCards.draw());
		
	}

	public int getTotal() {
		int sum = 0;
		for (Card c : hand) {
			sum += c.getValue();
		}
		return sum;
	}
	
	public boolean contains(FaceValue faceValue) {
		// TODO Auto-generated method stub
		for (Card c : hand) {
			if (c.getFaceValue() == faceValue) {
				return true;
			}
		} 
		return false;
	}
}  
