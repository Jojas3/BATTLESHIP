
import javax.swing.*;
import java.util.*;

//pretend this is a server
public class Service {

    //set true when game is active, set false when game-over
    private static boolean gameStatus;
    //True if two players, false if single player.
    private static boolean multiplayer;

    //list of all guesses the computer has made
    private String p1Guesses, p2Guesses;

    //keeps track of the number of player ships remaining on the board, will be used if I add more than one ship
    private int playerOneShips, playerTwoShips;

    //checks if shots are hit
    private boolean isHit, isMiss;

    //stats tracking p1
    private int p1ShotsHit, p1ShotsMiss;

    //stats tracking p2
    private int p2ShotsHit, p2ShotsMiss;

    //ship location, player1
    private int x1;
    private String y1;

    //ship location, player2
    private int x2;
    private String y2;

    //y letter bound
    private static final String yBound = "abcdefghij";
    private static final int xBound = 10;

    //ship length
    //private int length;



    //this method will loop player turns until game-over
    //TODO: might be useless. check back later when project is finished.
    public static void gameLoop() {
        setGameStatus(true);
        System.out.println("\nStarting game!!!\n");

        Turn.Turns();
        System.out.println("GAME OVER. Thank you for playing!");

    }


    //getters and setters

    protected static void checkCoord(char[] password) throws InputMismatchException{
        //y is char. x is int
        if (password.length == 2) {
            int x = password[1] - '0';
            char y = password[0];
        }else{
            throw new InputMismatchException();
        }

        checkX(password);
        checkY(password);


    }
    public static boolean isMultiplayer() {
        return multiplayer;
    }

    public static void setMultiplayer(boolean multiplayer) {
        Service.multiplayer = multiplayer;
    }

    public String getyBound() {
        return yBound;
    }
    public int getxBound(){
        return xBound;
    }

    public int getX1() {
        return this.x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public String getY1() {
        return this.y1;
    }

    public void setY1(String y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return this.x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public String getY2() {
        return this.y2;
    }

    public void setY2(String y2) {
        this.y2 = y2;
    }

    /*public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }*/

    public static boolean isGameStatus() {
        return gameStatus;
    }

    public static void setGameStatus(boolean gameStatus) {
        Service.gameStatus = gameStatus;
    }


    public int getPlayerOneShips() {
        return playerOneShips;
    }

    public void setPlayerOneShips(int playerOneShips) {
        this.playerOneShips = playerOneShips;
    }

    public int getPlayerTwoShips() {
        return playerTwoShips;
    }

    public void setPlayerTwoShips(int playerTwoShips) {
        this.playerTwoShips = playerTwoShips;
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

    public int getP1ShotsHit() {
        return p1ShotsHit;
    }

    public void setP1ShotsHit() {
        this.p1ShotsHit+=1;
    }

    public int getP1ShotsMiss() {
        return p1ShotsMiss;
    }

    public void setP1ShotsMiss() {
        this.p1ShotsMiss+=1;
    }

    public int getP2ShotsHit() {
        return p2ShotsHit;
    }

    public void setP2ShotsHit() {
        this.p2ShotsHit+=1;
    }

    public int getP2ShotsMiss() {
        return p2ShotsMiss;
    }

    public void setP2ShotsMiss() {
        this.p2ShotsMiss+=1;
    }

    public void setP2Guesses(String p2Guesses) {
        this.p2Guesses += (p2Guesses+" ");
    }

    public String getP2Guesses() {
        return p2Guesses+"";
    }

    public String getP1Guesses() {
        return p1Guesses+"";
    }

    public void setP1Guesses(String p1Guesses) {
        this.p1Guesses += (p1Guesses+" ");
    }
}
