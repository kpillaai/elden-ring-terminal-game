package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Buyable;

public class BuyAction extends TradeAction {
    private Buyable buyable;

    public BuyAction(Buyable buyable) {
        this.buyable = buyable;
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
        int buy_price = buyable.getBuyPrice();
        if (getRunes(actor) > (-1*(buy_price))) {
            updateRunes(buy_price, actor);
            actor.addWeaponToInventory(buyable.returnWeaponItem());
        }
        return actor + " bought " + buyable.returnWeaponItem() + " for " + buy_price + " runes";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Buy " + buyable.returnWeaponItem() + " from Merchant Kale for " + -buyable.getBuyPrice() + " runes";
    }
}
