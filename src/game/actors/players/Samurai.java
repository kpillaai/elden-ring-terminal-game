package game.actors.players;

import game.actors.players.Player;
import game.weapons.Uchigatana;

public class Samurai extends Player {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Samurai() {
        super(455);
        this.addWeaponToInventory(new Uchigatana());
    }


}
