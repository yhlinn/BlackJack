public class BlackJack {
    private BlackJackPlayer player;
    private Dealer dealer;
    private Deck deck;

    public BlackJack() {
        this.player = new BlackJackPlayer();
        this.dealer = new Dealer();
        this.deck = new Deck();

        deck.shuffle();
        initializeHands(player);
        initializeHands(dealer);
    }

    private void initializeHands(BlackJackPlayer player) {
        player.addToHand(deck);
        player.addToHand(deck);
    }

    /**
     * Return the ith card of the given player's hand.
     *
     * @param i the position of the card
     * @return the ith card
     */
    public Card getCardFromPlayer(int i) {
        return player.getCard(i);
    }

    /**
     * Return the ith card of the dealer's hand.
     *
     * @param i the position of the card
     * @return the ith card
     */
    public Card getCardFromDealer(int i) {
        return dealer.getCard(i);
    }

    public boolean didPlayerBust() {
        return player.bust();
    }

    public boolean didDealerBust() {
        return dealer.bust();
    }

    public boolean didPlayerBlackJack() {
        return player.blackJack();
    }

    public boolean didDealerBlackJack() {
        return dealer.blackJack();

    }

    /**
     * Checks whether the game is over because someone has busted or has scored a black jack.
     *
     * @return true if someone busted or got black jack, false otherwise
     */
    public boolean isGameOver() {
        return didDealerBust() || didPlayerBust() || didDealerBlackJack() || didPlayerBlackJack();
    }


    public String getWinner() {
        if (didPlayerBust()) {
            return dealer.toString();
        } else if (didDealerBust()) {
            return player.toString();
        }
        if (player.getMaximumScore() > dealer.getMaximumScore()) {
            return player.toString();
        } else if (player.getMaximumScore() < dealer.getMaximumScore()) {
            return dealer.toString();
        } else {
            return null;
        }
    }

    public void hit(BlackJackPlayer player) {
        player.addToHand(deck);
    }

    public void play(BlackJackPlayer player) {
        if (!isGameOver()) {
            System.out.printf("[ %s's Turn ] \n", player);
        }
        while (!isGameOver() && player.chooseToHit()) {
            hit(player);
            System.out.printf("Current Cards for %s : \n", player);
            player.displayHand();
            System.out.println();
        }
    }



    public void startGame() {
        System.out.println("\nBLACK JACK\n");
        System.out.printf("==== %s's Cards ====\n", player);
        player.displayHand();
        System.out.println("\n");

        System.out.printf("==== %s's Cards ====\n", dealer);
        dealer.displayCard(0); // display one card only
        System.out.println("\n");

        System.out.println("==== GAME BEGINS ====");
        play(player);

        System.out.println(">>> Dealer flips the hidden card....");
        System.out.printf("==== %s's Cards ====\n", dealer);
        dealer.displayHand();
        System.out.println("\n");

        play(dealer);

        if (didDealerBust()) {
            System.out.println("DEALER HAS BUSTED!");
        } else if (didPlayerBust()) {
            System.out.printf("%s HAS BUSTED!\n", player);
        } else if (didDealerBlackJack()) {
            System.out.println("DEALER BLACK JACK!");
        } else if (didPlayerBlackJack()) {
            System.out.printf("%s BLACK JACK!\n", player);
        }

        if (getWinner() == null) {
            System.out.println("It's a tie!");
        } else {
            System.out.printf("Winner is %s", getWinner());
        }

    }







//    public void play() {
//        System.out.printf("==== %s's Cards ====\n", player);
//        player.displayHand();
//        System.out.println("\n");
//
//        System.out.printf("==== %s's Cards ====\n", dealer);
//        dealer.displayCard(0); // display one card only
//        System.out.println("\n");
//
//        System.out.println("==== GAME BEGINS ====");
//        if (!isGameOver()) {
//            System.out.println("PLAYER's TURN");
//            playerPlay();
//            if (!isGameOver()) {
//                // dealer begins
//                System.out.println("DEALER's TURN");
//                System.out.println(">>> Dealer flips the 2nd card...");
//                dealer.displayHand();
//                dealerPlay();
//            }
//        }
//
//        System.out.println("=======================");
//
//        if (player.bust() || dealer.bust()) {
//            System.out.printf("BUST for %s\n", bustPlayer);
//        }
//
//        if (player.blackJack() || dealer.blackJack()) {
//            System.out.printf("BLACKJACK for %s\n", blackJackPlayer);
//        }
//
//        BlackJackPlayer winner = determineWinner();
//        if (winner == null) {
//            System.out.println("It's a tie.");
//        } else {
//            System.out.printf("The winner is %s!", winner);
//        }
//    }



    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.startGame();
    }


    // for UI
    public void playerHit() {
        hit(player);
    }

    public void dealerHit() {
        hit(dealer);
    }



}
