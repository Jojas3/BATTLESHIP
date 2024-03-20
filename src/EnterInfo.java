import javax.swing.*;
import java.awt.event.*;

public class EnterInfo extends JFrame {

    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel infoTitle;
    private JPanel mainPanel;

    public EnterInfo() {
        setTitle("Another Window");
        add(mainPanel);
        JLabel label = new JLabel("This is another window.");
        add(label);

        setSize(1000, 900);
        setLocationRelativeTo(null);
    }
}
