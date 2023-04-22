package game;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 *
 */
public class LoneWolf extends Enemy{

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        super.setRuneDropValues(55, 1470);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}