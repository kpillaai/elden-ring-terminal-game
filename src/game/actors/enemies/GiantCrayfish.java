package game.actors.enemies;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class GiantCrayfish extends GiantEnemy {

    public GiantCrayfish(){
        super("Giant Crayfish", 'R', 4803);
        super.setRuneDropValues(500, 2374);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }

    /**
     * @return
     */
    @Override
    public int getSpawnChance() {
        return 1;
    }
}
