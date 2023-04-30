package game.actors.enemies;
import edu.monash.fit2099.engine.actions.*;
import edu.monash.fit2099.engine.actors.*;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.QuickstepAction;
import game.actions.UnsheatheAction;
import game.behaviours.AOEAttackActionBehaviour;
import game.behaviours.BasicAttackActionBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.utils.Status;
import game.weapons.GreatKnife;
import game.weapons.Grossmesser;
import game.weapons.Scimitar;
import game.weapons.Uchigatana;

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

        ResetManager resetManager = ResetManager.getInstance();
        resetManager.registerResettable(this);
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
            // loops through the size of weapon inventory to attack enemy with weapon
            for(int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
                // if player has an Uchigatana, allow UnsheatheAction
                if (otherActor.getWeaponInventory().get(i) instanceof Uchigatana) {
                    actions.add(new UnsheatheAction(this, direction, new Uchigatana()));
                }
                if (otherActor.getWeaponInventory().get(i) instanceof GreatKnife) {
                    actions.add(new QuickstepAction(this, direction, new GreatKnife()));
                }
                if (otherActor.getWeaponInventory().get(i) instanceof Grossmesser) {
                    actions.add(new AOEAttackActionBehaviour(otherActor.getWeaponInventory().get(i)));
                }
                if (otherActor.getWeaponInventory().get(i) instanceof Scimitar) {
                    actions.add(new AOEAttackActionBehaviour(otherActor.getWeaponInventory().get(i)));
                }
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
     *
     */
    public int[] getRuneDropValues(){
        return this.runeDropValues;
    }

    public void setRuneDropValues(int min, int max) {
        this.runeDropValues = new int[]{min, max};
    }

    public abstract int getSpawnChance();

    @Override
    public void reset(GameMap gameMap) {
        gameMap.removeActor(this);
    }
}
