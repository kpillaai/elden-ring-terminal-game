package game.actors.players;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Club;

/**
 * Wretch class is custom combat Archetype available for the player to choose. It inherits from Player class.
 * @author Zilei Chen
 * @version 1.0
 */
public class Wretch extends CombatArchetypes {

    /**
     * @return
     */
    @Override
    public int getHp() {
        return 414;
    }

    /**
     * @return
     */
    @Override
    public WeaponItem getWeapon() {
        return new Club();
    }
}
