package game.actors.players;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.AstrologerStaff;

/**
 * Bandit class is custom combat Archetype available for the player to choose. It inherits from Player class.
 * @author Jason Skurr
 * @version 1.0
 */
public class Astrologer extends CombatArchetypes {

    /**
     * Constructor for Bandit class, it spawns with a Great Knife weapon.
     */
    public Astrologer() {
    }

    /**
     * @return
     */
    @Override
    public int getHp() {
        return 396;
    }

    /**
     * @return
     */
    @Override
    public WeaponItem getWeapon() {
        return new AstrologerStaff();
    }


}
