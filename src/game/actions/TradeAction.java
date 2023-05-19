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
    private Item itemToGive;

    private Item itemToReceive;

    public TradeAction(Item itemToGive, Item itemToReceive){
        super();
        this.itemToGive = itemToGive;
        this.itemToReceive = itemToReceive;
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
        actor.addItemToInventory(this.itemToReceive);
        actor.removeItemFromInventory(this.itemToGive);
        return actor + " trades " + this.itemToGive + " for " + this.itemToReceive;
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Trade " + this.itemToGive + " for " + this.itemToReceive;
    }
}
