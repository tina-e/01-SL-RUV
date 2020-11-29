package ingredient;

import config.Constants;
import quantity.Quantity;

public class OliveOil extends Ingredient {

    public OliveOil(){
        super(Constants.OLIVE_OIL);
    }
    public OliveOil(Quantity quantity){
        super(Constants.OLIVE_OIL, quantity);
    }
}
