import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    private ArrayList<Card> deck;

    /**
     * The default constructor for the Deck class.
     * Initializes the deck to consist of the standard 52 {@link Card} objects.
     */
    public Deck() {
        this.deck = new ArrayList<Card>(52);
        initAllCards();
    }

    /**
     * Initializes the deck to consist of an empty set, with the specified size,
     * of {@link Card} objects. Note that all cards are null and should be added
     * manually afterwards.
     *
     * @param size the specified size of the deck
     */
    public Deck(int size) {
        this.deck = new ArrayList<Card>(size);
    }

    private void initAllCards() {
        for (Suit suit : Suit.values()) {
            for (CardName name : CardName.values()) {
                this.deck.add(new Card(suit, name));
            }
        }
    }

    /**
     * Prints out all {@link Card} objects in this deck of cards.
     */
    public void print() {
        for (Card card : this.deck) {
            System.out.println(card);
        }
    }

    /**
     * Prints out the ith {@link Card} objects in this deck of cards.
     * @param i the location of the card
     */
    public void print(int i) {
        System.out.println(this.deck.get(i));
    }

    /**
     * Randomly shuffles the {@link Card} objects in this card deck in place.
     */
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    /**
     * Adds the given {@link Card} to this card deck.
     *
     * @param newCard the card being added to the deck
     */
    public void add(Card newCard) {
        this.deck.add(new Card(newCard));
    }

    /**
     * Removes the first {@link Card} in the card deck and returns it.
     *
     * @return the first card in the card deck that is removed
     */
    public Card remove() {
        return this.deck.remove(0);
    }


    /**
     * Returns the ith card in this deck. Note that {@link Card} objects are immutable.
     *
     * @param i the position of the card in this deck
     * @return the ith card in this deck
     */
    public Card getCard(int i) {
        return this.deck.get(i);
    }


    /**
     * Gets the value of the {@link Card} at the given
     * location in this deck.
     *
     * @param index the location of the card in the deck
     * @return the value of the card at the given index
     */
    public int getCardValue(int index) {
        return this.deck.get(index).getName().getValue();
    }


    /**
     * Returns the number of {@link Card} in this card deck.
     *
     * @return the number of cards
     */
    public int getSize() {
        return this.deck.size();
    }

    /**
     * Sorts the {@link Card} objects ordered by name. For example: Ace, 2, 3, 4, ... etc.
     */
    public void sort() {
        int minIndex;
        for (int i = 0; i < this.getSize(); i++) {
            minIndex = i;
            for (int j = i + 1; j < this.getSize(); j++) {
                if (this.getCardValue(j) < this.getCardValue(minIndex)) {
                    minIndex = j;
                }
            }
            Collections.swap(this.deck, minIndex, i);
        }
    }






}
