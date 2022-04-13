import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {

	Card[] deck1 = { new Card(Suit.spades, Pip.two, 2, "2OfSpades.png"),
			new Card(Suit.spades, Pip.three, 3, "3OfSpades.png"), new Card(Suit.spades, Pip.four, 4, "4OfSpades.png"),
			new Card(Suit.spades, Pip.five, 5, "5OfSpades.png"), new Card(Suit.spades, Pip.six, 6, "6OfSpades.png"),
			new Card(Suit.spades, Pip.seven, 7, "7OfSpades.png"), new Card(Suit.spades, Pip.eight, 8, "8OfSpades.png"),
			new Card(Suit.spades, Pip.nine, 9, "9OfSpades.png"), new Card(Suit.spades, Pip.ten, 10, "10OfSpades.png"),
			new Card(Suit.spades, Pip.jack, 10, "JackOfSpades.png"),
			new Card(Suit.spades, Pip.queen, 10, "QueenOfSpades.png"),
			new Card(Suit.spades, Pip.king, 10, "KingOfSpades.png"),
			new Card(Suit.spades, Pip.ace, 11, "AceOfSpades.png"),
			new Card(Suit.diamonds, Pip.two, 2, "2OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.three, 3, "3OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.four, 4, "4OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.five, 5, "5OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.six, 6, "6OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.seven, 7, "7OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.eight, 8, "8OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.nine, 9, "9OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.ten, 10, "10OfDiamonds.png"),
			new Card(Suit.diamonds, Pip.jack, 10, "JackfDiamonds.png"),
			new Card(Suit.diamonds, Pip.queen, 10, "QueenOfDiamonds.png"),
			new Card(Suit.diamonds, Pip.king, 10, "KingOfDiamonds.png"),
			new Card(Suit.diamonds, Pip.ace, 11, "AceOfDiamonds.png"),
			new Card(Suit.hearts, Pip.two, 2, "2OfHearts.png"), new Card(Suit.hearts, Pip.three, 3, "3OfHearts.png"),
			new Card(Suit.hearts, Pip.four, 4, "4OfHearts.png"), new Card(Suit.hearts, Pip.five, 5, "5OfHearts.png"),
			new Card(Suit.hearts, Pip.six, 6, "6OfHearts.png"), new Card(Suit.hearts, Pip.seven, 7, "7OfHearts.png"),
			new Card(Suit.hearts, Pip.eight, 8, "8OfHearts.png"), new Card(Suit.hearts, Pip.nine, 9, "9OfHearts.png"),
			new Card(Suit.hearts, Pip.ten, 10, "10OfHearts.png"),
			new Card(Suit.hearts, Pip.jack, 10, "JackOfHearts.png"),
			new Card(Suit.hearts, Pip.queen, 10, "QueenOfHearts.png"),
			new Card(Suit.hearts, Pip.king, 10, "KingOfHearts.png"),
			new Card(Suit.hearts, Pip.ace, 11, "AceOfHearts.png"), new Card(Suit.clubs, Pip.two, 2, "2OfClubs.png"),
			new Card(Suit.clubs, Pip.three, 3, "3OfClubs.png"), new Card(Suit.clubs, Pip.four, 4, "4OfClubs.png"),
			new Card(Suit.clubs, Pip.five, 5, "5OfClubs.png"), new Card(Suit.clubs, Pip.six, 6, "6OfClubs.png"),
			new Card(Suit.clubs, Pip.seven, 7, "7OfClubs.png"), new Card(Suit.clubs, Pip.eight, 8, "8OfClubs.png"),
			new Card(Suit.clubs, Pip.nine, 9, "9OfClubs.png"), new Card(Suit.clubs, Pip.ten, 10, "10OfClubs.png"),
			new Card(Suit.clubs, Pip.jack, 10, "JackOfClubs.png"),
			new Card(Suit.clubs, Pip.queen, 10, "QueenOfClubs.png"),
			new Card(Suit.clubs, Pip.king, 10, "KingOfClubs.png"),
			new Card(Suit.clubs, Pip.ace, 11, "AceOfClubs.png") };

	public Deck() {
		shuffle(deck1);
	}

	public void shuffle(Card[] deck1) {
		Stack<Card> newCards = new Stack<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();

		cards.addAll(Arrays.asList(deck1));
		Collections.shuffle(cards);

		for (Card c : cards) {
			newCards.push(c);
		}
	}
}
