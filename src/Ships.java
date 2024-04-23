//temp import
import javax.swing.*;
import java.util.*;
//this class deals with ship placement at beginning of round
public class Ships {
    public static void placeShips(JPasswordField p1, JPasswordField p2) throws InputMismatchException{
        //set player 1 ships
        checkCoord(p1.getPassword());
        setCoord(p1.getPassword(), 1);

        //if MP, run the check for p2 coord.
        //if not MP, generate random coords for the NPC
        if(Service.isMultiplayer()) {
            checkCoord(p2.getPassword());
            setCoord(p2.getPassword(), 2);
        }else{
            setComputerShips();
        }
    }

    private static void setComputerShips(){

        System.out.println("Generating NPC ship coordinates...");
        Random rand = new Random();


        //generate random y coord within the yBound
        String y = String.valueOf(Service.getYBound().charAt(rand.nextInt(Service.getYBound().length())));
        //generate random x coord within xBound
        int x = rand.nextInt(Service.getXBound());

        // and upload both x and y to server
        Service.setP2Location(y+x);

        //confirmation
        System.out.println("Computer Ships Placed!");
    }
    public static void setCoord(char[] password, int pNumber) {
        int x = password[1] - '0';
        char y = Character.toLowerCase(password[0]);
        String coord = String.valueOf(y);
        coord+=x;
        if(pNumber==1){
            Service.setP1Location(coord.toLowerCase());

        }else{
            Service.setP2Location(coord.toLowerCase());
        }
    }

    //check if a coordinate entered is valid
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
        if(!(x>=0 & Service.getXBound()-x>=0 & Service.getYBound().indexOf(y)!=(-1))){
            throw new InputMismatchException("Invalid coordinate given by player!");
        }

        System.out.println("Coordinate looks good!");
    }

}