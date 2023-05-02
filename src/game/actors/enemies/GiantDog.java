package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * BEHOLD, DOG!
 *
 * Created by: Zilei Chen
 * @author Adrian Kristanto
 * Modified by: Jason Skurr
 *
 */
public class GiantDog extends GiantEnemy {

    /**
     * Constructor for GiantDog
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        super.setRuneDropValues(313, 1808);
    }

    /**
     * This is the default weapon for a GiantDog
     * @return An IntrinsicWeapon object for GiantDog
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "slams", 90);
    }

    /**
     * Getter for the spawn chance of GiantDog out of 100
     * @return the spawn chance of GiantDog out of 100
     */
    @Override
    public int getSpawnChance() {
        return 4;
    }
}