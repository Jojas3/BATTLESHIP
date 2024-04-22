import javax.swing.*;
import java.awt.event.*;
public class StartScreen extends JFrame{

    private JPanel mainPanel;
    private JLabel Title;
    private JButton twoPlayerStart;
    private JButton onePlayerStart;
    private JButton lbButton;

    //this is the main panel, complete with tips.
    public StartScreen(){
        setTitle("BATTLESHIP!");
        add(mainPanel);
        setSize(1000, 900);
        setLocationRelativeTo(null);

        onePlayerStart.addActionListener(e -> {
            Service.setMultiplayer(false);
            dispose();
            new EnterInfo().setVisible(true);

        });

        twoPlayerStart.addActionListener(e -> {
            Service.setMultiplayer(true);
            dispose();
            new EnterInfo().setVisible(true);

        });

        lbButton.addActionListener(e -> {
            new Leaderboard().setVisible(true);
        });
    }

}
