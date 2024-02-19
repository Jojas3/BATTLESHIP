//temp import
import java.util.*;

public class Ships extends Service {


    //ship coordinate variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean hit;
    private int length;
    //will have length of all ships
    private int length(){
        return length;
    }


    public Ships(int length, int x1, int y1, int x2, int y2, boolean hit) {
        this.length = length;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.hit = isHit();
    }
    Ships ship1 = new Ships(length, x1, y1,0, 0, isHit());
    Ships ship2 = new Ships(length, 0, 0, x2, y2, isHit());

    //method that handles placing ships at the beginning of the round
    public static void placeShips() {
        System.out.println("Place your ships!");
        Scanner input = new Scanner(System.in);

        //example of try catch loop, just for funsies
        try {
            //get user input for coordinates. Maybe later can update so they click or drag to place
            System.out.println("Enter ship x coordinate: ");
            int x = input.nextInt();
            System.out.println("Enter ship y coordinate: ");
            int y = input.nextInt();
        }catch (InputMismatchException e) {
            //makes sure the user enters an integer
            System.out.println("ERROR: You need to enter an integer.");
            input.next();
            //start over
            placeShips();
        }
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}

