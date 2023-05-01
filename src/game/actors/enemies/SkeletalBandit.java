package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AOEAttackActionBehaviour;
import game.behaviours.BasicAttackActionBehaviour;
import game.weapons.Scimitar;

public class SkeletalBandit extends Skeleton {
    /**
     * Abstract constructor for Enemy class
     *
     * @param name        Name of the enemy
     * @param displayChar The character that represents the enemy
     * @param hitPoints   The number of hit points (HP) this enemy has
     */
    public SkeletalBandit(){
        super("Skeletal Bandit", 'b', 184);
        this.isPileOfBones = false;
        this.addWeaponToInventory(new Scimitar());
        super.setRuneDropValues(35, 892);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getWeaponInventory().get(0)));
    }

    @Override // not sure if a skeleton has an intrinsic weapon or what its meant to be
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "hits", 95);
    }

    /**
     * @return
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
