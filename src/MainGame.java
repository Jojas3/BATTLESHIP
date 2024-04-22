import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGame extends JFrame {

    private static final int GRID_SIZE = 10;
    private JButton[][] gridButtons;

    private JPanel infoPanel;
    private JLabel yourTurn;
    private JLabel hitLabel;
    private JLabel missLabel;
    private JLabel playerHits;
    private JLabel playerMiss;


    public MainGame(int player) {
        setTitle("Battleship Grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set player hits and misses
        if(player==1) {
            yourTurn.setText("Player "+player+", it is your turn. Click on your guess.");

            playerHits.setText(String.valueOf(Service.getP1ShotsHit()));
            playerMiss.setText(String.valueOf(Service.getP1ShotsMiss()));
        }else{
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

        //this line creates a square array of buttons that has area GRIDSIZExGRIDSIZE
        gridButtons = new JButton[GRID_SIZE][GRID_SIZE];

        //add empty label for the top-left corner to fix spacing issues
        gridPanel.add(new JLabel(""));

        //add labels for numbers (vertical)
        for (int i = 0; i < GRID_SIZE; i++) {
            JLabel label = new JLabel(String.valueOf(i + 1), SwingConstants.CENTER);
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
                JButton cellButton = new JButton();
                cellButton.setPreferredSize(new Dimension(50, 50)); // Set the size of the buttons
                gridButtons[i][j] = cellButton; // Store button reference in the gridButtons array
                // Add ActionListener to each button, each button disposes screen on click.
                cellButton.addActionListener(new ButtonClickListener(i, j));
                cellButton.addActionListener(e-> {dispose();});
                gridPanel.add(cellButton);
            }
        }

        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);
        add(mainPanel);

        pack();
        setLocationRelativeTo(null); //center the frame on the screen
    }

    //obtain the button clicked
    private record ButtonClickListener(int row, int column) implements ActionListener {
        public void actionPerformed(ActionEvent click) {
            // Obtain and store the clicked button.
            String buttonId = (char) ('A' + row) + String.valueOf(column + 1);
            System.out.println("You guessed: " + buttonId);

            //store to server
            Service.setCurrentGuess(buttonId);
        }
    }

}
