import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGame extends JFrame {


    //I couldn't figure out a way to draw the grid using the form so i did this instead. I think it saved time. this code is just meant
    // to visualize what the game board will look like. player will click a button and then that button location will be sent to the server.


    private static final int GRID_SIZE = 10;
    private JButton[][] gridButtons;

    public MainGame() {
        setTitle("Battleship Grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        //create panel for the grid
        JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE + 1, GRID_SIZE + 1));
        gridButtons = new JButton[GRID_SIZE][GRID_SIZE];

        //add empty label for the top-left corner
        gridPanel.add(new JLabel(""));

        //add labels for numbers (vertical)
        for (int i = 0; i < GRID_SIZE; i++) {
            JLabel label = new JLabel(String.valueOf(i + 1), SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gridPanel.add(label);
        }

        //add labels for letters (horizontal) and grid cells
        for (int i = 0; i < GRID_SIZE; i++) {
            char rowLabel = (char) ('A' + i);
            JLabel label = new JLabel(String.valueOf(rowLabel), SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gridPanel.add(label);

            for (int j = 0; j < GRID_SIZE; j++) {
                JButton cellButton = new JButton();
                cellButton.setPreferredSize(new Dimension(50, 50)); // Set preferred size for buttons
                gridButtons[i][j] = cellButton; // Store button reference in the gridButtons array
                cellButton.addActionListener(new ButtonClickListener(i, j)); // Add ActionListener to each button
                gridPanel.add(cellButton);
            }
        }

        mainPanel.add(gridPanel, BorderLayout.CENTER);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null); //center the frame on the screen
    }

    // ActionListener for grid buttons
    private class ButtonClickListener implements ActionListener {
        private int row;
        private int column;

        public ButtonClickListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            //obtain and print the clicked button. in the future this can be used to store or send data to the server.
            System.out.println("Clicked on cell: " + (char)('A' + row) + (column + 1));
        }
    }
}
