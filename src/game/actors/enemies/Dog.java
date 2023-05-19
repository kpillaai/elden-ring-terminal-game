package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.Status;
import game.utils.Spawnable;


/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Jason Skurr
 * Modified by: Jason Skurr
 *
 */
public class Dog extends Enemy implements Spawnable{

    /**
     * Constructor for Dog class
     */
    public Dog() {
        super("Dog", 'a', 104);
        super.setRuneDropValues(52, 1390);
        super.spawnRunes();
        this.addCapability(Status.STORMVEIL_FRIENDLY);
    }

    /**
     * This is the default weapon for a Dog
     * @return An IntrinsicWeapon object for Dog
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }

    /**
     * Getter for the spawn chance of a Dog out of 100
     * @return the spawn chance of a Dog out of 100
     */
    public int getSpawnChance() {
        return 37;
    }
}