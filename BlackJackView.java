import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.nio.file.Paths;

public class BlackJackView extends JFrame{
    private JPanel dealerPanel;
    private JPanel playerPanel;
    private JPanel messagePanel;
    private JButton hitButton = new JButton("HIT");
    private JButton standButton = new JButton("STAND");
    private JButton restartButton = new JButton("RESTART");
    private JLabel message = new JLabel("");
    private JPanel[][] panelHolder;
    private JLabel faceDownCard;
    public final String myPath = Paths.get("").toAbsolutePath().toString() + "/src/resources/";

    public BlackJackView() {
        super("Black Jack");
        setLayout(new BorderLayout());
        setSize(2000, 1000);
        addDealerPanel();
        addPlayerPanel();
        addMessagePanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void addMessagePanel() {
        panelHolder = new JPanel[2][3];
        messagePanel = new JPanel(new GridLayout(2, 3));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                panelHolder[i][j] = new JPanel();
                messagePanel.add(panelHolder[i][j]);
            }
        }

        message.setFont(new Font("American Typewriter", Font.PLAIN, 26));

        panelHolder[0][1].add(restartButton);
        restartButton.setVisible(false);
        panelHolder[1][1].add(message);
        panelHolder[1][0].add(hitButton);
        panelHolder[1][2].add(standButton);
        hitButton.setFont(new Font("Ariel", Font.PLAIN, 24));
        standButton.setFont(new Font("Ariel", Font.PLAIN, 24));
        restartButton.setFont(new Font("Ariel", Font.PLAIN, 24));

        add(messagePanel, BorderLayout.CENTER);
    }

    private void addPlayerPanel() {
        playerPanel = new JPanel(new FlowLayout());
        add(playerPanel, BorderLayout.SOUTH);
    }

    private void addDealerPanel() {
        dealerPanel = new JPanel(new FlowLayout());
        add(dealerPanel, BorderLayout.NORTH);
    }

    public void setMessage(String s) {
        message.setText(s);
    }

    /**
     * Adds the appropriate card image based on the given {@link Card} to the
     * given panel. If {@code null} is passed in as the card, a face down
     * card will be added to the panel.
     *
     * @param newCard the card to be displayed
     * @param panel the panel where the card is added
     */
    public void addCardToPanel(Card newCard, JPanel panel) {
        String imageName;

        if (newCard == null) {
            imageName = "blue_back";
        } else {
            char suitFirstLetter = newCard.getSuit().toString().charAt(0);

            if (newCard.getName().number() == 1 || newCard.getName().number() > 10) {
                imageName = String.format("%c%c", newCard.getName().toString().charAt(0), suitFirstLetter);
            } else {
                imageName = String.format("%d%c", newCard.getName().number(), suitFirstLetter);
            }
        }

        // get image from resources
        try {
            BufferedImage newDealerCard = ImageIO.read(new File(myPath + imageName + ".png"));
            JLabel newPicLabel = new JLabel(new ImageIcon(newDealerCard));
            panel.add(newPicLabel);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a face down card to the given panel.
     * @param panel the panel that the face down card is added to
     */
    public void addFaceDownCardToPanel(JPanel panel) {
        try {
            BufferedImage faceDownImage = ImageIO.read(new File(myPath + "blue_back.png"));
            faceDownCard = new JLabel(new ImageIcon(faceDownImage));
            panel.add(faceDownCard);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeFaceDownCard() {
        dealerPanel.remove(faceDownCard);
    }

    public JPanel getDealerPanel() {
        return this.dealerPanel;
    }

    public JPanel getPlayerPanel() {
        return this.playerPanel;
    }

    public JButton getHitButton() {
        return hitButton;
    }

    public JButton getStandButton() {
        return standButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

}

