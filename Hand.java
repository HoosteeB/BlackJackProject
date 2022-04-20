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
	
	public boolean contains(FaceValue faceValue) {
		// TODO Auto-generated method stub
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
