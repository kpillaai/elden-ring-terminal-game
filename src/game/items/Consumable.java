package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface Consumable {

    /**
     * Consumes the item by the actor.
     * @param actor The actor consuming the item
     * @return
     */
    public String consume(Actor actor);
}
