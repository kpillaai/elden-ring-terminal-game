package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.GoldenRunes;
import game.utils.Status;

public class ConsumeGoldenRuneAction extends Action {
    private GoldenRunes goldenRunes;

    public ConsumeGoldenRuneAction(GoldenRunes goldenRunes) {
        this.goldenRunes = goldenRunes;
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
        for (int i = 0; i < actor.getItemInventory().size(); i++) {
            if (actor.getItemInventory().get(i).toString().equals(goldenRunes.toString())) {
                actor.removeItemFromInventory(actor.getItemInventory().get(i));
            }
        }
        return actor + " consumed the Golden Rune";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes the " + goldenRunes;
    }
}
