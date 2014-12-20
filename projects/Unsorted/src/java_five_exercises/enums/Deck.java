package java_five_exercises.enums;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("serial")
public class Deck extends ArrayList<Card> {

	public Deck() {
		this(true, true);
	}

	public Deck(boolean full, boolean shuffled) {
		if (full)
			for (Card.Suit suit : Card.Suit.values())
				for (Card.Rank rank : Card.Rank.values())
					add(new Card(rank, suit));
		if (shuffled)
			shuffle();
	}

	public Deck(Collection<? extends Card> cards) {
		super(cards);
	}

	public void shuffle() {
		Collections.shuffle(this);
	}

	public String toString() {
		return "" + size();
	}

	public static void main(String... args) {
		Deck d = new Deck(true, false);

		for (Card c : d)
			System.out.println(c);
	}
}
