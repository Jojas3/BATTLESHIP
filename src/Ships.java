//temp import
import java.util.*;
//this class deals with ship placement at beginning of round
public class Ships {

    //Service obj = new Service();

    /*ignore
    example: Ships ships1 = new Ships(1, obj.getX1(), obj.getY1(), 0, 0, false);
    private Ships(int length, int x1, int y1, int x2, int y2, boolean hit) {
        this.obj.setLength(length);
        this.obj.setX1(x1);
        this.obj.setY1(y1);
        this.obj.setX2(x2);
        this.obj.setY2(y2);
        this.obj.setHit(this.obj.isHit());
    }*/

    private static void setPlayer1Ships(){
        ArrayList<String> p1Ships = new ArrayList<String>();
        Service obj = new Service();
        System.out.println("Player 1, place your ships.");
        Scanner input = new Scanner(System.in);


        obj.setX1(Service.setX());

        obj.setY1(Service.setY());

        p1Ships.add(obj.getY1()+obj.getX1());
        System.out.println("Player 1 Ships Placed!");

    }
    private static void setPlayer2Ships(){
        ArrayList<String> p2Ships = new ArrayList<String>();
        Service obj = new Service();

        if(Service.isMultiplayer()) {
            System.out.println("Player 2, place your ships.");

            obj.setX2(Service.setX());

            obj.setY2(Service.setY());

            p2Ships.add(obj.getY2()+obj.getX2());

        }else{
            System.out.println("Generating NPC's board...");
            Random rand = new Random();


            //generate random y coord
            String y = String.valueOf(obj.getyBound().charAt(rand.nextInt(obj.getyBound().length())));

            //generate random x coord and upload both x and y to server
            obj.setX2(rand.nextInt(10));
            obj.setY2(y);

            p2Ships.add(obj.getY2()+obj.getX2());
        }


        System.out.println("Player 2 Ships Placed!");
    }



    public static void placeShips() {
        Service.setMultiplayer();
        setPlayer1Ships();
        setPlayer2Ships();
    }
}