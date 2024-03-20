import javax.swing.*;
import java.awt.event.*;
public class StartScreen extends JFrame{

    private JPanel mainPanel;
    private JLabel Title;
    private JButton twoPlayerStart;
    private JButton onePlayerStart;
//this is the main panel, complete with tips.
    public StartScreen(){
        setTitle("BATTLESHIP!");
        add(mainPanel);

        onePlayerStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                //EnterInfo.setVisibility(true);
            }
        });

        twoPlayerStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                //EnterInfo.setVisibility(true);
            }
        });
    }

}
