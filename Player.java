import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/**
 * This class represents a Black Jack player with a hand of cards
 * and a score.
 */
public class Player {
    private Hand hand;
    private int score;

    /**
     * Default constructor for a player.
     * Initializes the new player with an empty hand.
     */
    public Player() {
        this.hand = new Hand();
        this.score = 0;
    }

    /**
     * Constructs a new player.
     * Initializes the new player with a hand of two cards from the
     * given source deck.
     */
    public Player(Deck sourceDeck) {
        this.hand = new Hand(2, sourceDeck);
        this.score = this.getHand().getHandPoints();
    }

    /**
     * Returns the current score of this player.
     * @return the number of points this player's hand is worth
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Returns this player's hand.
     * @return this player's hand
     */
    public Hand getHand(){
        return this.hand;
    }

    /**
     * Checks if this player has black jack.
     * @return true if this player has black jack, false otherwise
     */
    public boolean blackJack(){
        return (this.getScore() == 21);
    }

    /**
     * Checks whether this player has busted.
     * @return true if the player busts, false otherwise.
     */
    public boolean isBust() {
        return this.getScore() > 21;
    }

    /**
     * Prints out this player's current hand.
     */
    public void showHand() {
        System.out.println(this.getHand());
    }

    /**
     * Prints out the current cards in the hand and the current
     * number of points for this player.
     */
    public void showStatus() {
        System.out.print("\nCurrent Hand: " );
        showHand();
        System.out.println("Total points: " + this.getScore());
    }

    /**
     * Sets this player's score to zero.
     */
    public void resetScore() {
        this.score = 0;
    }

    /**
     * Hits a card by adding the first card from the given deck
     * to this player's hand.
     * @param deck the source deck
     */
    public void hit(Deck deck){
        this.hand.addCard(deck.getFirstCard());
        this.score = this.hand.getHandPoints();

    }

    /**
     * Begins a player's turn.
     * @param deck the source deck
     */
    public void turn(Deck deck){
        //check if blackjack
        if (this.blackJack()){
            System.out.println("BLACKJACK!");
            return;
        }
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Press 1 to HIT (add one more card), " +
                    "2 to STAND (hold the value and end your turn):");
            input = scan.nextInt();
            switch (input){
                case 1:
                    this.hit(deck);
                    System.out.print("You hit ===> ");
                    showStatus();
                    if (isBust()) {
                        System.out.println("YOU BUST!");
                        this.resetScore();
                        return;
                    } else if (blackJack()) {
                        System.out.println("BLACKJACK!");
                        return;
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid input. Press again!");
            }
        }
    }


    public static void main(String[] args) {
        Deck d = new Deck();
        d.shuffle();
        Player player = new Player(d);
        player.turn(d);
    }


}

