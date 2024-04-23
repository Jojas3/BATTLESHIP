import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Leaderboard extends JFrame {
    private final DefaultListModel<Player> leaderboardModel;
    private final String FILENAME = "leaderboard.txt";

    private static class Player {
        private String name;
        private int misses;
        private int rank;

        public Player(String name, int misses) {
            this.name = name;
            this.misses = misses;
        }

        public String getName() {
            return name;
        }

        public int getMisses() {
            return misses;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return rank + ". " + name + " - Misses: " + misses;
        }
    }

    //ViewMode removes ability to write new players to the leaderboard
    public Leaderboard(boolean ViewMode, String result) {
        setTitle("Leaderboard");
        setSize(350, 400);
        setLocationRelativeTo(null);

        leaderboardModel = new DefaultListModel<>();
        JList<Player> leaderboardList = new JList<>(leaderboardModel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(leaderboardList), BorderLayout.CENTER);


        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        if(!ViewMode) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextField nameField = new JTextField(10);

            JButton submitButton = new JButton("Save and Exit");
            JButton exitButton = new JButton("Exit without Saving");

            exitButton.addActionListener(e -> {
                System.exit(0);
            });


            if(!result.toLowerCase().contains("computer")) {
                submitButton.addActionListener(e -> {
                    String name = nameField.getText().trim();
                    if (!name.isEmpty()) {
                        Player newPlayer = new Player(name, Service.getLeastGuesses());
                        addPlayerToLeaderboard(newPlayer);
                        saveLeaderboardToFile();

                        dispose();
                        new StartScreen().setVisible(true);
                    }
                });

            }else{
                Player newPlayer = new Player("Computer", Service.getLeastGuesses());
                addPlayerToLeaderboard(newPlayer);
                saveLeaderboardToFile();
            }

            inputPanel.add(new JLabel("Enter Your Name:"));
            inputPanel.add(nameField);
            inputPanel.add(new JLabel("Number of Misses: "));
            inputPanel.add(new JLabel(String.valueOf(Service.getLeastGuesses())));
            inputPanel.add(submitButton);
            inputPanel.add(exitButton);
        }else {
            JButton mainMenuButton = new JButton("Main Menu");
            mainMenuButton.addActionListener(e -> {
                dispose();
                new StartScreen().setVisible(true);
            });
            inputPanel.add(mainMenuButton);
        }

        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        add(mainPanel);

        loadLeaderboardFromFile();
    }

    private void addPlayerToLeaderboard(Player newPlayer) {
        boolean added = false;
        for (int i = 0; i < leaderboardModel.size(); i++) {
            if (newPlayer.getMisses() < leaderboardModel.getElementAt(i).getMisses()) {
                newPlayer.setRank(i + 1);
                leaderboardModel.insertElementAt(newPlayer, i);
                added = true;
                break;
            }
        }
        if (!added) {
            newPlayer.setRank(leaderboardModel.size() + 1);
            leaderboardModel.addElement(newPlayer);
        }
        if (leaderboardModel.size() > 5) {
            leaderboardModel.removeElementAt(5);
        }
        updateRanks();
    }

    private void updateRanks() {
        for (int i = 0; i < leaderboardModel.size(); i++) {
            leaderboardModel.getElementAt(i).setRank(i + 1);
        }
    }

    private void saveLeaderboardToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (int i = 0; i < leaderboardModel.size(); i++) {
                Player player = leaderboardModel.getElementAt(i);
                writer.println(player.getName() + "," + player.getMisses());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving leaderboard to file: " + e.getMessage());
        }
    }

    private void loadLeaderboardFromFile() {
        File file = new File(FILENAME);
        if (!file.exists()) {
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            leaderboardModel.clear();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                if (line.length == 2) {
                    String name = line[0];
                    int misses = Integer.parseInt(line[1]);
                    Player newPlayer = new Player(name, misses);
                    addPlayerToLeaderboard(newPlayer);
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error loading leaderboard from file: " + e.getMessage());
        }
    }
}
