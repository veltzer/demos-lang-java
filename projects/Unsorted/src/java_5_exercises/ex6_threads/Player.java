package java_5_exercises.ex6_threads;

import java.util.Iterator;
import java.util.concurrent.Callable;

import java_5_exercises.ex5_enums.Card;
import java_5_exercises.ex5_enums.Deck;

/**
 * This class represents a player.
 * <CODE>Player</CODE> implements <CODE>Callable</CODE> so it can be executed by an <CODE>Executor</CODE>
 */
public class Player implements Callable<Player> {
    String name;
    Speed game;
    Deck cards;

    /**
     * Creates a new instance of Player.
     * @param name name of the player
     * @param game The game board
     * @param cards a deck of cards
     */
    public Player(String name,Speed game, Deck cards) {
        this.name=name;
        this.game=game;
        this.cards=cards;

        //THROW ONE CARD TO CREATE A NEW PILE
        game.newPile(cards.remove(cards.size()-1));
    }

    /**
     * This function runs the player's game strategy.
     * The call method is called by the <CODE>Executor</CODE>.
     * @return null
     */
    public Player call() {
        int idleCycles = 0;

        //IF THE PLAYER FAILS TO MAKE A MOVE IN 100 CYCLES HE GIVES UP
        //(IN SPEED NOT ALL USERS WILL BE ABLE TO THROW ALL THIER CARDS EVERY TIME)
        while(cards.size()>0&&idleCycles<100) {
            idleCycles++;
            //GO OVER ALL PILES
            for (Pile pile : game.getPiles())
            {
                //GO OVER ALL CARDS
                for (Iterator<Card> i = cards.iterator(); i.hasNext(); )
                {
                    Card card = i.next();
                    //TRY TO THROW CARD ON PILE
                    if (pile.tryAdvance(card)) {
                        //IF THE CARD WAS EXCEPTED BY THE PILE,
                        //REMOVE CARD THE CARD FROM THE PLAYER'S DECK
                        //AND SHOW MOVE DETAILS ON THE SCREEN
                        System.err.format("%s(%s) throws %s%n", name, cards, card);
                        i.remove();
                        game.moved();
                        idleCycles=0;
                    }
                }
            }
            //IF THIS WAS AN IDEL CYCLE IT IS A GOOD IDEA TO YIELD THE THREAD TO PREVENT BUSY WAITING
            if (idleCycles > 0) {
                Thread.yield();
            }
        }

        if (cards.size() == 0)
            System.err.printf("*** player %s finishes%n",name);
        else
            System.err.printf("*** player %s gave up%n",name);
        return null;
    }

    /**
     * returns the player's name and number of cards
     * @return a compact readable string
     */
    public String toString() {
      return String.format("%s[%d]",name,cards.size());
    }
}
