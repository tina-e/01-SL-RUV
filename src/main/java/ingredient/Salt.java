package ingredient;

import config.Constants;
import quantity.Weight;

public class Salt extends Ingredient{

    public Salt(){
        super(Constants.SALT);
        quantity = new Weight(1);
    }
}
