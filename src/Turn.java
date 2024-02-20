//temp
import java.util.*;

public class Turn {
    private static void playerOne(){
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter your guess (ex. B4): ");

        System.out.println("End of Player One's Turn.");
    }

    private static void playerTwo(){
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter your guess (ex. B4): ");


        System.out.println("End of Player Two's Turn.");

    }
    public static void playerComputer(){
        System.out.println("End of Computer's Turn.");
    }

    public static void Turns() {
        playerOne();
        if(Service.isMultiplayer()){
            playerTwo();
        }else{
            playerComputer();
        }
    }
}