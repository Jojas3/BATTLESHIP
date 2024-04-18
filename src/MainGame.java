import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGame extends JFrame {


    //I couldn't figure out a way to draw the grid using the form so i did this instead. I think it saved time. this code is just meant
    // to visualize what the game board will look like. player will click a button and then that button location will be sent to the server.


    private static final int GRID_SIZE = 10;
    private JButton[][] gridButtons;
    private JPanel infoPanel;
    private JLabel yourTurn;
    private JLabel hitLabel;
    private JLabel missLabel;
    private JLabel playerHits;
    private JLabel playerMiss;

    public MainGame() {
        setTitle("Battleship Grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                cellButton.addActionListener(new ButtonClickListener(i, j)); // Add ActionListener to each button
                gridPanel.add(cellButton);
            }
        }

        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);
        add(mainPanel);

        pack();
        setLocationRelativeTo(null); //center the frame on the screen
    }

    // ActionListener for grid buttons
        private record ButtonClickListener(int row, int column) implements ActionListener {

        public void actionPerformed(ActionEvent click) {
                //obtain and print the clicked button. in the future this can be used to store or send data to the server.
                JButton clickedButton = (JButton) click.getSource();
                String a = (char) ('A' + row) + String.valueOf(column + 1);
                System.out.println("Clicked on cell: " + a);
            }
        }
}
