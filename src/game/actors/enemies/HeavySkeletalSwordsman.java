package game.actors.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AOEAttackActionBehaviour;
import game.utils.Spawnable;
import game.weapons.Grossmesser;

/**
 * HeavySkeletalSwordsman is a concrete class inheriting from Skeleton
 * @author Zilei Chen
 * @version 1.0
 */
public class HeavySkeletalSwordsman extends Skeleton implements Spawnable {

    /**
     * Abstract constructor for HeavySkeletalSwordsman class
     */
    public HeavySkeletalSwordsman(){
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.isPileOfBones = false;
        this.addWeaponToInventory(new Grossmesser());
        super.setRuneDropValues(35, 892);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getWeaponInventory().get(0)));
        super.spawnRunes();
    }

    /**
     * This is the default weapon for a HeavySkeletalSwordsman
     * @return An IntrinsicWeapon object for HeavySkeletalSwordsman
     */
    @Override // not sure if a skeleton has an intrinsic weapon or what its meant to be
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "hits", 95);
    }

    /**
     * Getter for the spawn chance of HeavySkeletalSwordsman out of 100
     * @return the spawn chance of HeavySkeletalSwordsman out of 100
     */
    public int getSpawnChance() {
        return 27;
    }
}
