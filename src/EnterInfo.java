import javax.swing.*;
import java.util.Arrays;

public class EnterInfo extends JFrame {
    private JPanel mainPanel;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel infoTitle;
    private JButton STARTGAMEButton;
    private JButton backButton;

    //storeShip will check to see if a user-entered ship coordinate is a valid input. If it is, then it will
    //store that date. If it isn't, then it should throw an error and make the user enter another coord.
    //Repeat until user enters a valid cord.

    //see if you can modify the existing code in the Service class to help with this.
    public EnterInfo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Enter Positions");
        add(mainPanel);

        if(Service.isMultiplayer()){
            passwordField1.setVisible(true);
            passwordField2.setVisible(true);
            System.out.println("Two player mode selected.");
        }else{
            System.out.println("One player mode selected.");
            passwordField2.setVisible(false);
        }

        STARTGAMEButton.addActionListener(e-> {
            //checksPassed will be false until the player coord checks pass
            boolean checksPassed = false;

            //ask server to check if player coords are valid. if they are, then Service.checkCoord will set to appropriate variable. if not, throw error
            try {
                Service.checkCoord(passwordField1.getPassword());
                Ships.setCoord(Arrays.toString(passwordField1.getPassword()), 1);
                //if MP, run the check for p2 coord.
                //if not MP, generate random coords for the NPC
                if(Service.isMultiplayer()) {
                    Service.checkCoord(passwordField2.getPassword());
                    Ships.setCoord(Arrays.toString(passwordField2.getPassword()), 2);
                }else{
                    Ships.placeShips();
                }
                //set i=1, indicating that the checks passed.
                checksPassed = true;
            } catch (Exception badInput){
                JOptionPane.showMessageDialog(this, "Please enter a valid ship location. Hover over input box for further instruction.");
                passwordField1.setText("");
                passwordField2.setText("");
            }

            if(checksPassed){
                dispose();

                //begin the game and start taking turns
                Service.setGameStatus(true);
                Turn.Turns();
            }
        });

        backButton.addActionListener(e-> {
            dispose();
            new StartScreen().setVisible(true);
        });

        setSize(1000, 900);
        setLocationRelativeTo(null);
    }
}
