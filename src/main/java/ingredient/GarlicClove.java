package ingredient;

import config.Constants;
import quantity.Quantity;

public class GarlicClove extends Ingredient {
    public GarlicClove(){
        super(Constants.GARLICCLOVE);
    }
    public GarlicClove(Quantity quantity){
        super(Constants.GARLICCLOVE, quantity);
    }
}
