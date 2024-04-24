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
        Service.setMultiplayer(true);
        System.out.println(Service.isMultiplayer());
        System.out.println("\nWELCOME TO BATTLESHIP!!!\n");
        StartScreen StartScreen = new StartScreen();
        StartScreen.setVisible(true);

    }

}
