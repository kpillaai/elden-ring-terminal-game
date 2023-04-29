package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.BasicAttackActionBehaviour;

/**
 * BEHOLD, DOG!
 *
 * Created by: Zilei Chen
 * @author Adrian Kristanto
 * Modified by: Jason Skurr
 *
 */
public class GiantDog extends Enemy {

    public GiantDog() {
        super("Giant Dog", 'G', 693);
        super.setRuneDropValues(55, 1470);
        this.behaviours.put(1, new BasicAttackActionBehaviour(getIntrinsicWeapon()));
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "slams", 90);
    }
}