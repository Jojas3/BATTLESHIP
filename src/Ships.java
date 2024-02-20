//temp import
import java.util.*;
//this class deals with ship placement at beginning of round
public class Ships {

    Service obj = new Service();
    private Ships(int length, int x1, int y1, int x2, int y2, boolean hit) {
        this.obj.setLength(length);
        this.obj.setX1(x1);
        this.obj.setY1(y1);
        this.obj.setX2(x2);
        this.obj.setY2(y2);
        this.obj.setHit(this.obj.isHit());
    }

    private static void setPlayer1Ships(){
        System.out.println("Player 1, place your ships.");
        Random rand = new Random();
        Service obj = new Service();
        obj.setX1(rand.nextInt(10));
        obj.setY1(rand.nextInt(10));
        Ships ships1 = new Ships(1, obj.getX1(), obj.getY1(), 0, 0, false);
        System.out.println("Player 1 Ships Placed!");

    }
    private static void setPlayer2Ships(){
        Service obj = new Service();

        if(Service.isMultiplayer()){
            System.out.println("Player 2, place your ships.");
        }else{
            System.out.println("Generating NPC's board...");
            Random rand = new Random();
            obj.setX2(rand.nextInt(10));
            obj.setY2(rand.nextInt(10));
        }
        Ships ships2 = new Ships(1, 0, 0, obj.getX2(), obj.getY2(), false);
        System.out.println("Player 2 Ships Placed!");
    }



    public static void placeShips() {
        setPlayer1Ships();
        setPlayer2Ships();
    }
}