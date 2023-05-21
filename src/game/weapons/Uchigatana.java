package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.actions.UnsheatheAction;
import game.items.Runes;
import game.utils.Status;

/**
 * A starting weapon of the Samurai class
 * It deals 115 damage with 80% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor for Uchigatana class.
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slices", 80);
        this.addCapability(Status.UNSHEATHE);
    }

    /**
     * Gets the buy price of this Uchigatana. This number will be negative to represent losing Runes when purchasing
     * this item.
     *
     * @return Negative Integer representing the buy price of this Uchigatana
     */
    public int getBuyPrice() {
        return 5000;
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

    /**
     * Gets the sell price of this Uchigatana
     *
     * @return Integer representing the sell price of this Uchigatana
     */
    @Override
    public int getSellPrice() {
        return 500;
    }

    /**
     * Returns the name of this Uchigatana.
     *
     * @return String representing the name of the Uchigatana.
     */
    @Override
    public String toString() {
        return "Uchigatana";
    }

    /**
     * Get an active skill action from the weapon. This special action is the Unsheathe Action.
     * This allows the user to deal 2x damage but only have a 60% hit rate.
     *
     * @param target    target actor
     * @param direction
     * @return a special Action UnsheatheAction.
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target, direction, this);
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
