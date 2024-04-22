import java.util.*;
public class Turn {
    private static String gameResult;


    //get player computer guess and add to list of all computer guesses
    private static String computerGuess() {
        Random rand = new Random();
        Service obj = new Service();
        System.out.println("\nComputer, it is your turn.");

        String guess = "initialize", y;
        int x;

        while (!(obj.getP2Guesses().contains(guess))) {
            //generate random y coord
            y = String.valueOf(obj.getyBound().charAt(rand.nextInt(obj.getyBound().length())));

            //generate random x coord
            x = rand.nextInt(obj.getxBound());

            guess = y + x;

            obj.setP2Guesses(guess);
        }

        System.out.println("The computer guessed: " + guess);


        if (obj.getP1Location().contains(guess)){
            System.out.println("HIT!");
            //mark a hit for the stats
            obj.setP2ShotsHit();
            obj.setHit(true);
            if (!Service.isGameStatus()) {
                System.out.println("\nIT'S A DRAW!");

            }
        } else {
            obj.setP2ShotsMiss();
            obj.setHit(false);
        }

        return guess;
    }

    //player one turn
    private static void playerOne() {
        Service obj = new Service();
        obj.setHit(false);
        System.out.println("\nPlayer one, it is your turn.");


        if (obj.getP2Location().contains(Service.getCurrentGuess())) {
            System.out.println("HIT!");
            //mark a hit for the stats
            obj.setP1ShotsHit();
            obj.setHit(true);
        } else {
            System.out.println("You missed!");
            obj.setP1ShotsMiss();
            obj.setHit(false);
        }


        if (Service.getP1ShotsHit() == (obj.getShipsPerPlayer())) {
            Service.setGameStatus(false);
        }

    }

    //p2 turn
    private static void playerTwo() {
        Service obj = new Service();
        obj.setHit(false);
        System.out.println("\nPlayer two, it is your turn.");

        //if enemy ships contain the guess mark as hit and repeat, else miss. if guessed all ships then end program
        do {
            if (obj.getP1Location().contains(Service.getCurrentGuess())) {
                System.out.println("HIT!");
                //mark a hit for the stats
                obj.setP2ShotsHit();
                obj.setHit(true);
                if (!Service.isGameStatus()) {
                    System.out.println("\nIT'S A DRAW!");
                }
            } else {
                System.out.println("You missed!");
                obj.setP2ShotsMiss();
                obj.setHit(false);
            }
        } while (obj.isHit() && (Service.getP2ShotsHit() != (obj.getShipsPerPlayer())));
        if (Service.getP2ShotsHit() == (obj.getShipsPerPlayer())){
            Service.setGameStatus(false);
        }
        System.out.println("End of Player Two's Turn.");

    }

    //turn goes until computer misses
    public static void playerComputer() {
        System.out.println("The computer is guessing your location...");

        computerGuess();

        System.out.println("End of Computer's Turn.");
    }

    public static void Turns() {
        while (Service.isGameStatus()) {
            //player one turn
            new MainGame(1).setVisible(true);
            playerOne();

            //player two turn
            if (Service.isMultiplayer()) {
                new MainGame(2).setVisible(true);
                playerTwo();
            } else {
                playerComputer();
            }
        }


        //after turns are over, open game over screen.
        new GameOver(getGameResult()).setVisible(true);
    }


    public static String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String result) {
        gameResult = result;
    }
}