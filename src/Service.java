import java.util.*;

//pretend this is a server
public class Service {

    //set true when game is active, set false when game-over
    private static boolean gameStatus;
    //True if two players, false if single player.
    private static boolean multiplayer;

    //list of all guesses the computer has made
    private String p2Guesses;

    //Stores the current guess
    private static String currentGuess;

    //checks if shots are hit
    private boolean isHit, isMiss;

    //stats tracking p1
    private static int p1ShotsHit;
    private static int p1ShotsMiss;

    //stats tracking p2
    private static int p2ShotsHit;
    private static int p2ShotsMiss;

    //ship location, player1
    private String p1Location;

    //ship location, player2
    private String p2Location;

    //y letter bound
    private static final String yBound = "abcdefghij";
    private static final int xBound = 10;

    //total number of ships a player has
    private static final int shipsPerPlayer = 1;




    //getters and setters

    //check if a coordinate entered into the gui is valid
    public static void checkCoord(char[] password) throws InputMismatchException{
        int x;
        char y;
        //check the length, if its valid assign x/y to temp variables
        if (password.length == 2) {
            x = password[1] - '0';
            y = Character.toLowerCase(password[0]);
        }else{
            throw new InputMismatchException("Coordinate entered by Player is not length 2!");
        }

        //check if the inputs are within bounds,
        if(x>0 & xBound-x>=0 & yBound.indexOf(y)!=(-1)){
            //.indexOf returns -1 if the character is not in the yBound
            //do nothing if the coord is good
        }else{
            throw new InputMismatchException("Invalid coordinate given by player!");
        }
        System.out.println("Coordinate looks good!");
    }


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

    public String getyBound() {
        return yBound;
    }
    public int getxBound(){
        return xBound;
    }

    public int getShipsPerPlayer(){
        return shipsPerPlayer;
    }

    public String getP1Location() {
        return this.p1Location;
    }

    public void setP1Location(String location) {
        this.p1Location = location;
    }

    public String getP2Location() {
        return this.p2Location;
    }

    public void setP2Location(String p2Location) {
        this.p2Location = p2Location;
    }

    public static boolean isGameStatus() {
        return gameStatus;
    }

    public static void setGameStatus(boolean gameStatus) {
        Service.gameStatus = gameStatus;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean isMiss() {
        return isMiss;
    }

    public void setMiss(boolean miss) {
        isMiss = miss;
    }

    public static int getP1ShotsHit() {
        return p1ShotsHit;
    }

    public void setP1ShotsHit() {
        p1ShotsHit+=1;
    }

    public static int getP1ShotsMiss() {
        return p1ShotsMiss;
    }

    public void setP1ShotsMiss() {
        p1ShotsMiss+=1;
    }

    public static int getP2ShotsHit() {
        return p2ShotsHit;
    }

    public void setP2ShotsHit() {
        p2ShotsHit+=1;
    }

    public static int getP2ShotsMiss() {
        return p2ShotsMiss;
    }

    public void setP2ShotsMiss() {
        p2ShotsMiss+=1;
    }

    public void setP2Guesses(String p2Guesses) {
        this.p2Guesses += (p2Guesses+" ");
    }

    public String getP2Guesses() {
        return p2Guesses+"";
    }
}

