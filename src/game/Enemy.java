package game;
import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.actors.*;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import java.util.HashMap;
import java.util.Map;

/**
 * Enemy abstract class for all Enemies within the game
 * @author Zilei Chen
 * @version 1.0
 */
public abstract class Enemy extends Actor{

    /**
     * List of behaviours an enemy can perform
     */
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Abstract constructor for Enemy class
     * @param name Name of the enemy
     * @param displayChar The character that represents the enemy
     * @param hitPoints The number of hit points (HP) this enemy has
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Enemy
     * @param lastAction The Action this Enemy took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Enemy
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The Enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return The list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            // HINT 1: The AttackAction above allows you to attak the enemy with your intrinsic weapon.
            // HINT 1: How would you attack the enemy with a weapon?
            // Since otherActor may have weapons, this is stored inside an ArrayList attribute weaponInventory
            // By looping through each item in weaponInventory, we add an action for each weapon
            for(int i = 0; i < otherActor.getWeaponInventory().size(); i++){
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
            }
        }
        return actions;
    }

    /**
     * This is the default 'weapon' for an Enemy
     * @return An IntrinsicWeapon object for this specific enemy
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(0, "attacks", 100);
    }
}
