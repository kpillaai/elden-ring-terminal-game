package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Runes;
import game.utils.Status;

/**
 * An action to trade items between the player and Merchant Kale
 * Created by: Zilei Chen
 * @author Zilei Chen
 * Modified by: Zilei Chen
 */
public class TradeAction extends Action {

    /**
     * Update the number of runes the player has
     * @param amount the number to increase or decrease by
     * @param actor The player
     */
    public void updateRunes(int amount, Actor actor, GameMap map){
        Runes runes = new Runes(true);
        runes.setNumberOfRunes(amount);
        PickUpItemAction pickUpItemAction = new PickUpItemAction(runes);
        pickUpItemAction.execute(actor, map);
    }

    /**
     * Get the number of runes the player has
     * @param actor The player
     * @return The number of runes the player has
     */
    public int getRunes(Actor actor){
        int number = 0;
        for (Item item : actor.getItemInventory()){
            if (item.hasCapability(Status.CURRENCY)){
                number = Integer.parseInt(item.toString().substring(0, item.toString().length() - 6));
            }
        }
        return number;
    }

    /**
     * Perform the trade action
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
