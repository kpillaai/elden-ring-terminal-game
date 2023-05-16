package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.players.*;
import game.behaviours.BasicAttackActionBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Ally extends Actor {
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

    public void applyRandomClass(){
        ArrayList<Player> classes = new ArrayList<Player>();
        classes.add(new Astrologer());
        classes.add(new Bandit());
        classes.add(new Samurai());
        classes.add(new Wretch());
        int random = RandomNumberGenerator.getRandomInt(3);
        this.addWeaponToInventory(classes.get(random).getWeaponInventory().get(0));
        this.resetMaxHp(classes.get(random).getHp());
    }

}
