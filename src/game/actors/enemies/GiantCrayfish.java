package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * GiantCrayfish is a concrete class inheriting from GiantEnemy
 * @author Zilei Chen
 * @version 1.0
 */
public class GiantCrayfish extends GiantEnemy {

    /**
     * Constructor for GiantCrayfish
     */
    public GiantCrayfish(){
        super("Giant Crayfish", 'R', 4803);
        super.setRuneDropValues(500, 2374);
    }

    /**
     * This is the default weapon for a GiantCrayfish
     * @return An IntrinsicWeapon object for GiantCrayfish
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }

    /**
     * Getter for the spawn chance of GiantCrayfish out of 100
     * @return the spawn chance of GiantCrayfish out of 100
     */
    @Override
    public int getSpawnChance() {
        return 1;
    }
}
