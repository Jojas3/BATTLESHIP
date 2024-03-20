import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.*;
public class EnterInfo extends JFrame {
    private JPanel mainPanel;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel infoTitle;
    private JButton STARTGAMEButton;


    public EnterInfo() {
        setTitle("Another Window");
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
            dispose();
            new MainGame().setVisible(true);
        });

        setSize(1000, 900);
        setLocationRelativeTo(null);
    }
}
