/**
 * This class represents a card with a Suit enum type and a Name enum type.
 * It implements the comparable interface.
 */
public class Card implements Comparable<Card>{

    private final Suit suit;
    private final Name name;

    /**
     * Constructor of a Card object, initializes with the given Suit and Name
     * @param suit suit enum type
     * @param name name enum type
     */
    public Card(Suit suit, Name name){
        this.suit = suit;
        this.name = name;
    }

    /**
     * Returns the suit of this card.
     * @return the Suit type
     */
    public Suit getSuit(){
        return this.suit;
    }

    /**
     * Returns the name of this card.
     * @return the Name type
     */
    public Name getName(){
        return this.name;
    }

    /**
     * Returns the number of points that this card is worth in Black Jack.
     * @return the number of points for this card
     */
    public int getCardPoint(){
        return this.getName().point();
    }

    /**
     * Returns the string representation of this card.
     * @return a formatted string for this card
     */
    @Override
    public String toString(){
        return getSuit().symbol() + " " + getName();
    }

    /**
     * Compares this card to the give card, based on their numerical values.
     * @param card the other Card object
     * @return a negative integer, zero, or a positive integer as this card is less than,
     *         equal to, or greater than the specified card
     */
    @Override
    public int compareTo(Card card) throws NullPointerException {
        if (card == null) {
            throw new NullPointerException();
        }
        return this.getName().number() - card.getName().number();
    }

    /**
     * Checks whether this card and the given card are equal.
     * Two cards are equal if they have the same suit and name.
     * @param other another Object
     * @return true if the two cards are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Card card = (Card) other;
        return suit == card.suit && name == card.name;
    }

    public static void main(String[] args) {
        Card qs = new Card(Suit.SPADE, Name.QUEEN);
        Card sixHeart = new Card(Suit.HEART, Name.SIX);
        Card aceClub = new Card(Suit.CLUB, Name.ACE);
        Card dSeven = new Card(Suit.DIAMOND, Name.SEVEN);
        System.out.println(qs + ", " + sixHeart + ", " + aceClub + ", " + dSeven);
    }

}

