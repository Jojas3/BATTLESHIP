import java.util.*;
//this class handles advancing through and completing player turns
public class Turn{


    //get player computer guess and add to list of all computer guesses
    private static void computerGuess() {
        Random rand = new Random();
        System.out.println("\nComputer, it is your turn.");

        String guess = "", y;
        int x;

        while (Service.getP2Guesses().contains(guess)) {
            //generate random y coord
            y = String.valueOf(Service.getYBound().charAt(rand.nextInt(Service.getYBound().length())));

            //generate random x coord
            x = rand.nextInt(Service.getXBound()+1);

            guess = y + x;
        }
        //adds guess to list of guesses
        Service.setP2Guesses(guess);
        System.out.println("The computer guessed: " + guess);


        if (Service.getP1Location().equals(guess)){
            System.out.println("HIT!");
            //mark a hit for the stats
            Service.setP2ShotsHit();
            Service.setGameStatus(false);

            new GameOver("The Computer Wins!").setVisible(true);
        } else {
            Service.setP2ShotsMiss();
        }

    }

    //player one turn
    private static void playerOne() {
        System.out.println("\nPlayer one, it is your turn.");

        if (Service.getP2Location().equals(Service.getCurrentGuess())) {
            System.out.println("HIT!");
            //mark a hit for the stats
            Service.setP1ShotsHit();
            Service.setGameStatus(false);
            new GameOver("Player One Wins!").setVisible(true);
        } else {
            System.out.println("You missed!");
            Service.setP1ShotsMiss();
        }

        System.out.println("End of Player One's Turn.");

    }

    //p2 turn
    private static void playerTwo() {
        System.out.println("\nPlayer two, it is your turn.");

        if (Service.getP1Location().equals(Service.getCurrentGuess())) {
            System.out.println("HIT!");
            //mark a hit for the stats
            Service.setP2ShotsHit();

            Service.setGameStatus(false);
            new GameOver("Player Two Wins!").setVisible(true);
        } else {
            System.out.println("You missed!");
            Service.setP2ShotsMiss();
        }
        System.out.println("End of Player Two's Turn.");

    }


    private static void playerComputer() {
        System.out.println("The computer is guessing your location...");

        computerGuess();

        System.out.println("End of Computer's Turn.");
    }

    public static void Turns(boolean player1) {
        //if it is player one's turn
        if (player1) {
            //calculate outcome of turn
            playerOne();

            //advance to p2 turn
            if(Service.isGameStatus()) {
                if (Service.isMultiplayer()) {
                    //give p2 a turn
                    new MainGame(false).setVisible(true);
                } else {
                    //run the computer's turn
                    playerComputer();
                    if(Service.isGameStatus()) {
                        new MainGame(true).setVisible(true);
                    }
                }
            }
        } else {
            //calculate outcome of turn
            playerTwo();
            //advance to p1 turn
            if(Service.isGameStatus()) {
                new MainGame(true).setVisible(true);
            }
        }


    }

}