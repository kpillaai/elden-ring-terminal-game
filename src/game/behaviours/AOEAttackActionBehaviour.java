package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.utils.Status;

/**
 * The AOEAttackActionBehaviour inherits AttackAction and implements behaviour. Allowing both the player and the enemy
 * to use attacks that cause aoe effects.
 * @author Zilei Chen
 * @version 1.0
 */
public class AOEAttackActionBehaviour extends AttackAction implements Behaviour {

    /**
     * The constructor for AOEAttackActionBehaviour, only WeaponItem parameter is used since the inherited constructor
     * requires some attributes that are redundant in this class.
     */
    public AOEAttackActionBehaviour(Weapon weapon) {
        super(null, null, weapon);
    }

    /**
     * This method is an AOE attack that attacks within the 8 'block' radius of the user.
     * Overrides the execute method in AttackAction, since this method requires between 0 and 8 separate attacks since
     * this will be an Area of Effect (AOE) attack and there may be more than 1 actor in the radius.
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return The result of the attack.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location currentLocation = map.locationOf(actor);
        int xMax = map.getXRange().max();
        int yMax = map.getYRange().max();

        String executeString = "The " + actor + " " + this.weapon.verb() + " in all directions.";
        for (int i = 0; i < currentLocation.getExits().size(); i++) {
            if ((currentLocation.getExits().get(i).getDestination().x() > 0) && (currentLocation.getExits().get(i).getDestination().x() < xMax) && (currentLocation.getExits().get(i).getDestination().y() > 0) && (currentLocation.getExits().get(i).getDestination().y() < yMax)) {
                if (currentLocation.getExits().get(i).getDestination().x() != 0 || currentLocation.getExits().get(i).getDestination().y() != 0) {
                    Actor attackTarget = map.at(currentLocation.getExits().get(i).getDestination().x(), currentLocation.getExits().get(i).getDestination().y()).getActor();
                    if (attackTarget != null) {
                        AttackAction attack = new AttackAction(attackTarget, currentLocation.getExits().get(i).getName(), this.weapon);
                        executeString += " \n" + attack.execute(actor, map);
                    }
                }
            }
        }
        return executeString;
    }

    /**
     * Describes which target the actor is attacking with which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses spinning attack with " + weapon;
    }

    /**
     * Returns the action that is to be executed when chosen. In this case it will return itself.
     * @param actor the Actor doing the action
     * @param map the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location actor_location = map.locationOf(actor);
        int xMax = map.getXRange().max();
        int yMax = map.getYRange().max();
        for (int i = 0; i < actor_location.getExits().size(); i++) {
            if (!((actor_location.getExits().get(i).getDestination().x() == 0) && (actor_location.getExits().get(i).getDestination().y() == 0))) {
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
                    }
                }
            }
        }
        return null;
    }
}
