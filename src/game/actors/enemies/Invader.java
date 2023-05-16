package game.actors.enemies;

import game.actors.players.Player;

public class Invader extends Player{

    /**
     * Constructor for Player class. It also adds items to the player inventory that is necessary.
     * It also adds the player to the ResetManager.
     *
     * @param hitPoints The number of hit points (HP) the player has.
     */
    public Invader() {
        super(0);
    }
}
