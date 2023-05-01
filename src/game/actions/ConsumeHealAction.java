package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;

/**
 * An Action to consume a healing item.
 * Created by: Zilei Chen
 * @author Zilei Chen
 * Modified by: Zilei Chen
 */
public class ConsumeHealAction extends Action {

    /**
     * The Flask of Crimson Tears that is being consumed
     */
    FlaskOfCrimsonTears item;

    /**
     * The constructor for ConsumeHealAction
     * @param item The Flask of Crimson Tears that is being consumed
     */
    public ConsumeHealAction(FlaskOfCrimsonTears item){
        this.item = item;
    }

    /**
     * Perform the ConsumeHealAction. This updates the player current hp and reduces the number of uses of the item.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if(item.getUsesLeft() > 0){
            String result = "";
            result = actor + " uses " + item + " and heals for " + this.item.getHealAmount() + " HP.";
            actor.heal(this.item.getHealAmount());
            item.use();
            return result;
        }
        return "No uses left!";
    }

    /**
     * Returns a descriptive string of consuming the item
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Consume " + item;
    }
}
