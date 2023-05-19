package game.actors;

import edu.monash.fit2099.engine.displays.Display;
import game.actors.players.Player;

public class PlayerSelectionManager {
    Player player = new Player(0);

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
