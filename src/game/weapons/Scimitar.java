package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.items.Runes;
import game.utils.Status;

/**
 * The weapon held by the Skeleton Variant 'Skeletal Bandit'.
 * It deals 75 damage with 70% hit rate
 * Created by: Jason Skurr
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Scimitar extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor for Scimitar class.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "swings", 88);
        this.addCapability(Status.AOE_ATTACK);
    }

    /**
     * Gets the sell price of this Scimitar
     * @return Integer representing the sell price of this Scimitar
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /**
     * Gets the buy price of this Scimitar. This number will be negative to represent losing Runes when purchasing
     * this item.
     * @return Negative Integer representing the buy price of this Scimitar
     */
    @Override
    public int getBuyPrice() {
        return -600;
    }

    /**
     * Returns the name of this Scimitar.
     * @return String representing the name of the Scimitar.
     */
    @Override
    public String toString() {
        return "Scimitar";
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

    /**
     * Buys the item and gives the item to the actor.
     *
     * @param actor   the actor or player buying the item.
     */
    @Override
    public String buy(Actor actor) {
        int balance = 0;
        for(Item item : actor.getItemInventory()){
            if(item.hasCapability(Status.CURRENCY)){
                balance = Integer.parseInt(item.toString().substring(0, item.toString().length() - 6));
            }
        }
        if(balance > this.getBuyPrice()){
            Runes runes = new Runes(false);
            runes.setNumberOfRunes(-this.getBuyPrice());
            actor.addItemToInventory(runes);
            actor.addWeaponToInventory(this);
            return actor + " buys " + this + " for " + this.getBuyPrice() + " Runes";
        }
        else{
            return "Not enough runes!";
        }
    }
}