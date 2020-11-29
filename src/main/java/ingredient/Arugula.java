package ingredient;

import config.Constants;
import quantity.Quantity;

public class Arugula extends Ingredient{
    public Arugula(){
        super(Constants.ARUGULA);
    }

    public Arugula(Quantity quantity){
        super(Constants.ARUGULA, quantity);
    }
}
