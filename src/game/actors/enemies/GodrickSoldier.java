package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.Status;
import game.utils.Spawnable;

/**
 *
 * @author Jason Skurr
 *
 */
public class GodrickSoldier extends Enemy implements Spawnable{

    /**
     * Constructor for GodrickSoldier class
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        super.setRuneDropValues(38, 70);
        super.spawnRunes();
        this.addCapability(Status.STORMVEIL_FRIENDLY);

    }

    /**
     * This is the default weapon for a Godrick Soldier
     * @return An IntrinsicWeapon object for a Godrick Soldier
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(150, "attacks", 75);
    }

    /**
     * Getter for the spawn chance of a Godrick Soldier out of 100
     * @return the spawn chance of a Godrick Soldier out of 100
     */
    public int getSpawnChance() {
        return 45;
    }
}