package game;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.actors.*;
import edu.monash.fit2099.engine.positions.*;
/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 *
 */
public class LoneWolf extends Enemy {

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
    }

    /**
     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            // loops through the size of weapon inventory to attack enemy with weapon
            for(int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
                // if player has an Uchigatana, allow UnsheatheAction
                if (otherActor.getWeaponInventory().get(i) instanceof Uchigatana) {
                    // if (otherActor.getWeaponInventory().contains(new Uchigatana()))
                    actions.add(new UnsheatheAction(this, direction, new Uchigatana()));
                }

                // if player has GreatKnife, allow Quickstep
                // do AttackAction and then QuickstepAction? this would mean Quickstep is just responsible for moving
                // cant do this, should be one action
                //if (otherActor.getWeaponInventory().contains(new GreatKnife())) {
                    // actions.add(new QuickstepAction()
                //}
            }
            // HINT 1: The AttackAction above allows you to attack the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
        }
        return actions;
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}