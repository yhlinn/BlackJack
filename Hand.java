import java.util.ArrayList;

public class Hand extends Deck {
    public Hand(int size) {
        super(size);
    }

    public static void main(String[] args) {
        Deck wholeDeck = new Deck();
        int size = 5;
        Hand hand1 = new Hand(size);
        Hand hand2 = new Hand(size);

        wholeDeck.shuffle();
        for (int i = 0; i < size; i++) {
            hand1.add(wholeDeck.remove());
            hand2.add(wholeDeck.remove());
        }

        // test sort and print for the hands
        System.out.println("Hand 1: ");
        hand1.sort();
        hand1.print();
        System.out.println("\n");

        System.out.println("Hand 2: ");
        hand2.sort();
        hand2.print();
        System.out.println("\n");

        // add cards in the hands back to the deck
        System.out.println("Deck: ");
        for (int i = 0; i < size; i++) {
            wholeDeck.add(hand1.remove());
            wholeDeck.add(hand2.remove());
        }
        wholeDeck.sort();
        wholeDeck.print();
    }


}
