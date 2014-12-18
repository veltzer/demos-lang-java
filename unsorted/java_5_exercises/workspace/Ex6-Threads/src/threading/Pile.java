/*
 * Card.java
 *
 * Created on November 12, 2004, 5:28 AM
 */

package threading;

import java.util.concurrent.locks.*;
import enums.Card;

/**
 * This class represents a pile of cards on the game board.
 * The state of the pile is represented by the top-most card (so a pile is just a card).
 * A new card can be thrown on the Pile by calling tryAdvance() (this is a safe thread method),
 * it will be accepted only if it is permitted by the roles of the game.
 * @author pix
 */
public class Pile extends Card {
    static Lock lock = new ReentrantLock(true);

    /**
     * This method constract a new Pile with one card on top.
     * @param card The first card in the pile
     */
    public Pile(Card card) {
        super(card.getRank(),card.getSuit());
    }

    /**
     * This method can be used by players to put a new card on the pile.
     * This method will accept the new card only if it can be put on the pile accoring to the game roles
     * @return true - if the card was accepted by the pile
     * @param newValue The new card
     */
    public boolean tryAdvance(Card newValue)
    {
        int oldRank = this.getRank().ordinal();
        int newRank = newValue.getRank().ordinal();
        int rankSize = Card.Rank.values().length;
        int delta = (oldRank-newRank+rankSize)%rankSize;

        if ((delta!=1)&&(delta!=(rankSize-1))) return false;

        boolean ok=false;
        lock.lock();
        try
        {
            ok=getRank().ordinal()==oldRank;
            if (ok)
            {
                setRank(newValue.getRank());
                setSuit(newValue.getSuit());
            }
        } finally {
            lock.unlock();
        }
        return ok;
    }

    /**
     * describtion of the pile state
     * @return a compact readable string
     */
    public String toString() { return String.format("[%s]",super.toString()); }
}
