/**
 * This class represents a Black Jack game, with a player,
 * a dealer, and a deck of cards.
 */
public class Game {
    private final Player player;
    private final Dealer dealer;
    private final Deck deck;

    /**
     * Constructs a new game, with a new player, a new dealer, and a new deck
     * of cards.
     * The player and dealer are initialized with their initial two cards
     * from the shuffled deck.
     */
    public Game() {
        deck = new Deck();
        deck.shuffle();
        player = new Player(deck);
        dealer = new Dealer(deck);
    }

    /**
     * Determines the winner of this game.
     */
    public void displayGameEnd(){
        if (player.getScore() == dealer.getScore()) {
            System.out.println("Push!");
        } else {
            String winner = (player.getScore() > dealer.getScore()) ? "You" : "Dealer";
            System.out.println(winner + " won!");
        }
    }

    /**
     * Begins a game.
     */
    public void play() {
        System.out.println("\n=========== Welcome to BlackJack! ============\n");

        System.out.printf("Dealer's initial cards: ");
        dealer.showInitialCard();
        System.out.println();

        System.out.println("=========== Your turn ============");
        System.out.printf("Your initial cards: ");
        player.showHand();
        player.turn(deck); // start player's turn
        System.out.println();

        System.out.println("=========== Dealer's turn ============");
        System.out.println("Dealer shows second card......");
        System.out.printf("Dealer's card: ");
        dealer.showHand();
        dealer.turn(deck); // start dealer's turn
        System.out.println();

        System.out.println("=========== This Round Ends ============");
        displayGameEnd();
    }

    /**
     * Main function to execute the Game
     * @param arg entry point
     */
    public static void main(String[] arg){
        Game game = new Game();
        game.play();
    }


}
