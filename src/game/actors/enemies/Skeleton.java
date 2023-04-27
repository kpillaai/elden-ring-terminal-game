package game.actors.enemies;

/**
 * Interface for skeleton type enemies within the game such as Heavy Skeletal Swordsman
 * @author Zilei Chen
 * @version 1.0
 */
public interface Skeleton {
    /**
     * Getter for isPileOfBones
     * @return boolean stating whether this Skeleton is a Pile of Bones
     */
    public boolean getIsPileOfBones();

    /**
     * Updates the isPileOfBones to the opposite boolean
     * Also updates the state of the Enemy which includes changing its hp, name and display character
     * @return String describing the change the skeleton enemy went through
     */
    public String updatePileOfBones();

    /**
     * Getter for pileOfBonesTurns
     * @return the number of turns the skeleton is in Pile of Bones form
     */
    public int getPileOfBonesTurns();

    /**
     * Updates the number of turns the skeleton is in Pile of Bones form
     * @return a string if any changes are made to the skeleton during this form
     */
    public void updatePileOfBonesTurns();

}
