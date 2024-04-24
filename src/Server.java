import java.io.*;
import java.net.*;
public class Server {
    private static final int PORT = 8080;
    private static boolean gameStatus;
    private static boolean multiplayer;
    private static String currentGuess = "";
    private static String p1Location = "";
    private static String p2Location = "";
    private static int p1ShotsMiss = 0;
    private static int p2ShotsMiss = 0;
    private static String p2Guesses = "";
    private static final String yBound = "abcdefghij";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

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
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    System.out.println("Client disconnected: " + socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String getValueByKey(String key) {
            return switch (key) {
                case "gameStatus" -> Boolean.toString(gameStatus);
                case "multiplayer" -> Boolean.toString(multiplayer);
                case "currentGuess" -> currentGuess;
                case "p1Location" -> p1Location;
                case "p2Location" -> p2Location;
                case "p1ShotsMiss" -> Integer.toString(p1ShotsMiss);
                case "p2ShotsMiss" -> Integer.toString(p2ShotsMiss);
                case "p2Guesses" -> p2Guesses;
                case "yBound" -> yBound;
                case "xBound" -> Integer.toString((yBound.length() - 1));
                case "leastGuesses" -> Integer.toString(Math.min(p1ShotsMiss, p2ShotsMiss));
                default -> "Unknown key";
            };
        }

        private void setValueByKey(String key, String value) {
            switch (key) {
                case "gameStatus":
                    gameStatus = Boolean.parseBoolean(value);
                    break;
                case "multiplayer":
                    multiplayer = Boolean.parseBoolean(value);
                    break;
                case "currentGuess":
                    currentGuess = value+" ";
                    break;
                case "p1Location":
                    p1Location = value;
                    break;
                case "p2Location":
                    p2Location = value;
                    break;
                case "p1ShotsMiss":
                    p1ShotsMiss += Integer.parseInt(value);
                    break;
                case "p2ShotsMiss":
                    p2ShotsMiss = Integer.parseInt(value);
                    break;
                case "p2Guesses":
                    p2Guesses = value;
                    break;
                default:
                    System.out.println("Unknown key");
                    break;
            }
        }
    }
}

