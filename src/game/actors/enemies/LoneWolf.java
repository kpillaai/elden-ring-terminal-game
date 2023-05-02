package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.BasicAttackActionBehaviour;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 *
 */
public class LoneWolf extends Enemy {

    /**
     * Constructor for LoneWolf class
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        super.setRuneDropValues(55, 1470);
        super.spawnRunes();
    }

    /**
     * This is the default weapon for a LoneWolf
     * @return An IntrinsicWeapon object for LoneWolf
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    /**
     * Getter for the spawn chance of LoneWolf out of 100
     * @return the spawn chance of LoneWolf out of 100
     */
    @Override
    public int getSpawnChance() {
        return 33;
    }
}