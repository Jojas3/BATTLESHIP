//temp until project done and I know what needs to be imported
import java.util.*;
public class Battleship {

    public static void main(String[] args) {
    /* i want to have a start button preceded a splash screen
        that includes the game logo/a logo i create */

        System.out.println("WELCOME TO BATTLESHIP!!!");
        //will do later... for now the println will do

        //After pressing start:
        // generate the gameboard
        Board.generateBoard();

        // take user into the "placing ships" phase of the game
        Ships.placeShips();

        //player 1 will guess first, then player two, loop until game over
        Service.gameLoop();


    }

}
