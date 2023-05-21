package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.ArrayList;

/**
 * The BasicAttackActionBehaviour class that inherits AttackAction and implements Behaviour. This allows Enemies to be
 * able to use their basic attack.
 * @author Zilei Chen
 * @version 1.0
 */
public class BasicAttackActionBehaviour extends AttackAction implements Behaviour {

    /**
     * Constructor for BasicAttackActionBehaviour. Only the weapon is needed for this as it differs per actor.
     * @param weapon The weapon used to perform a basic attack
     */
    public BasicAttackActionBehaviour(Weapon weapon) {
        super(null, null, weapon);
    }

    /**
     * This will check the actor's surroundings within 1 unit radius. If there is an actor there, add a new AttackAction.
     * Then it will choose a random target to attack.
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return The result of the attack in String.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location actor_location = map.locationOf(actor);
        int xMax = map.getXRange().max();
        int yMax = map.getYRange().max();
        ArrayList<AttackAction> attackList = new ArrayList<AttackAction>();
        for (int i = 0; i < actor_location.getExits().size(); i++) {
            if (!(actor_location.getExits().get(i).getDestination().x() == 0 && actor_location.getExits().get(i).getDestination().y() == 0)) {
                if ((actor_location.getExits().get(i).getDestination().x() > 0) && (actor_location.getExits().get(i).getDestination().x() < xMax) && (actor_location.getExits().get(i).getDestination().y() > 0) && (actor_location.getExits().get(i).getDestination().y() < yMax)) {
                    if (map.at(actor_location.getExits().get(i).getDestination().x(), actor_location.getExits().get(i).getDestination().y()).containsAnActor()) {
                        Actor target = map.at(actor_location.getExits().get(i).getDestination().x(), actor_location.getExits().get(i).getDestination().y()).getActor();
                        if(!target.hasCapability(Status.PEACEFUL)) {
                            if (!target.hasCapability(Status.RABIDDOG) && actor.hasCapability(Status.RABIDDOG)) {
                                attackList.add(new AttackAction(target, actor_location.getExits().get(i).getName(), this.weapon));
                            }
                            if (!target.hasCapability(Status.SKELETON) && actor.hasCapability(Status.SKELETON)) {
                                attackList.add(new AttackAction(target, actor_location.getExits().get(i).getName(), this.weapon));
                            }
                            if (!target.hasCapability(Status.AQUATIC) && actor.hasCapability(Status.AQUATIC)) {
                                attackList.add(new AttackAction(target, actor_location.getExits().get(i).getName(), this.weapon));
                            }
                            if (!target.hasCapability(Status.STORMVEIL_FRIENDLY) && actor.hasCapability(Status.STORMVEIL_FRIENDLY)) {
                                attackList.add(new AttackAction(target, actor_location.getExits().get(i).getName(), this.weapon));
                            }
                            if (!target.hasCapability(Status.ENEMY_NPC) && actor.hasCapability(Status.ENEMY_NPC)) {
                                attackList.add(new AttackAction(target, actor_location.getExits().get(i).getName(), this.weapon));
                            }
                            if (!target.hasCapability(Status.HOSTILE_TO_ENEMY) && actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                                attackList.add(new AttackAction(target, actor_location.getExits().get(i).getName(), this.weapon));
                            }
                        }
                    }
                }
            }
        }
        RandomNumberGenerator rng = new RandomNumberGenerator();
        if(attackList.isEmpty()){
            return null;
        }
        int index = rng.getRandomInt(0, attackList.size()-1);
        return attackList.get(index).execute(actor, map);
    }

    /**
     * A factory for creating actions. Chaining these together can result in an actor performing more complex tasks.
     * <p>
     * A Behaviour represents a kind of objective that an Actor can have.  For example
     * it might want to seek out a particular kind of object, or follow another Actor,
     * or run away and hide.  Each implementation of Behaviour returns an Action that the
     * Actor could take to achieve its objective, or null if no useful options are available.
     * method that determines which Behaviour to perform.  This allows the Behaviour's logic
     * to be reused in other Actors via delegation instead of inheritance.
     * <p>
     * An Actor's {@code playTurn()} method can use Behaviours to help decide which Action to
     * perform next.  It can also simply create Actions itself, and for simpler Actors this is
     * likely to be sufficient.  However, using Behaviours allows
     * us to modularize the code that decides what to do, and that means that it can be
     * reused if (e.g.) more than one kind of Actor needs to be able to seek, follow, or hide.
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an Action that actor can perform, or null if actor can't do this.
     * @author Riordan D. Alfredo
     */


    /**
     * This method will return the action to be executed when performing a BasicAttackAction. It will check if the
     * surroundings of the actors has targets to hit.
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return The action to be executed by the Actor.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location actor_location = map.locationOf(actor);
        int xMax = map.getXRange().max();
        int yMax = map.getYRange().max();
        for (int i = 0; i < actor_location.getExits().size(); i++) {
            if (!(actor_location.getExits().get(i).getDestination().x() == 0 && actor_location.getExits().get(i).getDestination().y() == 0)) {
                if ((actor_location.getExits().get(i).getDestination().x() > 0) && (actor_location.getExits().get(i).getDestination().x() < xMax) && (actor_location.getExits().get(i).getDestination().y() > 0) && (actor_location.getExits().get(i).getDestination().y() < yMax)) {
                    if (map.at(actor_location.getExits().get(i).getDestination().x(), actor_location.getExits().get(i).getDestination().y()).containsAnActor()) {
                        Actor target = map.at(actor_location.getExits().get(i).getDestination().x(), actor_location.getExits().get(i).getDestination().y()).getActor();
                        if(!target.hasCapability(Status.RABIDDOG) && actor.hasCapability(Status.RABIDDOG)){
                            return this;
                        }
                        if(!target.hasCapability(Status.SKELETON) && actor.hasCapability(Status.SKELETON)){
                            return this;
                        }
                        if(!target.hasCapability(Status.AQUATIC) && actor.hasCapability(Status.AQUATIC)){
                            return this;
                        }
                        if(!target.hasCapability(Status.STORMVEIL_FRIENDLY) && actor.hasCapability(Status.STORMVEIL_FRIENDLY)){
                            return this;
                        }
                        if(!target.hasCapability(Status.ENEMY_NPC) && actor.hasCapability(Status.ENEMY_NPC)){
                            return this;
                        }
                        if(!target.hasCapability(Status.HOSTILE_TO_ENEMY) && actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                            return this;
                        }
                    }
                }
            }
        }
        return null;
    }
}
