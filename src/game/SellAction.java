package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class SellAction extends Action {
    // private Uchigatana uchigatana = new Uchigatana();
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
        // updating runes to be implemented
        //updateNumberOfRunes(sellable.getSellPrice());
        actor.removeItemFromInventory(sellable.returnWeaponItem());
        return actor + " sold " + sellable + " for";
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
