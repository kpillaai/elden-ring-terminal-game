package game.actors.players;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.AstrologerStaff;

/**
 * Astrologer class is custom combat Archetype available for the player to choose
 * @author Jason Skurr
 * @version 1.0
 */
public class Astrologer extends CombatArchetypes {

    /**
     * Constructor for Astrologer class, it spawns with an Astrologer Staff weapon.
     */
    public Astrologer() {
    }

    /**
     * getter for the hp
     * @return hp of this astrologer
     */
    @Override
    public int getHp() {
        return 396;
    }

    /**
     * getter for the weapon item
     * @return weapon item of this astrologer
     */
    @Override
    public WeaponItem getWeapon() {
        return new AstrologerStaff();
    }


}
