package ingredient;

import config.Constants;
import quantity.Quantity;

public class Tomato extends Ingredient{
    public Tomato(){
        super(Constants.TOMATO);
    }
    public Tomato(Quantity quantity){
        super(Constants.TOMATO, quantity);
    }
}
