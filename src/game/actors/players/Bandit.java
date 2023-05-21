package game.actors.players;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.GreatKnife;

/**
 * Bandit class is custom combat Archetype available for the player to choose. It inherits from Player class.
 * @author Zilei Chen
 * @version 1.0
 */
public class Bandit extends CombatArchetypes {

    /**
     * getter for the hp of this combat archetype
     *
     * @return int HP value
     */
    @Override
    public int getHp() {
        return 414;
    }

    /**
     * getter for the weapon of this combat archetype
     *
     * @return weapon item
     */
    @Override
    public WeaponItem getWeapon() {
        return new GreatKnife();
    }
}
