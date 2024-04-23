//temp import
import java.util.*;
//this class deals with ship placement at beginning of round
public class Ships {
    private static void setComputerShips(){

        System.out.println("Generating NPC ship coordinates...");
        Random rand = new Random();


        //generate random y coord within the yBound
        String y = String.valueOf(Service.getyBound().charAt(rand.nextInt(Service.getyBound().length())));
        //generate random x coord within xBound
        int x = rand.nextInt(Service.getxBound());

        // and upload both x and y to server
        Service.setP2Location(y+x);

        //confirmation
        System.out.println("Computer Ships Placed!"+Service.getP2Location());
    }
    public static void setCoord(char[] password, int pNumber) {
        int x = password[1] - '0';
        char y = Character.toLowerCase(password[0]);
        String coord = String.valueOf(y);
        coord+=x;
        System.out.println(coord);
        if(pNumber==1){
            Service.setP1Location(coord.toLowerCase());

        }else{
            Service.setP2Location(coord.toLowerCase());
        }
    }
    public static void placeShips() {
        setComputerShips();
    }

}