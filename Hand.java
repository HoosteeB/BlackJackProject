import java.util.ArrayList;

public class Hand {
	
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public void addCard(Card c) {
		 hand.add(c);	
	}

	public int getTotal() {
		int sum = 0;
		for (Card c : hand) {
			sum += c.getValue();
		}
		return sum;
	}
	
	public boolean tryToMutateAce() {
		for (Card c : hand) {
			if (c.getValue() == 11) {
				c.changeAceValue(c);
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(FaceValue faceValue) {
		for (Card c : hand) {
			if (c.getFaceValue() == faceValue) {
				return true;
			}
		} 
		return false;
	}
	
	public ArrayList<Card> getCards() {
		return hand;
	}
	
	public String toString() {
		return hand + "";
	}
}  