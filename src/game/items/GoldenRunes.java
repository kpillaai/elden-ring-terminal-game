package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeGoldenRuneAction;

public class GoldenRunes extends Item {
    /***
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Rune", '*', true);
        this.addAction(new ConsumeGoldenRuneAction(this));
    }


}
