package game.actions;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Sellable;

/**
 * An Action to sell items to the Trader
 * Created by: Zilei Chen
 * @author Zilei Chen
 * Modified by: Zilei Chen
 */
public class SellAction extends TradeAction {

    /**
     * The item to be sold to the trader
     */
    private Sellable sellable;

    /**
     * The constructor for SellAction
     * @param sellable The item to be sold to the trader
     */
    public SellAction(Sellable sellable) {
        this.sellable = sellable;
    }
    /**
     * Perform the sell action. It will update the players number of runes and remove the item from the inventory
     *
     * @param actor The player performing the action.
     * @param map   The map the actor is on.
     * @return a description of the transaction that is made.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int sell_price = sellable.getSellPrice();
        updateRunes(sell_price, actor);
        for (int i = 0; i < actor.getWeaponInventory().size(); i++) {
            if (actor.getWeaponInventory().get(i).toString().equals(sellable.toString())) {
                actor.removeWeaponFromInventory(actor.getWeaponInventory().get(i));
                break;
            }
        }
        return actor + " sold " + sellable.returnWeaponItem() + " for " + sell_price + " runes";
    }

    /**
     * Returns a descriptive string of selling the item
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + sellable.returnWeaponItem() + " to Merchant Kale for " + sellable.getSellPrice() + " runes";
    }
}
