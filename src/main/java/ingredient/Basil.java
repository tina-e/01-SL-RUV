package ingredient;

import config.Constants;
import quantity.Quantity;

public class Basil extends Ingredient{
    public Basil(){
        super(Constants.BASIL);
    }
    public Basil(Quantity quantity){
        super(Constants.BASIL, quantity);
    }
}
