//pretend this is a server
public class Service {
    //set true when game is active, set false when game-over
    private static boolean gameStatus;

    //keeps track of the number of player ships remaining on the board
    private int playerOneShips, playerTwoShips;

    //checks if shots are hit
    private boolean isHit, isMiss;

    //stats tracking p1
    private int p1ShotsHit, p1ShotsMiss;

    //stats tracking p2
    private int p2ShotsHit, p2ShotsMiss;



    //this method will loop player turns until game-over
    public static void gameLoop() {
        while(gameStatus){

        }
    }




    //getters and setters
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

    public void setP1ShotsHit(int p1ShotsHit) {
        this.p1ShotsHit = p1ShotsHit;
    }

    public int getP1ShotsMiss() {
        return p1ShotsMiss;
    }

    public void setP1ShotsMiss(int p1ShotsMiss) {
        this.p1ShotsMiss = p1ShotsMiss;
    }

    public int getP2ShotsHit() {
        return p2ShotsHit;
    }

    public void setP2ShotsHit(int p2ShotsHit) {
        this.p2ShotsHit = p2ShotsHit;
    }

    public int getP2ShotsMiss() {
        return p2ShotsMiss;
    }

    public void setP2ShotsMiss(int p2ShotsMiss) {
        this.p2ShotsMiss = p2ShotsMiss;
    }
}
