package game.actors.players;

import game.weapons.AstrologerStaff;

/**
 * Bandit class is custom combat Archetype available for the player to choose. It inherits from Player class.
 * @author Jason Skurr
 * @version 1.0
 */
public class Astrologer extends Player {

    /**
     * Constructor for Bandit class, it spawns with a Great Knife weapon.
     */
    public Astrologer() {
        super(396);
        this.addWeaponToInventory(new AstrologerStaff());
    }
}
