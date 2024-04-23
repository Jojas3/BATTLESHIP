import javax.swing.*;

public class GameOver extends JFrame {


    private JPanel mainPanel;
    private JLabel mainLabel;
    private JLabel resultLabel;
    private JButton nextButton;

    public GameOver(String result){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GAME OVER.");
        add(mainPanel);
        setSize(1000, 900);
        setLocationRelativeTo(null);

        resultLabel.setText(result);

        nextButton.addActionListener(e -> {
            new Leaderboard(false, result).setVisible(true);
            dispose();
        });

    }
}
