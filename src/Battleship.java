import java.io.IOException;

/**
 * @author Jacob Dzikowski
 * <p></p>
 * A guessing game for 1-2 players.
 * The size of the board can be updated by changing the final y bound in Service.java
 * <p></p>
 * For the purposes of this project, 'Y' is the letter in a coordinate and 'X' is the number.
 */
public class Battleship {

    public static void main(String[] args) {
        //TODO: Ensure you run the accompanying Server file as well.
        //start gui
        System.out.println("\nWELCOME TO BATTLESHIP!!!\n");
        StartScreen StartScreen = new StartScreen();
        StartScreen.setVisible(true);

    }

}
