package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class TradeAction extends Action {
    public void updateRunes(int amount, Actor actor){
        for (Item item : actor.getItemInventory()){
            if (item instanceof Runes){
                ((Runes) item).updateNumberOfRunes(amount);
            }
        }
    }

    public int getRunes(Actor actor){
        int number = 0;
        for (Item item : actor.getItemInventory()){
            if (item instanceof Runes){
                number = ((Runes) item).getNumberOfRunes();
            }
        }
        return number;
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
        return null;
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
