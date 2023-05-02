package game.actors.players;

import game.weapons.Club;

/**
 * Wretch class is custom combat Archetype available for the player to choose. It inherits from Player class.
 */
public class Wretch extends Player {

    /**
     * Constructor for Wretch class, it spawns with an Club weapon.
     */
    public Wretch() {
        super(414);
        this.addWeaponToInventory(new Club());
    }
}
