/**
 * Represents the Black Jack game model for UI.
 */
public class BlackJackModel {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private boolean playerStand;
    private boolean dealerStand;

    /**
     * Constructs a Black Jack model.
     * Initializes the game with a new shuffled deck, a new
     * player and a new dealer with empty hands of cards.
     */
    public BlackJackModel(){
        deck = new Deck();
        deck.shuffle();
        player = new Player();
        dealer = new Dealer();
        playerStand = false;
        dealerStand = false;
    }

    /**
     * Hits once for the player, and returns the card.
     * @return the new card that the player hits
     */
    public Card getPlayerHitCard(){
        player.hit(deck);
        int size = player.getHand().getSize();
        return player.getHand().getCard(size-1);
    }

    /**
     * Hits once for the dealer, and returns the card.
     * @return the new card that the dealer hits
     */
    public Card getDealerHitCard(){
        dealer.hit(deck);
        int size = dealer.getHand().getSize();
        return dealer.getHand().getCard(size-1);
    }


    /**
     * Checks whether the dealer can hit.
     * A dealer can hit if the score is less than 17.
     * @return true if the dealer can hit, false otherwise
     */
    public boolean dealerCanHit(){
        return dealer.getScore() < 17;
    }

    /**
     * Checks whether the player has busted.
     * @return true if the player busts, false otherwise
     */
    public boolean playerBust(){
        return player.isBust();
    }

    /**
     * Checks whether the dealer has busted.
     * @return true if the dealer busts, false otherwise
     */
    public boolean dealerBust(){
        return dealer.isBust();
    }

    /**
     * Checks whether the player has black jack.
     * @return true if the player black jack, false otherwise
     */
    public boolean playerBJ(){
        return player.blackJack();
    }

    /**
     * Checks whether the dealer has black jack.
     * @return true if the dealer black jack, false otherwise
     */
    public boolean dealerBJ(){
        return dealer.blackJack();
    }


    /**
     * Checks whether the game is over.
     * The game is over when both dealer and player has finished
     * their turn.
     * @return true if game is over, false otherwise
     */
    public boolean isGameOver(){
        return dealerStand && playerStand;
    }

    /**
     * Sets the player's turn as finished.
     */
    public void setPlayerStand(){
        playerStand = true;
    }

    /**
     * Sets the dealer's turn as finished.
     */
    public void setDealerStand(){
        dealerStand = true;
    }

    /**
     * Checks whether the game result is a tie.
     * @return true if there's a tie, false otherwise
     */
    public boolean tieGame(){
        return ((dealerBust() && playerBust()) || (dealerBJ() && playerBJ()) ||
                (player.getScore() == dealer.getScore()));
    }

    /**
     * Returns the winner of this game.
     * @return the winner
     * @throws IllegalStateException if the game is not over yet
     */
    public String getWinner() throws IllegalStateException {
        if (tieGame()){
            throw new IllegalStateException("There is no winner in this round.");
        }

        // otherwise, the player with a better hand wins
        if (player.getScore() > dealer.getScore()) {
            return "You";
        } else {
            return "Dealer";
        }
    }
}

