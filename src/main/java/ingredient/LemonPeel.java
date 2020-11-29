package ingredient;

import config.Constants;
import quantity.Quantity;

public class LemonPeel extends Ingredient{

    public LemonPeel(){
        super(Constants.LEMON_PEEL);
    }

    public LemonPeel(Quantity quantity){
        super(Constants.LEMON_PEEL, quantity);
    }
}
