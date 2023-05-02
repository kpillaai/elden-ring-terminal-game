package game.actors.enemies;

import game.utils.Status;

/**
 * Interface for skeleton type enemies within the game such as Heavy Skeletal Swordsman
 * @author Zilei Chen
 * @version 1.0
 */
public abstract class Skeleton extends Enemy {

    /**
     * A status checking if the enemy is a pile of bones
     */
    boolean isPileOfBones;

    /**
     * Number of turns in pile of bones form
     */
    int pileOfBonesTurns = 0;

    /**
     * Abstract constructor for Enemy class
     *
     * @param name        Name of the enemy
     * @param displayChar The character that represents the enemy
     * @param hitPoints   The number of hit points (HP) this enemy has
     */
    public Skeleton(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.SKELETON);
    }

    /**
     * Getter for isPileOfBones
     * @return boolean stating whether this Skeleton is a Pile of Bones
     */
    public boolean getIsPileOfBones() {
        return isPileOfBones;
    }

    /**
     * Updates the isPileOfBones to the opposite boolean
     * Also updates the state of the Enemy which includes changing its hp, name and display character
     * @return String describing the change the skeleton enemy went through
     */
    public String updatePileOfBones() {
        String result = "";
        this.isPileOfBones = !isPileOfBones;
        if(getIsPileOfBones()){
            this.setDisplayChar('X');
            this.resetMaxHp(1);
            updatePileOfBonesTurns();
            result = "The Skeletal Bandit crumbles into a Pile of Bones";
        }
        else{
            this.setDisplayChar('q');
            this.resetMaxHp(153);
            result = "The Pile of Bones revives back into the Skeletal Bandit!";
        }
        return result;
    }

    /**
     * Getter for pileOfBonesTurns
     * @return the number of turns the skeleton is in Pile of Bones form
     */
    public int getPileOfBonesTurns() {
        return this.pileOfBonesTurns;
    }

    /**
     * Updates the number of turns the skeleton is in Pile of Bones form
     * @return a string if any changes are made to the skeleton during this form
     */
    public void updatePileOfBonesTurns() {
        String result = "";
        this.pileOfBonesTurns += 1;
        if(this.pileOfBonesTurns > 3){
            this.updatePileOfBones();
        }
    }

}
