package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.items.Runes;
import game.utils.Status;

/**
 * The starting weapon of Godrick the Grafted
 * It deals 89 damage with 90% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 */
public class GraftedDragon extends WeaponItem implements Sellable {

    /**
     * Constructor for GraftedDragon class.
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "swings", 90);
    }

    /**
     * Gets the sell price of this GraftedDragon
     * @return Integer representing the sell price of this GraftedDragon
     */
    @Override
    public int getSellPrice() {
        return 200;
    }

    /**
     * Returns the name of this GraftedDragon.
     * @return String representing the name of the GraftedDragon.
     */
    @Override
    public String toString() {
        return "GraftedDragon";
    }

    /**
     * Sells the item by removing the item from the actor's inventory and updating the number of runes the actor has.
     *
     * @param actor the actor or player selling the item.
     */
    @Override
    public String sell(Actor actor) {
        Runes runes = new Runes(false);
        runes.setNumberOfRunes(this.getSellPrice());
        actor.addItemToInventory(runes);
        actor.removeWeaponFromInventory(this);
        return actor + " sells " + this + " for " + this.getSellPrice() + " Runes";
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        Boolean isTraderNear = false;
        for (Exit exits : currentLocation.getExits()) {
            if (exits.getDestination().containsAnActor()) {
                if(exits.getDestination().getActor().hasCapability(Status.TRADER)){
                    isTraderNear = true;
                }
                break;
            }
        }
        if(isTraderNear){
            if(this.getAllowableActions().size() == 0){
                this.addAction(new SellAction(this));
            }
        }
        else{
            for(Action action : this.getAllowableActions()){
                this.removeAction(action);
            }
        }
    }
}
