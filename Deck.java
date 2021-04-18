import java.util.*;
/**
 * This class represents a deck of playing cards.
 */
public class Deck {
    private ArrayList<Card> deck;

    /**
     * Initializes a standard 52-card deck.
     */
    public Deck(){
        this.deck = new ArrayList<>(52);
        initDeck();
    }

    /**
     * Initializes the deck with the standard 52 cards.
     */
    private void initDeck(){
        for (Suit suit : Suit.values()) {
            for (Name name : Name.values()) {
                this.deck.add(new Card(suit, name));
            }
        }
    }

    /**
     * Initializes an empty deck with the given initial capacity.
     * @param size the size of the deck
     */
    public Deck(int size) {
        this.deck = new ArrayList<>(size);
    }

    /**
     * Initializes a deck with the given size and adds the given
     * number of cards from the source deck to this new deck.
     * @param size input size of the deck
     * @param sourceDeck source deck to get the card from
     */
    public Deck(int size, Deck sourceDeck){
        this.deck = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            this.addCard(sourceDeck.getFirstCard());
        }
    }

    /**
     * Returns the number of cards in this deck.
     * @return the size of this deck
     */
    public int getSize(){
        return this.deck.size();
    }

    /**
     * Returns the card at the given index in this deck.
     * @param i the index of the card to be returned
     * @return the Card object at the given index in this deck
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Card getCard(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= this.getSize()){
            throw new IndexOutOfBoundsException("The index is not valid for this Deck.");
        }
        return this.deck.get(i);
    }

    /**
     * Returns the first card in this deck and removes it.
     * @return the first card in the deck
     * @throws IllegalStateException if the deck is empty
     */
    public Card getFirstCard() throws IllegalStateException{
        if (this.getSize() <= 0){
            throw new IllegalStateException("Empty deck.");
        }
        Card first = this.deck.get(0);
        this.deck.remove(0);
        return first;
    }

    /**
     * Adds a new Card to this deck.
     * @param card the card to be added
     */
    public void addCard(Card card){
        this.deck.add(card);
    }

    /**
     * Shuffles this deck.
     */
    public void shuffle(){
        Collections.shuffle(this.deck);
    }

    /**
     * Sorts the cards in this deck, ordered by name.
     */
    public void sortCard(){
        Collections.sort(this.deck);
    }

    /**
     * Returns the string representation of this deck, which includes
     * the string representation of every card in this deck.
     * @return the string representation of this deck
     */
    @Override
    public String toString(){
        if (this.getSize() == 0 ){
            return "";
        }

        String str = " | ";
        for (Card card: this.deck){
            str += card.toString() + " | ";
        }

        return str;
    }


    /**
     * Checks whether this deck is equal to the given deck.
     * Two decks are equal if they have the same size and every card
     * in the decks are equal (as determined by {@code equals} in the
     * Card class).
     *
     * @param other the other deck being compared
     * @return true if two decks contain the same cards, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Deck otherDeck = (Deck) other;

        if (this.getSize() != otherDeck.getSize()) {
            return false;
        }
        return this.deck.containsAll(otherDeck.deck);
    }



//    /**
//     * Checks whether this deck is equal to the given deck.
//     * @param other other Object
//     * @return true if two decks are equal, false otherwise
//     */
//    @Override
//    public boolean equals(Object other) {
//        if (this == other) return true;
//        if (other == null || getClass() != other.getClass()) return false;
//        Deck deck = (Deck) other;
//        if(getSize() == deck.getSize()){
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Deck d = new Deck();
        System.out.println(d);
        d.sortCard();
        System.out.println(d);
    }



}
