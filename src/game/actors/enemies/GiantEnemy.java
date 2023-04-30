package game.actors.enemies;

import game.behaviours.AOEAttackActionBehaviour;

public abstract class GiantEnemy extends Enemy{
    /**
     * Abstract constructor for Enemy class
     *
     * @param name        Name of the enemy
     * @param displayChar The character that represents the enemy
     * @param hitPoints   The number of hit points (HP) this enemy has
     */
    public GiantEnemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getIntrinsicWeapon()));
    }

    /**
     * @return
     */
    @Override
    public abstract int getSpawnChance();
}
