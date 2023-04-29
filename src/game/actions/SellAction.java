package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Sellable;

public class SellAction extends TradeAction {
    private Sellable sellable;

    public SellAction(Sellable sellable) {
        this.sellable = sellable;
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
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Sell " + sellable.returnWeaponItem() + " to Merchant Kale for " + sellable.getSellPrice() + " runes";
    }
}
