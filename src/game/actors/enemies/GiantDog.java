package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.Spawnable;

/**
 * BEHOLD, DOG!
 *
 * Created by: Zilei Chen
 * @author Adrian Kristanto
 * Modified by: Jason Skurr
 *
 */
public class GiantDog extends GiantEnemy implements Spawnable{

    /**
     * Constructor for GiantDog
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        super.setRuneDropValues(313, 1808);
        super.spawnRunes();
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
    public int getSpawnChance() {
        return 4;
    }
}