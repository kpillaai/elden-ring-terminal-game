package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * GiantCrab is a concrete class inheriting from GiantEnemy
 * @author Zilei Chen
 * @version 1.0
 */
public class GiantCrab extends GiantEnemy {

    /**
     * Constructor for GiantCrab
     */
    public GiantCrab(){
        super("Giant Crab", 'c', 407);
        super.setRuneDropValues(318, 4961);
        super.spawnRunes();
    }

    /**
     * This is the default weapon for a Giant Crab
     * @return An IntrinsicWeapon object for Giant Crab
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    /**
     * Getter for the spawn chance of Giant Crab out of 100
     * @return the spawn chance of Giant Crab out of 100
     */
    @Override
    public int getSpawnChance() {
        return 2;
    }
}
