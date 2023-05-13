package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.utils.Status;

/**
 *
 * Created by:
 * @author Jason Skurr
 * Modified by: Jason Skurr
 *
 */
public class GodrickSoldier extends Enemy {

    /**
     * Constructor for GodrickSoldier class
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        super.setRuneDropValues(38, 70);
        super.spawnRunes();
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
    @Override
    public int getSpawnChance() {
        return 45;
    }
}