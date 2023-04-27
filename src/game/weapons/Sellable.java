package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public interface Sellable {
    public int getSellPrice();
    public WeaponItem returnWeaponItem();
}
