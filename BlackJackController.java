import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackController implements ActionListener {
    private BlackJackModel model;
    private BlackJackView view;

    public BlackJackController() {
        model = new BlackJackModel();
        view = new BlackJackView();
        initController();
        initGame();
        view.setVisible(true);
    }

    /**
     * Registers this class to be the listener of the buttons.
     */
    public void initController() {
        view.getHitButton().addActionListener(this);
        view.getStandButton().addActionListener(this);
        view.getRestartButton().addActionListener(this);
    }

    /**
     * Displays the cards in the beginning, based on the game.
     * The second card of the dealer is hidden.
     */
    public void initGame() {
        view.addCardToPanel(model.getDealerHitCard(), view.getDealerPanel());
        view.addFaceDownCardToPanel(view.getDealerPanel());
        view.addCardToPanel(model.getPlayerHitCard(), view.getPlayerPanel());
        view.addCardToPanel(model.getPlayerHitCard(), view.getPlayerPanel());
    }

    /**
     * Starts a new game with a new view.
     */
    public void startAgain() {
        view.setVisible(false);
        view = new BlackJackView();
        model = new BlackJackModel();
        this.initController();
        this.initGame();
        view.setVisible(true);
    }

    /**
     * Displays game result in the message panel when game is over.
     * Hides the hit and stand buttons and displays the restart button.
     */
    public void displayGameOver() {
        String message = "";
        if (model.isGameOver()) {
            if (model.tieGame()){
                view.setMessage("PUSH!");
            }
            else if (model.playerBust() || model.dealerBJ()){
                String m = (model.dealerBJ())? "Dealer got BLACKJACK" : "You BUST";
                view.setMessage(m + ", Dealer WON!");
            }

            else if (model.dealerBust() || model.playerBJ()){
                String m = (model.playerBJ())?  "You got BLACKJACK" : "Dealer BUST";
                view.setMessage(m +  ", You WON!");
            }

            else {
                view.setMessage(model.getWinner() + " WON!");
            }

            // clean up buttons
            view.getRestartButton().setVisible(true);
            view.getStandButton().setVisible(false);
            view.getHitButton().setVisible(false);
        }
    }


    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.equals(view.getHitButton())) {
            view.addCardToPanel(model.getPlayerHitCard(), view.getPlayerPanel());
        }

        if (model.playerBust() || model.playerBJ() || button.equals(view.getStandButton())) {
            model.setPlayerStand();

            // display all dealer's cards
            view.removeFaceDownCard();
            view.addCardToPanel(model.getDealerHitCard(), view.getDealerPanel());
            view.setVisible(true);


            // dealer starts playing
            while (model.dealerCanHit()) {
                view.addCardToPanel(model.getDealerHitCard(), view.getDealerPanel());
            }
            model.setDealerStand();
        }

        if (button.equals(view.getRestartButton())) {
            startAgain();
        }

        displayGameOver();
        view.setVisible(true);
    }

    public static void main(String[] args) {
        BlackJackController c = new BlackJackController();
    }


}

