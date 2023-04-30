package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AOEAttackActionBehaviour;
import game.behaviours.BasicAttackActionBehaviour;
import game.weapons.Grossmesser;

public class HeavySkeletalSwordsman extends Enemy implements Skeleton {

    /**
     * A boolean stating whether this enemy is a Pile Of Bones or not
     */
    boolean isPileOfBones;

    /**
     * The number of turns in Pile of Bones form
     */
    int pileOfBonesTurns = 0;

    /**
     * Abstract constructor for Enemy class
     *
     * @param name        Name of the enemy
     * @param displayChar The character that represents the enemy
     * @param hitPoints   The number of hit points (HP) this enemy has
     */
    public HeavySkeletalSwordsman(){
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.isPileOfBones = false;
        this.addWeaponToInventory(new Grossmesser());
        super.setRuneDropValues(35, 892);
        this.behaviours.put(1, new AOEAttackActionBehaviour(this.getWeaponInventory().get(0)));
        this.behaviours.put(2, new BasicAttackActionBehaviour(this.getWeaponInventory().get(0)));
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
     * Getter for isPileOfBones
     * @return boolean stating whether this Skeleton is a Pile of Bones
     */
    @Override
    public boolean getIsPileOfBones() {
        return isPileOfBones;
    }

    /**
     * Updates the isPileOfBones to the opposite boolean
     * Also updates the state of the Enemy which includes changing its hp and display character
     * @return String describing the change the skeleton enemy went through
     */
    @Override
    public String updatePileOfBones() {
        String result = "";
        this.isPileOfBones = !isPileOfBones;
        if(getIsPileOfBones()){
            this.setDisplayChar('X');
            this.resetMaxHp(1);
            updatePileOfBonesTurns();
            result = "The Heavy Skeletal Swordsman crumbles into a Pile of Bones";
        }
        else{
            this.setDisplayChar('q');
            this.resetMaxHp(153);
            result = "The Pile of Bones revives back into the Heavy Skeletal Swordsman!";
        }
        return result;
    }

    /**
     * Getter for pileOfBonesTurns
     *
     * @return the number of turns the skeleton is in Pile of Bones form
     */
    @Override
    public int getPileOfBonesTurns() {
        return this.pileOfBonesTurns;
    }

    /**
     * Updates the number of turns the skeleton is in Pile of Bones form
     *
     * @return a string if any changes are made to the skeleton during this form
     */
    @Override
    public void updatePileOfBonesTurns() {
        String result = "";
        this.pileOfBonesTurns += 1;
        if(this.pileOfBonesTurns > 3){
            this.updatePileOfBones();
        }
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
