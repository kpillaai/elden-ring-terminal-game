package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AOEAttackActionBehaviour;
import game.behaviours.BasicAttackActionBehaviour;

public class GiantCrayfish extends Enemy {

    public GiantCrayfish(){
        super("Giant Crayfish", 'R', 4803);
        super.setRuneDropValues(318, 4961);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getIntrinsicWeapon()));
        this.behaviours.put(2, new BasicAttackActionBehaviour(this.getIntrinsicWeapon()));
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }
}
