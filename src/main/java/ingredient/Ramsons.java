package ingredient;

import config.Constants;
import quantity.Quantity;

public class Ramsons extends Ingredient{

    public Ramsons(){
        super(Constants.RAMSONS);
    }
    public Ramsons(Quantity quantity){
        super(Constants.RAMSONS, quantity);
    }
}
