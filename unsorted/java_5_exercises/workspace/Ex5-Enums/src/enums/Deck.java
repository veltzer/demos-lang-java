package enums;

/*
 * Deck.java
 *
 * Created on November 12, 2004, 5:30 AM
 */

import java.util.*;
import static enums.Card.*;

/**
 * @author pix
 */
public class Deck extends ArrayList<Card> {

	public Deck() {
		this(true, true);
	}

	public Deck(boolean full, boolean shuffled) {
		if (full)
			for (Suit suit : Suit.values())
				for (Rank rank : Rank.values())
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
