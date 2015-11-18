package exercises.threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exercises.enums.Card;
import exercises.enums.Deck;

/**
 * This program simulates the card game called "Speed"
 */
public class Speed {
	public static final int PLAYERS = 4;

	private List<Pile> piles = new ArrayList<Pile>(PLAYERS);
	private List<Player> players = new ArrayList<Player>(PLAYERS);

	/**
	 * Creates a new instance of the game
	 */
	public Speed() {
		System.err.println("INITIALIZING");

		// CREATE A SHUFFLED DECK
		Deck deck = new Deck();
		// System.err.println("Deck: "+deck);

		// CREATE FOUR PLAYERS AND DEAL EACH PLAYER 13 CARDS
		int size = deck.size();
		int cardPerPlayer = size / PLAYERS;
		for (int idx = 0; idx < deck.size(); idx += cardPerPlayer) {
			players.add(new Player("p" + Integer.toString(idx), this,
					new Deck(deck.subList(idx, idx + cardPerPlayer))));
		}

		// WRITE TO SCREEN THE STATUS OF THE GAME
		moved();

		// START PLAYING
		launch();
	}

	/**
	 * Entrance function that constructs the Speed game.
	 */
	public static void main(String[] args) {
		new Speed();
	}

	/**
	 * starts the game by invoking the four <CODE>Players</CODE>
	 */
	public void launch() {
		System.err.println("PLAYING");
		ExecutorService service = Executors.newFixedThreadPool(PLAYERS);
		Collection<Callable<Player>> ps = new ArrayList<Callable<Player>>(
				players);
		try {
			service.invokeAll(ps);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		service.shutdown();
	}

	/**
	 * @return a list of <CODE>Pile</CODE>s
	 */
	public List<Pile> getPiles() {
		return piles;
	}

	public void newPile(Card card) {
		piles.add(new Pile(card));
	}

	/**
	 * This method writes to standard-error a single line describing the state
	 * of the game
	 */
	public void moved() {
		System.err.printf("piles: %s players:%s\n", getPiles(), players);
	}
}
