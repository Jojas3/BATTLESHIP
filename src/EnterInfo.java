import javax.swing.*;
import java.awt.event.*;

public class EnterInfo extends JFrame {

    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JLabel infoTitle;

    public EnterInfo() {
        setTitle("Another Window");

        JLabel label = new JLabel("This is another window.");
        add(label);

        setSize(300, 200);
        setLocationRelativeTo(null);
    }
}
