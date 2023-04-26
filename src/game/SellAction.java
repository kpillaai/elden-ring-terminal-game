package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class SellAction extends Action {
    // private Uchigatana uchigatana = new Uchigatana();
    private WeaponItem weaponItem;
    // private Uchigatana uchigatana;

    public SellAction(WeaponItem weaponItem) {
        this.weaponItem = weaponItem;
        // this.uchigatana = uchigatana;
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
        // updateNumberOfRunes(uchigatana.getSellPrice());
        actor.removeItemFromInventory(weaponItem);
        return "player + sold uchigatana + for 500";
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
