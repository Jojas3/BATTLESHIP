//temp import
import java.util.*;
//this class deals with ship placement at beginning of round
public class Ships {
    private static void setComputerShips(){

        Service obj = new Service();

        System.out.println("Generating NPC ship coordinates...");
        Random rand = new Random();


        //generate random y coord within the yBound
        String y = String.valueOf(obj.getyBound().charAt(rand.nextInt(obj.getyBound().length())));
        //generate random x coord within xBound
        int x = rand.nextInt(obj.getxBound());

        // and upload both x and y to server
        obj.setP2Location(y+x);

        //confirmation
        System.out.println("Computer Ships Placed!");
    }
    public static void setCoord(String password, int pNumber) {
        Service obj = new Service();
        if(pNumber==1){
            obj.setP1Location(password.toLowerCase());
        }else{
            obj.setP2Location(password);
        }
    }
    public static void placeShips() {
        setComputerShips();
    }

}