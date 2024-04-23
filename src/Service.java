//pretend this is a server.
public class Service {

    //set true when game is active, set false when game-over
    private static boolean gameStatus;
    //True if two players, false if single player.
    private static boolean multiplayer;

    //list of all guesses the computer has made
    private static String p2Guesses;

    //Stores the current guess
    private static String currentGuess;

    //stats tracking p1
    private static int p1ShotsHit;
    private static int p1ShotsMiss;

    //stats tracking p2
    private static int p2ShotsHit;
    private static int p2ShotsMiss;

    //ship location, player1
    private static String p1Location;

    //ship location, player2
    private static String p2Location;

    //y letter bound
    private static final String yBound = "abcdef";
    //x bound, 0 inclusive
    private static final int xBound = (yBound.length() - 1);


    //getters and setters
    public static boolean isMultiplayer() {
        return multiplayer;
    }

    public static void setMultiplayer(boolean multiplayer) {
        Service.multiplayer = multiplayer;
    }

    public static void setCurrentGuess(String buttonId) {
        currentGuess = buttonId.toLowerCase();
    }

    public static String getCurrentGuess(){
        return currentGuess;
    }

    public static String getYBound() {
        return yBound;
    }
    public static int getXBound(){
        return xBound;
    }

    public static String getP1Location() {
        return p1Location;
    }

    public static void setP1Location(String location) {
        p1Location = location;
    }

    public static String getP2Location() {
        return p2Location;
    }

    public static void setP2Location(String location) {
        p2Location = location;
    }

    public static boolean isGameStatus() {
        return gameStatus;
    }

    public static void setGameStatus(boolean gameStatus) {
        Service.gameStatus = gameStatus;
    }

    public static int getP1ShotsHit() {
        return p1ShotsHit;
    }

    public static void setP1ShotsHit() {
        p1ShotsHit+=1;
    }

    public static int getP1ShotsMiss() {
        return p1ShotsMiss;
    }

    public static void setP1ShotsMiss() {
        p1ShotsMiss+=1;
    }

    public static int getP2ShotsHit() {
        return p2ShotsHit;
    }

    public static void setP2ShotsHit() {
        p2ShotsHit+=1;
    }

    public static int getP2ShotsMiss() {
        return p2ShotsMiss;
    }

    public static void setP2ShotsMiss() {
        p2ShotsMiss+=1;
    }

    public static void setP2Guesses(String p2Guess) {
        p2Guesses += (p2Guess+" ");
    }

    //+"" prevents p2guesses from returning null and throwing an error
    public static String getP2Guesses() {
        return p2Guesses+"";
    }

    public static int getLeastGuesses(){
        return Math.min(p1ShotsMiss, p2ShotsMiss);
    }
}

