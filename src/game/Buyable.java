package game;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public interface Buyable {
    public int getBuyPrice();
    public WeaponItem returnWeaponItem();
}
