import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.util.StringJoiner;

public class BlackJackView extends JFrame {
    private JPanel dealerPanel;
    private JPanel playerPanel;
    private JPanel messagePanel;
    private JButton hitButton, standButton;
    private JLabel message;
    private JPanel[][] panelHolder;

    public BlackJackView() {
        super("Black Jack");
        setLayout(new BorderLayout());
        setSize(2000, 1000);
        addDealerPanel();
        addPlayerPanel();
        addMessagePanel();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void addMessagePanel() {
        panelHolder = new JPanel[2][3];
        messagePanel = new JPanel(new GridLayout(2, 3));

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                panelHolder[i][j] = new JPanel();
                messagePanel.add(panelHolder[i][j]);
            }
        }
        message = new JLabel("Message");
        hitButton = new JButton("HIT");
        standButton = new JButton("STAND");

        panelHolder[1][1].add(message);
        panelHolder[1][0].add(hitButton);
        panelHolder[1][2].add(standButton);

        hitButton.setSize(20, 20);
        standButton.setSize(20, 20);

        add(messagePanel, BorderLayout.CENTER);
    }

    public void addMessage(Component component) {
        panelHolder[1][1].remove(message);
        panelHolder[1][1].add(component);
    }


    public void addPlayerPanel()  {
        playerPanel = new JPanel(new FlowLayout());
        add(playerPanel, BorderLayout.SOUTH);
    }

    public void addDealerPanel() {
        dealerPanel = new JPanel(new FlowLayout());
        add(dealerPanel, BorderLayout.NORTH);
    }

    public void addCardToPanel(Card newCard, JPanel panel){
        String imageName;
        String myPath = "/Users/yuhsuanlin/Documents/cs5004/hw/hw08/src/resources/";

        if (newCard == null) {
            imageName = "blue_back";
        }
        else {
            char suitFirstLetter = newCard.getSuit().toString().charAt(0);

            if (newCard.getName().getValue() == 1 || newCard.getName().getValue() > 10) {
                imageName = String.format("%c%c", newCard.getName().toString().charAt(0), suitFirstLetter);
            } else {
                imageName = String.format("%d%c", newCard.getName().getValue(), suitFirstLetter);
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



    public JPanel getDealerPanel() {
        return this.dealerPanel;
    }

    public JPanel getPlayerPanel() {
        return this.playerPanel;
    }

    public JPanel getMessagePanel() {
        return this.messagePanel;
    }



    public JButton getHitButton() {
        return hitButton;
    }

    public JButton getStandButton() {
        return standButton;
    }




    public static void main(String[] args) throws IOException {
        BlackJackView view = new BlackJackView();
    }


}
