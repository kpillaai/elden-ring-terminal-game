package game;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class GiantCrab extends Enemy{

    public GiantCrab(){
        super("Giant Crab", 'c', 407);

    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
