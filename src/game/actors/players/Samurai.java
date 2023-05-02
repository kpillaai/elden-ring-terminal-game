package game.actors.players;

import game.weapons.Uchigatana;

/**
 * Samurai class is custom combat Archetype available for the player to choose. It inherits from Player class.
 */
public class Samurai extends Player {

    /**
     * Constructor for Samurai class, it spawns with an Uchigatana weapon.
     */
    public Samurai() {
        super(455);
        this.addWeaponToInventory(new Uchigatana());
    }


}
