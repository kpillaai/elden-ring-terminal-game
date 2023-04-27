package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.FlaskOfCrimsonTears;

public class ConsumeAction extends Action {

    FlaskOfCrimsonTears item;
    public ConsumeAction(FlaskOfCrimsonTears item){
        this.item = item;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        result = actor + " uses " + item + " and heals for " + this.item.getHealAmount() + " HP.";
        actor.heal(this.item.getHealAmount());
        item.use();
        return result;
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Consume " + item;
    }
}
