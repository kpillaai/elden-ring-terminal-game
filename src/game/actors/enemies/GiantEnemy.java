package game.actors.enemies;

import game.behaviours.AOEAttackActionBehaviour;
import game.utils.Resettable;

/**
 * GiantEnemy is a concrete class inheriting from Enemy
 * @author Zilei Chen
 * @version 1.0
 */
public abstract class GiantEnemy extends Enemy implements Resettable {
    /**
     * Abstract constructor for GiantEnemy class
     * @param name        Name of the GiantEnemy
     * @param displayChar The character that represents the enemy
     * @param hitPoints   The number of hit points (HP) this enemy has
     */
    public GiantEnemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getIntrinsicWeapon()));
    }
}
