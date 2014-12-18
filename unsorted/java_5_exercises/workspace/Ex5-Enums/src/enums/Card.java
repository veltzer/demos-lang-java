package enums;
/*
 * Card.java
 *
 * Created on November 12, 2004, 5:28 AM
 */


/**
 *
 * @author  pix
 */
public class Card {

    public enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
    public enum Suit { DIAMOND, HEART, SPADE, CLUB }

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        setRank(rank);
        setSuit(suit);
    }

    public String toString() {
        return String.format("[%-5s,%-7s]",rank, suit);
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}
