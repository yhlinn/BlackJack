public class Card {
    private Suit suit;
    private CardName name;

    public Card(Suit suit, CardName name) {
        this.setSuit(suit);
        this.setName(name);
    }

    public Card(Card card) {
        this(card.getSuit(), card.getName());
    }


    private void setSuit(Suit suit) {
        this.suit = suit;
    }

    private void setName(CardName name) {
        this.name = name;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public CardName getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return suit.toString() + " " + name.toString();

    }

}
