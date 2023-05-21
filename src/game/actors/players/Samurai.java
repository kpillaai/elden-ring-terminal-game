package game.actors.players;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Uchigatana;

/**
 * Samurai class is custom combat Archetype available for the player to choose. It inherits from Player class.
 * @author Zilei Chen
 * @version 1.0
 */
public class Samurai extends CombatArchetypes {

    /**
     * getter for the hp of this combat archetype
     *
     * @return int HP value
     */
    @Override
    public int getHp() {
        return 455;
    }

    /**
     * getter for the weapon of this combat archetype
     *
     * @return weapon item
     */
    @Override
    public WeaponItem getWeapon() {
        return new Uchigatana();
    }
}
