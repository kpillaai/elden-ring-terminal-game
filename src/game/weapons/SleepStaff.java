package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.CastSleepAction;
import game.actions.SellAction;
import game.items.Runes;
import game.utils.Status;

public class SleepStaff extends WeaponItem implements Buyable, Sellable{
    /**
     * Constructor.
     */
    public SleepStaff() {
        super("Sleep Staff", '{', 40, "bonks",  100);
    }

    /**
     * Get an active skill action from the weapon. Use this method if you want to use a weapon skill
     * against one targeted Actor (i.e, special attack, heal, stun, etc.).
     *
     * @param target    target actor
     * @param direction
     * @return a special Action that can be performed by this weapon (perform special attack on the enemy, etc.)
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new CastSleepAction(target, direction, this );
    }

    /**
     * Gets the buy price of this weapon.
     *
     * @return Integer representing the buy price of the weapon
     */
    @Override
    public int getBuyPrice() {
        return 500;
    }

    /**
     * Gets the sell price of this weapon.
     *
     * @return Integer representing the sell price of the weapon
     */
    @Override
    public int getSellPrice() {
        return 200;
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
}
