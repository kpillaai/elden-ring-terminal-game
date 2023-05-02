package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Buyable;

/**
 * An Action to purchase items from a trader.
 * Created by: Zilei Chen
 * @author Zilei Chen
 * Modified by: Zilei Chen
 */
public class BuyAction extends TradeAction {

    /**
     * The item that is being purchased
     */
    private Buyable buyable;

    /**
     * Constructor for BuyAction class
     * @param buyable The item that is being purchased
     */
    public BuyAction(Buyable buyable) {
        this.buyable = buyable;
    }

    /**
     * Perform the BuyAction, by updating the number of runes and adding it to the actors inventory
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A string that describes the purchase action that is being made
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int buy_price = buyable.getBuyPrice();
        if (getRunes(actor) > (-1*(buy_price))) {
            updateRunes(buy_price, actor, map);
            actor.addWeaponToInventory(buyable.returnWeaponItem());
            return actor + " bought " + buyable.returnWeaponItem() + " for " + -buy_price + " runes";
        }
        else {
            return "Tarnished does not have enough runes";
        }
    }

    /**
     * Returns a descriptive string of buying from Merchant
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Buy " + buyable.returnWeaponItem() + " from Merchant Kale for " + -buyable.getBuyPrice() + " runes";
    }
}
