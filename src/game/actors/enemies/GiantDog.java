package game.actors.enemies;

public class GiantDog extends Enemy{
    /**
     * Abstract constructor for Enemy class
     *
     * @param name        Name of the enemy
     * @param displayChar The character that represents the enemy
     * @param hitPoints   The number of hit points (HP) this enemy has
     */
    public GiantDog(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }
}
