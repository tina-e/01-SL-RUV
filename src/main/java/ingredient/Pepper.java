package ingredient;

import config.Constants;
import quantity.Weight;

public class Pepper extends Ingredient{

    public Pepper(){
        super(Constants.PEPPER);
        quantity = new Weight(1);
    }
}
