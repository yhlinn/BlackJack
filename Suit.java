/**
 * An Enum type of that represents a card's suit.
 */
public enum Suit {
    CLUB("\u2663"), DIAMOND("\u2666"), HEART("\u2665"), SPADE("\u2660");

    private String symbol;

    /**
     * The constructor of Suit enum with its corresponding symbol.
     * @param symbol a unicode escape that represents the suit symbol
     */
    Suit(String symbol){
        this.symbol = symbol;
    }

    /**
     * Returns the symbol for this specific suit.
     * @return the suit symbol
     */
    public String symbol(){
        return this.symbol;
    }

}

