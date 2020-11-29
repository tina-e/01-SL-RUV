package ingredient;

import config.Constants;
import quantity.Quantity;

public class LemonJuice extends Ingredient {

    public LemonJuice(){
        super(Constants.LEMON_JUICE);
    }
    public LemonJuice(Quantity quantity){
        super(Constants.LEMON_JUICE, quantity);
    }
}
