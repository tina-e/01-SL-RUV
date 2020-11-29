package ingredient;

import config.Constants;
import quantity.Quantity;

public class Nectarine extends Ingredient{
    public Nectarine(){
        super(Constants.NECTARINE);
    }
    public Nectarine(Quantity quantity){
        super(Constants.NECTARINE, quantity);
    }
}
