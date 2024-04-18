//temp
import java.util.*;

import static java.lang.System.exit;
public class Turn {
    //get player computer guess and add to list of all computer guesses
    private static String computerGuess(){
        Random rand = new Random();
        Service obj = new Service();
        System.out.println("\nComputer, it is your turn.");

        String guess = "initialize", y="initialize";
        int x=0;

        while (!(obj.getP2Guesses().contains(guess))) {
            //generate random y coord
            y = String.valueOf(obj.getyBound().charAt(rand.nextInt(obj.getyBound().length())));

            //generate random x coord
            x = rand.nextInt(10);

            guess = y+x;

            obj.setP2Guesses(guess);
        }


        System.out.println("The computer guessed: "+guess);
        return guess;
    }

    //get player guess but doesnt add to list of player guesses
    private static String playerGuess(){
        Service obj = new Service();
        Scanner input  = new Scanner(System.in);
        String guess="initialize";
        try {
            System.out.println("Please enter a unique guess for an enemy ship location (ex. B4): ");
            guess = input.nextLine();

        }catch(InputMismatchException e){
            System.out.println("ERROR: You must enter a string.");
        }

        return guess;
    }

    //turn goes until player misses
    private static void playerOne() {
        Service obj = new Service();
        obj.setHit(false);
        System.out.println("\nPlayer one, it is your turn.");
        String guess = "initialize";
        //guess until the player makes a unique guess
        do {
            guess = playerGuess();
            //add guess to list of all guesses
        } while (obj.getP1Guesses().contains(guess));

        //add unique guess to string containing all of their guesses
        obj.setP1Guesses(guess);


        do {
            if (Ships.p2Ships.contains(guess)) {
                System.out.println("HIT!");
                //mark a hit for the stats
                obj.setP1ShotsHit();
                obj.setHit(true);
            } else {
                System.out.println("You missed!");
                obj.setP1ShotsMiss();
                obj.setHit(false);
            }
        } while (obj.isHit() && (obj.getP1ShotsHit() != (Ships.p2Ships.size())));
        if (obj.getP1ShotsHit() == (Ships.p2Ships.size())) {
            Service.setGameStatus(false);
        }

    }

    //turn goes until player misses
    private static void playerTwo(){
        Service obj = new Service();
        obj.setHit(false);
        System.out.println("\nPlayer two, it is your turn.");

        String guess;
        //guess until the player makes a unique guess
        do {
            guess = playerGuess();
            //add guess to list of all guesses
        } while (obj.getP2Guesses().contains(guess));

        //add unique guess to string containing all of their guesses
        obj.setP2Guesses(guess);


        //if enemy ships contain the guess mark as hit and repeat, else miss. if guessed all ships then end program
        do{
            if(Ships.p1Ships.contains(guess)){
                System.out.println("HIT!");
                //mark a hit for the stats
                obj.setP2ShotsHit();
                obj.setHit(true);
                if(!Service.isGameStatus()){
                    System.out.println("\nIT'S A DRAW!");
                }
            }else{
                System.out.println("You missed!");
                obj.setP2ShotsMiss();
                obj.setHit(false);
            }
        }while(obj.isHit()&&(obj.getP2ShotsHit()!=(Ships.p1Ships.size())));
        if(obj.getP2ShotsHit()==(Ships.p1Ships.size())){
            Service.setGameStatus(false);
        }
        System.out.println("End of Player Two's Turn.");

    }
    //turn goes until computer misses
    public static void playerComputer(){
        System.out.println("The computer is guessing your location...");

        computerGuess();


        System.out.println("End of Computer's Turn.");
    }
    public static void Turns() {
        while(Service.isGameStatus()) {
            new MainGame(1).setVisible(true);
            playerOne();
            if (Service.isMultiplayer()) {
                playerTwo();
                new MainGame(2).setVisible(true);
            } else {
                playerComputer();
            }
        }

        //after turns are over, open game over screen.
        new GameOver().setVisible(true);
    }
}