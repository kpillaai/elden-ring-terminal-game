package game.actors.enemies;
import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.actors.*;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.IsAsleepAction;
import game.behaviours.*;
import game.items.Runes;
import game.utils.RandomNumberGenerator;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.utils.Status;
import java.util.HashMap;
import java.util.Map;

/**
 * Enemy abstract class for all Enemies within the game
 * @author Zilei Chen
 * @version 1.0
 */
public abstract class Enemy extends Actor implements Resettable{

    /**
     * List of behaviours an enemy can perform
     */
    public Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Range of values runes can drop for each enemy
     */
    private int[] runeDropValues;


    /**
     * Abstract constructor for Enemy class
     * @param name Name of the enemy
     * @param displayChar The character that represents the enemy
     * @param hitPoints The number of hit points (HP) this enemy has
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(2, new BasicAttackActionBehaviour(this.getIntrinsicWeapon()));
        this.behaviours.put(999, new WanderBehaviour());
        this.addCapability(Status.HOSTILE_TO_PLAYER);

        ResetManager resetManager = ResetManager.getInstance();
        resetManager.registerResettable(this);
    }

    public void spawnRunes(){
        Runes runes = new Runes(true);
        runes.setNumberOfRunes(RandomNumberGenerator.getRandomInt(this.runeDropValues[0], this.runeDropValues[1]));
        this.addItemToInventory(runes);
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
        if (lastAction != null) {
            Action nextAction = lastAction.getNextAction();
            if (nextAction != null) {
                return nextAction;
            }
        }
        if (this.hasCapability(Status.ASLEEP)) {
            return new IsAsleepAction(3);
        }
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
        // Adding wander behaviour as the player approaches near an enemy.
        this.behaviours.put(998, new FollowBehaviour(otherActor));

        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
            // loops through the size of weapon inventory to attack enemy with weapon
            for(int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                actions.add(otherActor.getWeaponInventory().get(i).getSkill(this, direction));
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

    /**
     * Get the minimum and maximum values of runes the enemy can drop when killed by a player.
     * @return the minimum and maximum values of runes the enemy can drop when killed by a player.
     */
    public int[] getRuneDropValues(){
        return this.runeDropValues;
    }

    /**
     * Setter for the range of runes the enemy can drop when killed by a player
     * @param min minimum number of runes
     * @param max maximum number of runes
     */
    public void setRuneDropValues(int min, int max) {
        this.runeDropValues = new int[]{min, max};
    }


    /**
     * Reset the enemy by removing it from the map
     * @param gameMap The map the enemy is on
     */
    @Override
    public void reset(GameMap gameMap) {
        gameMap.removeActor(this);
    }
}
