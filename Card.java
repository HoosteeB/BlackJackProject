public class Card {

	private Suit suit;
	private FaceValue faceValue;
	private int value;
	private String path;

	public Card(Suit suit, FaceValue faceValue, int value, String path) {
		this.suit = suit;
		this.faceValue = faceValue;
		this.value = value;
		this.path = path;
	}
	public void changeAceValue(Card c){
		this.value = 1;
	}
	public int getValue() {
		return value;
	}
	
	public FaceValue getFaceValue() {
		return faceValue;
	}
	public String getPath() {
		return path;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public String toString() {
		return "[" + suit + ", " + faceValue + ", " + value + ", " + path + "]\n";
	}
	
	
			
}