package game;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class GiantCrab extends Enemy{

    public GiantCrab(){
        super("Giant Crab", 'c', 407);
        super.setRuneDropValues(318, 4961);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getIntrinsicWeapon()));
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
