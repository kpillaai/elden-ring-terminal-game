package game.utils;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.players.Player;

public class PlayerSelectionManager {
    /**
     * creating a new player before setting its HP and weapon
     */
    Player player = new Player(0);

    /**
     * Displays a menu for the user to choose the combat archetype
     * @return a player with the correct HP and weapon of the selected class
     */
    public Player selectCombatArchetype() {
        Display display = new Display();

        display.println("Select your class");
        display.println("1) Samurai");
        display.println("2) Bandit");
        display.println("3) Wretch");
        display.println("4) Astrologer");
        char input = display.readChar();

        player.setCombatArchetype(input - '0' - 1);

        return player;
    }
}
