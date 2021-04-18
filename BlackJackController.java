import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackController implements ActionListener {
    private BlackJack game;
    private BlackJackView view;


    public BlackJackController() {
        this.game = new BlackJack();
        this.view = new BlackJackView();
        registerListeners();
        init();
    }

    public void init() {
        // beginning of game
        System.out.println(game.getCardFromPlayer(0));
        view.addCardToPanel(game.getCardFromPlayer(0), view.getPlayerPanel());
        view.addCardToPanel(game.getCardFromPlayer(1), view.getPlayerPanel());
        view.addCardToPanel(game.getCardFromDealer(0), view.getDealerPanel());
        view.addCardToPanel(null, view.getDealerPanel());
        view.setVisible(true);
    }


    public void registerListeners() {
        view.getHitButton().addActionListener(this);
        view.getStandButton().addActionListener(this);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (game.isGameOver()) {
            return;
        }

        if (button.equals(view.getHitButton())) {
            game.playerHit();
        }


        if (game.didPlayerBlackJack()) {
            view.addMessage(new JLabel("Player Black Jack!"));
        } else if (game.didDealerBlackJack()) {
            view.addMessage(new JLabel("Dealer Black Jack!"));
        } else if (game.didDealerBust()) {
            view.addMessage(new JLabel("Dealer has busted!"));
        } else if (game.didPlayerBust()) {
            view.addMessage(new JLabel("Player has busted!"));
        }

        if (game.getWinner() != null) {
            String result = String.format("%s won!", game.getWinner());
            JLabel endingMessage = new JLabel(result);
            view.addMessage(endingMessage);
        }

    }


    public static void main(String[] args) {
        BlackJackController c = new BlackJackController();


    }



}
