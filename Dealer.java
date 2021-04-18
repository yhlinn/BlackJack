public class Dealer extends BlackJackPlayer {
    public Dealer() {
        super("The Dealer");
    }


    @Override
    public boolean chooseToHit() {
        return getMaximumScore() < 17;
    }


//    @Override
//    public int startTurn(Deck deck) {
//        while (getMaximumScore() < 17) {
//            addToHand(deck);
//            System.out.println(">>> Dealer hits...");
//            System.out.printf("Dealer got ");
//            displayCard(numCards()-1);
//        }
//
//        if (bust() || blackJack()) {
//            return 0;
//        }
//        return 1;
//    }

}
