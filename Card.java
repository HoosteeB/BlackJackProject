import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card {

	Suit suit;
	Pip pip;
	int value;
	String path;
	private BufferedImage imagePath;

	public Card(Suit suit, Pip pip, int value, String path) {
		this.suit = suit;
		this.pip = pip;
		this.value = value;
		this.path = path;

		try {
			BufferedImage imagePath = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage getImage(BufferedImage imagePath) {
		return imagePath;
	}

	Card two_spades = new Card(Suit.spades, Pip.two, 2, "2OfSpades.png");
	Card three_spades = new Card(Suit.spades, Pip.three, 3, "3OfSpades.png");
	Card four_spades = new Card(Suit.spades, Pip.four, 4, "4OfSpades.png");
	Card five_spades = new Card(Suit.spades, Pip.five, 5, "5OfSpades.png");
	Card six_spades = new Card(Suit.spades, Pip.six, 6, "6OfSpades.png");
	Card seven_spades = new Card(Suit.spades, Pip.seven, 7, "7OfSpades.png");
	Card eight_spades = new Card(Suit.spades, Pip.eight, 8, "8OfSpades.png");
	Card nine_spades = new Card(Suit.spades, Pip.nine, 9, "9OfSpades.png");
	Card ten_spades = new Card(Suit.spades, Pip.ten, 10, "10OfSpades.png");
	Card jack_spades = new Card(Suit.spades, Pip.jack, 10, "JackOfSpades.png");
	Card queen_spades = new Card(Suit.spades, Pip.queen, 10, "QueenOfSpades.png");
	Card king_spades = new Card(Suit.spades, Pip.king, 10, "KingOfSpades.png");
	Card ace_spades = new Card(Suit.spades, Pip.ace, 11, "AceOfSpades.png");

	Card two_diamonds = new Card(Suit.diamonds, Pip.two, 2, "2OfDiamonds.png");
	Card three_diamonds = new Card(Suit.diamonds, Pip.three, 3, "3OfDiamonds.png");
	Card four_diamonds = new Card(Suit.diamonds, Pip.four, 4, "4OfDiamonds.png");
	Card five_diamonds = new Card(Suit.diamonds, Pip.five, 5, "5OfDiamonds.png");
	Card six_diamonds = new Card(Suit.diamonds, Pip.six, 6, "6OfDiamonds.png");
	Card seven_diamonds = new Card(Suit.diamonds, Pip.seven, 7, "7OfDiamonds.png");
	Card eight_diamonds = new Card(Suit.diamonds, Pip.eight, 8, "8OfDiamonds.png");
	Card nine_diamonds = new Card(Suit.diamonds, Pip.nine, 9, "9OfDiamonds.png");
	Card ten_diamonds = new Card(Suit.diamonds, Pip.ten, 10, "10OfDiamonds.png");
	Card jack_diamonds = new Card(Suit.diamonds, Pip.jack, 10, "JackfDiamonds.png");
	Card queen_diamonds = new Card(Suit.diamonds, Pip.queen, 10, "QueenOfDiamonds.png");
	Card king_diamonds = new Card(Suit.diamonds, Pip.king, 10, "KingOfDiamonds.png");
	Card ace_diamonds = new Card(Suit.diamonds, Pip.ace, 11, "AceOfDiamonds.png");

	Card two_hearts = new Card(Suit.hearts, Pip.two, 2, "2OfHearts.png");
	Card three_hearts = new Card(Suit.hearts, Pip.three, 3, "3OfHearts.png");
	Card four_hearts = new Card(Suit.hearts, Pip.four, 4, "4OfHearts.png");
	Card five_hearts = new Card(Suit.hearts, Pip.five, 5, "5OfHearts.png");
	Card six_hearts = new Card(Suit.hearts, Pip.six, 6, "6OfHearts.png");
	Card seven_hearts = new Card(Suit.hearts, Pip.seven, 7, "7OfHearts.png");
	Card eight_hearts = new Card(Suit.hearts, Pip.eight, 8, "8OfHearts.png");
	Card nine_hearts = new Card(Suit.hearts, Pip.nine, 9, "9OfHearts.png");
	Card ten_hearts = new Card(Suit.hearts, Pip.ten, 10, "10OfHearts.png");
	Card jack_hearts = new Card(Suit.hearts, Pip.jack, 10, "JackOfHearts.png");
	Card queen_hearts = new Card(Suit.hearts, Pip.queen, 10, "QueenOfHearts.png");
	Card king_hearts = new Card(Suit.hearts, Pip.king, 10, "KingOfHearts.png");
	Card ace_hearts = new Card(Suit.hearts, Pip.ace, 11, "AceOfHearts.png");

	Card two_clubs = new Card(Suit.clubs, Pip.two, 2, "2OfClubs.png");
	Card three_clubs = new Card(Suit.clubs, Pip.three, 3, "3OfClubs.png");
	Card four_clubs = new Card(Suit.clubs, Pip.four, 4, "4OfClubs.png");
	Card five_clubs = new Card(Suit.clubs, Pip.five, 5, "5OfClubs.png");
	Card six_clubs = new Card(Suit.clubs, Pip.six, 6, "6OfClubs.png");
	Card seven_clubs = new Card(Suit.clubs, Pip.seven, 7, "7OfClubs.png");
	Card eight_clubs = new Card(Suit.clubs, Pip.eight, 8, "8OfClubs.png");
	Card nine_clubs = new Card(Suit.clubs, Pip.nine, 9, "9OfClubs.png");
	Card ten_clubs = new Card(Suit.clubs, Pip.ten, 10, "10OfClubs.png");
	Card jack_clubs = new Card(Suit.clubs, Pip.jack, 10, "JackOfClubs.png");
	Card queen_clubs = new Card(Suit.clubs, Pip.queen, 10, "QueenOfClubs.png");
	Card king_clubs = new Card(Suit.clubs, Pip.king, 10, "KingOfClubs.png");
	Card ace_clubs = new Card(Suit.clubs, Pip.ace, 11, "AceOfClubs.png");
	
	public int getValue() {
		return value;
	}
}
