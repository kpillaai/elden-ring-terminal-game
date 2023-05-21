package game.actors.players;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * abstract class for combat archetypes that can be selected for the player and also randomized for the ally and invader
 */
public abstract class CombatArchetypes {

    /**
     * getter for the hp of this combat archetype
     * @return int HP value
     */
    public abstract int getHp();

    /**
     * getter for the weapon of this combat archetype
     * @return weapon item
     */
    public abstract WeaponItem getWeapon();
}
