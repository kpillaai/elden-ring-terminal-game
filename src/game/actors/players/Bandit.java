package game.actors.players;

import game.weapons.GreatKnife;

public class Bandit extends Player {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Bandit() {
        super(414);
        this.addWeaponToInventory(new GreatKnife());
    }
}
