package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.players.Player;
import game.utils.RandomNumberGenerator;
import game.items.Runes;
import game.actors.enemies.Skeleton;
import game.actors.enemies.Enemy;
import game.utils.ResetManager;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 *
 */
public class DeathAction extends Action {
    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     * If there are special interaction on death such as skeletons turning into a Pile of Bones it will also perform
     * those actions
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        // Check if the target is a skeleton as they turn into a pile of bones
        if(target instanceof Skeleton){
            if(!((Skeleton) target).getIsPileOfBones()){
               result = ((Skeleton) target).updatePileOfBones();
               return result;
            }
        }

        // Grant gold to player on kill
        if(attacker instanceof Player && target instanceof Enemy){
            for (Item item : attacker.getItemInventory()){
                if (item instanceof Runes){
                    int[] ranges = ((Enemy) target).getRuneDropValues();
                    int killRunes = new RandomNumberGenerator().getRandomInt(ranges[0], ranges[1]);
                    ((Runes) item).updateNumberOfRunes(killRunes);
                }
            }
        }

        ActionList dropActions = new ActionList();
        // drop all items, but the player will not drop its items
        if(!(target instanceof Player)){
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
        }

        // remove actor
        if(target instanceof Player){
            ResetManager resetManager = ResetManager.getInstance(map);
            result += System.lineSeparator() + menuDescription(target) + " Respawning at the last visited Site of Lost Grace.";
            resetManager.run(map);
            return result;
        }
        else{
            map.removeActor(target);
        }
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
