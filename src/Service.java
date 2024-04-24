import java.io.*;
import java.net.*;

public class Service {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static String get(String key) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println("GET " + key);

            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void set(String key, String value) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            out.println("POST " + key + "=" + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isGameStatus() {
        String value = get("gameStatus");
        return Boolean.parseBoolean(value);
    }

    public static void setGameStatus(boolean gameStatus) {
        set("gameStatus", Boolean.toString(gameStatus));
    }

    public static boolean isMultiplayer() {
        String value = get("multiplayer");
        return Boolean.parseBoolean(value);
    }

    public static void setMultiplayer(boolean multiplayer) {
        set("multiplayer", Boolean.toString(multiplayer));
        System.out.println("Sent to server: "+Boolean.toString(multiplayer));
    }

    public static String getCurrentGuess() {
        return get("currentGuess");
    }

    public static void setCurrentGuess(String currentGuess) {
        set("currentGuess", currentGuess);
    }

    public static String getP1Location() {
        return get("p1Location");
    }

    public static void setP1Location(String p1Location) {
        set("p1Location", p1Location);
    }

    public static String getP2Location() {
        return get("p2Location");
    }

    public static void setP2Location(String p2Location) {
        set("p2Location", p2Location);
    }
    public static int getP1ShotsMiss() {
        String value = get("p1ShotsMiss");
        return Integer.parseInt(value);
    }

    public static void setP1ShotsMiss() {
        int currentMisses = getP1ShotsMiss();
        set("p1ShotsMiss", Integer.toString(currentMisses + 1));
    }

    public static int getP2ShotsMiss() {
        String value = get("p2ShotsMiss");
        return Integer.parseInt(value);
    }

    public static void setP2ShotsMiss() {
        int currentMisses = getP2ShotsMiss();
        set("p2ShotsMiss", Integer.toString(currentMisses + 1));
    }

    public static String getP2Guesses() {
        return get("p2Guesses");
    }

    public static void setP2Guesses(String p2Guesses) {
        set("p2Guesses", p2Guesses);
    }

    public static int getLeastGuesses() {
        String value = get("leastGuesses");
        return Integer.parseInt(value);
    }

    public static String getYBound() {
        return get("yBound");
    }

    public static int getXBound() {
        String value = get("xBound");
        return Integer.parseInt(value);
    }
}
