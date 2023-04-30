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

    public GiantDog() {
        super("Giant Dog", 'G', 693);
        super.setRuneDropValues(313, 1808);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "slams", 90);
    }

    /**
     * @return
     */
    @Override
    public int getSpawnChance() {
        return 4;
    }
}