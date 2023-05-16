package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.items.Tradeable;

import java.util.ArrayList;

public class TradeItemAction extends Action {
    private Tradeable tradeable_out;

    private WeaponItem tradeable_in;


    public TradeItemAction(Tradeable tradeable_out, WeaponItem tradeable_in) {
        this.tradeable_out = tradeable_out;
        this.tradeable_in = tradeable_in;
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
            if (actor.getItemInventory().get(i).toString().equals(tradeable_out.toString())) {
                actor.removeItemFromInventory(actor.getItemInventory().get(i));
                actor.addWeaponToInventory(tradeable_in);
            }
        }
        return actor + " traded " + tradeable_out.toString() + " for " + tradeable_in.toString();
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Trade " + tradeable_out.toString() + " to Finger Reader Enia for " + tradeable_in.toString();
    }
}
