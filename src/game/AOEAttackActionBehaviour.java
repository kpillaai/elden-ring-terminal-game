package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.HashMap;
import java.util.Map;

public class AOEAttackActionBehaviour extends AttackAction implements Behaviour{

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
        Map<String, Location> directions = new HashMap<String, Location>();
        int xCord = currentLocation.x();
        int yCord = currentLocation.y();
        directions.put("north", map.at(xCord, yCord+1));
        directions.put("north east", map.at(xCord+1, yCord+1));
        directions.put("east", map.at(xCord+1, yCord));
        directions.put("south east", map.at(xCord+1, yCord-1));
        directions.put("south", map.at(xCord, yCord-1));
        directions.put("south west", map.at(xCord-1, yCord-1));
        directions.put("west", map.at(xCord-1, yCord));
        directions.put("north west", map.at(xCord-1, yCord+1));

        String executeString = "The " + actor + " " + this.weapon.verb() + " in all directions.";
        for ( String key : directions.keySet()){
            Actor attackTarget = map.getActorAt(directions.get(key));
            if (attackTarget != null){
                AttackAction attack = new AttackAction(attackTarget, key, this.weapon);
                executeString += " \n" + attack.execute(actor, map);
            }
        }
        return executeString;
    }


    @Override
    public Action getAction(Actor actor, GameMap map) {
        return this;
    }
}
