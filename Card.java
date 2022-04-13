import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Card {
	
	Suit suit;
	Pip pip;
	int value;
	Image image;
	
	public Card(Suit suit, Pip pip, int value, String path) {
		this.suit = suit;
		this.pip = pip;
		this.value = value;
		Image image = new BufferedImage(path);
	}

	
	Card two_spades = new Card(Suit.spades,Pip.two,2,"2OfSpades.png");
	Card three_spades = new Card(Suit.spades,Pip.three,3,"3OfSpades.png");
	Card four_spades = new Card(Suit.spades,Pip.four,4,"4OfSpades.png");
	Card five_spades = new Card(Suit.spades,Pip.five,5,"5OfSpades.png");
	Card six_spades = new Card(Suit.spades,Pip.six,6,"6OfSpades.png");
	Card seven_spades = new Card(Suit.spades,Pip.seven,7,"7OfSpades.png");
	Card eight_spades = new Card(Suit.spades,Pip.eight,8,"8OfSpades.png");
	Card nine_spades = new Card(Suit.spades,Pip.nine,9,"9OfSpades.png");
	Card ten_spades = new Card(Suit.spades,Pip.ten,10,"10OfSpades.png");
	Card jack_spades = new Card(Suit.spades,Pip.jack,10,"JackOfSpades.png");
	Card queen_spades = new Card(Suit.spades,Pip.queen,10,"QueenOfSpades.png");
	Card king_spades = new Card(Suit.spades,Pip.king,10,"KingOfSpades.png");
	Card ace_spades = new Card(Suit.spades,Pip.ace,11,"AceOfSpades.png");
	
	Card two_diamonds = new Card(Suit.diamonds,Pip.two,2,"2OfDiamonds.png");
	Card three_diamonds = new Card(Suit.diamonds,Pip.three,3,"3OfDiamonds.png");
	Card four_diamonds = new Card(Suit.diamonds,Pip.four,4,"4OfDiamonds.png");
	Card five_diamonds = new Card(Suit.diamonds,Pip.five,5,"5OfDiamonds.png");
	Card six_diamonds = new Card(Suit.diamonds,Pip.six,6,"6OfDiamonds.png");
	Card seven_diamonds = new Card(Suit.diamonds,Pip.seven,7,"7OfDiamonds.png");
	Card eight_diamonds = new Card(Suit.diamonds,Pip.eight,8,"8OfDiamonds.png");
	Card nine_diamonds = new Card(Suit.diamonds,Pip.nine,9,"9OfDiamonds.png");
	Card ten_diamonds = new Card(Suit.diamonds,Pip.ten,10,"10OfDiamonds.png");
	Card jack_diamonds = new Card(Suit.diamonds,Pip.jack,10,"JackfDiamonds.png");
	Card queen_diamonds = new Card(Suit.diamonds,Pip.queen,10,"QueenOfDiamonds.png");
	Card king_diamonds = new Card(Suit.diamonds,Pip.king,10,"KingOfDiamonds.png");
	Card ace_diamonds = new Card(Suit.diamonds,Pip.ace,11,"AceOfDiamonds.png");
	
	Card two_hearts = new Card(Suit.hearts,Pip.two,2,"2OfHearts.png");
	Card three_hearts = new Card(Suit.hearts,Pip.three,3,"3OfHearts.png");
	Card four_hearts = new Card(Suit.hearts,Pip.four,4,"4OfHearts.png");
	Card five_hearts = new Card(Suit.hearts,Pip.five,5,"5OfHearts.png");
	Card six_hearts = new Card(Suit.hearts,Pip.six,6,"6OfHearts.png");
	Card seven_hearts = new Card(Suit.hearts,Pip.seven,7,"7OfHearts.png");
	Card eight_hearts = new Card(Suit.hearts,Pip.eight,8,"8OfHearts.png");
	Card nine_hearts = new Card(Suit.hearts,Pip.nine,9,"9OfHearts.png");
	Card ten_hearts = new Card(Suit.hearts,Pip.ten,10,"10OfHearts.png");
	Card jack_hearts = new Card(Suit.hearts,Pip.jack,10,"JackOfHearts.png");
	Card queen_hearts = new Card(Suit.hearts,Pip.queen,10,"QueenOfHearts.png");
	Card king_hearts = new Card(Suit.hearts,Pip.king,10,"KingOfHearts.png");
	Card ace_hearts = new Card(Suit.hearts,Pip.ace,11,"AceOfHearts.png");
	
	Card two_clubs = new Card(Suit.clubs,Pip.two,2,"2OfClubs.png");
	Card three_clubs = new Card(Suit.clubs,Pip.three,3,"3OfClubs.png");
	Card four_clubs = new Card(Suit.clubs,Pip.four,4,"4OfClubs.png");
	Card five_clubs = new Card(Suit.clubs,Pip.five,5,"5OfClubs.png");
	Card six_clubs = new Card(Suit.clubs,Pip.six,6,"6OfClubs.png");
	Card seven_clubs = new Card(Suit.clubs,Pip.seven,7,"7OfClubs.png");
	Card eight_clubs = new Card(Suit.clubs,Pip.eight,8,"8OfClubs.png");
	Card nine_clubs = new Card(Suit.clubs,Pip.nine,9,"9OfClubs.png");
	Card ten_clubs = new Card(Suit.clubs,Pip.ten,10,"10OfClubs.png");
	Card jack_clubs = new Card(Suit.clubs,Pip.jack,10,"JackOfClubs.png");
	Card queen_clubs = new Card(Suit.clubs,Pip.queen,10,"QueenOfClubs.png");
	Card king_clubs = new Card(Suit.clubs,Pip.king,10,"KingOfClubs.png");
	Card ace_clubs = new Card(Suit.clubs,Pip.ace,11,"AceOfClubs.png");
	
	}
	
	
	
	
	
	/*Stack<String> newCards = new Stack<String>();
	
	ArrayList<String> cards = new ArrayList<String>();
	cards.addAll(Arrays.asList("2OfSpades.png", "3OfSpades.png", "4OfSpades.png", "5OfSpades.png", "6OfSpades.png",
			"7OfSpades.png", "8OfSpades.png", "9OfSpades.png", "10OfSpades.png", "JackOfSpades.png",
			"KingOfSpades.png", "QueenOfSpades.png", "AceOfSpades.png", "2OfHearts.png", "3OfHearts.png",
			"4OfHearts.png", "5OfHearts.png", "6OfHearts.png", "7OfHearts.png", "8OfHearts.png", "9OfHearts.png",
			"10OfHearts.png", "JackOfHearts.png", "KingOfHearts.png", "QueenOfHearts.png", "AceOfHearts.png",
			"2OfDiamonds.png", "3OfDiamonds.png", "4OfDiamonds.png", "5OfDiamonds.png", "6OfDiamonds.png",
			"7OfDiamonds.png", "8OfDiamonds.png", "9OfDiamonds.png", "10OfDiamonds.png", "JackOfDiamonds.png",
			"KingOfDiamonds.png", "QueenOfDiamonds.png", "AceOfDiamonds.png", "2OfClubs.png", "3OfClubs.png",
			"4OfClubs.png", "5OfClubs.png", "6OfClubs.png", "7OfClubs.png", "8OfClubs.png", "9OfClubs.png",
			"10OfClubs.png", "JackOfClubs.png", "KingOfClubs.png", "QueenOfClubs.png", "AceOfClubs.png"));
	
	public static int cardValue(String Card) {
		if(Card.equals("2OfSpades.png") || Card.equals("2OfHearts.png") || Card.equals("2OfClubs.png") || Card.equals("2OfDiamonds.png")) {
			return 2;
		} else if(Card.equals("3OfSpades.png") || Card.equals("3OfHearts.png") || Card.equals("3OfClubs.png") || Card.equals("3OfDiamonds.png")) {
			return 3;
		} else if(Card.equals("4OfSpades.png") || Card.equals("4OfHearts.png") || Card.equals("4OfClubs.png") || Card.equals("4OfDiamonds.png")) {
			return 4;
		} else if(Card.equals("5OfSpades.png") || Card.equals("5OfHearts.png") || Card.equals("5OfClubs.png") || Card.equals("5OfDiamonds.png")) {
			return 5;
		} else if(Card.equals("6OfSpades.png") || Card.equals("6OfHearts.png") || Card.equals("6OfClubs.png") || Card.equals("6OfDiamonds.png")) {
			return 6;
		} else if(Card.equals("7OfSpades.png") || Card.equals("7OfHearts.png") || Card.equals("7OfClubs.png") || Card.equals("7OfDiamonds.png")) {
			return 7;
		} else if(Card.equals("8OfSpades.png") || Card.equals("8OfHearts.png") || Card.equals("8OfClubs.png") || Card.equals("8OfDiamonds.png")) {
			return 10;
		} else if(Card.equals("9OfSpades.png") || Card.equals("9OfHearts.png") || Card.equals("9OfClubs.png") || Card.equals("9OfDiamonds.png")) {
			return 10;
		} else if(Card.equals("10OfSpades.png") || Card.equals("10OfHearts.png") || Card.equals("10OfClubs.png") || Card.equals("10OfDiamonds.png")) {
			return 10;
		} else if(Card.equals("JackOfSpades.png") || Card.equals("JackOfHearts.png") || Card.equals("JackOfClubs.png") || Card.equals("JackOfDiamonds.png")) {
			return 10;
		} else if(Card.equals("QueenOfSpades.png") || Card.equals("QueenOfHearts.png") || Card.equals("QueenOfClubs.png") || Card.equals("QueenOfDiamonds.png")) {
			return 10;
		} else if(Card.equals("KingOfSpades.png") || Card.equals("KingOfHearts.png") || Card.equals("KingOfClubs.png") || Card.equals("KingOfDiamonds.png")) {
			return 10;
		} else {
			return 11;
		}
		
	}
*/
}


