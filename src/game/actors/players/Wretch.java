package game.actors.players;

import game.actors.players.Player;
import game.weapons.Club;

public class Wretch extends Player {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Wretch() {
        super(414);
        this.addWeaponToInventory(new Club());
    }
}
