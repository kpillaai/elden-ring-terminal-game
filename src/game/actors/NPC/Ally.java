package game.actors.NPC;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actors.players.CombatArchetypes;
import game.actors.players.*;
import game.behaviours.BasicAttackActionBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Ally extends Actor implements NPCCombatArchetype {
    /**
     * List of behaviours an ally can perform
     */
    public Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Ally() {
        super("Ally", 'A', 1);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.applyRandomClass();
        this.behaviours.put(1, new BasicAttackActionBehaviour(this.getWeaponInventory().get(0)));
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
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
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)){
            actions.add(new AttackAction(this, direction));
            // loops through the size of weapon inventory to attack enemy with weapon
            for(int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                actions.add(otherActor.getWeaponInventory().get(i).getSkill(this, direction));
                actions.add(new AttackAction(this, direction, otherActor.getWeaponInventory().get(i)));
            }
        }
        return actions;
    }

    public void applyRandomClass(){
        ArrayList<CombatArchetypes> classes = new ArrayList<CombatArchetypes>();
        classes.add(new Astrologer());
        classes.add(new Bandit());
        classes.add(new Samurai());
        classes.add(new Wretch());
        int random = RandomNumberGenerator.getRandomInt(3);
        this.addWeaponToInventory(classes.get(random).getWeapon());
        this.resetMaxHp(classes.get(random).getHp());
    }

}
