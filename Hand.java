import java.util.ArrayList;

public class Hand {
	ArrayList<Card> hand = new ArrayList<Card>();
	// TODO Auto-generated method stub
	
	Deck newCards = new Deck();

	public void addCard(Card card) {
		hand.add(card);
	}

	public int getTotal() {
		int sum = 0;
		for (Card c : hand) {
			sum += c.getValue();
		}
		System.out.print(sum);
		return sum;
	}
}
