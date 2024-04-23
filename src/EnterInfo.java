import javax.swing.*;
import java.util.InputMismatchException;

public class EnterInfo extends JFrame {
    private JPanel mainPanel;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel infoTitle;
    private JButton STARTGAMEButton;
    private JButton backButton;
    private JLabel p1Label;
    private JLabel p2Label;
    private JLabel yLabel;
    private JLabel spacer;

    public EnterInfo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Enter Positions");
        add(mainPanel);

        yLabel.setText("Y Bound: "+Service.getYBound().charAt(Service.getXBound())+"      X Bound: "+Service.getXBound());

        if(Service.isMultiplayer()){
            System.out.println("Two player mode selected.");
        }else{
            System.out.println("One player mode selected.");
            passwordField2.setVisible(false);
            p2Label.setVisible(false);
        }

        STARTGAMEButton.addActionListener(e-> {
            //checksPassed will be false until the player coord checks pass without exception
            boolean checksPassed = false;

            try {
                Ships.placeShips(passwordField1, passwordField2);
                //set i=1, indicating that the checks passed.
                checksPassed = true;
            } catch (InputMismatchException badInput){
                JOptionPane.showMessageDialog(this, "Please enter a valid ship location. Hover over input box for further instruction.");
                passwordField1.setText("");
                passwordField2.setText("");
            }

            if(checksPassed){
                dispose();

                //begin the game and start taking turns
                Service.setGameStatus(true);
                new MainGame(true).setVisible(true);
            }
        });

        backButton.addActionListener(e-> {
            dispose();
            new StartScreen().setVisible(true);
        });


        //set window size and center
        setSize(1000, 900);
        setLocationRelativeTo(null);
    }
}
