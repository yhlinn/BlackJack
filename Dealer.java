/**
 * This class represents a dealer in Black Jack.
 */
public class Dealer extends Player {

    /**
     * Default constructor for a dealer.
     * Initializes the new dealer with an empty hand.
     */
    public Dealer(){
        super();
    }

    /**
     * Constructs a new dealer.
     * Initializes the new dealer with a hand of two cards from the
     * given source deck.
     */
    public Dealer(Deck sourceDeck) {
        super(sourceDeck);
    }


    /**
     * Begins the dealer's turn. The dealer's turn stops if
     * the dealer totals 17 points or higher, or if the dealer busts.
     * @param deck the source deck
     */
    @Override
    public void turn(Deck deck) {
        if (this.blackJack()){
            System.out.println("BLACKJACK!");
            return;
        }

        while (this.getScore() < 17) {
            this.hit(deck);
            System.out.print("Dealer hits ===> ");
            this.showStatus();
            if (this.isBust()) {
                System.out.println("DEALER BUSTS!");
                this.resetScore();
                return;
            }
            if (this.blackJack()) {
                System.out.println("BLACKJACK!");
                return;
            }
        }
    }

    /**
     * Displays the dealer's first card and the hidden second card
     * at the start of the game.
     */
    public void showInitialCard(){
        String initialMessage = " | " + getHand().getCard(0) +
                                " | * HIDDEN CARD * | ";
        System.out.println(initialMessage);;
    }

    public static void main(String[] args) {
        Deck d= new Deck();
        d.shuffle();
        Dealer dealer = new Dealer(d);
        dealer.turn(d);
    }
}

