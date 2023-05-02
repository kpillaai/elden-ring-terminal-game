package game.actors.players;

import game.weapons.GreatKnife;

/**
 * Bandit class is custom combat Archetype available for the player to choose. It inherits from Player class.
 */
public class Bandit extends Player {

    /**
     * Constructor for Bandit class, it spawns with a Great Knife weapon.
     */
    public Bandit() {
        super(414);
        this.addWeaponToInventory(new GreatKnife());
    }
}
