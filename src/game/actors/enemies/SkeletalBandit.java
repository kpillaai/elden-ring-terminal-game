package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AOEAttackActionBehaviour;
import game.utils.Spawnable;
import game.weapons.Scimitar;

/**
 * SkeletalBandit is a concrete class inheriting from Skeleton abstract class
 * @author Zilei Chen
 * @version 1.0
 */
public class SkeletalBandit extends Skeleton implements Spawnable {

    /**
     * Abstract constructor for SkeletalBandit class
     */
    public SkeletalBandit(){
        super("Skeletal Bandit", 'b', 184);
        this.isPileOfBones = false;
        this.addWeaponToInventory(new Scimitar());
        super.setRuneDropValues(35, 892);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getWeaponInventory().get(0)));
        super.spawnRunes();
    }

    /**
     * This is the default weapon for a SkeletalBandit
     * @return An IntrinsicWeapon object for SkeletalBandit
     */
    @Override // not sure if a skeleton has an intrinsic weapon or what its meant to be
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "hits", 95);
    }

    /**
     * Getter for the spawn chance of SkeletalBandit out of 100
     * @return the spawn chance of SkeletalBandit out of 100
     */
    public int getSpawnChance() {
        return 27;
    }
}
