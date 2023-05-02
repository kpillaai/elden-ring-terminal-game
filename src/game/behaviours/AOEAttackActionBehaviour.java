package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        int xCord = currentLocation.x();
        int yCord = currentLocation.y();
        int xMax = map.getXRange().max();
        int yMax = map.getYRange().max();
        String[] directions = {"north", "north east", "east", "south east", "south", "south west", "west", "north west"};

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
        /*
        for(int i = -1; i<2; i++) {
            for (int j = -1; j < 2; j++) {
                if((xCord + i) > 0 && (xCord + i) < xMax && yCord + j > 0 && yCord + j < yMax){
                    if(i != 0 || j != 0){
                        Actor attackTarget = map.at(xCord+i, yCord+j).getActor();
                        if(attackTarget != null){
                            AttackAction attack = new AttackAction(attackTarget, directions[0], this.weapon);
                            executeString += " \n" + attack.execute(actor, map);
                        }
                    }
                }
            }
        }
         */
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

    @Override
    public Action getAction(Actor actor, GameMap map) {
        int currentX = map.locationOf(actor).x();
        int currentY = map.locationOf(actor).y();
        int xMax = map.getXRange().max();
        int yMax = map.getYRange().max();
        for(int i = -1; i < 2; i++){
            for(int j = -1; j<2; j++){
                if (!(i == 0 && j == 0)){
                    if((currentX + i) > 0 && (currentX + i) < xMax && currentY + j > 0 && currentY + j < yMax){
                        if (map.at(currentX+i, currentY+j).containsAnActor()){
                            return this;
                        }
                    }
                }
            }
        }
        return null;
    }
}
