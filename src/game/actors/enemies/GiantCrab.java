package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class GiantCrab extends GiantEnemy {

    public GiantCrab(){
        super("Giant Crab", 'c', 407);
        super.setRuneDropValues(318, 4961);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }

    /**
     * @return
     */
    @Override
    public int getSpawnChance() {
        return 2;
    }
}
