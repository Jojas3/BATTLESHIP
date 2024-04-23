import javax.swing.*;
import java.awt.*;

public class MainGame extends JFrame {

    private static final int GRID_SIZE = Service.getXBound()+1;

    private JPanel infoPanel;
    private JLabel yourTurn;
    private JLabel hitLabel;
    private JLabel missLabel;
    private JLabel playerHits;
    private JLabel playerMiss;


    public MainGame(boolean isPlayerOne) {
        setTitle("Battleship Grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set player hits and misses
        if (isPlayerOne) {
            yourTurn.setText("Player 1, it is your turn. Click on your guess.");
            playerHits.setText(String.valueOf(Service.getP1ShotsHit()));
            playerMiss.setText(String.valueOf(Service.getP1ShotsMiss()));
        } else {
            yourTurn.setText("Player 2, it is your turn. Click on your guess.");
            playerHits.setText(String.valueOf(Service.getP2ShotsHit()));
            playerMiss.setText(String.valueOf(Service.getP2ShotsMiss()));
        }


         /**
         * The following code draws the main grid with buttons.
         * At the time of creation I was unsure of how large the grid should be, so
         * the grid size can be changed by updating GRID_SIZE
         **/

        JPanel mainPanel = new JPanel(new BorderLayout());

        //create panel for the grid
        JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE + 1, GRID_SIZE + 1));

        //add empty label for the top-left corner to fix spacing issues
        gridPanel.add(new JLabel(""));

        //add labels for numbers (vertical)
        for (int i = 0; i < GRID_SIZE; i++) {
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gridPanel.add(label);
        }

        //add labels for letters (vertical) and grid cells
        for (int i = 0; i < GRID_SIZE; i++) {
            char rowLabel = (char) ('A' + i);
            JLabel label = new JLabel(String.valueOf(rowLabel), SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gridPanel.add(label);

            for (int j = 0; j < GRID_SIZE; j++) {
                JButton cellButton = newButtonListener(isPlayerOne, i, j);
                gridPanel.add(cellButton);
            }
        }

        add(gridPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); //center the frame on the screen
    }

    private JButton newButtonListener(boolean isPlayerOne, int i, int j) {
        JButton cellButton = new JButton();
        cellButton.setPreferredSize(new Dimension(50, 50)); //set the size of the buttons

        //stores the button (coordinate) clicked, then
        //dispose and go to next turn upon a button being clicked
        cellButton.addActionListener(e -> {
            String buttonId = (char) ('A' + i) + String.valueOf(j);
            System.out.println("You guessed: " + buttonId);

            //store to server
            Service.setCurrentGuess(buttonId);
            dispose();
            Turn.Turns(isPlayerOne);
        });
        return cellButton;
    }
}
