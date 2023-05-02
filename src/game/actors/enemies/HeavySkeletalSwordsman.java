package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AOEAttackActionBehaviour;
import game.weapons.Grossmesser;

/**
 * HeavySkeletalSwordsman is a concrete class inheriting from Skeleton
 * @author Zilei Chen
 * @version 1.0
 */
public class HeavySkeletalSwordsman extends Skeleton {

    /**
     * Abstract constructor for HeavySkeletalSwordsman class
     */
    public HeavySkeletalSwordsman(){
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.isPileOfBones = false;
        this.addWeaponToInventory(new Grossmesser());
        super.setRuneDropValues(35, 892);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getWeaponInventory().get(0)));
    }

    /**
     * This is the default weapon for a HeavySkeletalSwordsman
     * @return An IntrinsicWeapon object for HeavySkeletalSwordsman
     */
    @Override // not sure if a skeleton has an intrinsic weapon or what its meant to be
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "hits", 95);
    }

    /**
     * Getter for the spawn chance of HeavySkeletalSwordsman out of 100
     * @return the spawn chance of HeavySkeletalSwordsman out of 100
     */
    @Override
    public int getSpawnChance() {
        return 27;
    }

    /**
     * At each turn, select a valid action to perform.
     * Checks to see if the skeleton is in Pile of Bones form
     * @param actions    collection of possible Actions for this Enemy
     * @param lastAction The Action this Enemy took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Enemy
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(getIsPileOfBones()){
            this.updatePileOfBonesTurns();
            return new DoNothingAction();
        }
        else{
            return super.playTurn(actions, lastAction, map, display);
        }
    }

}
