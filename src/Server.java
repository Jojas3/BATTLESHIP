import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 8080;
    /**
     * Max y bound value cannot exceed j
     */
    private static final String yBound = "abcdefgh";
    private static volatile boolean gameStatus;
    private static volatile boolean multiplayer;
    private static volatile String currentGuess = "";
    private static volatile String p1Location = "";
    private static volatile String p2Location = "";
    private static volatile int p1ShotsMiss = 0;
    private static volatile int p2ShotsMiss = 0;
    private static volatile String p2Guesses = "";


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("\nClient connected: " + socket);

                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Server Failure!");
        }
    }

    private record ClientHandler(Socket socket) implements Runnable {

        public void run() {
                try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received from client: " + inputLine);
                        String[] tokens = inputLine.split(" ");

                        if (tokens.length < 2) {
                            out.println("Invalid command");
                            continue;
                        }

                        String command = tokens[0];
                        String key = tokens[1];

                        switch (command) {
                            case "GET":
                                String value = getValueByKey(key);
                                out.println(value);
                                break;
                            case "POST":
                                if (tokens.length < 3) {
                                    out.println("Invalid command");
                                    continue;
                                }
                                String newValue = tokens[2];
                                setValueByKey(key, newValue);
                                break;
                            default:
                                out.println("Invalid command");
                                break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Failed to interpret command!!!!");
                } finally {
                    try {
                        socket.close();
                        System.out.println("Client disconnected: " + socket);
                    } catch (IOException e) {
                        System.out.println("Failed to close socket!");
                    }
                }
            }

            private String getValueByKey(String key) {
                return switch (key) {
                    case "gameStatus" -> Boolean.toString(gameStatus);
                    case "multiplayer" -> Boolean.toString(multiplayer);
                    case "currentGuess" -> currentGuess;
                    case "p1Location" -> p1Location.toLowerCase();
                    case "p2Location" -> p2Location.toLowerCase();
                    case "p1ShotsMiss" -> Integer.toString(p1ShotsMiss);
                    case "p2ShotsMiss" -> Integer.toString(p2ShotsMiss);
                    case "p2Guesses" -> p2Guesses;
                    case "yBound" -> yBound;
                    case "xBound" -> Integer.toString((yBound.length() - 1));
                    case "leastGuesses" -> Integer.toString(Math.min(p1ShotsMiss, p2ShotsMiss));
                    default -> "Unknown Key";
                };
            }

            private void setValueByKey(String key, String value) {
                value = value.toLowerCase();
                switch (key) {
                    case "gameStatus":
                        gameStatus = Boolean.parseBoolean(value);
                        break;
                    case "multiplayer":
                        multiplayer = Boolean.parseBoolean(value);
                        System.out.println("Sent to server: " + Boolean.toString(multiplayer));
                        break;
                    case "currentGuess":
                        currentGuess = value;
                        break;
                    case "p1Location":
                        p1Location = value;
                        break;
                    case "p2Location":
                        p2Location = value;
                        break;
                    case "p1ShotsMiss":
                        p1ShotsMiss += 1;
                        break;
                    case "p2ShotsMiss":
                        p2ShotsMiss += 1;
                        break;
                    case "p2Guesses":
                        p2Guesses += value +" ";
                        break;
                    default:
                        System.out.println("Unknown key");
                        break;
                }
            }
        }
}


