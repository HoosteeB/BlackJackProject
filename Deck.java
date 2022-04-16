import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {
	
	public Deck() {
		shuffle();
	}

	public void shuffle() {
		
		ArrayList<Card> cards = new ArrayList<Card>();

		cards.addAll(Arrays.asList(cardList));
		Collections.shuffle(cards);

		for (Card c : cards) {
			deck.push(c);
		}
	
	}
	
	public Card draw() {
		Card drawnCard = deck.pop();
		return drawnCard;
	}
	
	public String toString() {
		return "" + deck + "";
	}
	

	Stack<Card> deck = new Stack<Card>();
	
	//Spades
		Card two_spades = new Card(Suit.spades, FaceValue.two, 2, "2OfSpades.png");
		Card three_spades = new Card(Suit.spades, FaceValue.three, 3, "3OfSpades.png");
		Card four_spades = new Card(Suit.spades, FaceValue.four, 4, "4OfSpades.png");
		Card five_spades = new Card(Suit.spades, FaceValue.five, 5, "5OfSpades.png");
		Card six_spades = new Card(Suit.spades, FaceValue.six, 6, "6OfSpades.png");
		Card seven_spades = new Card(Suit.spades, FaceValue.seven, 7, "7OfSpades.png");
		Card eight_spades = new Card(Suit.spades, FaceValue.eight, 8, "8OfSpades.png");
		Card nine_spades = new Card(Suit.spades, FaceValue.nine, 9, "9OfSpades.png");
		Card ten_spades = new Card(Suit.spades, FaceValue.ten, 10, "10OfSpades.png");
		Card jack_spades = new Card(Suit.spades, FaceValue.jack, 10, "JackOfSpades.png");
		Card queen_spades = new Card(Suit.spades, FaceValue.queen, 10, "QueenOfSpades.png");
		Card king_spades = new Card(Suit.spades, FaceValue.king, 10, "KingOfSpades.png");
		Card ace_spades = new Card(Suit.spades, FaceValue.ace, 11, "AceOfSpades.png");
		
		//Diamonds
		Card two_diamonds = new Card(Suit.diamonds, FaceValue.two, 2, "2OfDiamonds.png");
		Card three_diamonds = new Card(Suit.diamonds, FaceValue.three, 3, "3OfDiamonds.png");
		Card four_diamonds = new Card(Suit.diamonds, FaceValue.four, 4, "4OfDiamonds.png");
		Card five_diamonds = new Card(Suit.diamonds, FaceValue.five, 5, "5OfDiamonds.png");
		Card six_diamonds = new Card(Suit.diamonds, FaceValue.six, 6, "6OfDiamonds.png");
		Card seven_diamonds = new Card(Suit.diamonds, FaceValue.seven, 7, "7OfDiamonds.png");
		Card eight_diamonds = new Card(Suit.diamonds, FaceValue.eight, 8, "8OfDiamonds.png");
		Card nine_diamonds = new Card(Suit.diamonds, FaceValue.nine, 9, "9OfDiamonds.png");
		Card ten_diamonds = new Card(Suit.diamonds, FaceValue.ten, 10, "10OfDiamonds.png");
		Card jack_diamonds = new Card(Suit.diamonds, FaceValue.jack, 10, "JackfDiamonds.png");
		Card queen_diamonds = new Card(Suit.diamonds, FaceValue.queen, 10, "QueenOfDiamonds.png");
		Card king_diamonds = new Card(Suit.diamonds, FaceValue.king, 10, "KingOfDiamonds.png");
		Card ace_diamonds = new Card(Suit.diamonds, FaceValue.ace, 11, "AceOfDiamonds.png");
		
		//Hearts
		Card two_hearts = new Card(Suit.hearts, FaceValue.two, 2, "2OfHearts.png");
		Card three_hearts = new Card(Suit.hearts, FaceValue.three, 3, "3OfHearts.png");
		Card four_hearts = new Card(Suit.hearts, FaceValue.four, 4, "4OfHearts.png");
		Card five_hearts = new Card(Suit.hearts, FaceValue.five, 5, "5OfHearts.png");
		Card six_hearts = new Card(Suit.hearts, FaceValue.six, 6, "6OfHearts.png");
		Card seven_hearts = new Card(Suit.hearts, FaceValue.seven, 7, "7OfHearts.png");
		Card eight_hearts = new Card(Suit.hearts, FaceValue.eight, 8, "8OfHearts.png");
		Card nine_hearts = new Card(Suit.hearts, FaceValue.nine, 9, "9OfHearts.png");
		Card ten_hearts = new Card(Suit.hearts, FaceValue.ten, 10, "10OfHearts.png");
		Card jack_hearts = new Card(Suit.hearts, FaceValue.jack, 10, "JackOfHearts.png");
		Card queen_hearts = new Card(Suit.hearts, FaceValue.queen, 10, "QueenOfHearts.png");
		Card king_hearts = new Card(Suit.hearts, FaceValue.king, 10, "KingOfHearts.png");
		Card ace_hearts = new Card(Suit.hearts, FaceValue.ace, 11, "AceOfHearts.png");
		
		//Club
		Card two_clubs = new Card(Suit.clubs, FaceValue.two, 2, "2OfClubs.png");
		Card three_clubs = new Card(Suit.clubs, FaceValue.three, 3, "3OfClubs.png");
		Card four_clubs = new Card(Suit.clubs, FaceValue.four, 4, "4OfClubs.png");
		Card five_clubs = new Card(Suit.clubs, FaceValue.five, 5, "5OfClubs.png");
		Card six_clubs = new Card(Suit.clubs, FaceValue.six, 6, "6OfClubs.png");
		Card seven_clubs = new Card(Suit.clubs, FaceValue.seven, 7, "7OfClubs.png");
		Card eight_clubs = new Card(Suit.clubs, FaceValue.eight, 8, "8OfClubs.png");
		Card nine_clubs = new Card(Suit.clubs, FaceValue.nine, 9, "9OfClubs.png");
		Card ten_clubs = new Card(Suit.clubs, FaceValue.ten, 10, "10OfClubs.png");
		Card jack_clubs = new Card(Suit.clubs, FaceValue.jack, 10, "JackOfClubs.png");
		Card queen_clubs = new Card(Suit.clubs, FaceValue.queen, 10, "QueenOfClubs.png");
		Card king_clubs = new Card(Suit.clubs, FaceValue.king, 10, "KingOfClubs.png");
		Card ace_clubs = new Card(Suit.clubs, FaceValue.ace, 11, "AceOfClubs.png");
		
		Card[] cardList = { 
				//Spades
				two_spades, three_spades,four_spades, five_spades, six_spades, seven_spades, eight_spades, 
				nine_spades, ten_spades, jack_spades, queen_spades, king_spades, ace_spades, 
				//Diamonds
				two_diamonds, three_diamonds, four_diamonds, five_diamonds, six_diamonds,seven_diamonds, eight_diamonds, 
				nine_diamonds, ten_diamonds, jack_diamonds, queen_diamonds, king_diamonds, ace_diamonds,
				//Hearts
				two_hearts, three_hearts, four_hearts, five_hearts, six_hearts, seven_hearts, eight_hearts, 
				nine_hearts, ten_hearts, jack_hearts, queen_hearts, king_hearts, ace_hearts,
				//Club
				two_clubs, three_clubs, four_clubs, five_clubs, six_clubs, seven_clubs, eight_clubs, 
				nine_clubs, ten_clubs, jack_clubs, queen_clubs, king_clubs, ace_clubs 

		};
	
}
