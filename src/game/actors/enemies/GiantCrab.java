package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AOEAttackActionBehaviour;
import game.behaviours.BasicAttackActionBehaviour;

public class GiantCrab extends Enemy {

    public GiantCrab(){
        super("Giant Crab", 'c', 407);
        super.setRuneDropValues(318, 4961);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getIntrinsicWeapon()));
        this.behaviours.put(2, new BasicAttackActionBehaviour(this.getIntrinsicWeapon()));
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
