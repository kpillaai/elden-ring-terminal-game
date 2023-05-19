package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.utils.RandomNumberGenerator;

public class GoldenRunes extends Item implements Consumable {
    /***
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Rune", '*', true);
        this.addAction(new ConsumeAction(this));
    }


    /**
     * Consumes the item
     */
    @Override
    public String consume(Actor actor) {
        Runes runes = new Runes(true);
        int number = RandomNumberGenerator.getRandomInt(200, 10000);
        runes.setNumberOfRunes(number);
        actor.addItemToInventory(runes);
        return actor + " consumes " + this + " and receives " + runes;
    }
}
