package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.players.Player;
import game.utils.FancyMessage;
import game.utils.RandomNumberGenerator;
import game.items.Runes;
import game.actors.enemies.Skeleton;
import game.actors.enemies.Enemy;
import game.utils.ResetManager;
import game.utils.Status;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 *
 */
public class DeathAction extends Action {

    /**
     * The actor that is attacking
     */
    private Actor attacker;

    /**
     * The number of runes that is dropped when an enemy is killed
     */
    private int killRunes;

    /**
     * The constructor for DeathAction class
     * @param actor the actor that is killed
     */
    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the actor is killed, it will check if the target was a Skeleton, which will have a unique death sequence.
     * It will also check if a player killed an Enemy, which will also grant the player dropped runes.
     * It will then drop all items of the enemy. If the player dies, then it will trigger a game reset.
     * @param target The actor that died
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        // Check if the target is a skeleton as they turn into a pile of bones
        if(target.hasCapability(Status.SKELETON)){
            if(!((Skeleton) target).getIsPileOfBones()){
               result = ((Skeleton) target).updatePileOfBones();
               return result;
            }
        }

        // Grant gold to player on kill
        if(attacker.hasCapability(Status.HOSTILE_TO_ENEMY) && target.hasCapability(Status.HOSTILE_TO_PLAYER)){
            for (Item item : attacker.getItemInventory()){
                if (item.hasCapability(Status.CURRENCY)) {
                    int[] ranges = ((Enemy) target).getRuneDropValues();
                    killRunes = new RandomNumberGenerator().getRandomInt(ranges[0], ranges[1]);
                    ((Runes) item).updateNumberOfRunes(killRunes);
                    result += target + " drops " + killRunes + " runes.";
                }
            }
        }

        ActionList dropActions = new ActionList();
        // drop all items, but the player will not drop its items
        if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
        }

        // remove actor
        if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            ResetManager resetManager = ResetManager.getInstance(map);
            for (String line : FancyMessage.YOU_DIED.split("\n")) {
                new Display().println(line);
                try {
                    Thread.sleep(200);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
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

    /**
     * A string description of which actor died.
     * @param actor The actor performing the action.
     * @return A string description of which actor died.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
