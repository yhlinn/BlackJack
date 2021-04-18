import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackPlayer {
    private Hand hand;
    private String name;

    public BlackJackPlayer() {
        this.hand = new Hand(2);
        this.name = "Unknown Player";
    }

    public BlackJackPlayer(String name) {
        this.hand = new Hand(2);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int numCards() {
        return this.hand.getSize();
    }


    /**
     * Return the ith card in this player's hand. Note that {@link Card} objects
     * are immutable.
     *
     * @param i the position of the card in this player's hand
     * @return the ith card in this player's hand
     */
    public Card getCard(int i) {
        return this.hand.getCard(i);
    }

    /**
     * Pre-condition: deck is shuffled.
     *
     * @param deck
     */
    public void addToHand(Deck deck) {
        this.hand.add(deck.remove());
    }

    public void displayHand() {
        this.hand.print();
    }

    public void displayCard(int i) {
        this.hand.print(i);
    }


    /**
     * Returns the total score with ace representing 1.
     *
     * @return the minimum total score possible
     */
    public int getMinimumScore() {
        int total = 0;
        for (int i = 0; i < this.hand.getSize(); i++) {
            // face cards
            if (this.hand.getCardValue(i) == 11 ||
                    this.hand.getCardValue(i) == 12 ||
                    this.hand.getCardValue(i) == 13) {
                total += 10;
            } else {
                total += this.hand.getCardValue(i);
            }
        }
        return total;
    }

    /**
     * Returns the total score with ace representing 11.
     *
     * @return the maximum total score possible
     */
    public int getMaximumScore() {
        int total = 0;
        for (int i = 0; i < this.hand.getSize(); i++) {
            // face cards
            if (this.hand.getCardValue(i) == 11 ||
                    this.hand.getCardValue(i) == 12 ||
                    this.hand.getCardValue(i) == 13) {
                total += 10;
            } else if (this.hand.getCardValue(i) == 1) {
                total += 11;
            } else {
                total += this.hand.getCardValue(i);
            }
        }
        if (total > 21) {
            return this.getMinimumScore();
        }
        return total;
    }

    public boolean bust() {
        return this.getMinimumScore() > 21;
    }

    public boolean blackJack() {
        return this.getMinimumScore() == 21 || this.getMaximumScore() == 21;
    }


//    public int hit(Deck deck) {
//        addToHand(deck);
//        System.out.printf("%s got ", this);
//        displayCard(numCards()-1);
//
//        if (bust() || blackJack()) {
//            return 0;
//        }
//        return 1;
//    }

//    public void hit(Deck deck) {
//        addToHand(deck);
//    }





    public boolean chooseToHit() {
        Scanner keyboard = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.println("HIT (H) or STAND (S) ?");
            choice = keyboard.next();
            if (!choice.equals("H") && !choice.equals("S")) {
                System.out.println("Illegal Input : Please try again.");
            } else {
                return choice.equals("H");
            }
        }
    }






//    /**
//     * 0 if the player busts or if the player black jacked; 1 otherwise
//     * @param deck
//     * @return
//     */
//    public int startTurn(Deck deck) {
//        Scanner keyboard = new Scanner(System.in);
//        String choice;
//
//        while (true) {
//            System.out.println("HIT (H) or STAND (S) ?");
//            choice = keyboard.next();
//            if (choice.equals("S")) {
//                return 1;
//            } else if (choice.equals("H")) {
//                if (hit(deck) == 0) {
//                    return 0;
//                }
//            } else {
//                System.out.println("Illegal Input : Please try again.");
//            }
//        }
//    }



    public static void main(String[] args) {
        BlackJackPlayer player = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.shuffle();
        player.addToHand(deck);
        player.addToHand(deck);
        player.displayHand();
    }


}
